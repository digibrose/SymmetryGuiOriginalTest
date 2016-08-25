import javax.swing.*;
import java.awt.*;

/**
 * Created by digibrose on 10/10/2015.
 */
public class SymmetryGui extends JPanel {

    private JLayeredPane LP1;

    private JPanel Panel1;
    private JPanel Panel2;
    private JPanel Panel3;
    private JPanel Panel4;

    private JButton But1;
    private JButton But2;
    private JButton But3;
    private JButton But4;

  //  private List<SymmetryAxis> SymOptions;

    private SymImage SymImage;





    public SymmetryGui(){

     //   SymOptions = new ArrayList<SymmetryAxis>();

        JFrame f = new JFrame("Panel Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // f.setSize(1000, 500);
        f.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
     //   f.setLayout(new GridBagLayout());
     //   GridBagConstraints c = new GridBagConstraints();

        JLayeredPane LP1 = new JLayeredPane();
        LP1.setLayout(new GridBagLayout());
        LP1.setPreferredSize(new Dimension (500, 500));

        f.add(LP1);

        Panel1 = new JPanel();
        But1 = new JButton();
        //Panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        LP1.add(Panel1, gbc, 2);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        LP1.add(But1, gbc, 1);
        Panel1.setBackground(Color.BLACK);

        Panel2 = new JPanel();
        But2 = new JButton();
       // Panel2.setLayout(new GridBagLayout());
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        LP1.add(Panel2, gbc, 2);
        Panel2.setBackground(Color.BLUE);

        Panel3 = new JPanel();
        But3 = new JButton();
        // Panel2.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        LP1.add(Panel3, gbc, 2);
        Panel3.setBackground(Color.YELLOW);

        Panel4 = new JPanel();
        But4 = new JButton();
        //Panel2.setLayout(new GridBagLayout());
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        LP1.add(Panel4, gbc, 2);
        Panel4.setBackground(Color.RED);





        SymImage = new SymImage();
    //    SymImage.setSize(1000, 1000);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.weightx = 1.0;
        gbc2.weighty = 1.0;
        gbc2.gridwidth = 2;
        gbc2.gridheight = 2;
        LP1.add(SymImage, gbc2, 0);
        SymImage.setBorder(BorderFactory.createLineBorder(Color.BLUE));
      //  SymImage.setBackground(Color.PINK);
        SymImage.setOpaque(false);


        SymImage.createAndAddPiece(2, 50, 50);

        f.pack();
        f.setVisible(true);

    }

    public static void main(String[] args) {

        SymmetryGui NewGui = new SymmetryGui();

    }






}
