package br.com.cardoso.redis.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.serializer.GenericToStringSerializer


@Configuration
class RedisConfigurationPublisher {

    companion object {
        const val ARTIST_CHANNEL = "artist_channel"
    }

    @Bean
    fun redisPublisher(redisTemplate: RedisTemplate<String, Any>, channelTopic: ChannelTopic): RedisMessagePublisher {
        return RedisMessagePublisher(redisTemplate, channelTopic)
    }

    @Bean
    fun topic(): ChannelTopic {
        return ChannelTopic(ARTIST_CHANNEL)
    }

    @Bean
    fun redisTemplate(connectionFactory: RedisConnectionFactory): RedisTemplate<String, Any> {
        val template = RedisTemplate<String, Any>()
        template.setConnectionFactory(connectionFactory)
        template.valueSerializer = GenericToStringSerializer(Any::class.java)
        return template
    }
}