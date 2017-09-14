import java.net.URI;
import java.awt.*; 
import java.io.*;

public class Examples {
	
    public static void main(String[] args) {
    StringExtract();
	OpenWebsite();	
	  
    }
	
	// Example to extract the contents between '[' and ']', add in 9/13/2017
	public static void StringExtract() {    
		String str = "ABC[ This is the text to be extracted ]";    
		String result = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
		System.out.println(result);	     
	}
	
	// Open website by address, add in 9/13/2017
	public static void OpenWebsite() {
		URI uri = URI.create("https://www.google.com");
		try{
			java.awt.Desktop.getDesktop().browse(uri);
		}catch(IOException e){
		
		}
	}
	
}