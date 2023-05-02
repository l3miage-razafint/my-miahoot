package fr.uga.l3miage.example.exception.rest;

public class MiahootRestException extends RuntimeException {
    public MiahootRestException (String msg, Exception e) {
        super(msg, e);
    }

    public MiahootRestException (String msg) {
        super(msg);
    }
}
