import interfaces.Playable;

abstract class PlayableItem extends MediaPlayerItem implements Playable {
    
    protected int duration;
    protected boolean isPlaying;
    protected int volume;

    public PlayableItem(String title, int duration) {
        super(title);
        setDuration(duration);
    }

    @Override
    public void play() {
        setPlaying(true);
        System.out.println(getTitle() + " in riproduzione");
    }
    
    @Override
    public void pause() {
        setPlaying(false);
        System.out.println(getTitle() + " in pausa");
    }

    @Override
    public void turnUpVolume(){
        if(getVolume() != 100) {
            setVolume(getVolume() + 10);
            System.out.println("Il volume di " + getTitle() + " è stato aumentato di 10");
        }
    }

    @Override
    public void turnDownVolume(){
        if(getVolume() != 0){
            setVolume(getVolume() - 10);
            System.out.println("Il volume di " + getTitle() + " è stato diminuito di 10");
        }

    }

    protected void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public boolean getIsPlaying() {
        return isPlaying;
    }

    public int getDuration() {
        return duration;
    }

    protected void setDuration(int duration) {
        this.duration = duration;
    }

    public int getVolume() {
        return this.volume;
    }

    protected void setVolume(int volume) {
        this.volume = volume;
    }

}
