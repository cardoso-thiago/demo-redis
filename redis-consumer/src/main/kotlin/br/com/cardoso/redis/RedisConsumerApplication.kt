package br.com.cardoso.redis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class RedisConsumerApplication

fun main(args: Array<String>) {
    runApplication<RedisConsumerApplication>(*args)
}
