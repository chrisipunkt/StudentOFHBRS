package org.hbrs.se1.ws24.exercises.uebung3;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {
    private String location = "members.ser";

    @Override
    public void save(List<Member> memberList) throws PersistenceException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(location))) {
            out.writeObject(memberList);
        } catch (IOException e) {
            throw new PersistenceException("Error while saving members", e);
        }
    }

    @Override
    public List<Member> load() throws PersistenceException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(location))) {
            return (List<Member>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenceException("Error while loading members", e);
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
