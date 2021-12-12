package br.com.cardoso.redis.service.impl

import br.com.cardoso.redis.model.Artist
import br.com.cardoso.redis.repository.ArtistRepository
import br.com.cardoso.redis.service.ArtistService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.*

@Service
class ArtistServiceImpl(private val artistRepository: ArtistRepository) : ArtistService {

    @Cacheable(cacheNames = ["ArtistCache"], key = "#root.method.name")
    override fun findAllArtists(): MutableIterable<Artist> {
        return artistRepository.findAll()
    }

    @Cacheable(cacheNames = ["ArtistCache"], key = "#letter")
    override fun searchArtists(letter: Char): MutableIterable<Artist> {
        return artistRepository.findAll()
            .filter { it.name.lowercase(Locale.getDefault()).startsWith(letter.lowercaseChar()) }.toMutableSet()
    }

    @CacheEvict(cacheNames = ["ArtistCache"], allEntries = true)
    override fun saveAllArtists(artists: MutableIterable<Artist>): MutableIterable<Artist> {
        for (artist in artists) {
            if (!artistRepository.findByName(artist.name).isEmpty) {
                throw RuntimeException("O artista ${artist.name} já existe! Nenhum registro foi inserido!")
            }
        }
        return artistRepository.saveAll(artists)
    }
}