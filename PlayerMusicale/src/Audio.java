
public class Audio extends PlayableItem  {

    String artist;
    String album;
    String genre;
    String year;

    public Audio(String title, int duration, String artist, String album, String genre, String year) {
        super(title, duration);
        setArtist(artist);
        setAlbum(album);
        setGenre(genre);
        setYear(year);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "\ttitle='" + getTitle() + '\'' +
                "\tartist='" + getArtist() + '\'' +
                "\talbum='" + getAlbum() + '\'' +
                "\tgenre='" + getGenre() + '\'' +
                "\tyear='" + getYear() + '\'' +
                "\tduration=" + getDuration() +
                "\tisPlaying=" + getIsPlaying() +
                '}';
    }
}
