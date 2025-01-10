package org.hbrs.se1.ws24.exercises.uebung9;

public class TextDocument extends CoreDocument {
    private String content;
    private Encoding encoding;

    public TextDocument(String content, Encoding encoding) {
        this.content = content;
        this.encoding = encoding;
    }

    @Override
    public int getSize() {
        return encoding.getBytes(content);
    }
}