package com.platzi.play.persistence.mapper;

import com.platzi.play.domain.Gender;
import org.mapstruct.Named;

public class GenderMapper {

    @Named("stringToGender")
    public static Gender stringToGender(String genderName){
        Gender genderEnum = null;
        if(genderName != null){
            for (Gender gender : Gender.values()) {
                if (gender.getGenderName().equals(genderName)) {
                    genderEnum = gender;
                    break;
                }
            }
        }
        return genderEnum;
    }

    @Named("genderToString")
    public static String genderToString(Gender genderEnum){
        return genderEnum != null ? genderEnum.getGenderName() : null;
    }
}
