package com.rbbozkurt.chat

import com.rbbozkurt.agent.WeatherAgent

class AIWeatherChat(private val agent: WeatherAgent) {

    /**
     * Starts the interactive CLI chat session.
     * Users can enter weather queries, and the agent processes each request independently.
     */
    fun start() {
        println("🌍 AIWeatherChat - Your personal weather assistant")
        println("Ask me about the weather! (Type 'exit' to quit)")

        while (true) {
            print("\n> ")
            val userInput = readlnOrNull()?.trim() ?: ""

            if (userInput.equals("exit", ignoreCase = true)) {
                println("Goodbye! 👋")
                break
            }

            val response = agent.processRequest(userInput)
            println(response)
        }
    }
}
