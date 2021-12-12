package br.com.cardoso.redis.controller

import br.com.cardoso.redis.model.Artist
import br.com.cardoso.redis.service.ArtistService
import org.springframework.web.bind.annotation.*

@RestController
class ArtistController(private val artistService: ArtistService) {

    @GetMapping
    fun findAllArtists(): MutableIterable<Artist> = artistService.findAllArtists()

    @GetMapping("/{letter}")
    fun searchArtists(@PathVariable letter: Char): MutableIterable<Artist> = artistService.searchArtists(letter)

    @PostMapping
    fun saveAllArtists(@RequestBody artists: MutableList<Artist>): MutableIterable<Artist> =
        artistService.saveAllArtists(artists)
}