package AventurasdeMarcosyLuis.Phases.Exceptions;

/**
 * This Exception is called when an invalid transition happens. It extends the Exception class.
 */
public class InvalidTransitionException extends Exception{
    /**
     * The Constructor calls a message that is shown to the user
     * @param message with relevant information about the restriction
     */
    public InvalidTransitionException(final String message){
        super(message);
    }
}
