package com.senolerdem.eventapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class EventManager {
    private List<Event> events = new ArrayList<>();
    private Stack<Command> history = new Stack<>();
    private List<EventObserver> observers = new ArrayList<>();



    // Singleton (Design Pattern 1)
    private static EventManager instance = null;

    private EventManager() { }

    public static EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }
        return instance;
    }
    public void addObserver(EventObserver observer) {
        observers.add(observer);
    }
    public void registerToEvent(Event event) {
        event.incrementRegistration();
        System.out.println("Successfully registered!");
        notifyObservers(event);  // Observer tetikleniyor
    }


    private void notifyObservers(Event event) {
        for (EventObserver observer : observers) {
            observer.onRegister(event);
        }
    }



    public void addEvent(Event event) {
        events.add(event);
        System.out.println("Event saved successfully!");
    }
    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
        } else {
            System.out.println("No actions to undo.");
        }
    }


    public List<Event> getAllEvents() {
        return events;
    }

    public Event getEventById(int id) {
        return events.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Event> searchByName(String keyword) {
        return events.stream()
                .filter(e -> e.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Event> searchByCategory(String category) {
        return events.stream()
                .filter(e -> e.getCategories().stream()
                        .anyMatch(c -> c.equalsIgnoreCase(category)))
                .collect(Collectors.toList());
    }

    public List<Event> searchByTag(String tag) {
        return events.stream()
                .filter(e -> e.getTags().stream()
                        .anyMatch(t -> t.equalsIgnoreCase(tag)))
                .collect(Collectors.toList());
    }
}
