package com.rbbozkurt.chat

import com.rbbozkurt.agent.WeatherAgent

/**
 * A CLI chat implementation for interacting with the WeatherAgent.
 */
class AIWeatherChat(private val agent: WeatherAgent) : Chat {

    override fun start() {
        println("🌍 AIWeatherChat - Your personal weather assistant")
        println("Ask me about the weather! (Type 'exit' to quit)")

        while (true) {
            print("\n> ")
            val userInput = readlnOrNull()?.trim() ?: ""

            if (userInput.equals("exit", ignoreCase = true)) {
                end()
                break
            }

            val response = agent.processRequest(userInput)
            println(response)
        }
    }

    override fun end() {
        println("Goodbye! 👋")
    }
}
