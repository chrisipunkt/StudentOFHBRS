package org.hbrs.se1.ws24.exercises.uebung3;

public class ContainerException extends Exception {
    public ContainerException(String message) {
        super("Das Member-Objekt mit der ID " + message + " ist bereits vorhanden!");
    }
}
