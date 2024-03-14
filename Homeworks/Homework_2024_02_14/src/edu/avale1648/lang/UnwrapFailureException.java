package edu.avale1648.util.exceptions;

public class UnwrapFailureException extends Exception {
    private final Object ERROR;

    public <E> UnwrapFailureException(E error) {
        super("Unable to unwrap value from edu.avale1648.result.origin.Result: result contains error.");
        ERROR = error;
    }

    public Object getError() {
        return ERROR;
    }
}

