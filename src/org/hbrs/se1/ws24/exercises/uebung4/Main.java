package org.hbrs.se1.ws24.exercises.uebung4;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Container container = new Container();
    private static final PersistenceStrategyStream persistence = new PersistenceStrategyStream("userstories.ser");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("User Story Verwaltungstool gestartet. Geben Sie 'help' für Hilfe ein.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] command = input.split(" ", 2);

            switch (command[0]) {
                case "enter":
                    enterUserStory(scanner);
                    break;
                case "store":
                    storeUserStories();
                    break;
                case "load":
                    loadUserStories();
                    break;
                case "dump":
                    container.displayAllUserStories();
                    break;
                case "exit":
                    System.out.println("Programm beendet.");
                    return;
                case "help":
                    printHelp();
                    break;
                default:
                    System.out.println("Unbekannter Befehl.");
            }
        }
    }

    private static void enterUserStory(Scanner scanner) {
        System.out.print("Titel: ");
        String title = scanner.nextLine();
        System.out.print("Akzeptanzkriterien: ");
        String acceptanceCriteria = scanner.nextLine();
        System.out.print("Projekt: ");
        String project = scanner.nextLine();
        int value = getIntInput(scanner, "Wert");
        int effort = getIntInput(scanner, "Aufwand");
        int risk = getIntInput(scanner, "Risiko");
        int dependency = getIntInput(scanner, "Abhängigkeit");

        UserStory userStory = new UserStory(title, acceptanceCriteria, project, value, effort, risk, dependency);
        container.addUserStory(userStory);
        System.out.println("User Story hinzugefügt.");
    }

    private static int getIntInput(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextInt();
            scanner.nextLine();
            if (value >= 0) break;
            System.out.println("Ungültige Eingabe. Wert muss >= 0 sein.");
        }
        return value;
    }

    private static void storeUserStories() {
        try {
            persistence.save(container.getUserStories());
            System.out.println("User Stories gespeichert.");
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern: " + e.getMessage());
        }
    }

    private static void loadUserStories() {
        try {
            container.getUserStories().addAll(persistence.load());
            System.out.println("User Stories geladen.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Fehler beim Laden: " + e.getMessage());
        }
    }

    private static void printHelp() {
        System.out.println("Verfügbare Befehle:");
        System.out.println("enter - Eingabe einer neuen User Story");
        System.out.println("store - Speichert alle User Stories");
        System.out.println("load - Lädt alle gespeicherten User Stories");
        System.out.println("dump - Gibt alle User Stories aus");
        System.out.println("exit - Beendet das Programm");
    }
}
