# Funcionalidade de WebBrowser

Esta funcionalidade do projeto é responsável por criar e gerenciar um navegador da web simples, incluindo a capacidade de abrir e fechar sites, bem como criar e remover favoritos (bookmarks). Ela faz uso das seguintes classes:

## Classes

## Diagrama de Classes
Aqui uma representação UML das classes do projeto.

![Diagrama de Classes](https://raw.githubusercontent.com/EuDavidReis-ODev/Java_POO_UML/main/src/assets/Diagrama_de_classes-WebBrowser.png)


### `Bookmark`

- A classe `Bookmark` representa um favorito (bookmark) em um navegador da web.
- Ela pode conter informações como o título do favorito e a URL associada.

### `WebBrowser`

- A classe `WebBrowser` é o núcleo do navegador da web e executa as seguintes funções:
  - Abrir um sites: Permite que o usuário abra um ou vários sites específicos fornecendo a URL.
  - Fechar um site: Fecha um site do navegador.
  - Criar um favorito: Permite que o usuário crie um favorito com nome para a página atual.
  - Remover um favorito: Permite que o usuário remova um favorito da lista de favoritos.
  - Exibir favoritos: Mostra a lista de favoritos disponíveis.

## Exemplo de Uso

Aqui está um exemplo simples de como funciona o Browser (verifique a documentação para mais detalhes):

```java
// Criar uma instância do navegador
WebBrowser browser = new WebBrowser();

// Abrir um site
browser.openNewSite("https://www.example.com");

// Criar um favorito
Bookmark favorite = new Bookmark("Exemplo", "https://www.example.com");
browser.addBookmark(favorite);

// Exibir a lista de favoritos
browser.getBookmarks();


