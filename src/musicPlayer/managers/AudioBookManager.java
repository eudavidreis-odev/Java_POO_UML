package musicPlayer.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import musicPlayer.enums.EnumAudioBookExampleData;
import musicPlayer.objects.AudioBook;

/**
 * O AudioBookManager é o gerenciador responsável pelos audiobooks(representados pelo objeto AudioBook). Ele oferece diversos métodos para trabalhar com os audiobooks.
 * @see AudioBook
 */
public class AudioBookManager {
        /**
         * Todos os audiobooks do dispositivo.
         */
        private List<AudioBook> audioBooks;
        /**
         * ID doo audiobook que esta tocando. Possui o valor -1 caso nenhum audiobook tenha sido tocado ainda.
         */
        private int audioBookId;
        /**
         * Playlist atual.
         */
        private List<AudioBook> playlist;


        public AudioBookManager() {
            this.audioBooks = EnumAudioBookExampleData.getAudioBooks();
            this.audioBookId = -1;
            this.playlist = new ArrayList<>();
        }

        /**
         * Retorna o audiobook que esta tocando.
         * @return AudioBook
         */
        public AudioBook getPlayingAudioBook(){
            if(audioBookId != -1){
                return audioBooks.stream().filter(m -> m.getId() == audioBookId).toList().get(0);
            }else {
                playlist = audioBooks;
                audioBookId = audioBooks.get(0).getId();
                return audioBooks.get(0);
            }
        }

        /**
         * Retorna a próximo audiobook, com base na playlist atual.
         * @return AudioBook
         */
        public AudioBook getNextAudioBook(){
            AudioBook tempAudioBook = playlist.stream().filter(m -> m.getId() == audioBookId).toList().get(0);
            int audioBookIndex = playlist.indexOf(tempAudioBook);
            AudioBook newAudioBook;
            
            System.out.println("Trocando para a próximo audiobook...");

            audioBookIndex+=1;
            if(playlist.size() == audioBookIndex){
                newAudioBook = playlist.get(0);
                setAudioBookId(newAudioBook.getId());
            }else{
                newAudioBook = playlist.get(audioBookIndex);
                setAudioBookId(newAudioBook.getId());
            }

            return newAudioBook;
        }

        /**
         * Retorno o audiobook anterior, com base na playlist atual.
         * @return AudioBook
         */
        public AudioBook getPreviousAudioBook(){
            AudioBook tempAudioBook = playlist.stream().filter(m -> m.getId() == audioBookId).toList().get(0);
            int musicIndex = playlist.indexOf(tempAudioBook);
            AudioBook newAudioBook;
            musicIndex-=1;

            System.out.println("Trocando para o audiobook anterior...");

            if(musicIndex == -1){
                newAudioBook = playlist.get(playlist.size()-1);
                setAudioBookId(newAudioBook.getId());
            }else {
                newAudioBook = playlist.get(musicIndex);
                setAudioBookId(newAudioBook.getId());
            }
            return newAudioBook;
        }

        /**
         * Retorna todos os audiobooks. Os audiobooks seguem a ordenação alfabética.
         * @return List.AudioBook
         */
        public List<AudioBook> getAllAudioBooks(){
            List<AudioBook> ordenedMusics = audioBooks;
            Collections.sort(ordenedMusics, new Comparator<AudioBook>() {
                @Override
                public int compare(AudioBook m1, AudioBook m2) {
                    return m1.getName().compareTo(m2.getName());
                }
            });
            System.out.println("Retornando todas as audiobooks no dispositivo...");
            setPlaylist(ordenedMusics);
            setAudioBookId(playlist.get(0).getId());
            return ordenedMusics;
        }

        /**
         * Configura as audiobooks disponíveis.
         * @param audioBooks Musícas encontradas no díspositivo.
         */
        public void setAudioBooks(List<AudioBook> audioBooks) {
            this.audioBooks = audioBooks;
        }

        /**
         * Retorna audiobooks com base no nome do autor.
         * @param writer
         * @return
         */
        public List<AudioBook> getAudioBooksByWriter(String writer){
            setPlaylist(audioBooks.stream().filter(m -> m.getWriter().equals(writer)).toList());
            setAudioBookId(playlist.get(0).getId());
            System.out.println("Retornando os audiobooks do autor ".concat(writer));
            return playlist;
        }

        /**
         * Retorna uma lista de audiobooks com uma determminada avaliação.
         * @param rate int Número que representa a avaliação a ser procurada.
         * @return List Retorna uma List<AudioBook> com oos audiobooks.
         */
        public List<AudioBook> getAudioBooksByRate(int rate){
            setPlaylist(audioBooks.stream().filter(m -> m.getRate() == rate).toList());
            setAudioBookId(playlist.get(0).getId());
            System.out.println("Retornando apenas audiobooks do avaliação ".concat(String.valueOf(rate)));
            return playlist;
        }

        /**
         * Ordena audiobooks com base na avaliação, e retorna uma lista.
         * @return List List<AudioBook> ordenado por avaliação.
         */
        public List<AudioBook> orderAudioBooksByRate(){
            List<AudioBook> ordenedMusics = audioBooks;
            Collections.sort(ordenedMusics, new Comparator<AudioBook>() {
                @Override
                public int compare(AudioBook m1, AudioBook m2) {
                    return Integer.compare(m1.getRate(), m2.getRate());
                }
            });
            setPlaylist(ordenedMusics);
            setAudioBookId(playlist.get(0).getId());
            System.out.println("Ordenando as audiobooks com base na avaliação ");
            return ordenedMusics;
        }

        /**
         * Retorna o ID da audiobook que esta tocando.
         * @return int ID da audiobook.
         */
        public int getAudioBookId() {
            return audioBookId;
        }

        /**
         * Atualiza o ID do audiobook que esta tocando.
         * @param musicId int O ID do novo audiobook.
         */
        public void setAudioBookId(int musicId) {
            this.audioBookId = musicId;
        }

        /**
         * Retorna a playlist atual.
         * @return List Retorna uma List<AudioBook>.
         */
        public List<AudioBook> getPlaylist() {
            return playlist;
        }

        /**
         * Atualiza a playlist atual.
         * @param tempAudioBooks List Uma List<AudioBook> com a nova playlist atual.
         */
        public void setPlaylist(List<AudioBook> tempAudioBooks) {
            this.playlist = tempAudioBooks;
        }

}
