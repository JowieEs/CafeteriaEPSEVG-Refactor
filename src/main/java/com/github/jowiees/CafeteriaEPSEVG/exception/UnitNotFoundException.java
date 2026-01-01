package com.github.jowiees.CafeteriaEPSEVG.exception;

public class UnitNotFoundException extends RuntimeException {
    public UnitNotFoundException(Long id) {
        super("Could not find unit with id = " + id);
    }
}
