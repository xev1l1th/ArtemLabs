package ru.artem;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    public boolean isEmpty(String s){
        return s == null || s.isEmpty();
    }

}
