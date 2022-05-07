package design_patterns.state;

import java.util.ArrayList;

/**
 * Class that plays two songs in spanish when in this state
 * @author Danielle Higgins
 */
public class SpanishState implements State {
    private MusicBox box;

    /**
     * Creates the state that the music box is in
     * @param box The state the music box is in
     */
    public SpanishState(MusicBox box) {
        this.box = box;
    }

    /**
     * Plays the song in spanish
     */
    public void pressStarButton() {
        ArrayList<String> sLyrics = new ArrayList<String>();
        sLyrics.add("Estrellita, ¿dónde estás?");
        sLyrics.add("Quiero verte cintilar");
        sLyrics.add("En el cielo, sobre el mar.");
        sLyrics.add("Un diamante de verdad.");
        sLyrics.add("Estrellita, ¿dónde estás?");
        sLyrics.add("Quiero verte cintilar.\n");
        box.playSong("Estrellita, ¿Dónde Estás?", sLyrics);
    }

    /**
     * Plays the song spanish
     */
    public void pressHappyButton() {
        ArrayList<String> hLyrics = new ArrayList<String>();
        hLyrics.add("Si usted esta feliz Apaluda las fuerte.");
        hLyrics.add("Si usted esta feliz Apaluda las fuerte.");
        hLyrics.add("Si usted esta feliz En su cara se vera.");
        hLyrics.add("Si usted esta feliz Apaluda las fuerte.\n");
        box.playSong("Si usted esta feliz Apaluda las fuerte", hLyrics);
    }

    /**
     * Switchs mode from spanish to english
     */
    public void pressEnglishButton() {
        System.out.println("Switching to English\n");
        box.setState(box.getEnglishState());
    }

    /**
     * Switch the mode from spanish to french
     */
    public void pressFrenchButton() {
        System.out.println("Switching to French\n");
        box.setState(box.getFrenchState());
    }

    /**
     * Displays the user is already in spanish mode
     */
    public void pressSpanishButton() {
        System.out.println("You are already in Spanish mode!\n");
    }
}
