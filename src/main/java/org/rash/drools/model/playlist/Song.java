package org.rash.drools.model.playlist;

import java.util.ArrayList;
import java.util.List;

public class Song {
    public enum Genre {POP, JAZZ, CLASSIC, ROCK}

    private String title;
    private Genre genreType;
    private int duration;
    private List<Artist> artists;

    public Song() {
        artists = new ArrayList<>();
    }

    public Song(String title, Genre genreType, int duration) {
        this();
        this.title = title;
        this.genreType = genreType;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenreType() {
        return genreType;
    }

    public void setGenreType(Genre genreType) {
        this.genreType = genreType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public boolean addArtist(Artist artist) {
        return artists.add(artist);
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", genreType=" + genreType +
                ", duration=" + duration +
                ", artists=" + artists +
                '}';
    }
}
