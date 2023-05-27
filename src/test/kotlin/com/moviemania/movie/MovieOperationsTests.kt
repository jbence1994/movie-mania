package com.moviemania.movie

import com.fasterxml.jackson.databind.ObjectMapper
import com.moviemania.AVENGERS_ENDGAME_IMDB_ID
import com.moviemania.BREAKING_BAD_IMDB_ID
import com.moviemania.MOVIE_RESPONSE_STRING
import com.moviemania.OMDB_API_KEY
import com.moviemania.OMDB_BASE_URL
import com.moviemania.SERIES_RESPONSE_STRING
import com.moviemania.builder.dao.MovieTestBuilder
import com.moviemania.builder.okhttp.OkHttpResponseBuilder
import com.moviemania.config.OpenMovieDatabaseAPIConfigurations
import com.moviemania.dao.Movie
import io.mockk.every
import io.mockk.mockk
import okhttp3.OkHttpClient
import okhttp3.Response
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.boot.test.context.SpringBootTest
import java.util.stream.Stream

@SpringBootTest
class MovieOperationsTests {
    private val openMovieDatabaseAPIConfigurations = OpenMovieDatabaseAPIConfigurations(
        OMDB_BASE_URL,
        OMDB_API_KEY
    )
    private val okHttpClient: OkHttpClient = mockk()
    private val objectMapper: ObjectMapper = mockk()
    private val movieOperations = MovieOperations(
        openMovieDatabaseAPIConfigurations,
        okHttpClient,
        objectMapper
    )

    companion object {
        @JvmStatic
        fun movieParams(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    "Movie (Avengers: Endgame)",
                    AVENGERS_ENDGAME_IMDB_ID,
                    OkHttpResponseBuilder.default,
                    MOVIE_RESPONSE_STRING,
                    MovieTestBuilder.default
                ),
                Arguments.of(
                    "Series (Breaking Bad)",
                    BREAKING_BAD_IMDB_ID,
                    OkHttpResponseBuilder.series,
                    SERIES_RESPONSE_STRING,
                    MovieTestBuilder.series
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("movieParams")
    fun `getMovie - Happy paths`(
        testCase: String,
        imdbId: String,
        okHttpResponse: Response,
        responseAsString: String,
        expectedResult: Movie
    ) {
        every {
            okHttpClient.newCall(any()).execute()
        } returns okHttpResponse
        every {
            objectMapper.readValue(responseAsString, eq(Movie::class.java))
        } returns expectedResult
        val result = movieOperations.getMovie(imdbId)
        assertEquals(expectedResult, result)
    }
}
