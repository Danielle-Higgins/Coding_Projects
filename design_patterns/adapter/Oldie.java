package design_patterns.adapter;

/**
 * Class that displays the songs in a different way
 * @author Danielle Higgins
 */
public class Oldie implements Tune {
    private String artistName;
    private String songTitle;
    private String recordTitle;
    private String category;

    /**
     * Constructor that initializes the instance fields
     * @param artistName The name of the artist
     * @param songTitle The title of the song
     * @param recordTitle The album name
     * @param category The genre
     */
    public Oldie(String artistName, String songTitle, String recordTitle, String category) {
        this.artistName = artistName; // is the first name and last name separated by a space
        this.songTitle = songTitle;
        this.recordTitle = recordTitle;
        this.category = category;
    }

    /**
     * Gets the name of the artist
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Gets the title (song and album titles)
     */
    public String getDisplayTitle() {
        return songTitle + ":" + recordTitle;
    }

    /**
     * Gets the genre of the song
     */
    public String getCategory() {
        return category;
    }
}
