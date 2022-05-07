package design_patterns.adapter;

/**
 * This class holds the songs held in the JukeBox
 * @author Danielle Higgins
 */
public abstract class Song {
    
    /**
     * Abstract method which the children have to implement (gets the title of the song)
     * @return The title of the song
     */
    public abstract String getTitle();

    /**
     * Abstract method which the children have to implement (gets the album name)
     * @return The album name
     */
    public abstract String getAlbum();

    /**
     * Abstract method which the children have to implement (gets the artist first name)
     * @return The artist first name
     */
    public abstract String getArtistFirstName();

    /**
     * Abstract method which the children have to implement (gets the artist last name)
     * @return The artist last name
     */
    public abstract String getArtistLastName();

    /**
     * Abstract method which the children have to implement (gets the genre of the song)
     * @return The genre of the song
     */
    public abstract String getGenre();

    /**
     * Returns a string in a particular format
     * @return The format
     */
    public String toString() {
        String ret;
        ret =  getTitle() + "\n";
        ret += "Album: " + getAlbum() + "\n";
        ret += "By: " + getArtistFirstName() + " " + getArtistLastName() + "\n";
        ret += "Genre: " + getGenre() + "\n";
        return ret;
    }
}
