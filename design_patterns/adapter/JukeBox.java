package design_patterns.adapter;

import java.util.HashMap;

/**
 * Class that adds songs and plays songs in the form of a JukeBox
 * @author Danielle Higgins
 */
public class JukeBox {
    private HashMap<String, Song> songs;
    private int currentSong;
    
    /**
     * Constructor
     */
    public JukeBox() {
        songs = new HashMap<String, Song>();
    }

    /**
     * Adds the song to the hashmap
     * @param song The song being added
     */
    public void addSong(Song song) {
        songs.put(song.getTitle().toLowerCase(), song);
    }

    /**
     * Plays the song based on the name
     * @param songName The name of the song
     */
    public void play(String songName) {
        if (songs.containsKey(songName.toLowerCase())) {
            System.out.println(songs.get(songName.toLowerCase().toString()));
        } else {
            System.out.println("Sorry, song is not available!");
        }
    }
}