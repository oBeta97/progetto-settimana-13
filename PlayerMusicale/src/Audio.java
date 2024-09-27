
public class Audio extends PlayableItem  {

    private String artist;
    private String album;
    private String genre;
    private int year;

    public Audio(String title, int duration, String artist, String album, String genre, int year) {
        super(title, duration);
        setArtist(artist);
        setAlbum(album);
        setGenre(genre);
        setYear(year);
    }

    public String getArtist() {
        return artist;
    }

    private void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    private void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    private void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Audio{" +
                    "\n\ttitle='" + getTitle() + '\'' +
                    "\n\tartist='" + getArtist() + '\'' +
                    "\n\talbum='" + getAlbum() + '\'' +
                    "\n\tgenre='" + getGenre() + '\'' +
                    "\n\tyear='" + getYear() + '\'' +
                    "\n\tduration=" + getDuration() +
                    "\n\tisPlaying=" + getIsPlaying() +
                    "\n\tvolume=" + getVolume() +
                "\n}";
    }
}
