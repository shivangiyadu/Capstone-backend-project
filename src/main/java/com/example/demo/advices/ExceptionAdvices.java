package com.example.demo.advices;

import com.example.demo.dto.ErrorResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvices {

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleRuntimeException(RuntimeException e)
    {
        ErrorResponseDto dto=new ErrorResponseDto();
        dto.setStatus("Error");
        dto.setMessage(e.getMessage());
        return dto;
    }


    @ExceptionHandler(Exception.class)
    public String handleException()
    {
        return "Something went wrong";
    }


}
