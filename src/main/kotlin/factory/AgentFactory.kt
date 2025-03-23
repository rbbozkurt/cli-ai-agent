// File: factory/AgentFactory.kt
package com.rbbozkurt.factory

import com.rbbozkurt.agent.Agent
import com.rbbozkurt.agent.WeatherAgent
import com.rbbozkurt.tool.ToolRegistry

/**
 * Factory responsible for creating Agent instances based on a given agent name.
 */
class AgentFactory {

    /**
     * Creates an Agent instance based on the agent name.
     *
     * @param agentName The string identifier of the agent (e.g., "weather").
     * @param toolRegistry The registry containing tools required by the agent.
     * @return A concrete Agent instance or null if not supported.
     */
    fun create(agentName: String, toolRegistry: ToolRegistry): Agent? {
        return when (agentName.lowercase()) {
            "weather" -> WeatherAgent(toolRegistry)
            else -> null
        }
    }
}
