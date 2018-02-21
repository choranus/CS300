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
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class SaveButton {
	private static final int WIDTH = 96;
	private static final int HEIGHT = 32;
	 
	private PApplet processing;
	private float[] position;
	private String label;
	 
	public SaveButton(float x, float y, PApplet processing) {
		this.processing = processing;
		position = new float[] {x,y};
		label = "Save Room";
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
	public void update() {
		processing.fill(0);
		processing.text(label, position[0], position[1]);
	}
	
	public void mouseDown(Furniture[] furniture){
		try {
			File outFile = new File("RoomData.ddd");
			PrintWriter pw = new PrintWriter(outFile);
			for (Furniture f : furniture) {
				if (f != null) {
					pw.println(f.getType() + ":" + f.getPosition()[0] + "," + f.getPosition()[1] + "," + f.getRotations());
				}
			}
			pw.close();			
		} catch (FileNotFoundException e) {
          	System.out.println("WARNING: Could not save room contents to file RoomData.ddd.");
		}
	}
	// helper method to determine whether the mouse is currently over this furniture
	public boolean isMouseOver() {
		if (processing.mouseX >= (position[0] - WIDTH/2) && processing.mouseX <= (position[0] + WIDTH/2) && 
				processing.mouseY >= (position[1] - HEIGHT/2) && processing.mouseY <= (position[1] + HEIGHT/2)) {
			return true;
		}else {
			return false;
		}
	}
}
