import java.awt.*;

/**
 * Created by digibrose on 09/10/2015.
 */
public class SymmetryAxis {

    public static final int TYPE_TWOFOLD = 2;

    private Image img;
    private int x;
    private int y;
    private int type;

    public SymmetryAxis(Image img, int x, int y, int type) {

        this.img = img;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public Image getImage() {
        return img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return img.getHeight(null);
    }

    public int getHeight() {
        return img.getHeight(null);
    }





}
