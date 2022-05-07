package design_patterns.observer;

import java.util.HashMap;

/**
 * Interface that makes child classes implement the update method
 * @author Danielle Higgins
 */
public interface Observer {
    public void update(HashMap<String, Integer> votes);
}
