package com.rdas.consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KtMainApplication

fun main(args: Array<String>) {
	runApplication<KtMainApplication>(*args)
}
