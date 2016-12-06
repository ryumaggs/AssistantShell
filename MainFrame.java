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
	JFrame windowFrame;
    JPanel contentPane;
    JLabel imageLabel = new JLabel();
    JLabel headerLabel = new JLabel();
    JButton theButton;
    public MainFrame() {
        try {
        	//set up the JFrame
            windowFrame	= new JFrame();
            windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            windowFrame.setVisible(true);
            
            //Set up the JPanel
            contentPane = (JPanel) getContentPane();
            contentPane.setLayout(new BorderLayout());
            windowFrame.getContentPane().add(contentPane, BorderLayout.CENTER);
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
            windowFrame.pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}