package design_patterns.adapter;

/**
 * An adaptor that will take in a Tune and make it into a Song
 * @author Danielle Higgins
 */
public class SongAdapter extends Song {
    private Tune tune;

    /**
     * Constructor
     * @param tune The tune
     */
    public SongAdapter(Tune tune) {
        this.tune = tune;
    }

    /**
     * Gets the title of the song
     */
    public String getTitle() {
        String[] arr = tune.getDisplayTitle().split(":");
        return arr[0];
    }

    /**
     * Gets the album
     */
    public String getAlbum() {
        String[] arr = tune.getDisplayTitle().split(":");
        return arr[1];
    }

    /**
     * Gets the first name of artist
     */
    public String getArtistFirstName() {
        String[] arr = tune.getArtistName().split(" ");
        return arr[0];
    }

    /**
     * Gets the last name of the artist
     */
    public String getArtistLastName() {
        String[] arr = tune.getArtistName().split(" ");
        return arr[1];
    }

    /**
     * Turns the categories into their respective genres
     */
    public String getGenre() {
        if (tune.getCategory().equalsIgnoreCase("Country and Western")) {
            return Genre.COUNTRY.toString();
        } else if(tune.getCategory().equalsIgnoreCase("R&B and Soul")) {
            return Genre.HIPHOP.toString();
        } else if (tune.getCategory().equalsIgnoreCase("Easy Listening")) {
            return Genre.POP.toString();
        } else if (tune.getCategory().equalsIgnoreCase("Rock")) {
            return Genre.ROCK.name();
        } else if (tune.getCategory().equalsIgnoreCase("Classic Rock")) {
            return Genre.ROCK.toString();
        } else {
            return Genre.OTHER.toString();
        }
    }
}
