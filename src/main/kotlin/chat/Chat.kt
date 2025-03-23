package com.rbbozkurt.chat

/**
 * Interface for a generic CLI-based chat system.
 * All chats must implement startup, shutdown, and interactive handling.
 */
interface Chat {
    /**
     * Starts the interactive session.
     */
    fun start()

    /**
     * Ends the session gracefully.
     */
    fun end()
}
