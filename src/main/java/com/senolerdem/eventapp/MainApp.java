package com.senolerdem.eventapp;

import java.util.*;

public class MainApp {
    private static Scanner scanner = new Scanner(System.in);
    private static EventManager eventManager = EventManager.getInstance();

    public static void main(String[] args) {
        eventManager.addObserver(new RegistrationLogger());
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Event Management System ===");
            System.out.println("1. Create Event");
            System.out.println("2. Search Event");
            System.out.println("3. Register to Event");
            System.out.println("4. Modify Event");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createEvent();
                    break;
                case 2:
                    searchEvent();
                    break;
                case 3:
                    registerToEvent();
                    break;
                case 4:
                    modifyEvent();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void createEvent() {
        System.out.print("Event Name: ");
        String name = scanner.nextLine();
        System.out.print("Location: ");
        String location = scanner.nextLine();
        System.out.print("Date: ");
        String date = scanner.nextLine();
        System.out.print("Time: ");
        String time = scanner.nextLine();
        System.out.print("Organizer: ");
        String organizer = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        List<String> categories = new ArrayList<>();
        System.out.println("Enter up to 3 categories:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Category " + (i + 1) + " (press Enter to skip): ");
            String cat = scanner.nextLine();
            if (!cat.isEmpty()) categories.add(cat);
        }

        List<String> tags = new ArrayList<>();
        System.out.println("Enter up to 3 tags:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Tag " + (i + 1) + " (press Enter to skip): ");
            String tag = scanner.nextLine();
            if (!tag.isEmpty()) tags.add(tag);
        }

        Event event = new Event(name, location, date, time, organizer, categories, tags , description);
        eventManager.addEvent(event);
    }

    private static void searchEvent() {
        System.out.println("Search by:");
        System.out.println("1. Name");
        System.out.println("2. Category");
        System.out.println("3. Tag");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        List<Event> results = new ArrayList<>();

        switch (choice) {
            case 1:
                System.out.print("Enter keyword to search by name: ");
                String nameKeyword = scanner.nextLine();
                results = eventManager.searchByName(nameKeyword);
                break;
            case 2:
                System.out.print("Enter category to search: ");
                String category = scanner.nextLine();
                results = eventManager.searchByCategory(category);
                break;
            case 3:
                System.out.print("Enter tag to search: ");
                String tag = scanner.nextLine();
                results = eventManager.searchByTag(tag);
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        if (results.isEmpty()) {
            System.out.println("No events found.");
        } else {
            System.out.println("Sort results:");
            System.out.println("1. A-Z");
            System.out.println("2. Z-A");
            System.out.print("Choose an option: ");
            int sortChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (sortChoice == 1) {
                results.sort(Comparator.comparing(Event::getName));
            } else if (sortChoice == 2) {
                results.sort(Comparator.comparing(Event::getName).reversed());
            } else {
                System.out.println("Invalid sort option. Showing unsorted results.");
            }

            results.forEach(System.out::println);
        }
    }


    private static void registerToEvent() {
        System.out.print("Enter Event ID to register: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Event event = eventManager.getEventById(id);
        if (event != null) {
            eventManager.registerToEvent(event);  // EventManager üzerinden çağırıyoruz
        } else {
            System.out.println("Event not found.");
        }
    }


    private static void modifyEvent() {
        System.out.print("Enter Event ID to modify: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Event event = eventManager.getEventById(id);
        if (event == null) {
            System.out.println("Event not found.");
            return;
        }
        System.out.println("1. Update Location");
        System.out.println("2. Update Date");
        System.out.println("3. Update Time");
        System.out.println("4. Update Description");
        System.out.println("5. Update Categories");
        System.out.println("6. Update Tags");
        System.out.println("7. Undo Last Modification");


        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new location: ");
                String newLocation = scanner.nextLine();
                UpdateLocationCommand locCmd = new UpdateLocationCommand(event, newLocation);
                eventManager.executeCommand(locCmd);
                break;
            case 2:
                System.out.print("Enter new date: ");
                String newDate = scanner.nextLine();
                UpdateDateCommand dateCmd = new UpdateDateCommand(event, newDate);
                eventManager.executeCommand(dateCmd);
                break;
            case 3:
                System.out.print("Enter new time: ");
                String newTime = scanner.nextLine();
                UpdateTimeCommand timeCmd = new UpdateTimeCommand(event, newTime);
                eventManager.executeCommand(timeCmd);
                break;
            case 4:
                System.out.print("Enter new description: ");
                String newDesc = scanner.nextLine();
                UpdateDescriptionCommand descCmd = new UpdateDescriptionCommand(event, newDesc);
                eventManager.executeCommand(descCmd);
                break;
            case 5:
                List<String> newCategories = new ArrayList<>();
                System.out.println("Enter up to 3 new categories:");
                for (int i = 0; i < 3; i++) {
                    System.out.print("Category " + (i + 1) + " (press Enter to skip): ");
                    String cat = scanner.nextLine();
                    if (!cat.isEmpty()) newCategories.add(cat);
                }
                UpdateCategoriesCommand catCmd = new UpdateCategoriesCommand(event, newCategories);
                eventManager.executeCommand(catCmd);
                break;
            case 6:
                List<String> newTags = new ArrayList<>();
                System.out.println("Enter up to 3 new tags:");
                for (int i = 0; i < 3; i++) {
                    System.out.print("Tag " + (i + 1) + " (press Enter to skip): ");
                    String tag = scanner.nextLine();
                    if (!tag.isEmpty()) newTags.add(tag);
                }
                UpdateTagsCommand tagCmd = new UpdateTagsCommand(event, newTags);
                eventManager.executeCommand(tagCmd);
                break;
            case 7:
                eventManager.undo();
                break;
            default:
                System.out.println("Invalid option.");
        }

    }
    private static void printSearchResults(List<Event> results) {
        if (results.isEmpty()) {
            System.out.println("No events found.");
        } else {
            results.forEach(System.out::println);
        }
    }

}
