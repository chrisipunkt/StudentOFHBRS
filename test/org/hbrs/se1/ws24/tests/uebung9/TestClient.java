package org.hbrs.se1.ws24.tests.uebung9;

public class TestClient {
    public static void main(String[] args) {
        // Create documents
        TextDocument doc1 = new TextDocument("Hello World", Encoding.UTF8);
        doc1.setId("doc1");

        GraficDocument doc2 = new GraficDocument("http://example.com/image.png");
        doc2.setId("doc2");

        TextDocument doc3 = new TextDocument("Complex structure", Encoding.UTF16);
        doc3.setId("doc3");

        ComplexDocument root = new ComplexDocument();
        root.setId("root");

        ComplexDocument subDoc = new ComplexDocument();
        subDoc.setId("subDoc");

        // Build hierarchy
        root.addDocument(doc1);
        root.addDocument(subDoc);

        subDoc.addDocument(doc2);
        subDoc.addDocument(doc3);

        // Calculate total size
        System.out.println("Total size: " + root.getSize() + " bytes");
    }
}