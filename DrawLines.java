/////////////////////////////////////////////////////////////////////////////////////////////
//   Name: Chris O'Brien
//   Date: 11/1/2013
//   Purpose: Create GUI where the user inputs coordinates and the program connects those coordinates with lines
//   Inputs: Coordinates
//   Outputs: Drawing of coordinates connected by lines
//////////////////////////////////////////////////////////////////////////////////////////////

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawLines extends JApplet implements ActionListener {
    JLabel lX, lY; // labels for coordinates
	 JButton bAddPoint, bDrawLines; // buttons to perform actions
	 JTextField tX, tY; // fields for coordiantes
	 final int MAX = 20;
	 int coordinatesX[], coordinatesY[], indexX, indexY;
	 
    public void init (){
	 
       Container panel;
       panel = getContentPane();
       panel.setLayout(new FlowLayout());
       lX = new JLabel("X Coordinate");
       panel.add(lX);
       tX = new JTextField (15);
       tX.setText("X");
       panel.add(tX);
       lY = new JLabel ("Y Coordinate");
       panel.add(lY);
       tY = new JTextField (15);
       tY.setText("Y");
       panel.add(tY);
       bAddPoint = new JButton("Add Point");
		 panel.add(bAddPoint);
		 bAddPoint.addActionListener(this);
       bDrawLines = new JButton("Draw Lines");
		 panel.add(bDrawLines);
		 bDrawLines.addActionListener(this);
		 setSize (800,450);
	    coordinatesX = new int[MAX];
	    coordinatesY = new int[MAX];
	    indexX = 0; // initializing
	    indexY = 0; // initializing
		 
    } //end init method
    
    public void actionPerformed (ActionEvent event){
	   int x, y; // coordinates
	   if (event.getSource() == bAddPoint){
         if (Integer.parseInt(tX.getText()) >= 0 && Integer.parseInt(tY.getText()) >= 0){ // validating input
            x = Integer.parseInt(tX.getText()); // parsing x
            y = Integer.parseInt(tY.getText()); // parsing y
            coordinatesX[indexX] = x; // putting X coordinate into array
	 	      indexX++;
            coordinatesY[indexY] = y; // putting Y coordinate into array
	  	      indexY++;
            
         } else {
            System.out.println("ERROR: Inputs must be positive numbers");
            if (Integer.parseInt(tX.getText()) < 0)
               tX.setText("INVALID");
            if (Integer.parseInt(tY.getText()) < 0)
               tY.setText("INVALID");
         } // end input validation
	   } // end bAddPoint if
	   if (event.getSource() == bDrawLines){
	 	   paintIt ();
	   } // end bDrawLines if
    } // end actionPerformed method
    
	 public void paintIt () {
      int count1, count2; // counter for loop and nested loop
	   Graphics painter = getGraphics();
	   painter.setColor (Color.black);
      count1 = 0; // initializing count1
	   while (count1 <= indexX - 1 && count1 <= indexY - 1){
      count2 = 0; // initializing count2
         while (count2 <= indexX - 1 && count2 <= indexY - 1){
	         painter.drawLine (coordinatesX[count1], coordinatesY[count1], coordinatesX[count2], coordinatesY[count2]);
            count2++;
	      } // end nested while
         count1++;
      } // end while
      painter.drawString("Chris O'Brien", 50, 50);
	 } // end paintIt method
    
} //end the class