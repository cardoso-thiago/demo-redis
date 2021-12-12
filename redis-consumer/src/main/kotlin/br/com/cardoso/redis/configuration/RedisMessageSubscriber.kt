package br.com.cardoso.redis.configuration

import br.com.cardoso.redis.model.Artist
import br.com.cardoso.redis.service.ArtistService
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Service

@Service
class RedisMessageSubscriber(private val artistService: ArtistService) : MessageListener {

    override fun onMessage(message: Message, pattern: ByteArray?) {
        println("Mensagem Recebida: $message")
        artistService.saveAllArtists(mutableListOf(Artist(name = message.toString())))
    }
}