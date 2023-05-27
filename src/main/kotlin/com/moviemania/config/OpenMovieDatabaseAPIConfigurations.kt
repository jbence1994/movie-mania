package com.moviemania.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "open-movie-database-api")
class OpenMovieDatabaseAPIConfigurations(
    private val baseUrl: String,
    private val apiKey: String
) {
    operator fun component1(): String = baseUrl
    operator fun component2(): String = apiKey
}
