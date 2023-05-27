package com.moviemania.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "open-movie-database-api")
class OpenMovieDatabaseAPIConfigurations(
    val baseUrl: String,
    val apiKey: String
)
