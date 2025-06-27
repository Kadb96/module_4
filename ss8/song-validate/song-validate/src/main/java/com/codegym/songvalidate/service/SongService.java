package com.codegym.songvalidate.service;

import com.codegym.songvalidate.model.Song;
import com.codegym.songvalidate.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository repository;

    @Override
    public Iterable<Song> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Song> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Song song) {
        repository.save(song);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
