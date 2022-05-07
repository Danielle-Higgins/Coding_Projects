package design_patterns.command;

import java.util.concurrent.TimeUnit;
import java.io.*;

/**
 * Player class contains the algorithms that read the file
 */
public class Player {
	public Player() {
		
	}

	public void jump() {
		// Keeps track of current line in text file
        int line = 0;

        try {
            // Opens a bufferedReader for jump.txt
            BufferedReader html = new BufferedReader(new FileReader("./jump.txt"));
            
            String currLine;
            while ((currLine = html.readLine()) != null) {
                // Sleeps and clears console every 6 lines
                if(line % 6 == 0) {
                    sleep(100);
                    clear();
                }
                line++;
                System.out.println(currLine);
            }
            html.close();        
        } catch (Exception e) {
            System.out.println(e);
        }
	}

	public void fire() {
		// Keeps track of current line in text file
        int line = 0;

        try {
            // Opens a bufferedReader for fire.txt
            BufferedReader html = new BufferedReader(new FileReader("./fire.txt"));
            
            String currLine;
            while ((currLine = html.readLine()) != null) {
                // Sleeps and clears console every 3 lines
                if(line % 3 == 0) {
                    sleep(100);
                    clear();
                }
                line++;
                System.out.println(currLine);
            }
            html.close();        
        } catch (Exception e) {
            System.out.println(e);
        }
	}

	public void runForward() {
		int line = 0;
        try {
            String currentLine;
            BufferedReader reader = new BufferedReader(new FileReader("./run.txt"));
            while((currentLine = reader.readLine()) != null) {
                if (line % 3 == 0) {
                    sleep(100);
                    clear();
                }
                line++;
                System.out.println(currentLine);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
	}

	/**
     * Sleeps the loop for a temporary time
     * @param num The amount of times that the sleep happens
     * 
     */
    private void sleep(int num) {
        try {
            TimeUnit.MILLISECONDS.sleep(num);
        } catch (Exception e) {
            System.out.println("Timmer error");
        }
    }
    
    /**
     * Clears the console.
     * 
     */
    private void clear() {
        System.out.print("\033[H\033[2J");
    }
}
