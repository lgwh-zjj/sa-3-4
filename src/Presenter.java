import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Presenter extends JApplet{
	JPanel buttonPanel = new JPanel(); 
	JButton stepButton = new JButton("Step"); 

	 Model model = new Model();  
	 View view = new View(this); 
	 public  int BALL_SIZE = 0;  
	 public  int xPosition = 0;  
	 public  int yPosition = 0;  
	 
	 public Presenter() {
		 BALL_SIZE=model.BALL_SIZE;
		 xPosition=model.xPosition;
		 yPosition=model.yPosition;
	 }

	 public void init() { 
		 setLayout(new BorderLayout());      
		 buttonPanel.add(stepButton);      
		 this.add(BorderLayout.SOUTH, buttonPanel);      
		 this.add(BorderLayout.CENTER, view);
		 stepButton.addActionListener(new ActionListener() {           
			 public void actionPerformed(ActionEvent event) {   
				 model.makeOneStep();   
				 BALL_SIZE=model.BALL_SIZE;
				 xPosition=model.xPosition;
				 yPosition=model.yPosition;
				 }});   
		 model.addObserver(view);
		 }
	 
	 public void start() {          
		 model.xLimit = view.getSize().width - model.BALL_SIZE;          
		 model.yLimit = view.getSize().height - model.BALL_SIZE;          
		 repaint();   
		 }
	 }