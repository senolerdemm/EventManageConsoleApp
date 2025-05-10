package com.senolerdem.eventapp;

public class UpdateTimeCommand implements Command {
    private Event event;
    private String newTime;
    private String prevTime;

    public UpdateTimeCommand(Event event, String newTime) {
        this.event = event;
        this.newTime = newTime;
        this.prevTime = event.getTime();  // önceki zamanı kaydet
    }

    @Override
    public void execute() {
        event.setTime(newTime);
        System.out.println("Time updated to: " + newTime);
    }

    @Override
    public void undo() {
        event.setTime(prevTime);
        System.out.println("Undo: Time reverted to: " + prevTime);
    }
}
