import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by digibrose on 06/10/2015.
 */
public class SymImage extends JPanel {

    private Image imgBackground;
    private Image im2;
    private double height;
    private int h2;
    private double imwidth;
    private double pwidth;
    private List<SymmetryAxis> SymOptions = new ArrayList<SymmetryAxis>();
    public SymImage() {

        URL urlBackground = getClass().getResource("Cell.png");

        this.imgBackground = new ImageIcon(urlBackground).getImage();
        imwidth = (double) this.imgBackground.getWidth(null);
    }

    public void createAndAddPiece(int type, int x, int y) {
        Image img = this.getImageForPiece(type);
        SymmetryAxis axis = new SymmetryAxis(img, x, y, type);
        this.SymOptions.add(axis);
    }

    private Image getImageForPiece(int type) {

        String filename = "";

        switch (type) {
            case SymmetryAxis.TYPE_TWOFOLD:
                filename += "2fold";
                break;
        }
        filename += ".png";

        URL urlPieceImg = getClass().getResource(filename);
        return new ImageIcon(urlPieceImg).getImage();
    }


    @Override
    protected void paintComponent(Graphics g) {

        // im2 = imgBackground.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        // g.drawImage(im2, 0, 0, null);
        //  this.im2 = this.imgBackground.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        pwidth = (double) this.getWidth();
        this.height = (pwidth/imwidth) * imgBackground.getHeight(null);
        //  this.height = (this.getWidth() / imgBackground.getWidth(null)) * imgBackground.getHeight(null);
        System.out.println(height +" "+ getHeight());
        h2 = (int) height;
        //  System.out.println(this.getWidth() +" "+ imgBackground.getWidth(null) +" "+ imgBackground.getHeight(null));
  //      g.drawImage(this.imgBackground, 0, 0, getWidth(), h2, null);

        for (SymmetryAxis SA : this.SymOptions) {
            g.drawImage(SA.getImage(), SA.getX(), SA.getY(), null);
        }

   //     g.drawImage(this.imgBackground, 0, 0, getWidth(), getHeight(), null);

     //   this.SymGui.repaint();
     //   this.setBackground(new Color(125, 0, 0, 50));
        //   System.out.println(getWidth());

        SymAxisDragAndDropListener listener = new SymAxisDragAndDropListener(this.SymOptions, this);
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);


    }



}
