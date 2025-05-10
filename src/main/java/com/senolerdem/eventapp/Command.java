package com.senolerdem.eventapp;

public interface Command {
    void execute();
    void undo();
}
