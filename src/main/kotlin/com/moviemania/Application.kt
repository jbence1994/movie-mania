package com.moviemania

import com.moviemania.config.OpenMovieDatabaseAPIConfigurations
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(value = [OpenMovieDatabaseAPIConfigurations::class])
class Application

@SuppressWarnings("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
