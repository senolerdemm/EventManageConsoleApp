package com.senolerdem.eventapp;

public class RegistrationLogger implements EventObserver {
    @Override
    public void onRegister(Event event) {
        System.out.println("[Observer] New registration for Event ID " + event.getId() + ": " + event.getName());
    }
}
