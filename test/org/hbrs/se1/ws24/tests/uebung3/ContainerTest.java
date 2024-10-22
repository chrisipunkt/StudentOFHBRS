package org.hbrs.se1.ws24.tests.uebung3;

import org.hbrs.se1.ws24.exercises.uebung2.Member;
import org.hbrs.se1.ws24.exercises.uebung3.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class ContainerTest {

    // Testfall 1: No Strategy Set
    @Test
    public void testNoStrategySet() {
        Container container = Container.getInstance();
        PersistenceException exception = assertThrows(PersistenceException.class, container::store);
        assertEquals(PersistenceException.ExceptionType.NoStrategyIsSet, exception.getType());
    }

    // Testfall 2: MongoDB als Strategie gesetzt (nicht verfügbar)
    @Test
    public void testMongoDBStrategyThrowsException() {
        Container container = Container.getInstance();
        container.setPersistenceStrategy(new PersistenceStrategyMongoDB<>());
        PersistenceException exception = assertThrows(PersistenceException.class, container::store);
        assertEquals(PersistenceException.ExceptionType.ImplementationNotAvailable, exception.getType());
    }

    // Testfall 3: Falscher Speicherort für Datei
    @Test
    public void testInvalidFileLocation() {
        Container container = Container.getInstance();
        PersistenceStrategyStream<Member> strategy = new PersistenceStrategyStream<>();
        strategy.setLocation("invalid/directory/members.ser"); // Setze ungültigen Speicherort
        container.setPersistenceStrategy(strategy);
        PersistenceException exception = assertThrows(PersistenceException.class, container::store);
        assertEquals(PersistenceException.ExceptionType.ConnectionNotAvailable, exception.getType());
    }

    // Testfall 4: Member hinzufügen und speichern
    @Test
    public void testAddMemberAndStore() throws ContainerException, PersistenceException {
        Container container = Container.getInstance();
        Member member = new ConcreteMember(2); // Member mit ID = 2
        container.addMember(member);

        assertEquals(1, container.getCurrentList().size()); // Überprüfe Größe der Liste

        container.setPersistenceStrategy(new PersistenceStrategyStream<>());
        container.store();

        container.deleteMember(2); // Member löschen
        assertEquals(0, container.getCurrentList().size()); // Überprüfe, dass die Liste leer ist

        container.load(); // Liste neu laden
        assertEquals(1, container.getCurrentList().size()); // Liste sollte wieder ein Element haben
        assertEquals(member.getID(), container.getCurrentList().get(0).getID()); // Überprüfe, dass der Member mit ID = 2 geladen wurde
    }
}

