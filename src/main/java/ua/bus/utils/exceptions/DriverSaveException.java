package ua.bus.utils.exceptions;

/**
 * Created by Vitalii on 11.09.2017.
 */
public class DriverSaveException extends Exception {

    public DriverSaveException(){
        super("Driver was not saved");
    }
}
