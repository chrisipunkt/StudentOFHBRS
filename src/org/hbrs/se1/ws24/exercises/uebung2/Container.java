package org.hbrs.se1.ws24.exercises.uebung2;

import java.util.ArrayList;
import java.util.List;

public class Container {

    // Interne Liste, um Member-Objekte zu speichern
    private List<Member> memberList = new ArrayList<>();

    // FA1: Member hinzufügen
    public void addMember(Member member) throws ContainerException {
        for (Member m : memberList) {
            if (m.getID().equals(member.getID())) {
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
            }
        }
        memberList.add(member);
    }

    // FA2: Member löschen
    public String deleteMember(Integer id) {
        for (Member m : memberList) {
            if (m.getID().equals(id)) {
                memberList.remove(m);
                return "Member mit der ID " + id + " wurde gelöscht.";
            }
        }
        return "Kein Member mit der ID " + id + " gefunden.";
    }

    // FA3: Member-ID's ausgeben
    public void dump() {
        for (Member m : memberList) {
            System.out.println(m);
        }
    }

    // FA4: Anzahl der Member zurückgeben
    public int size() {
        return memberList.size();
    }
}
