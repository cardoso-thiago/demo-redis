package br.com.cardoso.redis.controller

import br.com.cardoso.redis.configuration.RedisMessagePublisher
import br.com.cardoso.redis.model.Artist
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PublishArtistController(private val redisMessagePublisher: RedisMessagePublisher) {

    @PostMapping
    fun saveAllArtists(@RequestBody artist: Artist) = redisMessagePublisher.publish(artist.name)
}