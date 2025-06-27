package com.codegym.songvalidate.repository;

import com.codegym.songvalidate.model.Song;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface ISongRepository extends PagingAndSortingRepository<Song, Long> {
}
