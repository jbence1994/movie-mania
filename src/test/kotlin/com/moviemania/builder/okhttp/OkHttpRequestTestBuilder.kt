package com.moviemania.builder.okhttp

import com.moviemania.AVENGERS_ENDGAME_IMDB_ID
import com.moviemania.BREAKING_BAD_IMDB_ID
import com.moviemania.OMDB_API_KEY
import com.moviemania.OMDB_BASE_URL
import com.moviemania.builder.DefaultBuilder
import okhttp3.Request

class OkHttpRequestTestBuilder {
    companion object : DefaultBuilder<Request> {
        private val instance = OkHttpRequestTestBuilder()
        override val default: Request = instance.build()
        val series: Request = instance.build(
            imdbId = BREAKING_BAD_IMDB_ID
        )
    }

    private fun build(
        imdbId: String = AVENGERS_ENDGAME_IMDB_ID
    ): Request {
        return Request.Builder()
            .url("$OMDB_BASE_URL?i=$imdbId&apiKey=$OMDB_API_KEY")
            .get()
            .build()
    }
}
