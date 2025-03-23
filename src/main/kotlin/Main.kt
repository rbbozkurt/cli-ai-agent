package com.rbbozkurt

import com.rbbozkurt.agent.WeatherAgent
import com.rbbozkurt.chat.AIWeatherChat
import com.rbbozkurt.tool.ToolRegistry
import com.rbbozkurt.tool.WeatherTool

fun main() {
    // Initialize and register the weather tool
    val toolRegistry = ToolRegistry()
    val weatherTool = WeatherTool()
    toolRegistry.register(weatherTool)

    // Create agent and chat
    val weatherAgent = WeatherAgent(toolRegistry)
    val chat = AIWeatherChat(weatherAgent)
    //TODO add session to list agents.
    // Start chat loop
    chat.start()
}
