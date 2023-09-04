package PhoneApp.objetos;

/**
 * Contact representa um contato. Com os atributos nome = "name", número = "number" e tipo = "type" que descreve se o contato é 
 * fixo ou de um celular.
 */
public class Contact {
    String name;
    String number;
    String type; 
    public Contact(String name, String number, String type) {
        this.name = name;
        this.number = number;
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
}
