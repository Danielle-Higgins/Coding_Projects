package design_patterns.state;

import java.util.ArrayList;

/**
 * Class that plays two songs in english when in this state
 * @author Danielle Higgins
 */
public class EnglishState implements State {
    
    private MusicBox box;

    /**
     * Creates the state that the music box is in
     * @param box The state the music box is in
     */
    public EnglishState(MusicBox box) {
        this.box = box;
    }

    /**
     * Plays the song in english
     */
    public void pressStarButton() {
        ArrayList<String> tLyrics = new ArrayList<String>();
        tLyrics.add("Twinkle twinkle little star");
        tLyrics.add("How I wonder what you are");
        tLyrics.add("Up above the world so high");
        tLyrics.add("Like a dimond in the sky");
        tLyrics.add("Twinkle twinkle little star");
        tLyrics.add("How I wonder what you are\n");
        box.playSong("Twinkle Twinkle Little Star", tLyrics);
    }

    /**
     * Plays song in english
     */
    public void pressHappyButton() {
        ArrayList<String> hLyrics = new ArrayList<String>();
        hLyrics.add("If you're happy and you know it clap your hands");
        hLyrics.add("If you're happy and you know it clap your hands");
        hLyrics.add("If you're happy and you know it");
        hLyrics.add("And you really want to show it");
        hLyrics.add("If you're happy and you know it clap your hands\n");
        box.playSong("If you're happy and you know it", hLyrics);
    }

    /**
     * Displays that the user is already in english mode
     */
    public void pressEnglishButton() {
        System.out.println("You are already in English mode!\n");
    }

    /**
     * Switches the mode from english to french
     */
    public void pressFrenchButton() {
        System.out.println("Switching to French\n");
        box.setState(box.getFrenchState());
    }

    /**
     * Switches the mode from english to spanish
     */
    public void pressSpanishButton() {
        System.out.println("Switching to Spanish\n");
        box.setState(box.getSpanishState());
    }
}
