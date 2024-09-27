import interfaces.Showable;

public class Video extends PlayableItem implements Showable {
    
    private int brightness;

    public Video(String title, int duration) {
        super(title, duration);
        setBrightness(50);
    }

    @Override
    public void moreBrightness() {
        setBrightness(getBrightness() + 10);
    }

    @Override
    public void lessBrightness() {
        setBrightness(getBrightness() - 10);
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100) {
            this.brightness = brightness;
        } else {
            System.out.println("Brightness value should be between 0 and 100.");
        }
    }

    @Override
    public String toString() {
        return "Video{\n" +
                    "\ttitle='" + getTitle() + "',\n" +
                    "\tduration=" + getDuration() + ",\n" +
                    "\tbrightness=" + getBrightness() + ",\n" +
                    "\tvolume=" + getVolume() + ",\n" +
                    "\tisPlaying=" + getIsPlaying() + "\n" +
                "}";
    }
}
