package br.com.cardoso.redis.model

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import java.io.Serializable

@RedisHash("Artist")
data class Artist(
    @Id
    val id: String? = null,
    @Indexed
    val name: String
) : Serializable