package com.codegym.uploadbaihat.service;

import com.codegym.uploadbaihat.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService implements ISongService {

    private final List<Song> songList = new ArrayList<>();

    @Override
    public List<Song> findAll() {
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }

    @Override
    public Song findById(long id) {
        return songList.get(Integer.parseInt(String.valueOf(id)));
    }

    @Override
    public void update(long id, Song song) {
        songList.set(Integer.parseInt(String.valueOf(id)), song);
    }

    @Override
    public void remove(long id) {

    }
}
