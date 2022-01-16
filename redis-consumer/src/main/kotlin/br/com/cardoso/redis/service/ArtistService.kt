package br.com.cardoso.redis.service

import br.com.cardoso.redis.model.Artist

interface ArtistService {

    fun findAllArtists(): MutableIterable<Artist>
    fun saveAllArtists(artists: MutableIterable<Artist>): MutableIterable<Artist>
    fun searchArtists(searchArtist: String): MutableIterable<Artist>
}