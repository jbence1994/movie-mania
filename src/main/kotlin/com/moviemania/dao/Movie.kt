package com.moviemania.dao

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(
    value = [
        "Rated",
        "Released",
        "Runtime",
        "Genre",
        "Writer",
        "Actors",
        "Language",
        "Country",
        "Awards",
        "Ratings",
        "Metascore",
        "imdbVotes",
        "DVD",
        "BoxOffice",
        "Production",
        "Website",
        "Response"
    ]
)
data class Movie(
    @JsonProperty("imdbID")
    var imdbId: String,
    @JsonProperty("Title")
    var title: String,
    @JsonProperty("Type")
    var type: String,
    @JsonProperty("Year")
    var year: Int,
    @JsonProperty("Director")
    var director: String,
    @JsonProperty("Plot")
    var plot: String,
    @JsonProperty("Poster")
    var posterUrl: String,
    @JsonProperty("imdbRating")
    var imdbRating: Double
)
