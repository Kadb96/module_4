package com.codegym.ungdungnghenhac.service;

import com.codegym.ungdungnghenhac.model.Song;
import com.codegym.ungdungnghenhac.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }
}
