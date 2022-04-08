package design_patterns.strategy;

import java.util.ArrayList;

/**
 * Sorts items based on the InsertionSort algorithm
 */
public class InsertionSort implements SortBehavior {
    
    /**
     * InsertionSort algorithm sorting the list of data
     * @param data The ArrayList being sorted
     */
    // Used as a reference: https://www.java67.com/2014/09/insertion-sort-in-java-with-example.html
    public ArrayList<String> sort(ArrayList<String> data) {
        for (int i = 1; i < data.size(); i++) {
            String temp = data.get(i);
            int j = i;
            while (j > 0 && temp.compareTo(data.get(j - 1)) < 0) {
                data.set(j, data.get(j - 1));
                j--;
            }
            data.set(j, temp);
        }
        return data;
    }
}
