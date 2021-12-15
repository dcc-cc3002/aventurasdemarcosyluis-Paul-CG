package AventurasdeMarcosyLuis.Phases.Exceptions;

/**
 * This Exception is called when an invalid choice happens. It extends the Exception class.
 */
public class InvalidChoiceException extends Exception{
    /**
     * The Constructor calls a message that is shown to the user
     * @param message with relevant information about the restriction
     */
    public InvalidChoiceException(final String message){
        super(message);
    }
}
