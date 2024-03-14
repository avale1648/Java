package edu.avale1648.util.result.orig;

import edu.avale1648.lang.UnwrapFailureException;

public class Result<R, E> {
    private final R VALUE;
    private final E ERROR;
    private final Boolean IS_OK;

    private Result(R value, E error, boolean isOk) {
        VALUE = value;
        ERROR = error;
        IS_OK = isOk;
    }

    public static <R, E> Result<R, E> ok(R value) {
        return new Result<>(value, null, true);
    }

    public static <R, E> Result<R, E> err(E error) {
        return new Result<>(null, error, false);
    }

    public boolean isOk() {
        return IS_OK;
    }

    public boolean isError() {
        return !IS_OK;
    }

    public R unwrap() throws UnwrapFailureException {
        if (IS_OK) {
            return VALUE;
        } else {
            throw new UnwrapFailureException(ERROR);
        }
    }

    public R okOrDefault(R defaultValue) {
        return IS_OK ? VALUE: defaultValue;
    }

    public E errOrDefault(E defaultError) {
        return IS_OK ? null: ERROR != null? ERROR: defaultError;
    }
}