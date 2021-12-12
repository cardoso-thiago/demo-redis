package br.com.cardoso.redis.repository

import br.com.cardoso.redis.model.Artist
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ArtistRepository : CrudRepository<Artist, String> {
    fun findByName(name: String): Optional<Artist>
}