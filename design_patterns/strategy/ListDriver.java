package design_patterns.strategy;

import java.util.ArrayList;

/**
 * Creates lists of information, and displays the sorted versions of the lists
 */
public class ListDriver {

    /**
     * Creates a new ListDriver
     */
    public ListDriver(){}

    /**
     * Main entryway to the program
     * Creates the lists, and displays the sorted lists
     */
    public void run() {
        Listing shoppingList = new Listing("Grocery List");
        shoppingList.add("Apples");
        shoppingList.add("Peaches");
        shoppingList.add("Cheese");
        shoppingList.add("Crackers");
        shoppingList.add("Chocolate");
        shoppingList.add("Cherries");
        shoppingList.add("Bananas");
        shoppingList.add("Oranges");

        ArrayList<String> sortedGroceryItems = shoppingList.getSortedList();
        System.out.println(shoppingList.getTitle());
        displayList(sortedGroceryItems);

        Listing wishList = new Listing("Wish List");
        wishList.setSortBehavior(new InsertionSort());
        wishList.add("Bike");
        wishList.add("Paddle Board");
        wishList.add("Boat");
        wishList.add("Truck");
        wishList.add("Puzzle");
        wishList.add("Monolopy");
        wishList.add("Skipping Rope");
        wishList.add("Cherry Tree");

        ArrayList<String> sortedWishListItems = wishList.getSortedList();
        System.out.println("\n" + wishList.getTitle());
        displayList(sortedWishListItems);
    }

    /**
     * Loops through and displays each item in the list items
     * @param items list to display
     */
    private void displayList(ArrayList<String> items){
        for(String item : items){
            System.out.println("- " + item);
        }
    }

    public static void main(String[] args){
        ListDriver driver = new ListDriver();
        driver.run();
    }
}
