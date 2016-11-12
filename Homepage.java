import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics. *;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class Homepage extends Applet implements ActionListener{

	Button randomQuestion;
	Button listQuestion;
	Button about;
	
	JTextArea text;
	
	String[] stringArray;
	
    public void init() {
    	//Set window size
    	this.setSize(new Dimension(800,800));
    	
    	// Create buttons
    	randomQuestion = new Button("Get a Random Question");
        listQuestion = new Button("Choose a Question");
        about = new Button("About Stereotype Threat");
        
        //Initialize text box (empty)
        text = new JTextArea("", 40, 40);
        
        //Initialize string array
        stringArray = new String[3];
        stringArray[0] = "a";
        stringArray[1] = "b";
        stringArray[2] = "c";
        	
        
        
        // Add buttons to the home screen
        add(randomQuestion);
        add(listQuestion);
        add(about);
        add(text);

        // Initialize what each thing will do
        randomQuestion.addActionListener(this);
        listQuestion.addActionListener(this);
        about.addActionListener(this);
     
    }
    
    //Check if button was clicked, react
    public void actionPerformed(ActionEvent e) {
 
		
		 
		 if (e.getSource() == listQuestion)
			System.out.println("listQuestion was pressed");
		else if (e.getSource() == about)
			text.append("    Stereotype threat occurs when a person confirms a \n"
			+ "stereotype of one’s group. This can occur during \n"
			+ "stressful situations like an interview or a test, \n"
			+ "where one can doubt their abilities due to a certain \n"
			+ "aspect of one’s identity. A concrete example may be women \n"
			+ "applying for engineering internships, where an indication \n"
			+ "of their gender on the application may create a subconscious \n"
			+ "stereotype threat.\n"
			+ "   A proven way to combat stereotype threat is to have \n"
			+ "people write down their strengths and past accomplishments \n"
			+ "so that they do not doubt their abilities. Even simple \n"
			+ "questions like asking about a special talent or a proud \n"
			+ "moment in their life has shown to decrease the effect of \n"
			+ "stereotype threat significantly. This applet is designed \n"
			+ "to help combat stereotype threat by asking the user these \n"
			+ "kinds of questions before stressful situations, particularly \n"
			+ "before tests and interviews.");

		 	
	}
    
    public void repaint(Graphics g){
        
        /*
         * Use
         * void drawString(String str, int x, int y)
         * method to print the string at specified location x and y.
         */
        g.drawString("about", 50, 50);
}
    
    
}

