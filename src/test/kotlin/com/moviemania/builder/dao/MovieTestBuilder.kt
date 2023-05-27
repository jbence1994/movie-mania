package com.moviemania.builder.dao

import com.moviemania.AVENGERS_ENDGAME_IMDB_ID
import com.moviemania.BREAKING_BAD_IMDB_ID
import com.moviemania.builder.DefaultBuilder
import com.moviemania.dao.Movie

class MovieTestBuilder {
    companion object : DefaultBuilder<Movie> {
        private val instance = MovieTestBuilder()
        override val default: Movie = instance.build()
        val series: Movie = instance.build(
            imdbId = BREAKING_BAD_IMDB_ID,
            title = "Breaking Bad",
            year = "2008–2013",
            director = "N/A",
            plot = "A chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine with a former student in order to secure his family's future.",
            posterUrl = "https://m.media-amazon.com/images/M/MV5BYmQ4YWMxYjUtNjZmYi00MDQ1LWFjMjMtNjA5ZDdiYjdiODU5XkEyXkFqcGdeQXVyMTMzNDExODE5._V1_SX300.jpg",
            imdbRating = 9.5
        )
    }

    private fun build(
        imdbId: String = AVENGERS_ENDGAME_IMDB_ID,
        title: String = "Avengers: Endgame",
        type: String = "movie",
        year: String = "2019",
        director: String = "Anthony Russo, Joe Russo",
        plot: String = "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.",
        posterUrl: String = "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg",
        imdbRating: Double = 8.4
    ): Movie {
        return Movie(
            imdbId,
            title,
            type,
            year,
            director,
            plot,
            posterUrl,
            imdbRating
        )
    }
}
