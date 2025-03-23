// File: src/main/kotlin/com/rbbozkurt/Main.kt
package com.rbbozkurt

import com.rbbozkurt.agent.Agent
import com.rbbozkurt.chat.AIWeatherChat
import com.rbbozkurt.factory.AgentFactory
import com.rbbozkurt.loader.AgentConfigLoader
import java.io.File

fun main() {
    val configDir = File("configs")
    require(configDir.exists() && configDir.isDirectory) { "❌ 'configs/' directory not found." }

    val configFiles = configDir.listFiles { file -> file.extension == "json" } ?: emptyArray()
    if (configFiles.isEmpty()) {
        println("⚠️ No config files found in 'configs/' directory.")
        return
    }

    println("🔍 Found the following agent configurations:")
    configFiles.forEachIndexed { index, file ->
        val config = AgentConfigLoader.load(file.absolutePath)
        println("${index + 1}. Agent Name: ${config.agentName} (file: ${file.name})")
    }

    print("\nSelect agent to run (enter number): ")
    val choice = readlnOrNull()?.toIntOrNull()

    if (choice == null || choice !in 1..configFiles.size) {
        println("❌ Invalid selection.")
        return
    }

    val selectedFile = configFiles[choice - 1]
    val selectedConfig = AgentConfigLoader.load(selectedFile.absolutePath)

    val agent: Agent = AgentFactory.create(selectedConfig)
        ?: error("Unknown agent type: ${selectedConfig.agentName}")

    val chat = AIWeatherChat(agent)
    chat.start()
}
