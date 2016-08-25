import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

/**
 * Created by digibrose on 08/09/2015.
 */

public class SymAxisDragAndDropListener implements MouseListener, MouseMotionListener {

    private List<SymmetryAxis> SymAxis;
    private SymImage SymImage;

    private SymmetryAxis DragAxis;
    private int dragOffsetX;
    private int dragOffsetY;

    public SymAxisDragAndDropListener(List<SymmetryAxis> SymAxis, SymImage SymImage) {
        this.SymAxis = SymAxis;
        this.SymImage = SymImage;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent evt) {
        int x = evt.getPoint().x;
        int y = evt.getPoint().y;


// find out which piece to move.

// we check the list from top to buttom

// (therefore we itereate in reverse order)

//
        for (int i = this.SymAxis.size()-1; i >= 0; i--) {
            SymmetryAxis Syaxis = this.SymAxis.get(i);

            if( mouseOverPiece(Syaxis,x,y)){

// calculate offset, because we do not want the drag piece

// to jump with it's upper left corner to the current mouse

// position

//
                this.dragOffsetX = x - Syaxis.getX();
                this.dragOffsetY = y - Syaxis.getY();
                this.DragAxis = Syaxis;
                break;
            }
        }


// move drag piece to the top of the list
        if(this.DragAxis != null){
            this.SymAxis.remove(this.DragAxis);
            this.SymAxis.add(this.DragAxis);
        }
    }

    /**
     * check whether the mouse is currently over this piece
     * @param piece the playing piece
     * @param x x coordinate of mouse
     * @param y y coordinate of mouse
     * @return true if mouse is over the piece
     */
    private boolean mouseOverPiece(SymmetryAxis piece, int x, int y) {
        return piece.getX() <= x
                && piece.getX()+piece.getWidth() >= x
                && piece.getY() <= y
                && piece.getY()+piece.getHeight() >= y;
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        this.DragAxis = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        if(this.DragAxis != null){
            this.DragAxis.setX(evt.getPoint().x - this.dragOffsetX);
            this.DragAxis.setY(evt.getPoint().y - this.dragOffsetY);
            this.SymImage.repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


//..
}
