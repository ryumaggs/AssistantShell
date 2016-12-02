import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class TextInputProcessing {
	String name;
	String activation;
	String EXIT = "exit";
	
	private TextInputProcessing(String name1, String activation1){
		name = name1;
		activation = activation1;
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
	
	private void getInput(Scanner scan){
		String input="";
		String[] retu;

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
			//webPage("youtube");

	}
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		TextInputProcessing shell = new TextInputProcessing("Linda","Mornin");
		shell.getInput(scanner);
		System.out.println("goodbye");
	}

}
