import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics. *;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import java.util.Random;


public class Homepage extends Applet implements ActionListener{
	Button randomQuestion;
	Button listQuestion;
	Button about;
	Button tester;
	Button interviewer;
	Button home;
	
	JTextArea text;
	JTextField field;
	
	String[] stringArray;
	String[] generalQuestions = { "Tell us about a secret skill, talent, or passion of yours.",
			"Tell us about a time you surprised yourself or others with one of your accomplishments.",
			"Tell us about the characteristics or values you are most proud of.",
			"What is the last compliment that you received that made you feel good about yourself?",
			"Tell us about something you’re proud of achieving in the last week.",
			"Tell us about someone who is a role model to you.",
			"Tell us something you’re excited to achieve in the next 5 years.",
			"What positive habits have you developed in the past couple years?",
			"What part of your identity makes you unique?",
			"Tell us about a time that you supported a friend and how you felt about their success?",
			"Tell us about a time that you worked very hard towards a goal and achieved it.",
			"Tell us about a time that you did something good and it went unrecognized."};
	String[] interviewQuestions = {"Tell us what you’re most proud to have on your resume.",
			"Tell us why you are interested in the job you are interviewing for.",
			"What impact do you hope to make when you get accepted to the position you’re applying for?",
			"How do you hope the interviewer will describe you after interacting with you in this interview?",
			"What experiences that you have that make you a good fit for this position?",
			"What experiences have you had and learned from that other applicants may have not?",
			"Tell us why you want this job and why you initially applied?",
			"Tell us one aspect of your personality that makes you stand out."};
	String[] testQuestions = {"Tell us about an assignment in that class that you particularly liked or excelled in.",
			"What have you learned by taking this class or studying for this exam?",
			"Do you feel prepared for this exam? If so, how did you prepare? If not, what would you have liked to have done first?",
			"What do you hope to learn by taking this exam?",
			"What are you proud of achieving in this class / subject?",
			"What are your goals for this test?",
			"Tell us about the last time you succeeded on a test. What allowed you to succeed, and how did you feel about it?",
			"Tell us about a time you didn’t do as well on a test. How did you study differently to not make the same mistakes?",
			"Tell us one thing you love about this subject."};

	
    public void init() {
    	//Set title
    	Frame title = (Frame)this.getParent().getParent();
        title.setTitle("Boost");

    	//Set window size and color
    	this.setSize(new Dimension(1200,1200));
    	this.setBackground(Color.WHITE);
    
    	// Create buttons
    	randomQuestion = new Button("Get a Random Question");
        listQuestion = new Button("Choose a Question");
        about = new Button("About Stereotype Threat");
        home = new Button("Home");
        
        //Initialize text box (empty)
        text = new JTextArea("", 30, 70);
        text.setEditable(false);
        field = new JTextField("", 60);
        Color c = new Color (237, 237, 237);
        field.setBackground(c);
        // Add buttons to the home screen
        add(randomQuestion);
        add(listQuestion);
        add(about);
        add(home);
        add(text);
        add(field);

        // Initialize what each thing will do
        randomQuestion.addActionListener(this);
        listQuestion.addActionListener(this);
        about.addActionListener(this);
        home.addActionListener(this);
     
        repaint();
    }
    
    
    
    //Check if button was clicked, react
    public void actionPerformed(ActionEvent e) {
    	
		if (e.getSource() == listQuestion) {
			this.listButtons();
		}
		else if (e.getSource() == randomQuestion) {
			this.randButtons();
		}
		else if (e.getSource() == tester) {
			this.randomTestQuestion();
		}
		else if (e.getSource() == interviewer) {
			this.randomInterviewQuestion();
		}
		else if (e.getSource() == home) {
			Component[] temp = getComponents();
			for(int i = 0; i < temp.length; i++) {
				remove(temp[i]);
			}
			text.setText(null);
			add(randomQuestion);
	        add(listQuestion);
	        add(about);
	        add(home);
	        add(text);
	        add(field);
	        repaint();
		}
		else if (e.getSource() == about) {
			text.setText("    Stereotype threat occurs when a person confirms a \n"
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
		
		//Repaint the 
		repaint();
	}
    
    public void listButtons() {
        remove(randomQuestion);
        remove(listQuestion);
        remove(about);
        remove(text);
        remove(field);
        for(int i = 1; i < 30; i++) {
        	String s = Integer.toString(i);
        	Button temp = new Button(s);
        	add(temp);
        }
        text.setText(null);
        for(int i = 1; i < 13; i++) {
        	text.append(Integer.toString(i) + ": ");
        	text.append(generalQuestions[i - 1] + "\n");
        }
        text.append("\n");
        for(int i = 13; i < 21; i++) {
        	text.append(Integer.toString(i) + ": ");
        	text.append(interviewQuestions[i - 13] + "\n");
        }
        text.append("\n");
        for(int i = 21; i < 30; i++) {
        	text.append(Integer.toString(i) + ": ");
        	text.append(testQuestions[i - 21] + "\n");
        }
        add(text);
        add(field);
        repaint();
    }
    
    public void randButtons() {
    	remove(randomQuestion);
        remove(listQuestion);
        remove(about);
        remove(text);
        remove(field);
        tester = new Button("Test Questions");
        interviewer = new Button("Interview Questions");
        add(tester);
        add(interviewer);
        add(text);
        add(field);
        tester.addActionListener(this);
        interviewer.addActionListener(this);
        repaint();
    }
    
    public void randomTestQuestion(){
    	/*
    	 * returns random question from our array of test questions
    	 */
    	int range = testQuestions.length + generalQuestions.length;
    	
    	Random rand = new Random();


    	int  n = rand.nextInt(range);
    	
    	
    	if (n < testQuestions.length) {
    		text.setText(testQuestions[n]);
    	}
    	else {
    		text.setText(generalQuestions[n- testQuestions.length]);
    	}
    	
    }

    public void randomInterviewQuestion(){
    	/*
    	 * returns random question from our array of interview questions
    	 */
    	int range = interviewQuestions.length + generalQuestions.length;
    	
    	Random rand = new Random();


    	int  n = rand.nextInt(range);
    	
    	if (n < interviewQuestions.length) {
    		text.setText(interviewQuestions[n]);
    	}
    	else {
    		text.setText(generalQuestions[n- interviewQuestions.length]);
    	}
    	
    }

    
}

