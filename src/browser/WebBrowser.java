package browser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import browser.objects.Bookmark;

public class WebBrowser {
    private List<Bookmark> bookmarks;
    private List<String> openSites;
    private List<String> history;
    
    public WebBrowser() {
    
        bookmarks = new ArrayList<>();

        bookmarks.add(new Bookmark("www.mrdev.tec.br", "MrDev Site"));
        bookmarks.add(new Bookmark("www.facebook.com.br", "Facebook"));

        openSites = new ArrayList<>();
        history = new ArrayList<>();

    }

    /**
     * Carrega um novo site a partir de uma URL. Também adiciona o site ao histórico.
     * @param url Url para acesso do site.
     * @return void
     */
    public void openNewSite(String url){
        System.out.println(url.concat(" está sendo carregado..."));

        for(int i=0;i<3;i++){
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*4));
                System.out.println("Carregado ".concat(String.valueOf(i*25)).concat("%"));

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        System.out.println("Carregado 100%!");
        openSites.add(url);
        history.add(url);

    }

    /**
     * Carrega um novo site a partir de um Bookmark. Também adiciona o site ao histórico.
     * @param bookmark O favorito que contém a URL.
     * @see Bookmark
     * @return void
     */
    public void openNewSite(Bookmark bookmark){
        String url = bookmark.getUrl();
        System.out.println(url.concat(" está sendo carregado..."));

        for(int i=0;i<3;i++){
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*4));
                System.out.println("Carregado ".concat(String.valueOf(i*25)).concat("%"));

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        System.out.println("Carregado 100%!");
        openSites.add(url);
        history.add(url);

    }

    /**
     * Fecha um site aberto.
     * @param index int Index da aba do site a ser fechado.
     * @return void
     */
    public void closeSiteByIndex(int index){
        String url = openSites.get(index);
        System.out.println("Fechando ".concat(url));
        openSites.remove(index);
        System.out.println("Fechado.");

    }

    /**
     * Adiciona um novo favorito (Bookmark)
     * @param url String
     * @param name String
     * @return void
     */
    public void addBookmar(String url, String name){
        bookmarks.add(new Bookmark(url,name));
        System.out.println(name.concat(" adicionado ao favoritos."));
    }

    /**
     * Remove um favorito salvo com base no nome.
     * @param name String
     * @return void
     */
    public void removeBookmarkByName(String name){
        bookmarks.removeIf(b->(b.getName().equals(name)));
        System.out.println(name.concat(" removido."));
    }

    /**
     * Retorna e printa os favoritos.
     * @see Bookmark
     * @return List Uma lista de favoritos.
     */
    public List<Bookmark> getBookmarks() {
        System.out.println("Favoritos:");
        for(int i=0;i<bookmarks.size();i++){
            System.out.println("Nome:"+bookmarks.get(i).getName()+" Url:"+bookmarks.get(i).getUrl());
        }        
        return bookmarks;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    /**
     * Retorna e printa os site abertos.
     * @return List
     */
    public List<String> getOpenSites() {
        System.out.println("Sites abertos:");
        for(int i=0;i<openSites.size();i++){
            System.out.println("Index:"+i+" Url:"+openSites.get(i));
        }
        return openSites;
    }

    public void setOpenSites(List<String> openSites) {
        this.openSites = openSites;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }




    

    
}
