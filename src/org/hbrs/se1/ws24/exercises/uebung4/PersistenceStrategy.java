package org.hbrs.se1.ws24.exercises.uebung4;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream {
    private final String filename;

    public PersistenceStrategyStream(String filename) {
        this.filename = filename;
    }

    public void save(List<UserStory> userStories) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(userStories);
        }
    }

    public List<UserStory> load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<UserStory>) in.readObject();
        }
    }
}
