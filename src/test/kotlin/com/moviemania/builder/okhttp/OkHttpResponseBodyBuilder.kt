package com.moviemania.builder.okhttp

import com.moviemania.APPLICATION_JSON
import com.moviemania.MOVIE_RESPONSE_STRING
import com.moviemania.SERIES_RESPONSE_STRING
import com.moviemania.builder.DefaultBuilder
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody

class OkHttpResponseBodyBuilder {
    companion object : DefaultBuilder<ResponseBody> {
        private val instance = OkHttpResponseBodyBuilder()
        override val default: ResponseBody = instance.build()
        val series: ResponseBody = instance.build(
            okHttpResponse = SERIES_RESPONSE_STRING
        )
    }

    private fun build(
        contentType: String = APPLICATION_JSON,
        okHttpResponse: String = MOVIE_RESPONSE_STRING
    ): ResponseBody {
        return okHttpResponse.toResponseBody(contentType.toMediaType())
    }
}
