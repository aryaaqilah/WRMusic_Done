package com.example.navigationdrawer;

public class SetterGetter {
    String album_img;
    String album_name;
    String artist_name;
    String album_desc;

    public SetterGetter(String album_img, String album_name, String artist_name, String album_desc) {
        this.album_img = album_img;
        this.album_name = album_name;
        this.artist_name = artist_name;
        this.album_desc = album_desc;
    }

    public String getAlbum_img() {
        return album_img;
    }

    public void setAlbum_img(String album_img) {
        this.album_img = album_img;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getAlbum_desc() {
        return album_desc;
    }

    public void setAlbum_desc(String album_desc) {
        this.album_desc = album_desc;
    }
}
