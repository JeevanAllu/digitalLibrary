package com.example.digitalLibraryPractice.Exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceNotFoundException extends RuntimeException{

    public <T> ResourceNotFoundException(Class<T> type,String fieldName,String fieldValue){
        super("Resource of type: " + type + "with the fieldName " + fieldName + "=" + fieldValue + "could not be found");
        log.error("Resource of type {} with the fieldname {}  = {} could not be found",type,fieldName,fieldValue);
    }

    public ResourceNotFoundException(String message){
        super(message);
        log.error(message);
    }
}
