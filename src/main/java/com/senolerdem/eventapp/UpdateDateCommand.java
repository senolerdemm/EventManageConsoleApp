package com.senolerdem.eventapp;

public class UpdateDateCommand implements Command {
    private Event event;
    private String newDate;
    private String prevDate;

    public UpdateDateCommand(Event event, String newDate) {
        this.event = event;
        this.newDate = newDate;
        this.prevDate = event.getDate();
    }

    @Override
    public void execute() {
        event.setDate(newDate);
        System.out.println("Date updated to: " + newDate);
    }

    @Override
    public void undo() {
        event.setDate(prevDate);
        System.out.println("Undo: Date reverted to: " + prevDate);
    }
}

