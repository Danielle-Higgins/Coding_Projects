package design_patterns.observer;

import java.util.HashMap;

/**
 * An observer that shows the number of votes
 * @author Danielle Higgins
 */
public class TallyDisplay implements Observer {
    private Subject poll;
    private HashMap<String, Integer> votes;

    /**
     * When used, allows subject to passed in as an observer
     * @param poll A subject being passed in
     */
    public TallyDisplay(Subject poll) {
        this.poll = poll;
        poll.registerObserver(this);
    }

    /**
     * Updates whats in the HashMap
     * @param votes The HashMap being updated
     */
    public void update(HashMap<String, Integer> votes) {
        this.votes = votes;
        display();
    }

    /**
     * Display the total number of votes each candidate has
     */
    private void display() {
        System.out.println("\nCurrent Tallies:");
        for (String key : votes.keySet()) {
            System.out.println(key + ": " + votes.get(key));
        }
    }
}
