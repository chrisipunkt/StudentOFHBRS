package uebung2;
import static org.junit.jupiter.api.Assertions.*;
import org.hbrs.se1.ws24.exercises.uebung2.ConcreteMember;
import org.hbrs.se1.ws24.exercises.uebung2.Container;
import org.hbrs.se1.ws24.exercises.uebung2.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung2.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContainerTest {

    private Container container;

    @BeforeEach
    void setUp() {
        container = new Container();
    }

    // Testfall 1: Member erfolgreich hinzufügen
    @Test
    void testAddMemberSuccess() throws ContainerException {
        Member member1 = new ConcreteMember(1);
        container.addMember(member1);
        assertEquals(1, container.size(), "Die Anzahl der Member sollte 1 sein.");
    }

    // Testfall 2: Exception, wenn Member mit gleicher ID hinzugefügt wird
    @Test
    void testAddMemberDuplicateID() {
        Member member1 = new ConcreteMember(1);
        Member member2 = new ConcreteMember(1); // gleiche ID wie member1

        try {
            container.addMember(member1);
            container.addMember(member2);
            fail("Es sollte eine ContainerException geworfen werden.");
        } catch (ContainerException e) {
            assertEquals("Das Member-Objekt mit der ID 1 ist bereits vorhanden!", e.getMessage());
        }
    }

    // Testfall 3: Member erfolgreich löschen
    @Test
    void testDeleteMemberSuccess() throws ContainerException {
        Member member1 = new ConcreteMember(1);
        container.addMember(member1);

        String result = container.deleteMember(1);
        assertEquals("Member mit der ID 1 wurde gelöscht.", result);
        assertEquals(0, container.size(), "Die Anzahl der Member sollte 0 sein.");
    }

    // Testfall 4: Member löschen, das nicht existiert
    @Test
    void testDeleteMemberNotFound() {
        String result = container.deleteMember(1);
        assertEquals("Kein Member mit der ID 1 gefunden.", result);
    }

    // Testfall 5: Mehrere Member hinzufügen
    @Test
    void testAddMultipleMembers() throws ContainerException {
        Member member1 = new ConcreteMember(1);
        Member member2 = new ConcreteMember(2);
        container.addMember(member1);
        container.addMember(member2);

        assertEquals(2, container.size(), "Die Anzahl der Member sollte 2 sein.");
    }

    // Testfall 6: Löschen eines von mehreren Members
    @Test
    void testDeleteOneOfMultipleMembers() throws ContainerException {
        Member member1 = new ConcreteMember(1);
        Member member2 = new ConcreteMember(2);
        container.addMember(member1);
        container.addMember(member2);

        container.deleteMember(1);
        assertEquals(1, container.size(), "Die Anzahl der Member sollte nach dem Löschen 1 sein.");
    }

    // Testfall 7: Ausgabe der Member mit dump()
    @Test
    void testDump() throws ContainerException {
        Member member1 = new ConcreteMember(1);
        Member member2 = new ConcreteMember(2);
        container.addMember(member1);
        container.addMember(member2);

        container.dump(); // Soll auf der Konsole die IDs ausgeben
    }

    // Testfall 8: Hinzufügen und Löschen im Wechsel
    @Test
    void testAddAndDeleteAlternating() throws ContainerException {
        Member member1 = new ConcreteMember(1);
        Member member2 = new ConcreteMember(2);
        container.addMember(member1);
        assertEquals(1, container.size());

        container.deleteMember(1);
        assertEquals(0, container.size());

        container.addMember(member2);
        assertEquals(1, container.size());

        container.deleteMember(2);
        assertEquals(0, container.size());
    }

    // Testfall 9: Löschen von bereits gelöschtem Member
    @Test
    void testDeleteAlreadyDeletedMember() throws ContainerException {
        Member member1 = new ConcreteMember(1);
        container.addMember(member1);
        container.deleteMember(1);

        String result = container.deleteMember(1);
        assertEquals("Kein Member mit der ID 1 gefunden.", result);
    }

    // Testfall 10: Leerer Container sollte Größe 0 haben
    @Test
    void testEmptyContainerSize() {
        assertEquals(0, container.size(), "Die Größe eines leeren Containers sollte 0 sein.");
    }
}