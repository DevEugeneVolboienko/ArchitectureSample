package com.example.architectureexample.domain.response

import com.squareup.moshi.Json

enum class BookType(val value: String) {
    @Json(name = "fiction")
    FICTION("fiction"),

    @Json(name = "non-fiction")
    NON_FICTION("non-fiction"),

    UNKNOWN("");

    companion object {
        fun from(type: String): BookType = values().associateBy(BookType::value)[type] ?: UNKNOWN
    }
}