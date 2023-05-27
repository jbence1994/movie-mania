package com.moviemania.builder.okhttp

import com.moviemania.builder.DefaultBuilder
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody

class OkHttpResponseBuilder {
    companion object : DefaultBuilder<Response> {
        private val instance = OkHttpResponseBuilder()
        override val default: Response = instance.build()
        val series: Response = instance.build(
            request = OkHttpRequestTestBuilder.series,
            responseBody = OkHttpResponseBodyBuilder.series
        )
    }

    private fun build(
        request: Request = OkHttpRequestTestBuilder.default,
        protocol: Protocol = Protocol.HTTP_1_1,
        message: String = "OK",
        statusCode: Int = 200,
        responseBody: ResponseBody = OkHttpResponseBodyBuilder.default
    ): Response {
        return Response.Builder()
            .request(request)
            .protocol(protocol)
            .message(message)
            .code(statusCode)
            .body(responseBody)
            .build()
    }
}
