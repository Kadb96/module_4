package com.codegym.uploadbaihat.model;

import org.springframework.web.multipart.MultipartFile;

public class SongUpload {
    private long id;
    private String artist;
    private String name;
    private String genre;
    MultipartFile path;

    public SongUpload() {}

    public SongUpload(long id, String artist, String name, String genre, MultipartFile path) {
        this.id = id;
        this.artist = artist;
        this.name = name;
        this.genre = genre;
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public MultipartFile getPath() {
        return path;
    }

    public void setPath(MultipartFile path) {
        this.path = path;
    }
}
