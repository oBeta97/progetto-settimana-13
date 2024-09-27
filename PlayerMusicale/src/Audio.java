
public class Audio extends PlayableItem  {

    String artist;
    String album;
    String genre;
    int year;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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
