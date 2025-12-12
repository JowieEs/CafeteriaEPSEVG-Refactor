package com.github.jowiees.CafeteriaEPSEVG.controller.advice;

import com.github.jowiees.CafeteriaEPSEVG.exception.ClientNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.exception.MenuNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    ProblemDetail handleClientMissing(ClientNotFoundException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(OrderNotFoundException.class)
    ProblemDetail handleOrderMissing(OrderNotFoundException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(MenuNotFoundException.class)
    ProblemDetail handleMenuMissing(MenuNotFoundException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
    }
}
