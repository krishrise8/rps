package com.onboarding.rockpaperscissors

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer




@SpringBootApplication
class RockPaperScissorsApplication

fun main(args: Array<String>) {
	runApplication<RockPaperScissorsApplication>(*args)
}

@Bean
fun corsConfigurer(): WebMvcConfigurer? {
	return object : WebMvcConfigurer {
		override fun addCorsMappings(registry: CorsRegistry) {
			registry.addMapping("/game/**").allowedOrigins("http://localhost:3000").allowedMethods("POST", "PUT", "GET", "OPTIONS")
		}
	}
}
