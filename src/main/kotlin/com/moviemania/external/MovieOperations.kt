package com.moviemania.external

import com.fasterxml.jackson.databind.ObjectMapper
import com.moviemania.config.OpenMovieDatabaseAPIConfigurations
import com.moviemania.dao.Movie
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.stereotype.Component

// Movie: https://www.omdbapi.com/?i=tt4154796&apiKey=d88933c8
// Series: https://www.omdbapi.com/?i=tt0903747&apiKey=d88933c8

@Component
class MovieOperations(
    private val openMovieDatabaseAPIConfigurations: OpenMovieDatabaseAPIConfigurations,
    private val okHttpClient: OkHttpClient,
    private val objectMapper: ObjectMapper
) {
    fun getMovie(imdbId: String): Movie {
        val (baseUrl, apiKey) = openMovieDatabaseAPIConfigurations

        val request: Request = Request.Builder()
            .url("$baseUrl?i=$imdbId&apiKey=$apiKey")
            .get()
            .build()
        val response: Response = okHttpClient.newCall(request).execute()
        val responseAsString: String? = response.body?.string()

        return objectMapper.readValue(responseAsString, Movie::class.java)
    }
}
