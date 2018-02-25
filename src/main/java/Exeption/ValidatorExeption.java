package Exeption;

public class ValidatorExeption extends Exception {
    private final static String MESSAGE = "Invalid yaml file format";

    public String getMessage() {
        return MESSAGE;
    }
}
