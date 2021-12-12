package br.com.cardoso.redis.configuration

import br.com.cardoso.redis.service.ArtistService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.MessageListener
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter


@Configuration
class RedisConfigurationSubscriber {

    companion object {
        const val ARTIST_CHANNEL = "artist_channel"
    }

    @Bean
    fun messageListener(artistService: ArtistService): MessageListenerAdapter {
        return MessageListenerAdapter(RedisMessageSubscriber(artistService))
    }

    @Bean
    fun redisContainer(
        connectionFactory: RedisConnectionFactory,
        messageListener: MessageListener
    ): RedisMessageListenerContainer {
        val container = RedisMessageListenerContainer()
        container.setConnectionFactory(connectionFactory)
        container.addMessageListener(messageListener, topic())
        return container
    }

    @Bean
    fun topic(): ChannelTopic {
        return ChannelTopic(ARTIST_CHANNEL)
    }
}