package com.codegym.uploadbaihat.service;

import com.codegym.uploadbaihat.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    Song findById(long id);
    void update(long id, Song song);
    void remove(long id);
}
