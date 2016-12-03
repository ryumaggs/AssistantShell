import java.awt.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TextInputProcessing extends JPanel
								implements ActionListener
{
	String name;
	String activation;
	String EXIT = "exit";
	
	public TextInputProcessing(Container parent){
		System.out.println("set up prompt via seperate class");
		JTextArea prompt = new JTextArea();
        prompt.setBackground(Color.BLUE);
        prompt.setForeground(Color.WHITE);
        parent.add(prompt, BorderLayout.PAGE_END);
	}
	
	public void actionPerformed(ActionEvent e) {
		getInput(); // finish thisadad
	}
	private boolean exit(String input, String exit){
		if((input.toLowerCase()).equals(exit))
			return true;
		return false;
	}
	
	private String[] parseCommand(String input){ // counter not incrementing correctly. places everything in first slot of array
		String[] tokens;
		String delims = "\\s+";
		tokens = input.split(delims);
		return tokens;
	}
	
	private void webPage(String url1){
		String url = "https://www." + url1 + ".com";
		
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
	
	private void getInput(){
		String input="";
		String[] retu;
		Scanner scan = new Scanner(System.in);

		while(true){
			System.out.print(">");
			input = scan.next();
			
			if(exit(input, EXIT)==true) // checks for exit
				break;
			
			retu = parseCommand(input);
			
			for (int i = 0; i < retu.length; i++){
				System.out.println(retu[i]);
			}
		}
		scan.close();
		System.exit(1);
			//webPage("youtube");

	}
	
	public static void main(String args[]){;
		System.out.println("goodbye");
	}

}
