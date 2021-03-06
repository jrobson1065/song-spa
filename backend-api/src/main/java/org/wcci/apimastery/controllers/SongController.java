package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.entities.Album;
import org.wcci.apimastery.entities.Artist;
import org.wcci.apimastery.entities.Song;
import org.wcci.apimastery.storage.AlbumStorage;
import org.wcci.apimastery.storage.SongStorage;


@RestController
public class SongController {
    SongStorage songStorage;
    AlbumStorage albumStorage;

    public SongController(SongStorage songStorage, AlbumStorage albumStorage) {
        this.songStorage = songStorage;
        this.albumStorage = albumStorage;
    }

    @GetMapping("/api/song/{id}")
    public Song showSingleSong(@PathVariable long id) {
        return songStorage.findById(id);
    }

    @GetMapping("/api/song/{id}/album")
    public Album getSongAlbum (@PathVariable long id){
        return songStorage.findById(id).getSongAlbum();
    }

    @GetMapping("/api/song/{id}/artist")
    public Artist getSongArtist(@PathVariable long id){
        Album songAlbum = songStorage.findById(id).getSongAlbum();
        return songAlbum.getArtist();
    }

    @DeleteMapping("/api/song/{id}")
    public Album deleteSongFromAlbum(@PathVariable long id) {
        Song song = songStorage.findById(id);
        songStorage.delete(id);
        return song.getSongAlbum();
    }
}
