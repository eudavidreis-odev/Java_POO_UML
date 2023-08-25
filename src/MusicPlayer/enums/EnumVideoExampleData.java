package MusicPlayer.enums;

import java.util.ArrayList;
import java.util.List;

import MusicPlayer.objects.Music;
import MusicPlayer.objects.Video;

public enum EnumVideoExampleData {
    GAME_OF_THRONE (0,"Game of Thrones"),
    VINGADORES_2 (1,"Vingadores: A era de Ultron"),
    FIGHT_CLUB (2,"O Clube da Luta"),
    RICKANDMORTY (3,"Rick and Morty - TEMP 1 - EP1"),
    SIMPSONS_O_FILME (4,"Simpsons: O Filme."),
    SCARY_MOVIE (5,"Todo Mundo em Pânico");

    private int id;
    private String name;

    private EnumVideoExampleData(int id, String name){
        this.id = id;
        this.name = name;

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


    public static ArrayList<Video> getVideos() {
        ArrayList<Video> videos = new ArrayList<Video>();
        videos.add(new Video(GAME_OF_THRONE.getId(), GAME_OF_THRONE.getName()));
        videos.add(new Video(VINGADORES_2.getId(), VINGADORES_2.getName()));
        videos.add(new Video(FIGHT_CLUB.getId(), FIGHT_CLUB.getName()));
        videos.add(new Video(RICKANDMORTY.getId(), RICKANDMORTY.getName()));
        videos.add(new Video(SIMPSONS_O_FILME.getId(), SIMPSONS_O_FILME.getName()));
        videos.add(new Video(SCARY_MOVIE.getId(), SCARY_MOVIE.getName()));

        return videos;
    }

    
    

}
