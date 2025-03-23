// File: factory/AgentFactory.kt
package com.rbbozkurt.factory

import com.rbbozkurt.agent.Agent
import com.rbbozkurt.agent.WeatherAgent
import com.rbbozkurt.config.AgentConfig
import com.rbbozkurt.tool.ToolRegistry

/**
 * Factory responsible for creating [Agent] instances from configuration.
 */
object AgentFactory {

    /**
     * Creates an [Agent] instance using [AgentConfig].
     *
     * @param config The agent configuration.
     * @return A concrete [Agent] or null if unsupported.
     */
    fun create(config: AgentConfig): Agent? {
        val toolRegistry = ToolRegistryFactory.create(config.toolRegistry)

        return when (config.agentName.lowercase()) {
            "weather" -> WeatherAgent(toolRegistry)
            else -> {
                println("⚠️ Unsupported agent type: ${config.agentName}")
                null
            }
        }
    }
}
