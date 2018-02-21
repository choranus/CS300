//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Dorm Designer 4000
// Files:           CreateBedButton.java, CreateSofaButton.java, Furniture.java, LoadButton.java, Main.java, SaveButton.java
// Course:          CS 300, Spring 2018
//
// Author:          Zhanhe Lyu
// Email:           zlyu8@wisc.edu
// Lecturer's Name: Alexi Brooks
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    NA
// Partner Email:   NA
// Lecturer's Name: NA
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class LoadButton {
	private static final int WIDTH = 96;
	private static final int HEIGHT = 32;
	 
	private PApplet processing;
	private float[] position;
	private String label;
	 
	public LoadButton(float x, float y, PApplet processing) {
		this.processing = processing;
		position = new float[] {x,y};
		label = "Load Room";
	}
	// getters
	public float[] getPosition() {
		return position;
	}
	public int getWidth() {
		return WIDTH;
	}
	public int getHeight() {
		return HEIGHT;
	}
	public String getLabel() {
		return label;
	}
	// show the label
	public void update() {
		processing.fill(0);
		processing.text(label, position[0], position[1]);
	}
	// load furniture from file
	public void mouseDown(Furniture[] furniture) {
		for (int i = 0; i< furniture.length; i++)
			furniture[i] = null;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			File inFile = new File("RoomData.ddd");
		    Scanner s = new Scanner(inFile);
		    while(s.hasNextLine()){
		    	  String ss = s.nextLine();
		    	  lines.add(ss);
		    }
		    
		    s.close();
		}catch(FileNotFoundException e) {
			System.out.println("WARNING: Could not load room contents from file RoomData.ddd.");
		}
		for (String line : lines) {
			String original = line;
			String p1 = null;
			float p2, p3;
			int p4;
			// to see if each line is incorrectly formatted
			try {
			 	line = line.replaceAll("\\s+","");
			  	p1 = line.split(":")[0];
			  	String[] nums = line.split(":")[1].split(",");
			  	p2 = Float.parseFloat(nums[0]);
			  	p3 = Float.parseFloat(nums[1]);
			  	p4 = Integer.parseInt(nums[2]);  
			}catch(Exception e) {
			    System.out.println("WARNING: Found incorrectly formatted line in file: " + original);
				continue;
			}
			// to see if we can find the image corresponding to the name of furniture
			try {
				File inFile = new File("images/"+p1+".png");
				if (inFile.isFile() == false) {
					throw new Exception();
				}
			}catch(Exception e) {
				System.out.println("WARNING: Could not find an image for a furniture object of type: " + p1);
				continue;	 
			}
			// to see if the furniture array is full
			try {
				boolean ifNotFull = false;
				for(int i = 0; i<furniture.length;i++) {
					if(furniture[i] == null) {
						ifNotFull = true;
						break;
					}
				 }
				if (!ifNotFull) {
					throw new Exception();
				}
			}catch(Exception e) {
				System.out.println("WARNING: Unable to load more furniture.");
			}
	  		for (int i = 0; i<furniture.length; i++) {
		  		if (furniture[i] == null) {
		  			furniture[i] = new Furniture(p1,p2,p3,p4,processing);
		  			break;
		  		}
	  	 	}
		}
	}
	// helper method to determine whether the mouse is currently over this button
	public boolean isMouseOver() {
		if (processing.mouseX >= (position[0] - WIDTH/2) && processing.mouseX <= (position[0] + WIDTH/2) 
				&& processing.mouseY >= (position[1] - HEIGHT/2) && processing.mouseY <= (position[1] + HEIGHT/2)) {
			return true;
		}else {
			return false;
		}
	}
}
