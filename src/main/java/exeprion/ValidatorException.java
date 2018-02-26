package exeprion;

/**
 * The ValidatorExeption,  is uses to throw out the validation error
 */
public class ValidatorException extends Exception {
    public String getMessage() {
        return ErrorMessage.VALIDATOR_EXCEPTION_MESSAGE;
    }
}
