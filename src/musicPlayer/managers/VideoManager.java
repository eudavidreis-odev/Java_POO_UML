package musicPlayer.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import musicPlayer.enums.EnumVideoExampleData;
import musicPlayer.objects.Video;

/**
 * O VideoManager é o gerenciador responsável pelos vídeos (representados pelo objeto Video). Ele oferece diversos métodos para trabalhar com os vídeos.
 * @see Video
 */
public class VideoManager {
        /**
         * Todos os vídeos do dispositivo.
         */
        private List<Video> videos;
        /**
         * ID do vídeo que esta tocando. Possui o valor -1 caso nenhum vídeo tenha sido tocado ainda.
         */
        private int videoId;
        /**
         * Playlist atual.
         */
        private List<Video> playlist;


        public VideoManager() {
            this.videos = EnumVideoExampleData.getVideos();
            this.videoId = -1;
            this.playlist = new ArrayList<>();
        }

        /**
         * Retorna a video que esta tocando.
         * @return Video
         */
        public Video getPlayingVideo(){
            if(videoId != -1){
                return videos.stream().filter(m -> m.getId() == videoId).toList().get(0);
            }else {
                playlist = videos;
                videoId = videos.get(0).getId();
                return videos.get(0);
            }
        }

        /**
         * Retorna o próximo vídeo, com base na playlist atual.
         * @return Video
         */
        public Video getNextVideo(){
            Video tempVideo = playlist.stream().filter(m -> m.getId() == videoId).toList().get(0);
            int videoIndex = playlist.indexOf(tempVideo);
            Video newVideo;
            
            System.out.println("Trocando para o próximo vídeo...");

            videoIndex+=1;
            if(playlist.size() == videoIndex){
                newVideo = playlist.get(0);
                setVideoId(newVideo.getId());
            }else{
                newVideo = playlist.get(videoIndex);
                setVideoId(newVideo.getId());
            }

            return newVideo;
        }

        /**
         * Retorna o vídeo anterior, com base na playlist atual.
         * @return Video
         */
        public Video getPreviousVideo(){
            Video tempVideo = playlist.stream().filter(m -> m.getId() == videoId).toList().get(0);
            int videoIndex = playlist.indexOf(tempVideo);
            Video newVideo;
            videoIndex-=1;

            System.out.println("Trocando para vídeo anterior...");

            if(videoIndex == -1){
                newVideo = playlist.get(playlist.size()-1);
                setVideoId(newVideo.getId());
            }else {
                newVideo = playlist.get(videoIndex);
                setVideoId(newVideo.getId());
            }
            return newVideo;
        }

        /**
         * Retorna todos os vídeos. Os vídeos seguem a ordenação alfabética.
         * @return List.Video
         */
        public List<Video> getAllVideos(){
            List<Video> ordenedMusics = videos;
            Collections.sort(ordenedMusics, new Comparator<Video>() {
                @Override
                public int compare(Video m1, Video m2) {
                    return m1.getName().compareTo(m2.getName());
                }
            });
            System.out.println("Retornando todos os vídeos no dispositivo...");
            setPlaylist(ordenedMusics);
            setVideoId(playlist.get(0).getId());
            return ordenedMusics;
        }

        /**
         * Configura os videos disponíveis.
         * @param videos Vídeos encontradas no díspositivo.
         */
        public void setVideos(List<Video> videos) {
            this.videos = videos;
        }
        /**
         * Retorna uma lista de vídeos com um determminado enrate.
         * @param rate int Número que representa o enrate a ser procurado.
         * @return List Retorna uma List<Video> com os vídeos.
         */
        public List<Video> getVideosByRate(int rate){
            setPlaylist(videos.stream().filter(m -> m.getRate() == rate).toList());
            setVideoId(playlist.get(0).getId());
            System.out.println("Retornando apenas vídeos de nota ".concat(String.valueOf(rate)));
            return playlist;
        }

        /**
         * Ordena vídeos com base na avaliação, e retorna uma lista.
         * @return List List<Video> ordenado por enrate.
         */
        public List<Video> orderVideosByRate(){
            List<Video> ordenedVideos = videos;
            Collections.sort(ordenedVideos, new Comparator<Video>() {
                @Override
                public int compare(Video m1, Video m2) {
                    return Integer.compare(m2.getRate(), m1.getRate());
                }
            });
            setPlaylist(ordenedVideos);
            setVideoId(playlist.get(0).getId());
            System.out.println("Ordenando os vídeos com base na nota ");
            return ordenedVideos;
        }


        /**
         * Retorna o ID do vídeo que esta tocando.
         * @return int ID do vídeo.
         */
        public int getVideoId() {
            return videoId;
        }

        /**
         * Atualiza o ID do vídeo que esta tocando.
         * @param videoId int O ID doo novo vídeo.
         */
        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }

        /**
         * Retorna a playlist atual.
         * @return List Retorna uma List<Video>.
         */
        public List<Video> getPlaylist() {
            return playlist;
        }

        /**
         * Atualiza a playlist atual.
         * @param tempMusics List Uma List<Video> com a nova playlist.
         */
        public void setPlaylist(List<Video> tempVideos) {
            this.playlist = tempVideos;
        }

}
