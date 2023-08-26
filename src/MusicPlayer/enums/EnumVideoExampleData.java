package MusicPlayer.enums;

import java.util.ArrayList;
import java.util.List;

import MusicPlayer.objects.Music;
import MusicPlayer.objects.Video;

public enum EnumVideoExampleData {
    GAME_OF_THRONE (0,"Game of Thrones",4),
    VINGADORES_2 (1,"Vingadores: A era de Ultron",3),
    FIGHT_CLUB (2,"O Clube da Luta",5),
    RICKANDMORTY (3,"Rick and Morty - TEMP 1 - EP1",5),
    SIMPSONS_O_FILME (4,"Simpsons: O Filme.",4),
    SCARY_MOVIE (5,"Todo Mundo em Pânico",5);

    private int id;
    private String name;
    private int rate;

    private EnumVideoExampleData(int id, String name,int rate){
        this.id = id;
        this.name = name;
        this.rate = rate;
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


    public int getRate() {
        return rate;
    }


    public void setRate(int rate) {
        this.rate = rate;
    }


    public static ArrayList<Video> getVideos() {
        ArrayList<Video> videos = new ArrayList<Video>();
        videos.add(new Video(GAME_OF_THRONE.getId(), GAME_OF_THRONE.getName(),GAME_OF_THRONE.getRate()));
        videos.add(new Video(VINGADORES_2.getId(), VINGADORES_2.getName(),VINGADORES_2.getRate()));
        videos.add(new Video(FIGHT_CLUB.getId(), FIGHT_CLUB.getName(),FIGHT_CLUB.getRate()));
        videos.add(new Video(RICKANDMORTY.getId(), RICKANDMORTY.getName(),RICKANDMORTY.getRate()));
        videos.add(new Video(SIMPSONS_O_FILME.getId(), SIMPSONS_O_FILME.getName(),SIMPSONS_O_FILME.getRate()));
        videos.add(new Video(SCARY_MOVIE.getId(), SCARY_MOVIE.getName(),SCARY_MOVIE.getRate()));

        return videos;
    }

    
    

}
