package fr.uga.l3miage.example.exception.technical;

import lombok.Getter;

@Getter
public class MiahootTechException extends Exception {

    public MiahootTechException (String message) {
        super(message);
    }

    public MiahootTechException (String message, Throwable cause) {
        super(message, cause);
    }
}
