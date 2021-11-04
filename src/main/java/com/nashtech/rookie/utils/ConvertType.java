package com.nashtech.rookie.utils;

import org.springframework.stereotype.Component;

@Component
public class ConvertType {

    public long parseLong(String value, long defaultValue){
        try{
            return Long.parseLong(value);
        }catch (Exception e){
            return defaultValue;
        }
    }
}
