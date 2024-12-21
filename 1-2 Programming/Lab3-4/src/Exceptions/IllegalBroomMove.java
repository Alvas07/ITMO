package Exceptions;

import Environment.Broom;

public class IllegalBroomMove extends Exception {
    private final String message;

    public IllegalBroomMove(String message) {
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
