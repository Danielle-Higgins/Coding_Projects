package design_patterns.observer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The subject which keeps track of the observers, the votes, the school and the number of updates
 * @author Danielle Higgins
 */
public class StudentGovPoll implements Subject {
    private ArrayList<Observer> observers;
    private HashMap<String, Integer> votes;
    private String school;
    private int numUpdates;

    /**
     * Creates a StudentGovPoll with the indicated school which also initializes observers and votes
     * @param school The name of the school
     */
    public StudentGovPoll(String school) {
        this.school = school;
        observers = new ArrayList<Observer>();
        votes = new HashMap<String, Integer>();
    }

    /**
     * Adds an observer to ArrayList
     * @param observer The class doing the observing
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from ArrayList
     * @param observer The class doing the observing
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * When called, allows observer to update the HashMap
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(votes);
        }
    }

     /**
     * Adds canadiate to HashMap if not already in HashMap
     * @param president The key in the HashMap
     */
    public void addCandidate(String president) {
        if (!votes.containsKey(president)) {
            votes.put(president, 0);
        }
    }

    /**
     * Adds value (number of votes) to HashMap associated with the key
     * @param president The key in HashMap
     * @param num The value in HashMap
     */
    public void enterVotes(String president, int num) {
        if(votes.containsKey(president)) {
            votes.put(president, votes.get(president) + num);
        }
        numUpdates++;
        if (numUpdates == 4) {
            notifyObservers();
        }
    }

    /**
     * Displays the name of the school
     * @return The name of the school
     */
    public String getSchool() {
        return school;
    }
}
