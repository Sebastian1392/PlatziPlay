package com.platzi.play.domain;

public enum State {

    AVAILABLE("D", true),
    UNAVAILABLE("N", false);

    private String stateString;
    private boolean stateBoolean;

    State(String stateString, boolean stateBoolean) {
        this.stateString = stateString;
        this.stateBoolean = stateBoolean;
    }

    public String getStateString() {
        return stateString;
    }

    public boolean getStateBoolean() {
        return stateBoolean;
    }
}
