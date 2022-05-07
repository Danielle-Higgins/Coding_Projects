package design_patterns.observer;

import java.util.HashMap;

/**
 * An observer that shows the percentage of votes
 * @author Danielle Higgins
 */
public class PercentageDisplay implements Observer {
    private Subject poll;
    private HashMap<String, Integer> votes;
    private int numVotes;

    /**
     * When used, allows subject to passed in as an observer
     * @param poll A subject being passed in
     */
    public PercentageDisplay(Subject poll) {
        this.poll = poll;
        poll.registerObserver(this);
    }

     /**
     *  Updates whats in the HashMap
     * @param votes The HashMap being updated
     */
    public void update(HashMap<String, Integer> votes) {
        this.votes = votes;
        display();
    }

     /**
     * Displays the percentage of votes each candidate has
     */
    private void display() {
        System.out.println("\nCurrent Percent of Votes:");
        for (String key : votes.keySet()) {
            double sum = 0;
            double per = 0;
            for (double value : votes.values()) {
                sum += value;
                per = (votes.get(key) / sum) * 100;
            }
            double round = (Math.round(per*10.0)) / 10.0;
            System.out.println(key + ": " + round + "%");
        }
    }
}
