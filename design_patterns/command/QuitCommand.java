package design_patterns.command;

/**
 * Command class that quits the execution of the program
 */
public class QuitCommand implements command {
    private Player player;

    /**
     * Sets the player
     * @param player Doing the run, jump, and fire commands
     */
    public QuitCommand(Player player) {
        this.player = player;
    }

    /**
     * Exits the program
     */
    public void execute() {
        System.exit(0);
    }
}