abstract class MediaPlayerItem {

    protected String title;


    public MediaPlayerItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class PlayableItem {
    }
}
