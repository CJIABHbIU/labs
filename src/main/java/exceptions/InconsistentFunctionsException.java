package exceptions;

public class InconsistentFunctionsException extends RuntimeException {
    private static final long serialVersionUID = -1221970400808747943L;

    public InconsistentFunctionsException() {
    }

    public InconsistentFunctionsException(String message) {
        super(message);
    }
}