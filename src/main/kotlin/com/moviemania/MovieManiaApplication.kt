package com.moviemania

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MovieManiaApplication

fun main(args: Array<String>) {
    runApplication<MovieManiaApplication>(*args)
}
