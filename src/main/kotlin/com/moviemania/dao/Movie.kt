package com.moviemania.dao

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(
    value = [
        "Rated",
        "Released",
        "Runtime",
        "Genre",
        "Director",
        "Writer",
        "Actors",
        "Plot",
        "Language",
        "Country",
        "Awards",
        "Poster",
        "Ratings",
        "Metascore",
        "imdbRating",
        "imdbVotes",
        "Type",
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
    @JsonProperty("Year")
    var year: Int
)
