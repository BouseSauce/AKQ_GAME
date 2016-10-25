package sample;

import com.sun.deploy.panel.JSmartTextArea;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Bouse PC on 10/10/2016.
 */
public class GUI extends JFrame {


    //File Dir
    static String aceDir = "C:\\Users\\Bouse PC\\IdeaProjects\\AKQ_GAME\\images\\Ace.png";
    static String kingDir = "C:\\Users\\Bouse PC\\IdeaProjects\\AKQ_GAME\\images\\King.jpg ";
    static String queenDir = "C:\\Users\\Bouse PC\\IdeaProjects\\AKQ_GAME\\images\\Queen.png ";
    static String frogDir = "C:\\Users\\Bouse PC\\IdeaProjects\\AKQ_GAME\\images\\FrogHat.jpg ";

    Boolean callButtonClick = false;
    Boolean foldButtonClick = false;


    Player player = null;
    JTextField textArea = null;
    JFrame f = null;

    public GUI() {
        try {
            initUI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initUI() throws IOException {

        f = new JFrame();

        textArea = new JTextField();
        textArea.setEditable(false);

        //Add image to JFrame
        File file = new File(frogDir);
        BufferedImage image = ImageIO.read(file);
        JLabel label = new JLabel(new ImageIcon(image));
        f.getContentPane().add(label);


        //JPanel layout
        JPanel panel = new JPanel();
        this.setLayout(null);

        //Buttons for Player Two
        JButton callButton = new JButton("Call");
        JButton foldButton = new JButton("Fold");
        panel.add(callButton);
        panel.add(foldButton);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(3,1));
        f.getContentPane().add(textArea);
        f.pack();
        f.getContentPane().add(panel);
        f.setVisible(true);






        callButton.addActionListener((ActionEvent event) -> {
            callButtonClick = true;
        });

        foldButton.addActionListener((ActionEvent event ) -> {
            foldButtonClick = false;
        });
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(()->
        {
            GUI gui = new GUI();
            gui.setVisible(true);
        });
    }

    void setGuiPlayer(Player player)
    {
        this.player = player;
    }

    public void updatePlayerCard(char card) throws IOException
    {
        String cardDir;
        if(card == 'A')
        {
            cardDir = aceDir;
        }
        if(card == 'K')
        {
            cardDir = kingDir;
        }
        else
        {
            cardDir = queenDir;
        }

        f.setVisible(false);
        f.remove(getContentPane());
        File file = new File(cardDir);
        BufferedImage image = ImageIO.read(file);
        JLabel label = new JLabel(new ImageIcon(image));
        f.getContentPane().add(label);
        f.setVisible(true);
    }

    public void setTextBox(String action)
    {
       textArea.setText('\n' + action + '\n');
    }

    public Boolean getCallButtonClick()
    {
        System.out.println("callButton");
        return callButtonClick;
    }

    public Boolean getFoldButtonClick()
    {
        System.out.println("foldButton");
        return foldButtonClick;
    }

    public void setCallButtonClick(Boolean callButtonClick)
    {
        this.callButtonClick = callButtonClick;
    }

    public void setFoldButtonClick(Boolean foldButtonClick){this.foldButtonClick = foldButtonClick;}





}
