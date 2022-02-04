package comp3350.winSport.exceptions;

public class InvalidNameException extends Exception{
    // Used for Name Validation methods in business layer
    public InvalidNameException(String errorMessage) {
        super(errorMessage);
    }
}
