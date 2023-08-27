# Funcionalidade de MusicPlayer

Neste subdiretório, exploramos a funcionalidade de MusicPlayer, parte do projeto desenvolvido durante o Bootcamp DIO - JAVA + AWS (UML e Java POO) da empresa DIO (Digital Innovation One). A funcionalidade de MusicPlayer envolve a reprodução de diversos tipos de arquivos, como músicas, vídeos, podcasts e audiobooks.

## Interface Playable

A base para todos os tipos de arquivos que o MusicPlayer executa é a interface `Playable`. Esta interface define os métodos essenciais para reprodução e pausa dos arquivos.
```java
public interface Playable {
    void play();
    void stop();
}
```

## Tipos de Arquivos Executados pelo MusicPlayer

### Music

O objeto `Music` possui atributos como nome da música, artista, avaliação e capa do álbum.

### Video

O objeto `Video` possui atributos como nome e avaliação.

### Podcast

O objeto `Podcast` possui atributos como nome.

### AudioBook

O objeto `AudioBook` possui atributos como nome, capa, escritor e avaliação.

## Managers Responsáveis

Existem quatro managers, cada um responsável por um tipo de objeto que o MusicPlayer pode reproduzir:

1. `MusicManager`: Responsável por gerenciar as músicas.
2. `VideoManager`: Responsável por gerenciar os vídeos.
3. `PodcastManager`: Responsável por gerenciar os podcasts.
4. `AudioBookManager`: Responsável por gerenciar os audiobooks.

Cada manager oferece métodos para interagir com os objetos correspondentes, permitindo reproduzir, pausar e gerenciar as diferentes funcionalidades de cada tipo de arquivo.

Esperamos que esta funcionalidade do projeto seja uma oportunidade para explorar a implementação de diferentes tipos de arquivos no MusicPlayer, proporcionando uma experiência completa de reprodução.

Aproveite e bons estudos! 🎶🎬🎙📚
