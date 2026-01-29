package com.platzi.play.persistence.mapper;

import com.platzi.play.domain.Gender;
import com.platzi.play.domain.State;
import org.mapstruct.Named;

public class StateMapper {

    @Named("stringToBoolean")
    public static boolean stringToState(String stateString){
        boolean stateBoolean = false;
        if(stateString != null){
            for (State state : State.values()) {
                if (state.getStateString().equals(stateString)) {
                    stateBoolean = state.getStateBoolean();
                    break;
                }
            }
        }
        return stateBoolean;
    }

    @Named("booleanToString")
    public static String stateToString(boolean stateBoolean){
        String stateString = null;
        for (State state : State.values()) {
            if (state.getStateBoolean() == stateBoolean) {
                stateString = state.getStateString();
                break;
            }
        }
        return stateString;
    }
}
