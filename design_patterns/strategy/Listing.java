package design_patterns.strategy;

import java.util.ArrayList;

/**
 * Holds a list of data in an ArrayList with functionality
 * @author Danielle
 */
public class Listing {
    private String title;
    private ArrayList<String> items;
    private SortBehavior sortBehavior;

    /**
     * Creates a new listing with the indicated title, also initializes items and the sortBehavior
     * @param title The title of the listing
     */
    public Listing(String title) {
        this.title = title;
        items = new ArrayList<String>();
        sortBehavior = new BubbleSort();
    }

    /**
     * Adds an item to an ArrayList
     * @param item The item being added to the list
     */
    public void add(String item) {
        items.add(item);
    }

    /**
     * Removes an item from an ArrayList
     * @param item The item being removed from the list
     */
    public void remove(String item) {
        items.remove(item);
    }

    /**
     * Displays the title
     * @return The title of the Listing
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the sortBehavior, can change the type of sorting algorithm to use
     * @param sortBehavior The sorting algorithm
     */
    public void setSortBehavior(SortBehavior sortBehavior) {
        this.sortBehavior = sortBehavior;
    }

    /**
     * Displays the sorted list
     * @return The sorted items in the list
     */
    public ArrayList<String> getSortedList() {
        return sortBehavior.sort(items);
    }

    /**
     * Displays the original list
     * @return The items in the original list
     */
    public ArrayList<String> getUnsortedList() {
        return items;
    }
}
