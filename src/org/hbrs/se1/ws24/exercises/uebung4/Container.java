package org.hbrs.se1.ws24.exercises.uebung4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Container {
    private List<UserStory> userStories = new ArrayList<>();

    public void addUserStory(UserStory userStory) {
        userStories.add(userStory);
    }

    public void displayAllUserStories() {
        userStories.stream()
                .sorted((u1, u2) -> Double.compare(u2.getPriority(), u1.getPriority()))
                .forEach(System.out::println);
    }

    public List<UserStory> getUserStories() {
        return userStories;
    }
}
