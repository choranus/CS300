//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Search Engine
// Files:           WebPageNode.java, SearchEngine.java
// Course:          CS 300, Spring 2018
//
// Author:          Zhanhe Lyu
// Email:           zlyu8@wisc.edu
// Lecturer's Name: Alexi Brooks
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

/**
 * Represent the  web pages for your search engine.
 * @author Zhanhe Lyu
 * @version 1.0
 */
public class WebPageNode{
 
    private final String id; 	    // The id of the web page
	private final String webLink;   // The web link of the web page
    private WebPageNode leftChild;  // The leftChild of the current WebPageNode
    private WebPageNode rightChild; // The rightChild of the current WebPageNode
    
    /**
     * The only constructor of WebPageNode.
     */
    public WebPageNode(String id, String webLink) {
    		this.id = id;
    		this.webLink = webLink;
    		this.leftChild = null;
    		this.rightChild = null;
    }
    
    /**
     * Get leftChild field.
     */
	public WebPageNode getLeftChild() {
		return this.leftChild;
	}
	
	/**
     * Set leftChild field.
     */
	public void setLeftChild(WebPageNode leftChild) {
		this.leftChild = leftChild;
	}
	
	/**
     * Get rightChild field.
     */
	public WebPageNode getRightChild() {
		return this.rightChild;
	}
	
	/**
     * Set rightChild field.
     */
	public void setRightChild(WebPageNode rightChild) {
		this.rightChild = rightChild;
	}
	
	/**
     * Get id field.
     */
	public String getId() {
		return this.id;
	}
	
	/**
     * Get webLink field.
     */
	public String getWebLink() {
		return this.webLink;
	}	
}