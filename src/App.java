import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import browser.WebBrowser;
import musicPlayer.managers.AudioBookManager;
import musicPlayer.managers.MusicManager;
import musicPlayer.managers.PodcastManager;
import musicPlayer.managers.VideoManager;
import phoneApp.PhoneApp;
import phoneApp.objetos.Callable;
import phoneApp.objetos.Contact;
import phoneApp.objetos.VideoCall;
import phoneApp.objetos.VoiceCall;
import phoneApp.objetos.VoiceMail;
public class App {
    public static void main(String[] args) throws Exception {
        //executeMusicExamples();
        //executeVideoExamples();
        //executePodcastExamples();
        //executeAudioBookExamples();
        //executeCallsExamples();
        executeWebBrowserExamples();
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

        videoManager.getVideosByRate(3);
        videoManager.getPlayingVideo().play();

        videoManager.orderVideosByRate();
        videoManager.getPlayingVideo().play();
        videoManager.getNextVideo().play();
        videoManager.getNextVideo().play();
        videoManager.getNextVideo().play();
        videoManager.getPlayingVideo().stop();
        videoManager.getPreviousVideo().play();
        videoManager.getPlayingVideo().stop();


    }

    public static void executePodcastExamples(){
        PodcastManager podcastManager = new PodcastManager();
        podcastManager.getPlayingPodcast().play();
        podcastManager.getNextPodcast().play();
        podcastManager.getNextPodcast().play();
        podcastManager.getNextPodcast().play();
        podcastManager.getNextPodcast().play();
        podcastManager.getNextPodcast().play();
        podcastManager.getNextPodcast().stop();
        podcastManager.getPlayingPodcast().play();
        podcastManager.getNextPodcast().play();
        podcastManager.getPreviousPodcast().play();

    }

    public static void executeAudioBookExamples(){
        AudioBookManager audioBookManager = new AudioBookManager();

        audioBookManager.getAllAudioBooks();
        audioBookManager.getPlayingAudioBook().play();
        audioBookManager.getNextAudioBook().play();
        audioBookManager.getNextAudioBook().play();
        audioBookManager.getNextAudioBook().play();
        audioBookManager.getNextAudioBook().play();
        audioBookManager.getPreviousAudioBook().play();
        audioBookManager.getPreviousAudioBook().play();
        audioBookManager.getPlayingAudioBook().stop();
        audioBookManager.getPlayingAudioBook().play();
        audioBookManager.getNextAudioBook().play();
        audioBookManager.getNextAudioBook().play();

        audioBookManager.getAudioBooksByRate(5);
        audioBookManager.getPlayingAudioBook().play();
        audioBookManager.getNextAudioBook().play();
        audioBookManager.getNextAudioBook().play();

        audioBookManager.getAudioBooksByRate(4);
        audioBookManager.getPlayingAudioBook().play();
        audioBookManager.getNextAudioBook().play();
        audioBookManager.getNextAudioBook().play();

        audioBookManager.getAudioBooksByWriter("J.R.R. Tolkien");
        audioBookManager.getPlayingAudioBook().play();

        audioBookManager.orderAudioBooksByRate();
        audioBookManager.getPlayingAudioBook().play();
        audioBookManager.getPlayingAudioBook().stop();

    }

    public static void executeCallsExamples() throws InterruptedException{
        PhoneApp phoneApp = new PhoneApp();

        Contact myContact = new Contact("Meu contato","(12)99719-0932","Celular");
        List<Contact> myContactList = phoneApp.getContacts();

        
        VoiceCall voiceCall1 = new VoiceCall(myContactList.get((int) (Math.random()* (myContactList.size()-1))),myContact,0, new Date());
        phoneApp.getCallListener().addNewCall(voiceCall1);

        
        phoneApp.acceptCall();

        phoneApp.endCall();

        Callable lastCall = phoneApp.getCallHistory().get(0);
        if(lastCall.getCaller().getName() == null)System.out.println("Quem ligou: "+lastCall.getCaller().getNumber());
        else System.out.println("Quem ligou: "+lastCall.getCaller().getName());

        if(lastCall.getCaller().getName() == null)System.out.println("Quem recebeu a ligação: "+lastCall.getRecipient().getNumber());
        else System.out.println("Quem recebeu a ligação: "+lastCall.getRecipient().getName());

        System.out.println("Duração: "+lastCall.getDuration()+"s Data: "+lastCall.getDate());



        VideoCall videoCall1 = new VideoCall(myContact, myContactList.get((int) (Math.random()* (myContactList.size()-1))),0, new Date());
        phoneApp.getCallListener().addNewCall(videoCall1);

        phoneApp.startCall();

        phoneApp.endCall();

        lastCall = phoneApp.getCallHistory().get(1);
        if(lastCall.getCaller().getName() == null)System.out.println("Quem ligou: "+lastCall.getCaller().getNumber());
        else System.out.println("Quem ligou: "+videoCall1.getCaller().getName());

        if(lastCall.getCaller().getName() == null)System.out.println("Quem recebeu a ligação: "+lastCall.getRecipient().getNumber());
        else System.out.println("Quem recebeu a ligação: "+videoCall1.getRecipient().getName());

        System.out.println("Duração: "+lastCall.getDuration()+"s Data: "+lastCall.getDate());
            
        System.out.println("===============================");
        System.out.println("Exibindo histórico de chamadas:");

        List<Callable> callHistory = phoneApp.getCallHistory();

        callHistory.forEach(call ->{
            System.out.println("-------------------------------");

            if(call.getCaller().getName()!=null) System.out.println(call.getCaller().getName());
            else System.out.println(call.getCaller().getNumber());

            if(call.getRecipient().getName()!=null) System.out.println(call.getRecipient().getName());
            else System.out.println(call.getRecipient().getNumber());
            
            
            System.out.println("Data: "+call.getDate());
            System.out.println("Duração: "+call.getDuration());
            System.out.println("-------------------------------");

        });
        
        List<VoiceMail> voiceMailsByNumber = phoneApp.getCallListener().getVoiceMailByNumber("(13)3647-4347");

        if(voiceMailsByNumber.size()>0){
            System.out.println("Existem "+voiceMailsByNumber.size()+" mensagens do número (13)3647-4347");

            voiceMailsByNumber.forEach(voiceMail ->{
                System.out.println("Número: "+voiceMail.getNumber()+" Mensagem: "+voiceMail.getVoiceMsg());
            });
        }

        voiceMailsByNumber = phoneApp.getCallListener().getVoiceMailByNumber("(14)1100-2233");

        if(voiceMailsByNumber.size()>0){
            System.out.println("Existem "+voiceMailsByNumber.size()+" mensagens do número (14)1100-2233");

            voiceMailsByNumber.forEach(voiceMail ->{
                System.out.println("Número: "+voiceMail.getNumber()+" Mensagem: "+voiceMail.getVoiceMsg());
            });
        }else System.out.println("Não existem mensagens do número (14)1100-2233 na caixa postal.");
    }

    public static void executeWebBrowserExamples(){
        WebBrowser browser = new WebBrowser();
        
        browser.openNewSite("www.google.com");

        browser.openNewSite("www.youtube.com");
        
        browser.openNewSite("www.mrdev.tec.br");

        browser.getOpenSites();

        browser.closeSiteByIndex(1);

        browser.getOpenSites();

        browser.getBookmarks();

        browser.addBookmar("www.google.com", "Google");

        browser.addBookmar("www.stackoverflow.com", "StackOverflow");

        browser.getBookmarks();

        browser.removeBookmarkByName("Facebook");

        browser.getBookmarks();

        browser.openNewSite(browser.getBookmarks().get(2));

    }
}
