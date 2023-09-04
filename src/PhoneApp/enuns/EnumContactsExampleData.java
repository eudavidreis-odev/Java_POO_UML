package PhoneApp.enuns;

import java.util.ArrayList;
import java.util.List;

import PhoneApp.objetos.Contact;

public enum EnumContactsExampleData {
    ANTONIO ("Antonio Machado","(11)3641-2277","Fixo"),
    MARIA_CLARA("Maria Clara","(11)99541-2527","Celular"),
    GUSTAVO ("Gustavo","(12)3755-2971","Fixo"),
    MONICA ("Mônica Machado","(11)3641-2577","Fixo"),
    CLAUDIO ("Claudio","(11)99846-2277","Celular"),
    MELISA ("Melisa","(41)99741-2277","Celular");

    String name;
    String number;
    String type;
    private EnumContactsExampleData(String name, String number,String type) {
        this.name = name;
        this.number = number;
        this.type = type;
    }

    public static List<Contact> getContatos(){
            List<Contact> contacts = new ArrayList<>();
            contacts.add(new Contact(ANTONIO.getName(),ANTONIO.getNumber(),ANTONIO.getType()));
            contacts.add(new Contact(MARIA_CLARA.getName(),MARIA_CLARA.getNumber(),MARIA_CLARA.getType()));
            contacts.add(new Contact(GUSTAVO.getName(),GUSTAVO.getNumber(),GUSTAVO.getType()));
            contacts.add(new Contact(MONICA.getName(),MONICA.getNumber(),MONICA.getType()));
            contacts.add(new Contact(CLAUDIO.getName(),CLAUDIO.getNumber(),CLAUDIO.getType()));
            contacts.add(new Contact(MELISA.getName(),MELISA.getNumber(),MELISA.getType()));

            return contacts;
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

    
}
