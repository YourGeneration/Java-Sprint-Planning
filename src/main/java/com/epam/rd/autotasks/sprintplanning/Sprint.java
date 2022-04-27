package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;
import java.util.ArrayList;
import java.util.List;

public class Sprint {
    private final int CAPACITY;
    private final int TICKETS_LIMIT;
    private int capacityNow = 0;
    private int numberOfTickets = 0;
    private Ticket[] arrayOfUserStories=new Ticket[1];

    public Sprint(int capacity, int ticketsLimit) {
        CAPACITY = capacity;
        TICKETS_LIMIT= ticketsLimit;
    }

    public boolean addUserStory(UserStory userStory) {
        if(numberOfTickets >= TICKETS_LIMIT || userStory == null || 
        ( capacityNow + userStory.getEstimate()) > CAPACITY || userStory.isCompleted()){
            return false;
        }
        else{
                
            numberOfTickets++; 
            capacityNow += checkCapacity(userStory);
            
            Ticket[] copy = new Ticket[numberOfTickets];
            System.arraycopy(arrayOfUserStories, 0, copy, 0, arrayOfUserStories.length); 
            copy[numberOfTickets-1] = userStory;
            arrayOfUserStories = new Ticket[numberOfTickets];
            System.arraycopy(copy, 0, arrayOfUserStories, 0, copy.length);  
            return true; 
            
        } 
    }

    public int checkCapacity(UserStory userStory){
        UserStory[] users = userStory.getDependencies();
        int capacity = userStory.getEstimate();
        if(users.length==0){
            return capacity;
        }
        for(int i = 0;i<users.length;i++){
            capacity+= users[i].getEstimate();
        }
        return capacity;
    }

    public boolean addBug(Bug bugReport) {
        if(bugReport == null) return false;
        if(numberOfTickets >= TICKETS_LIMIT || bugReport.userStory == null || bugReport.getEstimate()+capacityNow >CAPACITY){
            return false;
        }
        else{

            
            //    int counter = 0;
            //    for(int i = 0;i<bugReport.userStory.userStory.length;i++){
            //        for(int j = 0;j<arrayOfUserStories.length;j++){
           //             if(bugReport.userStory.userStory[i].getId()==arrayOfUserStories[j].getId())counter++;
            //        }
            //        if(counter == 0)return false;
            //        else counter = 0;
            //    }
        }
            
            numberOfTickets++; 
            capacityNow += bugReport.getEstimate();
        
            Ticket[] copy = new Ticket[numberOfTickets];
            System.arraycopy(arrayOfUserStories, 0, copy, 0, arrayOfUserStories.length); 
            copy[numberOfTickets-1] = bugReport;
            arrayOfUserStories = new Ticket[numberOfTickets];
            System.arraycopy(copy, 0, arrayOfUserStories, 0, copy.length);  
            return true; 
            
        } 
    
    
    public Ticket[] getTickets() {
        Ticket[] copy = new Ticket[numberOfTickets];
        System.arraycopy(arrayOfUserStories, 0, copy, 0, arrayOfUserStories.length); 
        return copy;
    }

    public int getTotalEstimate() {
        return capacityNow;
    }
}
