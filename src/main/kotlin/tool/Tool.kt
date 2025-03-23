package com.rbbozkurt.tool

/**
 * Represents a generic tool capable of processing structured input.
 */
interface Tool {
    val name: String

    /**
     * Process a request with a given input.
     */
    fun execute(arguments: Map<String, String>): ToolResponse
}
