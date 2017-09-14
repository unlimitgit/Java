// import java.net.URI;
// import java.awt.*; 
// import java.io.*;

public class Test {
    public static void main(String[] args) {
     String str = "ABC[ This is the text to be extracted ]";    
	String result = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
	System.out.println(result);
	  
    }
}