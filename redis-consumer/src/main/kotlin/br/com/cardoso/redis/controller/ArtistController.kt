package br.com.cardoso.redis.controller

import br.com.cardoso.redis.model.Artist
import br.com.cardoso.redis.model.SearchArtist
import br.com.cardoso.redis.service.ArtistService
import org.springframework.web.bind.annotation.*

@RestController
class ArtistController(private val artistService: ArtistService) {

    @GetMapping
    fun findAllArtists(): MutableIterable<Artist> = artistService.findAllArtists()

    @GetMapping("/search")
    fun searchArtists(@RequestBody searchArtist: SearchArtist): MutableIterable<Artist> = artistService.searchArtists(searchArtist.partialName)

    @PostMapping
    fun saveAllArtists(@RequestBody artists: MutableList<Artist>): MutableIterable<Artist> =
        artistService.saveAllArtists(artists)
}