package com.rbbozkurt.tool

/**
 * Represents the result of a tool execution.
 */
sealed class ToolResponse {
    data class Success(val data: String) : ToolResponse()
    data class Error(val errorMessage: String) : ToolResponse()
}
