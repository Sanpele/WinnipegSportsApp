package comp3350.winSport.exceptions;

public class InvalidTimeException extends Exception{
    // Used with Period object and its use of time
    public InvalidTimeException(String errorMessage){
        super(errorMessage);
    }
}
