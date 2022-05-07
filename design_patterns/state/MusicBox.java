package design_patterns.state;

import java.util.ArrayList;

/**
 * Class that determines what state the music box is in
 * @author Danielle Higgins
 */
public class MusicBox {
    
    private State englishState;
    private State frenchState;
    private State spanishState;
    private State state;

    /**
     * Sets the variables to there states
     */
    public MusicBox() {
        englishState = new EnglishState(this);
        frenchState = new FrenchState(this);
        spanishState = new SpanishState(this);
        this.state = englishState;
    }

    /**
     * Will play the song
     */
    public void pressStarButton() {
        state.pressStarButton();
    }

    /**
     * Will play the song
     */
    public void pressHappyButton() {
        state.pressHappyButton();
    }

    /**
     * Will change the state to english
     */
    public void pressEnglishButton() {
        state.pressEnglishButton();
    }

    /**
     * Will change the state to french
     */
    public void pressFrenchButton() {
        state.pressFrenchButton();
    }

    /**
     * Will change the state to spanish
     */
    public void pressSpanishButton() {
        state.pressSpanishButton();
    }

    /**
     * Sets the state
     * @param state the state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Will get the english state
     * @return the english state
     */
    public State getEnglishState() {
        return englishState;
    }

    /**
     * Will get the french state
     * @return the french state
     */
    public State getFrenchState() {
        return frenchState;
    }

    /**
     * Will get the spanish state
     * @return The spanish state
     */
    public State getSpanishState() {
        return spanishState;
    }

    /**
     * When called, will print the lyrics to the song
     * @param songName The name of the song
     * @param lyrics The lyrics to the song
     */
    public void playSong(String songName, ArrayList<String> lyrics) {
        System.out.println("\nPlaying: " + songName);
        for (int i = 0; i < lyrics.size(); i++) {
            System.out.println(lyrics.get(i));
        }
    }
}
