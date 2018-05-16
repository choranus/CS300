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

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simulates the functionality of a simple search engine using a Binary Search Tree.
 * @author Zhanhe Lyu
 * @version 1.0
 */
public class SearchEngine {
    
    private WebPageNode root; // root of the BST-based search engine
    
    /**
     * Creates an empty search engine.
     */
    public SearchEngine() {
    		this.root = null;
    }
	
    /**
     * Returns true if the search engine is empty, false otherwise.
     */
	public boolean isEmpty() {
		return root == null;
	}
    
	/**
     * Inserts an instance of WebPageNode with the given id and weblink 
     * into the search engine conforming to the search order property of a BST.
     * Throws an exception if a user tries to insert an entry with a duplicate id.
     */
    public void insert(String id, String webLink) {
    		if (isEmpty())
    			root = new WebPageNode(id, webLink);
    		else
    			insertHelper(root, id, webLink);
    }
	
    /**
     * A recursive helper method of insert.
     */
    private void insertHelper(WebPageNode curr, String id, String webLink) {
    		if (curr.getId().equals(id)) {
			throw new IllegalArgumentException();
		}else if (curr.getId().compareTo(id) > 0) {
			if (curr.getLeftChild() == null) 
				curr.setLeftChild(new WebPageNode(id, webLink));
			else 
				insertHelper(curr.getLeftChild(), id, webLink);
		}else {
			if (curr.getRightChild() == null) 
				curr.setRightChild(new WebPageNode(id, webLink));
			else
				insertHelper(curr.getRightChild(), id, webLink);
		}
    }
    
    /**
     * A look-up method that searches for a webPageNode with the given id 
     * in the current search engine
     * @return the related weblink if that webPageNode is present
     * Otherwise, a Warning message will be returned.
     */
    public String searchWebPage(String id) {
    		return searchWebPageHelper(root, id);
    }
	
    /**
     * A recursive helper method of searchWebPage.
     */
    private String searchWebPageHelper(WebPageNode curr, String id) {
    		if (curr == null) {
    			String result = "No web link found for the web page " + id + ".";
    			return result;
    		}else if (curr.getId().equals(id)) {
    			return curr.getWebLink();
    		}else if (curr.getId().compareTo(id) < 0) {
    			return searchWebPageHelper(curr.getRightChild(), id);
    		}else {
    			return searchWebPageHelper(curr.getLeftChild(), id);
    		}
    }
    
    /**
     * @return the number of webPageNodes stored in the search engine
     */
    public int getWebPageCount() {
    		return getWebPageCountHelper(root);
    }
	
    /**
     * A recursive helper method of getWebPageCount.
     */
    private int getWebPageCountHelper(WebPageNode curr) {
    		if (curr == null)
    			return 0;
		WebPageNode right = curr.getRightChild();
    		WebPageNode left = curr.getLeftChild();
    		int result = 1;
    		if (right != null)
    			result += getWebPageCountHelper(right);
    		if (left != null)
    			result += getWebPageCountHelper(left);
    		return result;
    }
    
    /**
     * @return an ArrayList of String that stores all the id fields of 
     * the webPageNodes present in the current search engine, 
     * sorted in alphabetical order from left to right.
     */
    public ArrayList<String> getAllWebPages() {
    		ArrayList<String> result = new ArrayList<String>();
    		getAllWebPagesHelper(root, result);
    		return result;
    }
	
    /**
     * A recursive helper method of getAllWebPages.
     */
    private void getAllWebPagesHelper(WebPageNode curr, ArrayList<String> as) {
    		if (curr == null)
    			return;
    		getAllWebPagesHelper(curr.getLeftChild(),as);
    		as.add(curr.getId());
    		getAllWebPagesHelper(curr.getRightChild(),as);
    }
    
    /**
     * The main method of SearchEngine.
     * Continuously prompt the user to enter a command and process it.
     * The user enters a ‘q’ command to quit the program.
     */
    public static void main(String[] args) {
    		System.out.println();
    		String prompt = "";
    		prompt += "=========================== Search Engine ============================\n";
    		prompt += "1. Enter 'i <id> <webLink>' to insert a web page in the search engine\n";
    		prompt += "2. Enter 's <id>' to search a web link in the search engine\n";
    		prompt += "3. Enter 'p' to print all the web page ids in the search engine\n";
    		prompt += "4. Enter 'c' to get the count of all web pages in the search engine\n";
    		prompt += "5. Enter 'q' to quit the program\n";
    		prompt += "======================================================================\n";
    		Scanner s = new Scanner(System.in);	// the Scanner that reads the input
    		SearchEngine test = new SearchEngine();	// an object of Search Engine class
    		while (true) {
    			System.out.println(prompt);
    			System.out.print("Please enter your command:");
    			String line = s.nextLine();	// get the command from user
    			String[] cmd = line.split(" ");
    			if ((cmd[0].equals("q") || cmd[0].equals("Q")) && cmd.length == 1) {
    				// quit the program
    				break;
    			}else if((cmd[0].equals("c") || cmd[0].equals("C")) && cmd.length == 1) {
    				// count
    				System.out.println("" + test.getWebPageCount() + "\n");
    			}else if((cmd[0].equals("p") || cmd[0].equals("P")) && cmd.length == 1) {	
    				// get all web pages
    				if (test.isEmpty()) {
    					System.out.print("Search Engine is empty.\n");
    				}else {
    					ArrayList<String> allPage = test.getAllWebPages();
    					for (int i = 0; i < allPage.size()-1; i++) {
    						System.out.print(allPage.get(i) + ", ");
    					}
    					System.out.println(allPage.get(allPage.size()-1) + "\n");
    				}
    			}else if(cmd[0].equals("i") || cmd[0].equals("I")) {
    				// insert
    				if (cmd.length == 3) {
        				try {
        					test.insert(cmd[1], cmd[2]);
        					System.out.println();
        				}catch(IllegalArgumentException e) {
        					System.out.println("WARNING: failed to insert duplicate web page:"+cmd[1]);
        				}
    				}else {
    					System.out.print("WARNING: Invalid syntax for search operation:");
    					System.out.println(" Id link can’t be blank!");
    				}
    			}else if((cmd[0].equals("s") || cmd[0].equals("S")) && cmd.length == 2) {
    				// search
    				System.out.print(cmd[1]+" - ");
    				System.out.println(test.searchWebPage(cmd[1]) + "\n");
    			}else {
    				System.out.println("WARNING: Unrecognized command.\n");
    			}
    		}
    		s.close();
    }
    
}