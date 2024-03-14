package edu.avale1648.util.result.alt;

public final class Ok<R, E> extends Result<R, E> {
    private final R VALUE;

    public Ok(R value) {
        VALUE = value;
    }

    @Override
    public boolean isOk() {
        return true;
    }

    @Override
    public boolean isErr() {
        return false;
    }

    public R getValue() {
        return VALUE;
    }
}
