package br.com.cardoso.redis.configuration

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.stereotype.Service

@Service
class RedisMessagePublisher(
    private val redisTemplate: RedisTemplate<String, Any>,
    private val channelTopic: ChannelTopic
) {

    fun publish(message: String) {
        redisTemplate.convertAndSend(channelTopic.topic, message)
    }
}