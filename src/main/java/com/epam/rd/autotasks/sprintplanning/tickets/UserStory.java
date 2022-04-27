package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {
    public UserStory[] userStory; 
    
    public UserStory(int id, String name, int estimate) {
        super(id, name, estimate);
        userStory = new UserStory[0];
    }

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        userStory = new UserStory[dependsOn.length];
        userStory = dependsOn;
    }
    @Override
    public void complete() {
        if(userStory.length == 0){
            completed = true;
        }
        else{
            int counter = 0;

            for(int i = 0;i<userStory.length;i++){
                if(userStory[i].completed == false){
                    counter++;
                    break;
                }    
            }
            if(counter == 0){
                completed = true;
            } 
        }
        
    }

    public UserStory[] getDependencies() {
        UserStory[] copyArray = new UserStory[userStory.length];
        System.arraycopy(userStory, 0, copyArray, 0, userStory.length);
        return copyArray;
    }

    @Override
    public String toString() {
        return "[US "+ getId() +"] "+ getName();
    }
}
