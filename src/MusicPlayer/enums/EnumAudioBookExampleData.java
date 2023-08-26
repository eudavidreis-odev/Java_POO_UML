package MusicPlayer.enums;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import MusicPlayer.objects.AudioBook;

public enum EnumAudioBookExampleData {
    HARRY_POTTER(0,"Harry Potter e a Pedra Filosofal", null, "J.K. Rowling", 5),
    SOL_E_PARA_TODOS(1,"O Sol é para Todos", null, "Harper Lee", 4),
    O_GRANDE_GATSBY(2,"O Grande Gatsby", null, "F. Scott Fitzgerald", 4),
    BOOK_1984(3,"1984", null, "George Orwell", 5),
    ORGULHO_E_PRECONCEITO(4,"Orgulho e Preconceito", null, "Jane Austen", 5),
    O_APANHADOR(5,"O Apanhador no Campo de Centeio", null, "J.D. Salinger", 3),
    O_SENHOR_DOS_ANEIS(6,"O Senhor dos Anéis", null, "J.R.R. Tolkien", 5),
    AO_FAROL(7,"Ao Farol", null, "Virginia Woolf", 4),
    ADMIRAVEL_MUNDO_NOVO(8,"Admirável Mundo Novo", null, "Aldous Huxley", 4),
    JOGOS_VORAZES(9,"Jogos Vorazes", null, "Suzanne Collins", 3);

    private int id;
    private String name;
    private File audioBookArt;
    private String writer;
    private int rate;

    private EnumAudioBookExampleData(int id, String name, File audioBookArt, String writer, int rate) {
        this.id = id;
        this.name = name;
        this.audioBookArt = audioBookArt;
        this.writer = writer;
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
    public File getAudioBookArt() {
        return audioBookArt;
    }
    public void setAudioBookArt(File audioBookArt) {
        this.audioBookArt = audioBookArt;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public int getRate() {
        return rate;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }

    public static List<AudioBook> getAudioBooks(){
        List<AudioBook> audioBooks = new ArrayList<>();
        audioBooks.add(new AudioBook(HARRY_POTTER.getId(),HARRY_POTTER.getName(),HARRY_POTTER.getAudioBookArt(),HARRY_POTTER.getWriter(),HARRY_POTTER.getRate()));

        audioBooks.add(new AudioBook(SOL_E_PARA_TODOS.getId(),SOL_E_PARA_TODOS.getName(),SOL_E_PARA_TODOS.getAudioBookArt(),SOL_E_PARA_TODOS.getWriter(),SOL_E_PARA_TODOS.getRate()));

        audioBooks.add(new AudioBook(O_GRANDE_GATSBY.getId(),O_GRANDE_GATSBY.getName(),O_GRANDE_GATSBY.getAudioBookArt(),O_GRANDE_GATSBY.getWriter(),O_GRANDE_GATSBY.getRate()));

        audioBooks.add(new AudioBook(BOOK_1984.getId(),BOOK_1984.getName(),BOOK_1984.getAudioBookArt(),BOOK_1984.getWriter(),BOOK_1984.getRate()));

        audioBooks.add(new AudioBook(ORGULHO_E_PRECONCEITO.getId(),ORGULHO_E_PRECONCEITO.getName(),ORGULHO_E_PRECONCEITO.getAudioBookArt(),ORGULHO_E_PRECONCEITO.getWriter(),ORGULHO_E_PRECONCEITO.getRate()));

        audioBooks.add(new AudioBook(O_APANHADOR.getId(),O_APANHADOR.getName(),O_APANHADOR.getAudioBookArt(),O_APANHADOR.getWriter(),O_APANHADOR.getRate()));

        audioBooks.add(new AudioBook(O_SENHOR_DOS_ANEIS.getId(),O_SENHOR_DOS_ANEIS.getName(),O_SENHOR_DOS_ANEIS.getAudioBookArt(),O_SENHOR_DOS_ANEIS.getWriter(),O_SENHOR_DOS_ANEIS.getRate()));

        audioBooks.add(new AudioBook(AO_FAROL.getId(),AO_FAROL.getName(),AO_FAROL.getAudioBookArt(),AO_FAROL.getWriter(),AO_FAROL.getRate()));

        audioBooks.add(new AudioBook(ADMIRAVEL_MUNDO_NOVO.getId(),ADMIRAVEL_MUNDO_NOVO.getName(),ADMIRAVEL_MUNDO_NOVO.getAudioBookArt(),ADMIRAVEL_MUNDO_NOVO.getWriter(),ADMIRAVEL_MUNDO_NOVO.getRate()));
        
        audioBooks.add(new AudioBook(JOGOS_VORAZES.getId(),JOGOS_VORAZES.getName(),JOGOS_VORAZES.getAudioBookArt(),JOGOS_VORAZES.getWriter(),JOGOS_VORAZES.getRate()));

        return audioBooks;
    }
    
}
