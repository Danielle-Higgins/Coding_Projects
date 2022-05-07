package design_patterns.state;

import java.util.ArrayList;

/**
 * Class that plays two songs in french when in this state
 * @author Danielle Higgins
 */
public class FrenchState implements State {
    private MusicBox box;

    /**
     * Creates the state that the music box is in
     * @param box The state the music box is in
     */
    public FrenchState(MusicBox box) {
        this.box = box;
    }

    /**
     * Plays song in french
     */
    public void pressStarButton() {
        ArrayList<String> sLyrics = new ArrayList<String>();
        sLyrics.add("Brille, brille, petite étoile");
        sLyrics.add("Je me demande vraiment ce que tu es");
        sLyrics.add("Au-dessus du monde si haut");
        sLyrics.add("Comme un diamant dans le ciel");
        sLyrics.add("Brille, brille, petite étoile");
        sLyrics.add("Je me demande vraiment ce que tu es\n");
        box.playSong("Brille, brille, petite étoile", sLyrics);
    }

    /**
     * Plays song in french
     */
    public void pressHappyButton() {
        ArrayList<String> hLyrics = new ArrayList<String>();
        hLyrics.add("Si tu as d' la joie au coeur, Frappe des mains");
        hLyrics.add("Si tu as d' la joie au cœur, Frappe des mains");
        hLyrics.add("Si tu as d' la joie au cœur");
        hLyrics.add("Si tu as d' la joie au cœur");
        hLyrics.add("Si tu as d' la joie au cœur, Frappe des mains\n");
        box.playSong("Si tu as d' la joie au cœur", hLyrics);
    }

    /**
     * Switches from french to english mode
     */
    public void pressEnglishButton() {
        System.out.println("Switching to English\n");
        box.setState(box.getEnglishState());
    }

    /**
     * Displays the mode is already in french
     */
    public void pressFrenchButton() {
        System.out.println("You are already in French mode!\n");
    }

    /**
     * Switches from french to spanish mode
     */
    public void pressSpanishButton() {
        System.out.println("Switching to Spanish\n");
        box.setState(box.getSpanishState());
    }
}
