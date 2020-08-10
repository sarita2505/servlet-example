package com.java.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Reader;

public class EmplObjectMapper {
    public static  final ObjectMapper OBJECTMAPER=new ObjectMapper();
    public static <T>T getObjectFromJson(Reader reader,Class<T> cls){
        T result=null;
        try {
            result=  OBJECTMAPER.readValue(reader,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String getJsonFromObject(Object o){
        String json=null;
        try {
            json=OBJECTMAPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
