// File: src/main/kotlin/com/rbbozkurt/loader/AgentConfigLoader.kt
package com.rbbozkurt.loader

import com.rbbozkurt.config.AgentConfig
import kotlinx.serialization.json.Json
import java.io.File

object AgentConfigLoader {
    fun load(path: String): AgentConfig {
        val file = File(path)
        require(file.exists()) { "❌ Config file not found at: $path" }

        val jsonString = file.readText()
        return Json.decodeFromString(AgentConfig.serializer(), jsonString)
    }
}
