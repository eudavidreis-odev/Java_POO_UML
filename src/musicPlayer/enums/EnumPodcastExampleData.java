package musicPlayer.enums;

import java.util.ArrayList;
import java.util.List;

import musicPlayer.objects.Podcast;

public enum EnumPodcastExampleData {
    PODPAH (0,"Podpah Podcast."),
    FLOW (1,"Flow Podcast."),
    VENUS (2,"Venûs Podcast."),
    MANO_A_MANO (3,"Mano a Mano.");

    
    private int id;
    private String name;

    private EnumPodcastExampleData(int id, String name) {
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

    public static List<Podcast> getPodcasts(){
        List<Podcast> podcasts = new ArrayList<>();
        podcasts.add(new Podcast(PODPAH.getId(),PODPAH.getName()));
        podcasts.add(new Podcast(FLOW.getId(),FLOW.getName()));
        podcasts.add(new Podcast(VENUS.getId(),VENUS.getName()));
        podcasts.add(new Podcast(MANO_A_MANO.getId(),MANO_A_MANO.getName()));

        return podcasts;
    }
    
}
