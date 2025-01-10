package org.hbrs.se1.ws24.exercises.uebung9;

public abstract class Document {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract int getSize();
}