package MusicPlayer.enums;

import java.io.File;
import java.util.ArrayList;

import MusicPlayer.objects.Music;

public enum EnumMusicExampleData {
    COME_AS_YOU_ARE (1,"Come as you are","Nirvana",5,"Nevermind",null),
    SMELLS_LIKE_A_TEEN_SPIRIT (2,"Smells Like A Teen Spirit","Nirvana",4,"Nevermind",null),
    HEART_SHAPED_BOX (3,"Heart-Shaped Box","Nirvana",3,"In Utero",null),
    NIB (4,"N.I.B","Black-Sabbath",5,"Black-Sabbath",null),
    DO_THE_EVOLUTION (5,"Do The Evolution","Pearl Jam",3,"Yield",null),
    NOTHING_ELSE_MATTERS (6,"Nothing Else Matters","Metallica",5,"The Black Album",null);
    

    private int id;
    private String name;
    private String artist;
    private int rate;
    private String albumName;
    private File albumArt;

    private EnumMusicExampleData(int id, String name,String artist,int rate,String albumName,File albumArt){
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.rate = rate;
        this.albumName = albumName;
        this.albumArt = albumArt;

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

    public static ArrayList<Music> getMusics() {
        ArrayList<Music> musics = new ArrayList<Music>();

        musics.add(new Music(COME_AS_YOU_ARE.getId(),COME_AS_YOU_ARE.getName(),COME_AS_YOU_ARE.getArtist(),COME_AS_YOU_ARE.getRate(),COME_AS_YOU_ARE.getAlbumName(),COME_AS_YOU_ARE.getAlbumArt()));

        musics.add(new Music(SMELLS_LIKE_A_TEEN_SPIRIT.getId(),SMELLS_LIKE_A_TEEN_SPIRIT.getName(),SMELLS_LIKE_A_TEEN_SPIRIT.getArtist(),SMELLS_LIKE_A_TEEN_SPIRIT.getRate(),SMELLS_LIKE_A_TEEN_SPIRIT.getAlbumName(),SMELLS_LIKE_A_TEEN_SPIRIT.getAlbumArt()));

        musics.add(new Music(HEART_SHAPED_BOX.getId(),HEART_SHAPED_BOX.getName(),HEART_SHAPED_BOX.getArtist(),HEART_SHAPED_BOX.getRate(),HEART_SHAPED_BOX.getAlbumName(),HEART_SHAPED_BOX.getAlbumArt()));    

        musics.add(new Music(NIB.getId(),NIB.getName(),NIB.getArtist(),NIB.getRate(),NIB.getAlbumName(),NIB.getAlbumArt()));        
 
        musics.add(new Music(DO_THE_EVOLUTION.getId(),DO_THE_EVOLUTION.getName(),DO_THE_EVOLUTION.getArtist(),DO_THE_EVOLUTION.getRate(),DO_THE_EVOLUTION.getAlbumName(),DO_THE_EVOLUTION.getAlbumArt()));   
     
        musics.add(new Music(NOTHING_ELSE_MATTERS.getId(),NOTHING_ELSE_MATTERS.getName(),NOTHING_ELSE_MATTERS.getArtist(),NOTHING_ELSE_MATTERS.getRate(),NOTHING_ELSE_MATTERS.getAlbumName(),NOTHING_ELSE_MATTERS.getAlbumArt())); 

        return musics;
    }

    
}
