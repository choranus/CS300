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
import java.io.FileNotFoundException;

public class Main {
	private PApplet processing;
	private PImage backgroundImage;
	private Furniture[] furniture;
	private CreateBedButton bedButton;
	private CreateSofaButton sofaButton;
	private SaveButton saveButton;
	private LoadButton loadButton;
	// create the window
	public static void main(String[] args) {
		Utility.startApplication();
	}
	// constructor for the Main class
	public Main(PApplet processing) {
		backgroundImage = processing.loadImage("images/background.png");
		this.processing = processing;
		bedButton = new CreateBedButton(50, 24, processing);
		sofaButton = new CreateSofaButton(150, 24, processing);
		saveButton = new SaveButton(650, 24, processing);
		loadButton = new LoadButton(750, 24, processing);
		furniture = new Furniture [6];
		// set all the positions to null
		for (int i = 0; i < furniture.length; i++) {
			furniture[i] = null;
		}
	}
	// execute repeatedly
	public void update() {
		// draw background and the room
		processing.background(100,150,250);
		processing.image(backgroundImage, processing.width/2, processing.height/2);
		// draw bed button
		if (bedButton.isMouseOver()) {
			processing.fill(100);
		}else {
			processing.fill(200);
		}
		processing.rect(bedButton.getPosition()[0] - bedButton.getWidth()/2, bedButton.getPosition()[1] - bedButton.getHeight()/2,
				bedButton.getPosition()[0] + bedButton.getWidth()/2,bedButton.getPosition()[1] + bedButton.getHeight()/2);
		bedButton.update();
		// draw sofa button
		if (sofaButton.isMouseOver()) {
			processing.fill(100);
		}else {
			processing.fill(200);
		}
		processing.rect(sofaButton.getPosition()[0] - sofaButton.getWidth()/2, sofaButton.getPosition()[1] - sofaButton.getHeight()/2,
				sofaButton.getPosition()[0] + sofaButton.getWidth()/2,sofaButton.getPosition()[1] + sofaButton.getHeight()/2);
		sofaButton.update();
		// draw save button
		if (saveButton.isMouseOver()) {
			processing.fill(100);
		}else {
			processing.fill(200);
		}
		processing.rect(saveButton.getPosition()[0] - saveButton.getWidth()/2, saveButton.getPosition()[1] - saveButton.getHeight()/2,
				saveButton.getPosition()[0] + saveButton.getWidth()/2,saveButton.getPosition()[1] + saveButton.getHeight()/2);
		saveButton.update();
		// draw load button
		if (loadButton.isMouseOver()) {
			processing.fill(100);
		}else {
			processing.fill(200);
		}
		processing.rect(loadButton.getPosition()[0] - loadButton.getWidth()/2, loadButton.getPosition()[1] - loadButton.getHeight()/2,
				loadButton.getPosition()[0] + loadButton.getWidth()/2,loadButton.getPosition()[1] + loadButton.getHeight()/2);
		loadButton.update();
		// draw furniture
		for (int i = 0; i < furniture.length; i++) {
			if (furniture[i] != null) {
				furniture[i].update();
			}
		}
		for (int i = 0; i < furniture.length; i++) {
			if (furniture[i] != null) {
				processing.image(furniture[i].getImage(), furniture[i].getPosition()[0], furniture[i].getPosition()[1], 
						furniture[i].getRotations()*PApplet.PI/2);
			}
		}
		
	}
	// called when mouse is down
	public void mouseDown() throws FileNotFoundException {
		// when save button is pressed
		if (saveButton.isMouseOver()) {
			saveButton.mouseDown(furniture);
			return;
		}
		// when load button is pressed
		if (loadButton.isMouseOver()) {
			loadButton.mouseDown(furniture);
			return;
		}
		// when furniture button is pressed
		for (int i = 0; i <furniture.length; i++) {
			if (furniture[i] == null) {
				if (bedButton.isMouseOver()) {
					furniture[i] = bedButton.mouseDown();
					return;
				}else if (sofaButton.isMouseOver()){
					furniture[i] = sofaButton.mouseDown();
					return;
				}
			}
		}
		// when drag furniture
		for (int i = furniture.length - 1; i >=0; i--) {
			if (furniture[i] != null) {
				furniture[i].mouseDown();
				if (furniture[i].getIsDragging()) {
					return;
				}
			}
		}
	}
	// called when mouse is up
	public void mouseUp() {
		for (int i = 0; i < furniture.length; i++) {
			if (furniture[i] != null) {
				furniture[i].mouseUp();
			}
		}
	}
	// called when press a key
	public void keyPressed() {
		//Remove a bed
		if (processing.key == 'd' || processing.key == 'D') {
			for (int i = furniture.length - 1; i >=0; i--) {
				if (furniture[i] != null) {
					if (furniture[i].isMouseOver()) {
						furniture[i] = null;
						return;
					}
				}
			}
		}
		//Rotate a bed
		if (processing.key == 'r' || processing.key == 'R') {
			for (int i = furniture.length - 1; i >=0; i--) {
				if (furniture[i] != null) {
					if (furniture[i].isMouseOver()) {
						furniture[i].rotate();
						return;
					}
				}
			}
		}		
	}
	
}
