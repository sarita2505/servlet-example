package com.java.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletRequest;
import java.io.IOException;

public class MapperClass {
   static final ObjectMapper objectMapper=new ObjectMapper();
    public static <T>T getObjectFromJson(ServletRequest request, Class<T> cls){
        T result=null;
        try {
          result=objectMapper.readValue(request.getReader(),cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
