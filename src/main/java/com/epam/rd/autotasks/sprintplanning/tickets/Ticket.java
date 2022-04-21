package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {
    private final int id;
    private String name;
    private int estimate;
    protected boolean completed = false;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        completed = true;
    }

    public int getEstimate() {
        return estimate;
    }
}
