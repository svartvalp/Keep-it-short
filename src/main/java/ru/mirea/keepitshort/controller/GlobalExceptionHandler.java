package ru.mirea.keepitshort.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.mirea.keepitshort.exception.BusinessLogicException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<?> handleBusinessLogicException(BusinessLogicException exc) {
        Map<String, String> body = new HashMap<>();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        body.put("status", status.toString());
        body.put("message", exc.getMessage());
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exc) {
        Map<String, String> body = new HashMap<>();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        body.put("status", httpStatus.toString());
        body.put("message", exc.getBindingResult().getFieldErrors().stream().map(error -> error.getField() + " " + error.getDefaultMessage()).collect(Collectors.joining("\n")));
        return ResponseEntity.status(httpStatus).body(body);
    }

}
