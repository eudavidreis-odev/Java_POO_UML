package MusicPlayer.objects;

import java.io.File;

import MusicPlayer.interfaces.Playable;
import MusicPlayer.managers.MusicManager;

/**
 * Music é o Objeto que representa uma música, e oferece métodos para acessar e alterar suas informações.@interface
 * @see MusicManager
 */
public class Music implements Playable{
    private int id;
    private String name;
    private String artist;
    private int rate;
    private String albumName;
    private File albumArt;

    public Music(int id, String name, String artist, int rate, String albumName, File albumArt) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.rate = rate;
        this.albumName = albumName;
        this.albumArt = albumArt;
    }

    @Override
    public void play() {
        System.out.println("Tocando a musica ".concat(name).concat("!"));
    }

    @Override
    public void stop() {
        System.out.println("Musica ".concat(name).concat(" pausada!"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public File getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(File albumArt) {
        this.albumArt = albumArt;
    }

    @Override
    public String toString(){
        return getArtist().concat(" - ").concat(getName());
    }
    
}
