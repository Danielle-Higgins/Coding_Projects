package design_patterns.strategy;

import java.util.ArrayList;

/**
 * Interface that makes the child classes implement the sort method
 * @author Danielle
 */
public interface SortBehavior {
    public ArrayList<String> sort(ArrayList<String> data);
}
