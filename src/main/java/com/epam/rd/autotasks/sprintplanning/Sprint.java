package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;
import java.util.ArrayList;

public class Sprint {
    private final int CAPACITY;
    private final int TICKETS_LIMIT;
    private int capacityNow = 0;
    private int numberOfTickets = 0;
    //private List<Ticket> listsOfUserStories = new LinkedList<Ticket>();
    private Ticket[] arrayOfUserStories=new Ticket[1];

    public Sprint(int capacity, int ticketsLimit) {
        CAPACITY = capacity;
        TICKETS_LIMIT= ticketsLimit;
    }

    public boolean addUserStory(UserStory userStory) {
        //checking if userStory can be accepted
        if(numberOfTickets >= TICKETS_LIMIT || userStory == null || 
        (capacityNow + userStory.getEstimate()) > CAPACITY || userStory.isCompleted()){
            return false;
        }
        else{
            //checking if userStory uncompleted dependencies are already accepted 
            if(userStory.userStory == null) return addUser(userStory);
            else if(arrayOfUserStories == null && !(userStory.userStory == null)) return false;
            else{
                int counter = 0;
                for(int i = 0;i<userStory.userStory.length;i++){
                    for(int j = 0;j<arrayOfUserStories.length;j++){
                        if(arrayOfUserStories[j]==userStory.userStory[i]) counter++;
                    }
                    if(counter>0)counter =0;
                    else return false;
                }
                return addUser(userStory);
            }
        } 
    }
    public boolean addUser(UserStory userStory){
        //adding UserStory to the list Of UserStory
        numberOfTickets++; 
        capacityNow += userStory.getEstimate();
            
        Ticket[] copy = new Ticket[numberOfTickets];
        System.arraycopy(arrayOfUserStories, 0, copy, 0, arrayOfUserStories.length); 
        copy[numberOfTickets-1] = userStory;
        arrayOfUserStories = new Ticket[numberOfTickets];
        System.arraycopy(copy, 0, arrayOfUserStories, 0, copy.length);  
        return true; 

    }

    public boolean addBug(Bug bugReport) {
        if(bugReport == null) return false;
        if(numberOfTickets >= TICKETS_LIMIT || bugReport.userStory == null || bugReport.getEstimate()+capacityNow >CAPACITY){
            return false;
        }
        else{
            //adding bugReport
            if(bugReport.isCompleted())return false;
            numberOfTickets++; 
            capacityNow += bugReport.getEstimate();
        
            Ticket[] copy = new Ticket[numberOfTickets];
            System.arraycopy(arrayOfUserStories, 0, copy, 0, arrayOfUserStories.length); 
            copy[numberOfTickets-1] = bugReport;
            arrayOfUserStories = new Ticket[numberOfTickets];
            System.arraycopy(copy, 0, arrayOfUserStories, 0, copy.length);  
            return true; 
        }
    } 
    
    
    public Ticket[] getTickets() {
        //return copy array of tickets
        Ticket[] copy = new Ticket[numberOfTickets];
        System.arraycopy(arrayOfUserStories, 0, copy, 0, arrayOfUserStories.length); 
        return copy;
    }

    public int getTotalEstimate() {
        //return taken capacity
        return capacityNow;
    }
}
