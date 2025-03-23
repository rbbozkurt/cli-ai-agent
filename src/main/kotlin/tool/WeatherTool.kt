package com.rbbozkurt.tool

import kotlin.random.Random

/**
 * A tool to simulate weather forecast information.
 */
class WeatherTool : Tool {

    override val name: String = "weather"

    private val supportedCities = listOf("London", "New York", "Paris", "Berlin", "Tokyo")

    override fun execute(arguments: Map<String, String>): ToolResponse {
        val city = arguments["city"]
        val time = arguments["time"]

        if (city == null || time == null) {
            return ToolResponse.Error("Missing 'city' or 'time' argument.")
        }

        if (city !in supportedCities) {
            return ToolResponse.Error("Unsupported city: $city")
        }

        val temperature = Random.nextInt(-5, 35)
        return ToolResponse.Success(temperature.toString())
    }
}
