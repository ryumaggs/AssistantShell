/* This class will handle all of the graphical aspects to this,
 * Setting up the frame with the gif + button, and setting up the
 * JTextArea
 */ 
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
public class MainFrame extends JFrame {
    JPanel contentPane;
    JLabel imageLabel = new JLabel();
    JLabel headerLabel = new JLabel();
    JButton theButton;
    public MainFrame() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            contentPane = (JPanel) getContentPane();
            contentPane.setLayout(new BorderLayout());
            setSize(new Dimension(400, 300));
            setTitle("GOODLUCK");
            
            // add the header label
            headerLabel.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 16));
            headerLabel.setText("                          GOODLUCK");
            contentPane.add(headerLabel, java.awt.BorderLayout.NORTH);
            
            // add the image label
            ImageIcon ii = new ImageIcon(this.getClass().getResource(
                    "saber.gif"));
            imageLabel.setIcon(ii);
            contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
            
            //add button
            JComponent chatter = new TextInitiator();
            chatter.setOpaque(true);
            contentPane.add(chatter, java.awt.BorderLayout.PAGE_END);
            
            // show it
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}