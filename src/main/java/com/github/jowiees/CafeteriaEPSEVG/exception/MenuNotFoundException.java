package com.github.jowiees.CafeteriaEPSEVG.exception;

public class MenuNotFoundException extends RuntimeException {
    public MenuNotFoundException(Long id) {
        super("Could not get menu with id = " + id);
    }
}
