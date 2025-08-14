package com.vn.bidu.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {
    public static List<String> splitString(String str, String regex) {
       if(str == null || str.isEmpty())
           return new ArrayList<>();
       return Arrays.stream(str.split(regex))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }
}
