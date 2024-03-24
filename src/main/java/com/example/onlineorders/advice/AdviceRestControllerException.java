package com.example.onlineorders.advice;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class AdviceRestControllerException {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> showErrorsValidations(MethodArgumentNotValidException exception){
    Map<String,String> message=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->{
            message.put(error.getField(),error.getDefaultMessage());
                }

                );
        return message;
    }
    @ExceptionHandler(SQLServerException.class)
    public String  showErrorRoles(){
      log.error("The user used a role that does not exist!");
        return "This role was not found. Please choose another role";
    }
}
