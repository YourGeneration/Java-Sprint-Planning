package com.epam.rd.autotasks.sprintplanning.tickets;

public class Bug extends Ticket {

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        throw new UnsupportedOperationException("Implement this method");
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Implement this method");
    }
}
