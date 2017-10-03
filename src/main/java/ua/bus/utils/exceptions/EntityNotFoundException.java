package ua.bus.utils.exceptions;

/**
 * Created by Vitalii on 14.09.2017.
 */
public class EntityNotFoundException extends Exception{

    public EntityNotFoundException(long id, Class clazz){
        super("Sorry but " + clazz.getName() +" with id" + id + "not found" );
    }
}
