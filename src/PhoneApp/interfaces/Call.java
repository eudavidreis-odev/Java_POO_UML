package PhoneApp.interfaces;

import java.sql.Date;

import PhoneApp.objetos.Callable;
import PhoneApp.objetos.Contact;

public interface Call {

    void start();
    
    void accept();

    Callable end();
}
