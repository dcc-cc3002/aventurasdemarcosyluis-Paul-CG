package AventurasdeMarcosyLuis.Phases.Exceptions;

/**
 * This Exception is called when an invalid target is selected. It extends the Exception class.
 */
public class InvalidTargetException extends Exception{
    /**
     * The Constructor calls a message that is shown to the user
     * @param message with relevant information about the restriction
     */
    public InvalidTargetException(final String message){
        super(message);
    }
}
