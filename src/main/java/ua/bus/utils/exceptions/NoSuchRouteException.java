package ua.bus.utils.exceptions;

/**
 * Created by Vitalii on 02.09.2017.
 */
public class NoSuchRouteException extends Exception {

    public NoSuchRouteException(){
        super("Sorry, but route with such parameters does not exists");
    }
}
