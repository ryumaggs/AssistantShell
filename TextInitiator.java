/*
 *  This class will handle keyboard inputs, such as mouse+ keyboard inputs
 */

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class TextInitiator extends JPanel
                           implements ActionListener, KeyListener
{
    JButton theButton;
    JTextArea prompt = new JTextArea();
    TextInputProcessing input;
    public TextInitiator()
    {
        super(new BorderLayout());
        theButton = new JButton("what's up?");
        theButton.setPreferredSize(new Dimension(200,30));
        add(theButton, BorderLayout.PAGE_END);
        theButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().beep();
        JButton buttonThatWasClicked = (JButton)e.getSource();
        Container parent = buttonThatWasClicked.getParent();
        parent.remove(buttonThatWasClicked);
        input = new TextInputProcessing(parent);
        prompt.addKeyListener(this);
        parent.repaint();
    }
	public void keyPressed (KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER){
			String s = prompt.getText();
			e.consume();
			System.out.println("activated upon enter");
			input.proccessInput(s);
		}
	}
	
	public void keyReleased(KeyEvent e){
		if (e.getKeyCode()==KeyEvent.VK_ENTER){
			String s = prompt.getText();
			System.out.println("activated upon enter");
			input.proccessInput(s);
		}
	}
	
	public void keyTyped(KeyEvent e){
		
	}
}
