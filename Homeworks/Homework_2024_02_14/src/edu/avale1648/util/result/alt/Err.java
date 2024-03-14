package edu.avale1648.util.result.alt;

public final class Err<R, E> extends Result<R, E> {
    private final E ERROR;

    public Err(E error) {
        ERROR = error;
    }

    @Override
    public boolean isOk() {
        return false;
    }

    @Override
    public boolean isErr() {
        return true;
    }

    public E getError() {
        return ERROR;
    }
}
