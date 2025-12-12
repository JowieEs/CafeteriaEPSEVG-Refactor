package com.github.jowiees.CafeteriaEPSEVG.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Integer memberId) {
       super("Could not find client " + memberId);
    }
}
