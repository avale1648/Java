package edu.avale1648.util.result.alt;

import edu.avale1648.lang.UnwrapFailureException;

public abstract sealed class Result<R, E> permits Ok, Err {
    public abstract boolean isOk();

    public abstract boolean isErr();

    public static void processResult(Result<?, ?> result) {
        switch (result) {
            case Ok<?, ?> ok -> {
                System.out.format("Sucess: %s\n", ok.getValue());
            }
            case Err<?, ?> err -> {
                System.out.format("Error: %s\n/", err.getError());
            }
        }
    }

    public static <R, E> Result<R, E> ok(R value) {
        return new Ok<>(value);
    }

    public static <R, E> Result<R, E> err(E error) {
        return new Err<>(error);
    }

    public R unwrap() throws UnwrapFailureException {
        if (isOk() && this instanceof Ok<R, E>) {
            return ((Ok<R, E>)this).getValue();
        } else {
            if(this instanceof Err<R, E>){
                throw new UnwrapFailureException(((Err<R, E>) this).getError());
            }
        }
        return null;
    }
}
