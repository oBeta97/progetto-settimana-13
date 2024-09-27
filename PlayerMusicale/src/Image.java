import interfaces.Showable;
import interfaces.Viewable;

public class Image extends MediaPlayerItem implements Viewable, Showable {

    private int brightness;
    private boolean isVisible;
    private String format;

    public Image(String title, String format) {
        super(title);
        setFormat(format);
        setBrightness(50); // Default brightness
        setVisible(false); // Default visibility
    }

    public String getFormat() {
        return format;
    }

    private void setFormat(String format) {
        this.format = format;
    }

    private void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    @Override
    public void show() {
        setVisible(true);
        System.out.println("Image is now visible.");
    }

    @Override
    public void hide() {
        setVisible(false);
        System.out.println("Image is now hidden.");
    }

    @Override
    public void toggleVisibility() {
        isVisible = !isVisible;
        System.out.println("Image visibility toggled. Current visibility: " + isVisible);
    }

    @Override
    public boolean isVisible() {
        return isVisible;
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
    public void moreBrightness() {
        setBrightness(getBrightness() + 10);
        System.out.println("Aumentato valore della luminosità a: " + getBrightness());
    }

    @Override
    public void lessBrightness() {
        setBrightness(getBrightness() - 10);
        System.out.println("Diminuito valore della luminosità a: " + getBrightness());
    }


    @Override
    public String toString() {
        return "Image{\n\t" +
                    "filename='" + getTitle() + '\'' + "\n\t" +
                    "format='" + getFormat() + '\'' + "\n\t" +
                    "brightness=" + getBrightness() + "\n\t" +
                    "isVisible=" + isVisible() +
                "\n}";
    }
}
