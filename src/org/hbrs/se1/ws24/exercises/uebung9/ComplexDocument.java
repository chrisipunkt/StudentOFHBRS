package org.hbrs.se1.ws24.exercises.uebung9;

import java.util.ArrayList;
import java.util.List;

public class ComplexDocument extends Document {
    private List<Document> documents = new ArrayList<>();

    public void addDocument(Document doc) {
        documents.add(doc);
    }

    public void removeDocument(Document doc) {
        documents.remove(doc);
    }

    @Override
    public int getSize() {
        return documents.stream().mapToInt(Document::getSize).sum();
    }
}