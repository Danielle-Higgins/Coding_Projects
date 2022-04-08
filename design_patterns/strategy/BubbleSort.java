package design_patterns.strategy;

import java.util.ArrayList;

/**
 * Sorts items based on the BubbleSort algorithm
 */
public class BubbleSort implements SortBehavior {
    
    /**
     * BubbleSort algorithm sorting the list of data
     * @param data The ArrayList being sorted
     */
    // Used as a reference: https://www.geeksforgeeks.org/sorting-strings-using-bubble-sort-2/
    public ArrayList<String> sort(ArrayList<String> data) {
        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(i).compareTo(data.get(j)) > 0) {
                    String temp = data.get(i);
                    data.set(i, data.get(j));
                    data.set(j, temp);
                }
            }
        }
        return data;
    }
}
