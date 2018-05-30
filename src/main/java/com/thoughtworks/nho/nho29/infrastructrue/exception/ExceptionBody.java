package com.thoughtworks.nho.nho29.infrastructrue.exception;

public class ExceptionBody {
    private Object message;
    private String exception;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public ExceptionBody() { }

    public ExceptionBody(String message) {
        this.message = message;
    }

    public ExceptionBody(Throwable ex) {
        this.message = ex.getMessage();
        this.exception = ex.getClass().getCanonicalName();
    }

    public ExceptionBody setMessage(Object message) {
        this.message = message;
        return this;
    }

    public ExceptionBody setException(String exception) {
        this.exception = exception;
        return this;
    }

    public Object getMessage() {
        return message;
    }

    public String getException() {
        return exception;
    }
}
