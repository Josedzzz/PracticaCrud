package com.joki.exceptions;

public class ClienteYaExistenteException extends Exception {
    public ClienteYaExistenteException(String mensaje) {
        super(mensaje);
    }
}
