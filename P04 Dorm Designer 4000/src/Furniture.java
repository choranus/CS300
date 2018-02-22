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
public class Furniture {
	private PApplet processing;
	private PImage image;
	private float[] position;
	private boolean isDragging;
	private int rotations;
	private String type;
	
	// constructor, initializes the fields of a new bed object positioned in the center of the display
	public Furniture(String type,PApplet processing) {
		image = processing.loadImage("images/"+type+".png");
		position = new float[] {processing.width/2,processing.height/2};
		isDragging = false;
		this.processing = processing;
		rotations = 0;
		this.type = type;
	}
	// constructor overwrite
	public Furniture(String type,float x, float y,int rotations,PApplet processing) {
		image = processing.loadImage("images/"+type+".png");
		position = new float[] {x,y};
		isDragging = false;
		this.processing = processing;
		this.rotations = rotations;
		this.type = type;

	}
	//getters
	public PImage getImage() {
		return image;
	}
	public float[] getPosition() {
		return position;
	}
	public boolean getIsDragging() {
		return isDragging;
	}
	public int getRotations() {
		return rotations;
	}
	public String getType() {
		return type;
	}
	// draws this bed at its current position
	public void update() {
		if (isDragging) {
			position[0] = processing.mouseX;
			position[1] = processing.mouseY;
		}
	}
	// used to start dragging the bed, when the mouse is over this bed when it is pressed
	public void mouseDown() {
		if(isMouseOver()) {
			isDragging = true;
		}
	}
	// used to indicate that the bed is no longer being dragged
	public void mouseUp() {
		isDragging = false;
	}
	// helper method to determine whether the mouse is currently over this furniture
	public boolean isMouseOver() {
		if (rotations % 2 == 0) {
			if (processing.mouseX >= (position[0] - image.width/2) && processing.mouseX <= (position[0] + image.width/2) && 
					processing.mouseY >= (position[1] - image.height/2) && processing.mouseY <= (position[1] + image.height/2)) {
				return true;
			}
		}else {
			if (processing.mouseX >= (position[0] - image.height/2) && processing.mouseX <= (position[0] + image.height/2) && 
					processing.mouseY >= (position[1] - image.width/2) && processing.mouseY <= (position[1] + image.width/2)) {
				return true;
			}
		}
		return false;
	}
	// used to increase rotations
	public void rotate() {
		rotations++;
	}
}