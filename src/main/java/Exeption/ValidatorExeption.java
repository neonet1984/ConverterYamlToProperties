package Exeption;

/**
 * The ValidatorExeption,  is uses to throw out the validation error
 */
public class ValidatorExeption extends Exception {
    private final static String MESSAGE = "Invalid yaml file format";

    public String getMessage() {
        return MESSAGE;
    }
}
