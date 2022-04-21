package com.epam.rd.autotasks.sprintplanning.tickets;

public class Bug extends Ticket {
    public UserStory userStory;

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if(userStory.completed == false || userStory == null) return null;
        else{
            Bug bug = new Bug(id,name,estimate,userStory);
            return bug;
        } 
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }

    @Override
    public String toString() {
        return "[Bug "+ getId() +"] "+ userStory.getName() + ": " + getName();
    }
}
