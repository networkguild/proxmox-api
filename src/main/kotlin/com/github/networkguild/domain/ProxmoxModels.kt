package com.github.networkguild.domain

import io.micronaut.core.annotation.Introspected

@Introspected
data class Token(
    val data: TokenData
) {
    @Introspected
    data class TokenData(
        val CSRFPreventionToken: String,
        val ticket: String,
        val username: String
    )
}
