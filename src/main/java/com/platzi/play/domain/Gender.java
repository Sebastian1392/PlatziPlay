package com.platzi.play.domain;

public enum Gender {
    ACTION("ACCION"),
    COMEDY("COMEDIA"),
    DRAMA("DRAMA"),
    ANIMATED("ANIMADA"),
    HORROR("TERROR"),
    SCI_FI("CIENCIA_FICCION");

    private String genderName;

    Gender(String genderName){
        this.genderName = genderName;
    }

    public String getGenderName() {
        return this.genderName;
    }
}
