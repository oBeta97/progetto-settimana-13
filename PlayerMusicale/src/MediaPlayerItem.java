abstract class MediaPlayerItem {

    protected String title;


    public MediaPlayerItem(String title) {
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }
}
