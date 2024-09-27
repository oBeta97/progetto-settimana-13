import interfaces.Playable;

abstract class PlayableItem extends MediaPlayerItem implements Playable {
    
    protected int duration;
    protected boolean isPlaying;
    protected int volume;

    public PlayableItem(String title, int duration) {
        super(title);
        setDuration(duration);
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public boolean getIsPlaying() {
        return isPlaying;
    }

    @Override
    public void play() {
        setPlaying(true);
    }
    
    @Override
    public void pause() {
        setPlaying(false);
    }

    @Override
    public void turnUpVolume(){
        if(getVolume() != 100)
            setVolume(getVolume() + 10);
    }

    @Override
    public void turnDownVolume(){
        if(getVolume() != 0)
            setVolume(getVolume() - 10);

    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

}
