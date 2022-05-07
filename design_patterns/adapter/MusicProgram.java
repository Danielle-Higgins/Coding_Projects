package design_patterns.adapter;

import java.util.ArrayList;

/**
 * Driver Prgoram to interact with the JukeBox
 */
public class MusicProgram {
    public MusicProgram() {

    }

    /**
     * Creates a Jukebox, adds and plays songs
     */
    public void run() {
        JukeBox jukebox = new JukeBox();
        jukebox.addSong(new Track("Cover Me in Sunshine", "Cover Me in Sunshine", "Pink", "", Genre.POP));
        jukebox.addSong(new Track("Waiting On A War", "Medicine at Midnight", "Foo Fighters", "", Genre.ROCK));
        jukebox.addSong(new Track("The Bandit", "When You See Yourself", "Kings of Leon", "", Genre.ROCK));
        jukebox.addSong(new Track("What's Your Country Song", "Country Again", "Thomas", "Rhett", Genre.COUNTRY));

        // add oldies to jukebox
        ArrayList<Tune> tunes = getMyOldies();
        for (Tune tune : tunes) {
            jukebox.addSong(new SongAdapter(tune));
        }

        jukebox.play("Waiting On A War");
        jukebox.play("Twist and shout");
        jukebox.play("What's your country song");
        jukebox.play("Free Fallin");
    }

    /**
     * Gather a list of oldie songs
     * 
     * @return And ArrayList of Tunes
     */
    private ArrayList<Tune> getMyOldies() {
        ArrayList<Tune> tunes = new ArrayList<>();
        tunes.add(new Oldie("Tom Petty", "Free Fallin", "Full Moon Fever", "Classic Rock"));
        tunes.add(new Oldie("Loretta Lynn", "Coal Miner's Dauthger", "Coal Miner's Daughter", "Country and Western"));
        tunes.add(new Oldie("The Beatles", "Twist and Shout", "Please Please Me", "Rock"));
        return tunes;
    }

    public static void main(String[] args) {
        MusicProgram program = new MusicProgram();
        program.run();
    }
}
