package ua.bus.utils.exceptions;

/**
 * Created by Vitalii on 11.09.2017.
 */
public class EntitySaveException extends Exception {

    public EntitySaveException(Class clazz){
        super(clazz.getName() + " was not saved");
    }
}
