import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.*;

public class Test  {
	
		boolean textEditable = true;
	
    public Test() throws BadLocationException {	
		
		String fileName = "write.txt";
		
		Color mygray = new Color(245, 245, 245); 
        JFrame frame = new JFrame();
        DefaultStyledDocument document = new DefaultStyledDocument();
        JTextPane pane = new JTextPane(document);
        JPanel mainPanel = new JPanel();
        JButton button = new JButton("Save");
        button.setPreferredSize(new Dimension(100, 40));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.setPreferredSize(new Dimension(200, 200));
		JScrollPane paneScrollPane = new JScrollPane(pane);
        paneScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        paneScrollPane.setPreferredSize(new Dimension(250, 155));
        paneScrollPane.setMinimumSize(new Dimension(10, 10));
        mainPanel.add(button);
        frame.getContentPane().add(paneScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(mainPanel, BorderLayout.WEST);
		
		// Extract the string contents, and open the website page included by '[' ']'
		pane.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
               return;
            }
            if (e.getClickCount() != 2) {
               return;
            }

            int offset = pane.viewToModel(e.getPoint());

            try {
               int rowStart = Utilities.getRowStart(pane, offset);
               int rowEnd = Utilities.getRowEnd(pane, offset);
               String selectedLine = pane.getText().substring(rowStart, rowEnd);
               System.out.println(selectedLine);
			   // String Website = StringExtract(selectedLine);
			   // OpenWebsite(Website);

            } catch (BadLocationException e1) {
               e1.printStackTrace();
            }

         }
      });
		
        StyleContext context = new StyleContext();
        // build a style
        Style style = context.addStyle("Test", null);
        // set some style properties
        StyleConstants.setForeground(style, Color.BLACK);
        document.insertString(0, "Four: success \n", style);
        StyleConstants.setForeground(style, Color.RED);
        document.insertString(0, "Three: error \n", style);
        //document.insertString(0, "Two: error \n", style);

        //StyleConstants.setForeground(style, Color.BLACK);
        // add some data to the document
       // document.insertString(0, "One: success \n", style);
		
		button.addActionListener(new java.awt.event.ActionListener(){ 
		  public void actionPerformed(java.awt.event.ActionEvent evt) { 	  
			//int lines = pane.getLineCount();
			if (textEditable){
				textEditable = false;
				button.setText("Edit");
				pane.setBackground(mygray);
				pane.setEditable(false);
			} else {
				textEditable = true;
				button.setText("Save");
				pane.setEditable(true);
				pane.setBackground(Color.white);
			}
			
			try {
			String content = pane.getDocument().getText(0, pane.getDocument().getLength());
			System.out.println(content);
			int i = pane.getDocument().getLength();
			System.out.println(i);
			
			 try {
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(content);
           
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
			
			
			
			} 
			catch (BadLocationException ee) {
				//handle exception
			}	
	
			  } 
		} );


        //  StyleConstants.setForeground(style, Color.blue);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) throws BadLocationException {
        new Test();
    }
}