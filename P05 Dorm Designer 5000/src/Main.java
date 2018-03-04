//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Dorm Designer 5000
// Files:           CreateFurnitureButton.java, Furniture.java, LoadButton.java, Main.java, SaveButton.java, DormGUI.java, ClearButton.java, Button.java
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
import java.util.ArrayList;

public class Main{
	private PApplet processing;
	private PImage backgroundImage;
	private ArrayList<DormGUI> guiObjects;
    // Max number of furniture that LoadButton will be allowed to load at once.    
	private final static int MAX_LOAD_FURNITURE = 100;        
	/**
	 * This method creates a new Furniture[] for the old mouseDown() methods
	 * to make use of.  It does so by copying all Furniture references from
	 * this.guiObjects into a temporary array of size MAX_LOAD_FURNITURE.
	 * @return that array of Furniture references.
	 */
	private Furniture[] extractFurnitureFromGUIObjects() {
	    Furniture[] furniture = new Furniture[MAX_LOAD_FURNITURE];
	    int nextFreeIndex = 0;
	    for(int i=0;i<guiObjects.size() && nextFreeIndex < furniture.length;i++)
	        if(guiObjects.get(i) instanceof Furniture)
	            furniture[nextFreeIndex++] = (Furniture)guiObjects.get(i);        
	    return furniture;        
	}    
	/**
	 * This method first removes all Furniture references from this.guiObjects,
	 * and then adds back in all of the non-null references from it's parameter.
	 * @param furniture contains the only furniture that will be left in 
	 *   this.guiObjects after this method is invoked (null references ignored).
	 */
	private void replaceFurnitureInGUIObjects(Furniture[] furniture) {
	    for(int i=0;i<guiObjects.size();i++)
	        if(guiObjects.get(i) instanceof Furniture)
	            guiObjects.remove(i--);
	    for(int i=0;i<furniture.length;i++)
	        if(furniture[i] != null)
	            guiObjects.add(furniture[i]);
	}
	// create the window
	public static void main(String[] args) {
		Utility.startApplication();
	}
	// constructor of the Main class
	public Main(PApplet processing) {
		backgroundImage = processing.loadImage("images/background.png");
		this.processing = processing;
		ArrayList<DormGUI> guiList = new ArrayList<DormGUI>();
		guiList.add(new CreateFurnitureButton("bed",50, 24, processing));
		guiList.add(new CreateFurnitureButton("sofa",150, 24, processing));
		guiList.add(new CreateFurnitureButton("dresser",250, 24, processing));
		guiList.add(new CreateFurnitureButton("desk",350, 24, processing));
		guiList.add(new CreateFurnitureButton("sink",450, 24, processing));
		guiList.add(new SaveButton(650, 24, processing));
		guiList.add(new LoadButton(750, 24, processing));
		guiList.add(new ClearButton(550, 24, processing));
		guiObjects = guiList;
	}
	// execute repeatedly
	public void update() {
		// draw background and the room
		processing.background(100,150,250);
		processing.image(backgroundImage, processing.width/2, processing.height/2);
		// draw createFurniture button
		for(int i = 0; i < 5; i++) {
			CreateFurnitureButton furnitureButton = (CreateFurnitureButton) guiObjects.get(i);
			if (furnitureButton.isMouseOver()) {
				processing.fill(100);
			}else {
				processing.fill(200);
			}
			processing.rect(furnitureButton.getPosition()[0] - furnitureButton.getWidth()/2, furnitureButton.getPosition()[1] - furnitureButton.getHeight()/2,
					furnitureButton.getPosition()[0] + furnitureButton.getWidth()/2,furnitureButton.getPosition()[1] + furnitureButton.getHeight()/2);
			furnitureButton.update();
		}
		// draw save button
		SaveButton saveButton = (SaveButton) guiObjects.get(5);
		if (saveButton.isMouseOver()) {
			processing.fill(100);
		}else {
			processing.fill(200);
		}
		processing.rect(saveButton.getPosition()[0] - saveButton.getWidth()/2, saveButton.getPosition()[1] - saveButton.getHeight()/2,
				saveButton.getPosition()[0] + saveButton.getWidth()/2,saveButton.getPosition()[1] + saveButton.getHeight()/2);
		saveButton.update();
		// draw load button
		LoadButton loadButton = (LoadButton) guiObjects.get(6);
		if (loadButton.isMouseOver()) {
			processing.fill(100);
		}else {
			processing.fill(200);
		}
		processing.rect(loadButton.getPosition()[0] - loadButton.getWidth()/2, loadButton.getPosition()[1] - loadButton.getHeight()/2,
				loadButton.getPosition()[0] + loadButton.getWidth()/2,loadButton.getPosition()[1] + loadButton.getHeight()/2);
		loadButton.update();
		// draw clear button
		ClearButton clearButton = (ClearButton) guiObjects.get(7);
		if (clearButton.isMouseOver()) {
			processing.fill(100);
		}else {
			processing.fill(200);
		}
		processing.rect(clearButton.getPosition()[0] - clearButton.getWidth()/2, clearButton.getPosition()[1] - clearButton.getHeight()/2,
				clearButton.getPosition()[0] + clearButton.getWidth()/2,clearButton.getPosition()[1] + clearButton.getHeight()/2);
		clearButton.update();
		// draw furniture
		Furniture[] furniture = extractFurnitureFromGUIObjects();
		for (int i = 0; i < furniture.length; i++) {
			if (furniture[i] != null) {
				furniture[i].update();
			}
		}
		replaceFurnitureInGUIObjects(furniture);
		for (int i = 0; i < furniture.length; i++) {
			if (furniture[i] != null) {
				processing.image(furniture[i].getImage(), furniture[i].getPosition()[0], furniture[i].getPosition()[1], 
						furniture[i].getRotations()*PApplet.PI/2);
			}
		}
		
	}
	// called when mouse is down
	public void mouseDown() throws FileNotFoundException {
		SaveButton saveButton = (SaveButton) guiObjects.get(5);
		LoadButton loadButton = (LoadButton) guiObjects.get(6);
		ClearButton clearButton = (ClearButton) guiObjects.get(7);
		Furniture[] furniture = extractFurnitureFromGUIObjects();
		for(int i = 0; i < 5; i++) {
			CreateFurnitureButton furnitureButton = (CreateFurnitureButton) guiObjects.get(i);
			if (furnitureButton.isMouseOver()) {
				furnitureButton.mouseDown(furniture);
			}
		}
		// when save button is pressed
		if (saveButton.isMouseOver()) {
			saveButton.mouseDown(furniture);
		}
		// when load button is pressed
		if (loadButton.isMouseOver()) {
			loadButton.mouseDown(furniture);
		}
		// when clear button is pressed
		if (clearButton.isMouseOver()) {
			clearButton.mouseDown(furniture);
		}
		// when drag furniture
		for (int i = furniture.length - 1; i >=0; i--) {
			if (furniture[i] != null) {
				furniture[i].mouseDown(furniture);
				if (furniture[i].getIsDragging()) {
					break;
				}
			}
		}
		replaceFurnitureInGUIObjects(furniture);
	}
	// called when mouse is up
	public void mouseUp() {
		Furniture[] furniture = extractFurnitureFromGUIObjects();
		for (int i = 0; i < furniture.length; i++) {
			if (furniture[i] != null) {
				furniture[i].mouseUp();
			}
		}
		replaceFurnitureInGUIObjects(furniture);
	}
	// called when press a key
	public void keyPressed() {
		Furniture[] furniture = extractFurnitureFromGUIObjects();
		//Remove a bed
		if (processing.key == 'd' || processing.key == 'D') {
			for (int i = furniture.length - 1; i >=0; i--) {
				if (furniture[i] != null) {
					if (furniture[i].isMouseOver()) {
						furniture[i] = null;
						break;
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
						break;
					}
				}
			}
		}
		replaceFurnitureInGUIObjects(furniture);
	}
	
}
