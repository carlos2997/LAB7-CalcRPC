package co.edu.escuelaing.is.lab7_calcrpc;

/**
 * Created by carlos on 9/03/18.
 */

public class ServicesException extends Exception {

    public ServicesException(String message){
        super(message);
    }

    public ServicesException(String message, Throwable cause){
        super(message,cause);
    }
}
