//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Exploring A Maze
// Files:           StackADT.java MazeRunnerStack.java TestStack.java Maze.java
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

import java.util.EmptyStackException;

/**
 * A stack abstract data type.
 * @author Zhanhe Lyu
 * @version 1.0
 */
public interface StackADT<E> {
	/**
	    * Adds a new item to the top of the stack
	    * @param item the item to be pushed
	    */
	public void push(E item);
	
	/**
	    * Removes the top item from the stack and returns it
	    */
	public E pop() throws EmptyStackException; 
	
	/**
	    * Returns the top item from the stack without removing it
	    */						
	public E peek() throws EmptyStackException;
	
	/**
	    * Returns true if the stack is empty, otherwise returns false
	    * @param other another MazeRunnerNode
	    */ 
	public boolean isEmpty();
}
