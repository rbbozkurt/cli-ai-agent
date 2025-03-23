// File: config/AgentConfig.kt
package com.rbbozkurt.config

import kotlinx.serialization.Serializable

@Serializable
data class AgentConfig(
    val agentName: String,
    val toolRegistry: ToolRegistryConfig
)

@Serializable
data class ToolRegistryConfig(
    val tools: List<String>
)
