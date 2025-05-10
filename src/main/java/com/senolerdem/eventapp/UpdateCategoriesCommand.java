package com.senolerdem.eventapp;

import java.util.ArrayList;
import java.util.List;

public class UpdateCategoriesCommand implements Command {
    private Event event;
    private List<String> newCategories;
    private List<String> prevCategories;

    public UpdateCategoriesCommand(Event event, List<String> newCategories) {
        this.event = event;
        this.newCategories = new ArrayList<>(newCategories);
        this.prevCategories = new ArrayList<>(event.getCategories());
    }

    @Override
    public void execute() {
        event.setCategories(newCategories);
        System.out.println("Categories updated to: " + newCategories);
    }

    @Override
    public void undo() {
        event.setCategories(prevCategories);
        System.out.println("Undo: Categories reverted to: " + prevCategories);
    }
}

