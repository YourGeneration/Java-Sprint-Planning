package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {

    public Sprint(int capacity, int ticketsLimit) {
        throw new UnsupportedOperationException("Implement this method");
    }

    public boolean addUserStory(UserStory userStory) {
        throw new UnsupportedOperationException("Implement this method");
    }

    public boolean addBug(Bug bugReport) {
        throw new UnsupportedOperationException("Implement this method");
    }

    public Ticket[] getTickets() {
        throw new UnsupportedOperationException("Implement this method");
    }

    public int getTotalEstimate() {
        throw new UnsupportedOperationException("Implement this method");
    }
}
