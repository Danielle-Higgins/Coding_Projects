package design_patterns.command;

public class RunCommand implements command {
    private Player player;

    /**
     * Default Constructor: Sets the player to the current player
     * @param player The player that is passed in
     * 
     */
    public RunCommand(Player player) {
        this.player = player;
    }

    /**
     * Main method of the class that reads the txt file, and prints the necessary lines to perform the console animation
     * 
     */
    public void execute() {
        player.runForward();
    }
}
