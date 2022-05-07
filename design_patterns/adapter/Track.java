package design_patterns.adapter;

/**
 * Getter class that gets all of the qualities of a song
 * @author Danielle Higgins
 */
public class Track extends Song {
    private String title;
    private String album;
    private String firstName;
    private String lastName;
    private Genre genre;

    /**
     * Constructor
     * @param title The title of the song
     * @param album The album
     * @param firstName The first name of artist
     * @param lastName The last name of artist
     * @param genre The genre of the song
     */
    public Track(String title, String album, String firstName, String lastName, Genre genre) {
        this.title = title;
        this.album = album;
        this.firstName = firstName;
        this.lastName = lastName;
        this.genre = genre;
    }

    /**
     * Gets the title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Gets the first name of artist
     */
    public String getArtistFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the artist
     */
    public String getArtistLastName() {
        return lastName;
    }

    /**
     * Gets the genre of song
     */
    public String getGenre() {
        return genre.toString();
    }
}
