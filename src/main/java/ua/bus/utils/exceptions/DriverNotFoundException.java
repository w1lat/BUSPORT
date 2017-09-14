package ua.bus.utils.exceptions;

/**
 * Created by Vitalii on 14.09.2017.
 */
public class DriverNotFoundException extends Exception{

    public DriverNotFoundException(long id){
        super("Sorry but driver with id" + id + "not found" );
    }
}
