package MusicPlayer.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import MusicPlayer.enums.EnumMusicExampleData;
import MusicPlayer.objects.Music;

/**
 * O MusicManager é o gerenciador responsável pelas musicas (representadas pelo objeto Musica). Ele oferece diversos métodos para trabalhar com as musicas.
 * @see Musica
 */
public class MusicManager {
        /**
         * Todas as músicas do dispositivo.
         */
        private List<Music> musics;
        /**
         * ID da música que esta tocando. Possui o valor -1 caso nenhuma música tenha sido tocada ainda.
         */
        private int musicId;
        /**
         * Playlist atual.
         */
        private List<Music> playlist;


        public MusicManager() {
            this.musics = EnumMusicExampleData.getMusics();
            this.musicId = -1;
            this.playlist = new ArrayList<>();
        }

        /**
         * Retorna a música que esta tocando.
         * @return Music
         */
        public Music getPlayingMusic(){
            if(musicId != -1){
                return musics.stream().filter(m -> m.getId() == musicId).toList().get(0);
            }else {
                playlist = musics;
                musicId = musics.get(0).getId();
                return musics.get(0);
            }
        }

        /**
         * Retorna a próxima música, com base na playlist atual.
         * @return Music
         */
        public Music getNextMusic(){
            Music tempMusic = playlist.stream().filter(m -> m.getId() == musicId).toList().get(0);
            int musicIndex = playlist.indexOf(tempMusic);
            Music newMusic;
            
            System.out.println("Trocando para a próxima música...");

            musicIndex+=1;
            if(playlist.size() == musicIndex){
                newMusic = playlist.get(0);
                setMusicId(newMusic.getId());
            }else{
                newMusic = playlist.get(musicIndex);
                setMusicId(newMusic.getId());
            }

            return newMusic;
        }

        /**
         * Retorna a música anterior, com base na playlist atual.
         * @return Music
         */
        public Music getPreviousMusic(){
            Music tempMusic = playlist.stream().filter(m -> m.getId() == musicId).toList().get(0);
            int musicIndex = playlist.indexOf(tempMusic);
            Music newMusic;
            musicIndex-=1;

            System.out.println("Trocando para música anterior...");

            if(musicIndex == -1){
                newMusic = playlist.get(playlist.size()-1);
                setMusicId(newMusic.getId());
            }else {
                newMusic = playlist.get(musicIndex);
                setMusicId(newMusic.getId());
            }
            return newMusic;
        }

        /**
         * Retorna todas as músicas. As músicas seguem a ordenação alfabética.
         * @return List.Music
         */
        public List<Music> getAllMusics(){
            List<Music> ordenedMusics = musics;
            Collections.sort(ordenedMusics, new Comparator<Music>() {
                @Override
                public int compare(Music m1, Music m2) {
                    return m1.getName().compareTo(m2.getName());
                }
            });
            System.out.println("Retornando todas as músicas no dispositivo...");
            setPlaylist(ordenedMusics);
            setMusicId(playlist.get(0).getId());
            return ordenedMusics;
        }

        /**
         * Configura as músicas disponíveis.
         * @param musics Musícas encontradas no díspositivo.
         */
        public void setMusics(List<Music> musics) {
            this.musics = musics;
        }

        /**
         * Retorna músicas com base no nome do artista.
         * @param artist
         * @return
         */
        public List<Music> getMusicByArtist(String artist){
            setPlaylist(musics.stream().filter(m -> m.getArtist().equals(artist)).toList());
            setMusicId(playlist.get(0).getId());
            System.out.println("Retornando as músicas do artista ".concat(artist));
            return playlist;
        }

        /**
         * Retorna todos os albuns encontrados no formato Map<Key,List<Music>>.
         * @return Map
         */
        public Map<String,List<Music>> getAllAlbuns(){
            List<Music> ordenedMusicByAlbuns = orderMusicsByAlbuns();

            Map<String,List<Music>> albuns = new HashMap<>();
            ordenedMusicByAlbuns.forEach(m ->{
                List<Music> tempMusics = new ArrayList<Music>();
                tempMusics.add(m);
                albuns.put(m.getAlbumName(),tempMusics);
            });
            System.out.println("Retornando todos os albúns...");

            Set<String> albumNames = albuns.keySet();
            albumNames.forEach(albumName -> {
                System.out.println("Album: ".concat(albumName));
                List<Music> albumMusics = albuns.get(albumName);
                albumMusics.forEach(m ->{
                    System.out.println(m.toString());
                });
            });
            return albuns;
        }

        /**
         * Retorna todas as músicas de um album.
         * @param album String Nome do albúm.
         * @return List<Music> List de músicas do albúm.
         */
        public List<Music> getMusicsByAlbumName(String album){
            setPlaylist(musics.stream().filter(m -> m.getAlbumName().equals(album)).toList());
            setMusicId(playlist.get(0).getId());
            
            System.out.println("Retornando as músicas do albúm ".concat(album));

            return playlist;
        }

        /**
         * Retorna uma lista de músicas com um determminado enrate.
         * @param rate int Número que representa o enrate a ser procurado.
         * @return List Retorna uma List<Music> com as músicas.
         */
        public List<Music> getMusicsByRate(int rate){
            setPlaylist(musics.stream().filter(m -> m.getRate() == rate).toList());
            setMusicId(playlist.get(0).getId());
            System.out.println("Retornando apenas músicas do nota ".concat(String.valueOf(rate)));
            return playlist;
        }

        /**
         * Ordena músicas com base no enrate, e retorna uma lista.
         * @return List List<Music> ordenado por enrate.
         */
        public List<Music> orderMusicsByRate(){
            List<Music> ordenedMusics = musics;
            Collections.sort(ordenedMusics, new Comparator<Music>() {
                @Override
                public int compare(Music m1, Music m2) {
                    return Integer.compare(m1.getRate(), m2.getRate());
                }
            });
            setPlaylist(ordenedMusics);
            setMusicId(playlist.get(0).getId());
            System.out.println("Ordenando as músicas com base na nota ");
            return ordenedMusics;
        }

        /**
         * Ordena todas as músicas do dispositivo com base nos seus albúns.
         * @return List Retorna uma List<Music> ordenada pelo nome do albúm.
         */
        public List<Music> orderMusicsByAlbuns(){
            List<Music> ordenedMusics = musics;
            Collections.sort(ordenedMusics, new Comparator<Music>() {
                @Override
                public int compare(Music m1, Music m2) {
                    return m1.getAlbumName().compareTo(m2.getAlbumName());
                }
            });
            setPlaylist(ordenedMusics);
            setMusicId(playlist.get(0).getId());
            System.out.println("Ordenando as músicas usando os albúns, em orde alfabética.");
            return ordenedMusics;
        }

        /**
         * Retorna o ID da música que esta tocando.
         * @return int ID da música.
         */
        public int getMusicId() {
            return musicId;
        }

        /**
         * Atualiza o ID da música que esta tocando.
         * @param musicId int O ID da nova música.
         */
        public void setMusicId(int musicId) {
            this.musicId = musicId;
        }

        /**
         * Retorna a playlist atual.
         * @return List Retorna uma List<Music>.
         */
        public List<Music> getPlaylist() {
            return playlist;
        }

        /**
         * Atualiza a playlist atual.
         * @param tempMusics List Uma List<Music> com a nova playlist atual.
         */
        public void setPlaylist(List<Music> tempMusics) {
            this.playlist = tempMusics;
        }

}
