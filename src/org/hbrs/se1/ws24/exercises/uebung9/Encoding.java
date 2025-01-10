package org.hbrs.se1.ws24.exercises.uebung9;

public enum Encoding {
    UTF8("UTF-8"),
    UTF16("UTF-16"),
    UTF32("UTF-32");

    private final String encodingName;

    Encoding(String encodingName) {
        this.encodingName = encodingName;
    }

    public int getBytes(String content) {
        try {
            return content.getBytes(this.encodingName).length;
        } catch (Exception e) {
            throw new RuntimeException("Error calculating bytes for encoding: " + this.encodingName, e);
        }
    }
}