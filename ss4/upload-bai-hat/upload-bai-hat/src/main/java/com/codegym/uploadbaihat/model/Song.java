package com.codegym.uploadbaihat.model;

public class Song {
    private long id;
    private String name;
    private String artist;
    private String genre;
    private String path;

    public Song() {
    }

    public Song(long id, String name, String artist, String genre, String path) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
