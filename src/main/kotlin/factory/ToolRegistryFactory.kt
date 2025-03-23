// File: factory/ToolRegistryFactory.kt
package com.rbbozkurt.factory

import com.rbbozkurt.tool.Tool
import com.rbbozkurt.tool.ToolRegistry
import com.rbbozkurt.tool.WeatherTool

object ToolRegistryFactory {

    fun create(toolNames: List<String>): ToolRegistry {
        val registry = ToolRegistry()

        toolNames.forEach { name ->
            val tool = createTool(name)
            if (tool != null) {
                registry.register(tool)
            } else {
                println("⚠️ Unsupported tool: $name")
            }
        }

        return registry
    }

    private fun createTool(name: String): Tool? = when (name.lowercase()) {
        "weather" -> WeatherTool()
        else -> null
    }
}
