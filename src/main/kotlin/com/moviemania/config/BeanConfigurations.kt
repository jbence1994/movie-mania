package com.moviemania.config

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfigurations {

    @Bean
    fun okHttpClient(): OkHttpClient = OkHttpClient()

    @Bean
    fun objectMapper(): ObjectMapper = ObjectMapper()
}
