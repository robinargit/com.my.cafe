package com.my.cafe.com.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CafeUtils {

    public CafeUtils() {
    }

    public static ResponseEntity<String> getResponseEntity(String responseMessages, HttpStatus httpStatus){
        return  new ResponseEntity<String>("{\"message\":\""+responseMessages+"\"}", httpStatus);
    }
}
