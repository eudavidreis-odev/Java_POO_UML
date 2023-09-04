package PhoneApp.interfaces;

import java.sql.Date;

import PhoneApp.objetos.Callable;
import PhoneApp.objetos.Contact;

/**
 * Interface Call implementa os metodos básicos de ligação.
 */
public interface Call {

    /**
     * Inicia uma chamada.
     */
    void start();
    
    /**
     * Aceita uma chamada recebida.
     */
    void accept();

    /**
     * Termina uma chamada.
     */
    Callable end();
}
