package musicPlayer.objects;

import java.io.File;

import musicPlayer.interfaces.Playable;

public class Podcast implements Playable{
    private int id;
    private String name;
    
    @Override
    public void play() {
        System.out.println("Tocando o podcast ".concat(name).concat("!"));
    }

    @Override
    public void stop() {
        System.out.println("Podcast ".concat(name).concat(" pausado!"));
    }

    

    public Podcast(int id, String name) {
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
    
}
