package Exceptions;

import Environment.Window;

public class IllegalWindowMove extends Exception {
    private final String message;

    public IllegalWindowMove(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
