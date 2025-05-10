package com.senolerdem.eventapp;

import java.util.ArrayList;
import java.util.List;

public class UpdateTagsCommand implements Command {
    private Event event;
    private List<String> newTags;
    private List<String> prevTags;

    public UpdateTagsCommand(Event event, List<String> newTags) {
        this.event = event;
        this.newTags = new ArrayList<>(newTags);
        this.prevTags = new ArrayList<>(event.getTags());
    }

    @Override
    public void execute() {
        event.setTags(newTags);
        System.out.println("Tags updated to: " + newTags);
    }

    @Override
    public void undo() {
        event.setTags(prevTags);
        System.out.println("Undo: Tags reverted to: " + prevTags);
    }
}
