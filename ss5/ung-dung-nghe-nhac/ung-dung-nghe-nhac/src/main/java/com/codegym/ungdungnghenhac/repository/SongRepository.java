package com.codegym.ungdungnghenhac.repository;

import com.codegym.ungdungnghenhac.model.Song;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SongRepository implements ISongRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> query = entityManager.createQuery("select s from Song s", Song.class);
        return query.getResultList();
    }
}
