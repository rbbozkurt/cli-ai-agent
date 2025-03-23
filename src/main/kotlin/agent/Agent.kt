package com.rbbozkurt.agent

interface Agent {
    fun processRequest(request: String): String
}
