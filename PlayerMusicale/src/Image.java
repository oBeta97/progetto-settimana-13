import interfaces.Showable;
import interfaces.Viewable;

public class Image implements Viewable, Showable {

    private int brightness;
    private boolean isVisible;
    private String filename;
    private String format;

    public Image(String filename, String format) {
        setFilename(filename);
        setFormat(format);
        setBrightness(50); // Default brightness
        setVisible(false); // Default visibility
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    @Override
    public void show() {
        isVisible = true;
        System.out.println("Image is now visible.");
    }

    @Override
    public void hide() {
        isVisible = false;
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
    }

    @Override
    public void lessBrightness() {
        setBrightness(getBrightness() - 10);
    }


    @Override
    public String toString() {
        return "Image{" +
                "filename='" + getFilename() + '\'' + "\t" +
                "format='" + getFormat() + '\'' + "\t" +
                "brightness=" + getBrightness() + "\t" +
                "isVisible=" + isVisible() +
                '}';
    }
}
