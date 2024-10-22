package org.hbrs.se1.ws24.exercises.uebung3;
import org.hbrs.se1.ws24.exercises.uebung2.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung2.Member;
import java.util.List;
import java.util.ArrayList;

public class Container {

    private static Container instance;
    private List<Member> memberList;
    private PersistenceStrategy<Member> strategy;

    // Privater Konstruktor, um direkte Instanziierung zu verhindern
    private Container() {
        memberList = new ArrayList<>();
    }

    // Statische Methode, um die einzige Instanz der Klasse zurückzugeben
    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public void addMember(Member member) throws ContainerException {
        if (contains(member)) {
            throw new ContainerException(member.getID().toString());
        }
        memberList.add(member);
    }

    private boolean contains(Member member) {
        return memberList.stream().anyMatch(m -> m.getID().equals(member.getID()));
    }

    public List<Member> getCurrentList() {
        return memberList;
    }

    public String deleteMember(Integer id) {
        Member member = memberList.stream().filter(m -> m.getID().equals(id)).findFirst().orElse(null);
        if (member == null) return "Member nicht gefunden.";
        memberList.remove(member);
        return "Member mit ID " + id + " gelöscht.";
    }

    // Methoden für Persistenz
    public void setPersistenceStrategy(PersistenceStrategy<Member> strategy) {
        this.strategy = strategy;
    }

    public void store() throws PersistenceException {
        if (strategy == null) {
            throw new PersistenceException("No persistence strategy set.");
        }
        strategy.save(memberList);
    }

    public void load() throws PersistenceException {
        if (strategy == null) {
            throw new PersistenceException("No persistence strategy set.");
        }
        memberList = strategy.load();
    }
}
