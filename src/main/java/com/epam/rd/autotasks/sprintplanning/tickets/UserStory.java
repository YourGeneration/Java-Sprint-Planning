package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public void complete() {
        throw new UnsupportedOperationException("Implement this method");
    }

    public UserStory[] getDependencies() {
        throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Implement this method");
    }
}
