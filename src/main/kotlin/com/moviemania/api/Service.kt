package com.moviemania.api

import com.moviemania.dao.Movie
import com.moviemania.external.MovieOperations
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("movies")
class Service(private val movieOperations: MovieOperations) {

    @GetMapping("/{imdbId}")
    fun getMovieByImdbId(@PathVariable imdbId: String): ResponseEntity<Movie> {
        val movie: Movie = movieOperations.getMovie(imdbId)
        return ResponseEntity(movie, HttpStatus.OK)
    }
}
