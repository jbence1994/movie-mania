package com.moviemania.external

import com.fasterxml.jackson.databind.ObjectMapper
import com.moviemania.config.OpenMovieDatabaseAPIConfigurations
import com.moviemania.dao.Movie
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.stereotype.Component

@Component
class MovieOperations(
    private val openMovieDatabaseAPIConfigurations: OpenMovieDatabaseAPIConfigurations,
    private val okHttpClient: OkHttpClient,
    private val objectMapper: ObjectMapper
) {
    fun getMovie(imdbId: String): Movie {
        val (baseUrl, apiKey) = openMovieDatabaseAPIConfigurations

        val request: Request = Request.Builder()
            .url("$baseUrl?i=$imdbId&apiKey=$apiKey") // https://www.omdbapi.com/?i=tt2015381&apiKey=d88933c8
            .get()
            .build()
        val response: Response = okHttpClient.newCall(request).execute()
        val responseAsString: String? = response.body?.string()

        return objectMapper.readValue(responseAsString, Movie::class.java)
    }
}
