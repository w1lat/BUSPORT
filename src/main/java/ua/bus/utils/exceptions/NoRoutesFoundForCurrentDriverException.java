package ua.bus.utils.exceptions;

/**
 * Created by Vitalii on 28.10.2017.
 */
public class NoRoutesFoundForCurrentDriverException extends Exception{

    public NoRoutesFoundForCurrentDriverException() {
        super("Current driver has no active routes");
    }
}
