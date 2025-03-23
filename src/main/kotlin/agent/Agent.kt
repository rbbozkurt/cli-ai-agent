package com.rbbozkurt.agent

interface Agent {
    val name: String
    fun processRequest(request: String): String
}
