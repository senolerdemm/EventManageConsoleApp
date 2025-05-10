package com.senolerdem.eventapp;

public class UpdateDescriptionCommand implements Command {
    private Event event;
    private String newDescription;
    private String prevDescription;

    public UpdateDescriptionCommand(Event event, String newDescription) {
        this.event = event;
        this.newDescription = newDescription;
        this.prevDescription = event.getDescription();
    }

    @Override
    public void execute() {
        event.setDescription(newDescription);
        System.out.println("Description updated to: " + newDescription);
    }

    @Override
    public void undo() {
        event.setDescription(prevDescription);
        System.out.println("Undo: Description reverted to: " + prevDescription);
    }
}

