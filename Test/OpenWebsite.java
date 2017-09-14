import java.net.URI;
import java.awt.*; 
import java.io.*;

public class OpenWebsite {
    public static void main(String[] args) throws Exception {
      URI uri = URI.create("https://www.google.com");
	  // try{
		java.awt.Desktop.getDesktop().browse(uri);
	// }catch(IOException e){
		
	// }
	  
    }
}