package com.rbbozkurt.agent

import com.rbbozkurt.tool.ToolRegistry
import com.rbbozkurt.tool.ToolResponse
import com.rbbozkurt.tool.WeatherTool

/**
 * AI agent that processes user requests using registered tools.
 * This implementation supports only weather-related queries.
 */
class WeatherAgent(private val toolRegistry: ToolRegistry) : Agent {
    override val name: String = "weather"

    /**
     * Processes weather-related requests by parsing the user input,
     * selecting the appropriate tool from the registry, and executing the query.
     *
     * @param request The input query (e.g., "Determine the temperature in London in an hour").
     * @return The result of the processed request or an error message.
     */
    override fun processRequest(request: String): String {
        val pattern = Regex("""Determine the temperature in (.+?) in ((?:\d+|a|an) (?:minute|minutes|hour|hours|day|days))""", RegexOption.IGNORE_CASE)

        val matchResult = pattern.matchEntire(request)

        if (matchResult != null) {
            val (city, time) = matchResult.destructured

            val tool = toolRegistry.getTool("weather")
            if (tool is WeatherTool) {
                val response = tool.execute(mapOf("city" to city, "time" to time))
                return when (response) {
                    is ToolResponse.Success -> "It will be ${response.data}°C in $city in $time."
                    is ToolResponse.Error -> "⚠️ Unable to get temperature: ${response.errorMessage}"
                }
            }

            return "❌ Weather tool is not available in the registry."
        }

        return "I can only process requests like: 'Determine the temperature in <city> in <time>'."
    }
}
