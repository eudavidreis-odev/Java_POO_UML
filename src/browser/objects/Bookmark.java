package browser.objects;

/**
 * Bookmark representa um "Favorito", um site salvo para acesso recorrente.
 */
public class Bookmark {
    String url;
    String name;

    public Bookmark(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}
