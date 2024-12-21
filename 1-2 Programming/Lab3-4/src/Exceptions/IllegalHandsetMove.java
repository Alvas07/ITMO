package Exceptions;

import Environment.Telephone;

public class IllegalHandsetMove extends Exception {
    private final String message;

    public IllegalHandsetMove(String message) {
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
