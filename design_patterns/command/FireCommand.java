package design_patterns.command;

public class FireCommand implements command {
    private Player player;

    /**
     * Class constructor
     * @param player constructer parent class
    */
    public FireCommand(Player player) {
        this.player = player;
    }

    public void execute() {
        player.fire();    
    }
    
}
