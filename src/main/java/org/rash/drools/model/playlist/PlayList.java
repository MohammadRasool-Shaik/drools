package org.rash.drools.model.playlist;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private String name;
    private List<Song> songs;

    public PlayList() {
        songs = new ArrayList<>();
    }

    public PlayList(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public boolean addSong(Song song) {
        return songs.add(song);
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "name='" + name + '\'' +
                ", songs=" + songs +
                '}';
    }
}
