package com.senolerdem.eventapp;

public class UpdateLocationCommand implements Command {
    private Event event;
    private String newLocation;
    private String prevLocation;

    public UpdateLocationCommand(Event event, String newLocation) {
        this.event = event;
        this.newLocation = newLocation;
        this.prevLocation = event.getLocation();
    }

    @Override
    public void execute() {
        event.setLocation(newLocation);
        System.out.println("Location updated to: " + newLocation);
    }

    @Override
    public void undo() {
        event.setLocation(prevLocation);
        System.out.println("Undo: Location reverted to: " + prevLocation);
    }
}
