package design_patterns.iterator;

import java.util.ArrayList;

/**
 * Holds information of the exercises
 * @author Danielle Higgins
 */
public class Exercise {
    private String title;
    private ArrayList<String> targetMuscles = new ArrayList<String>();
    private ArrayList<String> directions = new ArrayList<String>();

    /**
     * Creates exercise with just the title (not used)
     * @param title The title of the exercise
     */
    public Exercise(String title) {
        this.title = title;
    }

    /**
     * Creates the exercise with the title, muscles, and directions
     * @param title The title of the exercise
     * @param targetMuscles The muscles associated with the exercise
     * @param directions The directions of the exercise
     */
    public Exercise(String title, ArrayList<String> targetMuscles, ArrayList<String> directions) {
        this.title = title;
        this.targetMuscles = targetMuscles;
        this.directions = directions;
    }

    /**
     * Adds the muscle to the ArrayList
     * @param muscle The muscle associated with the exercise
     */
    public void addTargetMuscle(String muscle) {
        targetMuscles.add(muscle);
    }

    /**
     * Removes the muscle from the ArrayList
     * @param muscle The muscle associated with the exercise
     */
    public void removeTargetMuscle(String muscle) {
        targetMuscles.remove(muscle);
    }

    /**
     * Returns the string of the title, targetMuscles, and directions in a certain way
     * @return String representation of title, targetMuscles, and directions
     */
    public String toString() {
        return "\n... " + title + " ..." + "\n" + "Muscles: " + targetMuscles.toString().replaceAll("[\\[\\]]", "")
        + "\nExercises:" + "\n" + directions.toString().replaceAll("[\\[\\]]", "").replaceAll(",", "\n-").replaceFirst("", "- ")
        + "\n";
    }
}
