package com.codegym.songvalidate.service;

import com.codegym.songvalidate.model.Song;

import java.util.Optional;

public interface ISongService {
    Iterable<Song> findAll();
    Optional<Song> findById(Long id);
    void save(Song song );
    void remove(Long id);
}
