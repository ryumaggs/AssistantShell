import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TextInitiator extends JPanel
                           implements ActionListener
{
    JButton theButton;
    JTextArea prompt = new JTextArea();
    public TextInitiator()
    {
        super(new BorderLayout());
        theButton = new JButton("what'sup?");
        theButton.setPreferredSize(new Dimension(200,30));
        add(theButton, BorderLayout.PAGE_END);
        theButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().beep();
        JButton buttonThatWasClicked = (JButton)e.getSource();
        Container parent = buttonThatWasClicked.getParent();
        parent.remove(buttonThatWasClicked);
        //parent.revalidate();
        parent.repaint();
        prompt.setBackground(Color.BLUE);
        prompt.setForeground(Color.WHITE);
        parent.add(prompt, BorderLayout.PAGE_END);
        parent.repaint();
    }
    
    //for testing purposes
    /*public static void createButton(){
        JFrame buttonFrame = new JFrame("whatsup?");
        buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JComponent chatter = new TextInitiator();
        chatter.setOpaque(true);
        buttonFrame.setContentPane(chatter);
        
        buttonFrame.pack();
        buttonFrame.setVisible(true);
    }
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createButton();
            }
        });
    }*/
}
