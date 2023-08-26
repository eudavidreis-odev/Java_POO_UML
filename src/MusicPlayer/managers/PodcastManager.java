package MusicPlayer.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import MusicPlayer.enums.EnumPodcastExampleData;
import MusicPlayer.objects.Podcast;

/**
 * O PodcastManager é o gerenciador responsável pelos podcasts (representados pelo objeto Podcast). Ele oferece diversos métodos para trabalhar com os podcasts.
 * @see Podcast
 */
public class PodcastManager {
        /**
         * Todos os podcasts do dispositivo.
         */
        private List<Podcast> podcasts;
        /**
         * ID do podcast que esta tocando. Possui o valor -1 caso nenhum podcast tenha sido tocado ainda.
         */
        private int podcastId;
        /**
         * Playlist atual.
         */
        private List<Podcast> playlist;


        public PodcastManager() {
            this.podcasts = EnumPodcastExampleData.getPodcasts();
            this.podcastId = -1;
            this.playlist = new ArrayList<>();
        }

        /**
         * Retorna a Podcast que esta tocando.
         * @return Podcast
         */
        public Podcast getPlayingPodcast(){
            if(podcastId != -1){
                return podcasts.stream().filter(m -> m.getId() == podcastId).toList().get(0);
            }else {
                playlist = podcasts;
                podcastId = podcasts.get(0).getId();
                return podcasts.get(0);
            }
        }

        /**
         * Retorna o próximo podcast, com base na playlist atual.
         * @return Podcast
         */
        public Podcast getNextPodcast(){
            Podcast tempPodcast = playlist.stream().filter(m -> m.getId() == podcastId).toList().get(0);
            int podcastIndex = playlist.indexOf(tempPodcast);
            Podcast newPodcast;
            
            System.out.println("Trocando para o próximo podcast...");

            podcastIndex+=1;
            if(playlist.size() == podcastIndex){
                newPodcast = playlist.get(0);
                setPodcastId(newPodcast.getId());
            }else{
                newPodcast = playlist.get(podcastIndex);
                setPodcastId(newPodcast.getId());
            }

            return newPodcast;
        }

        /**
         * Retorna o podcast anterior, com base na playlist atual.
         * @return Podcast
         */
        public Podcast getPreviousPodcast(){
            Podcast tempPodcast = playlist.stream().filter(m -> m.getId() == podcastId).toList().get(0);
            int podcastIndex = playlist.indexOf(tempPodcast);
            Podcast newPodcast;
            podcastIndex-=1;

            System.out.println("Trocando para podcast anterior...");

            if(podcastIndex == -1){
                newPodcast = playlist.get(playlist.size()-1);
                setPodcastId(newPodcast.getId());
            }else {
                newPodcast = playlist.get(podcastIndex);
                setPodcastId(newPodcast.getId());
            }
            return newPodcast;
        }

        /**
         * Retorna todos os podcasts. Os podcasts seguem a ordenação alfabética.
         * @return List.Podcast
         */
        public List<Podcast> getAllPodcasts(){
            List<Podcast> ordenedMusics = podcasts;
            Collections.sort(ordenedMusics, new Comparator<Podcast>() {
                @Override
                public int compare(Podcast m1, Podcast m2) {
                    return m1.getName().compareTo(m2.getName());
                }
            });
            System.out.println("Retornando todos os podcasts no dispositivo...");
            setPlaylist(ordenedMusics);
            setPodcastId(playlist.get(0).getId());
            return ordenedMusics;
        }

        /**
         * Configura os podcasts disponíveis.
         * @param podcasts Podcasts encontradas no díspositivo.
         */
        public void setPodcasts(List<Podcast> podcasts) {
            this.podcasts = podcasts;
        }

        /**
         * Retorna o ID do podcast que esta tocando.
         * @return int ID do podcast.
         */
        public int getPodcastId() {
            return podcastId;
        }

        /**
         * Atualiza o ID do podcast que esta tocando.
         * @param podcastId int O ID doo novo podcast.
         */
        public void setPodcastId(int podcastId) {
            this.podcastId = podcastId;
        }

        /**
         * Retorna a playlist atual.
         * @return List Retorna uma List<Podcast>.
         */
        public List<Podcast> getPlaylist() {
            return playlist;
        }

        /**
         * Atualiza a playlist atual.
         * @param temppodcasts List Uma List<Podcast> com a nova playlist.
         */
        public void setPlaylist(List<Podcast> temppodcasts) {
            this.playlist = temppodcasts;
        }

}
