package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class UserObjectMapper {
    public static final ObjectMapper MAPPER=new ObjectMapper();
    public static <T>T getObjectFromJson(Reader reader, Class<T> cls){
        T result=null;
        try {
            result=MAPPER.readValue(reader,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getJsonFromObject(Object o){
        String jsonResult=" ";
        try {
            jsonResult=MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  jsonResult;
    }

}
