package design_patterns.iterator;

import java.util.Iterator;

/**
 * Creates an iterator for the array of exercises
 * @author Danielle Higgins
 */
public class ExerciseIterator implements Iterator {
    private Exercise[] exercises;
    private int position = 0;

    /**
     * Accepts an array of exercises
     * @param exercises Array of exercises
     */
    public ExerciseIterator(Exercise[] exercises) {
        this.exercises = exercises;
    }

    /**
     * Checks to see if there are anymore exercises to iterate over
     * @return The next position
     */
    public boolean hasNext() {
        return position < exercises.length && exercises[position] != null;
    }

    /**
     * Checks to see if there is another exercise other wise its empty
     * @return If empty, null
     * @return The next position
     */
    public Exercise next() {
        if (!hasNext()) {
            return null;
        }
        Exercise exercise = exercises[position];
        position++;
        return exercise;
    }
}
