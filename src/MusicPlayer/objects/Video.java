package MusicPlayer.objects;

import MusicPlayer.interfaces.Playable;

public class Video implements Playable{

    private int id;
    private String name;

    

    public Video(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Executando o vídeo ".concat(name).concat("!"));
    }

    @Override
    public void stop() {
        System.out.println("Vídeo ".concat(name).concat(" pausado!"));
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

    
    
}
