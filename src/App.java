import MusicPlayer.managers.MusicManager;
import MusicPlayer.managers.VideoManager;

public class App {
    public static void main(String[] args) throws Exception {
        //executeMusicExamples();
        executeVideoExamples();

    }

    public static void executeMusicExamples(){
        System.out.println("Executando examplos das funcionalidades do Tocador de Música!");

        MusicManager musicManager = new MusicManager();

        musicManager.getPlayingMusic().play();
        musicManager.getNextMusic();
        musicManager.getNextMusic();
        musicManager.getNextMusic();

        musicManager.getNextMusic().play();
        musicManager.getNextMusic().play();
        musicManager.getPreviousMusic().play();
        musicManager.getNextMusic().play();
        musicManager.getPreviousMusic().play();
        musicManager.getNextMusic();
        musicManager.getNextMusic();
        musicManager.getNextMusic().play();

        musicManager.getMusicByArtist("Pearl Jam");
        musicManager.getPlayingMusic().play();

        musicManager.getMusicsByAlbumName("Nevermind");
        musicManager.getPlayingMusic().play();
        musicManager.getNextMusic().play();

        musicManager.getMusicsByRate(5);
        musicManager.getPlayingMusic().play();
        musicManager.getNextMusic().play();

        musicManager.getMusicsByRate(3);
        musicManager.getPlayingMusic().play();

        musicManager.orderMusicsByRate();
        musicManager.getPlayingMusic().play();
        musicManager.getNextMusic().play();
        musicManager.getNextMusic().play();
        musicManager.getNextMusic().play();
        musicManager.getNextMusic().stop();

        musicManager.getAllAlbuns();
    }

    public static void executeVideoExamples(){
        VideoManager videoManager = new VideoManager();
        videoManager.getPlayingVideo().play();
        videoManager.getNextVideo().play();
        videoManager.getNextVideo().play();
        videoManager.getNextVideo().play();
        videoManager.getNextVideo().play();
        videoManager.getNextVideo().play();
        
        videoManager.getPreviousVideo().play();
        videoManager.getNextVideo().play();
        videoManager.getPreviousVideo().play();
        videoManager.getNextVideo();
        videoManager.getNextVideo();
        videoManager.getNextVideo().play();

        videoManager.getPlayingVideo().play();
        videoManager.getNextVideo().play();
        videoManager.getNextVideo().play();
        videoManager.getNextVideo().play();
        videoManager.getNextVideo().play();
    }
}
