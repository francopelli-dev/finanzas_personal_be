package com.fpelli.finanzas_personal.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleDefaultException() {
        ProblemDetail defaultProblem = ProblemDetail.forStatus(400);
        return defaultProblem;
    }
}
