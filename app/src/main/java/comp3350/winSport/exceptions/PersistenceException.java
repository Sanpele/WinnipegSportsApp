package comp3350.winSport.exceptions;

public class PersistenceException extends RuntimeException {
    // Used for DB methods to handle the many DB errors we have experienced.
    public PersistenceException(final Exception cause) {
        super(cause);
    }
}