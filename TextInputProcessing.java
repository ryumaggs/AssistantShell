import java.awt.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class TextInputProcessing extends JPanel
								 implements KeyListener
{
	String name;
	String activation;
	JTextArea prompt;
	
	//Constructor for the input loop
	public TextInputProcessing(Container parent){
		System.out.println("set up prompt via seperate class");
		prompt = new JTextArea();
        prompt.setBackground(Color.BLUE);
        prompt.setForeground(Color.WHITE);
        parent.add(prompt, BorderLayout.PAGE_END);
        prompt.requestFocusInWindow();
        prompt.addKeyListener(this);
	}
	public void keyPressed (KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER){
			String s = prompt.getText();
			proccessInput(s);
			e.consume();
			System.out.println(s);
			repaint();
		}
	}
	
	public void keyReleased(KeyEvent e){
	
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	//checks for if exit was typed in
	public static boolean exit(String input, String exit){
		if((input.toLowerCase()).equals(exit))
			return true;
		return false;
	}
	
	//parses the input command
	public static String[] parseCommand(String input){ // counter not incrementing correctly. places everything in first slot of array
		String[] tokens;
		String delims = "\\s+";
		tokens = input.split(delims);
		return tokens;
	}
	
	//opens a web page with given input
	public void webPage(String url1){
		String url = "https://www." + url1 + ".com";
		System.out.println("webpage attempted to open: " + url);
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
       }
	}
	
	//infinite loop to keep getting input and respond accordingly
	//consider changing to without the loop; does not fit well with JTextArea
	//can just use KeyPre
	public void proccessInput(String input){
		String[] retu;
		if(exit(input, "exit")==true) // checks for exit
			System.exit(1);
		retu = parseCommand(input);
		if(retu[0].equals("open"))
			webPage(retu[1]);
		for (int i = 0; i < retu.length; i++){
			System.out.println("hi" + retu[i]);
		}
			//webPage("youtube");

	}
	
	//main function
	public static void main(String args[]){;
		System.out.println("goodbye");
	}

}
