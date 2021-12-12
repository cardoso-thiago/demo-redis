package br.com.cardoso.redis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RedisPublisherApplication

fun main(args: Array<String>) {
    runApplication<RedisPublisherApplication>(*args)
}
