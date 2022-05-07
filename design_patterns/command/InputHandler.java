package design_patterns.command;

import java.util.HashMap;

/**
 * Takes input and calls the correct command according to the input
 */
public class InputHandler {
    private HashMap<String, command> commands = new HashMap<String, command>();

    /**
     * Contructs instance for all the commands and creates hash map for input/commands
     * @param player Instance of player
     */
    public InputHandler(Player player) {
        JumpCommand jumpcommand = new JumpCommand(player);
        RunCommand runcommand = new RunCommand(player);
        FireCommand firecommand = new FireCommand(player);
        QuitCommand quitcommand = new QuitCommand(player);
        commands.put("jump", jumpcommand);
        commands.put("run", runcommand);
        commands.put("fire", firecommand);
        commands.put("quit", quitcommand);
    }

    /**
     * Executes command according to input given in param
     * @param button Desired command
     */
    public void buttonPressed(String button) {
        commands.get(button).execute();
    }
}
