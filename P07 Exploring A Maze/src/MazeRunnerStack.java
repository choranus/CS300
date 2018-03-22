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
 * A helper class to help implement MazeRunnerStack.
 * @author Zhanhe Lyu
 * @version 1.0
 */
class Position {
	/**
	    * The column portion of the Position
	    */
	int col;	
	
	/**
	    * The row portion of the Position
	    */
	int row;	
	
	/**
	    * Constructor initializing row and columns to Position
	    * @param row row portion of Position
	    * @param col col portion of Position
	    */
	Position(int row, int col) {
		this.col = col;
		this.row = row;
	}
	
	/**
	    * Compares itself with another Position
	    * @param other another Position
	    */
	boolean equals(Position other) {
		return this.col==other.col && this.row==other.row;
	}
}

/**
 * A helper class that add features to Position.
 * @author Zhanhe Lyu
 * @version 1.0
 */
class MazeRunnerNode {
	/**
	    * The column portion of the MazeRunnerNode
	    */
	int col;	
	
	/**
	    * The row portion of the MazeRunnerNode
	    */
	int row;	
	
	/**
	    * point to the next node
	    */
	MazeRunnerNode next;	
	
	/**
	    * Constructor initializing Position to MazeRunnerNode
	    * @param p position
	    */
	MazeRunnerNode(Position p){
		this.col = p.col;
		this.row = p.row;
		this.next = null;
	}
	
	/**
	    * Compares itself with another MazeRunnerNode
	    * @param other another MazeRunnerNode
	    */
	boolean equals(MazeRunnerNode other) {
		return this.col==other.col && this.row==other.row;
	}
}

/**
 * A class implements StackADT<Position>.
 * A stack contains Positions.
 * @author Zhanhe Lyu
 * @version 1.0
 */
public class MazeRunnerStack implements StackADT<Position>{
	/**
	    * point to head node
	    */
	private MazeRunnerNode head;	
	
	/**
	    * point to tail node
	    */
	private MazeRunnerNode tail;	
	
	/**
	    * size of the linked list
	    */
	private int size;
	
	/**
	    * Push an item to stack
	    * @param item the item to be pushed
	    */
	@Override
	public void push(Position item) {
		if (item == null)
			throw new IllegalArgumentException();
		MazeRunnerNode newNode = new MazeRunnerNode(item);
		if (size == 0) {
			head = newNode;
			tail = newNode;
			size++;
		}else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
		
	}

	/**
	    * Pop the last item out of stack
	    */
	@Override
	public Position pop() throws EmptyStackException {
		if (size == 0) {
			throw new EmptyStackException();
		}else if (size == 1) {
			int c = head.col;
			int r = head.row;
			head = null;
			tail = null;
			size = 0;
			return new Position(r,c);
		}else {
			int c = tail.col;
			int r = tail.row;
			MazeRunnerNode curr = head;
			while (curr.next.next != null) {
				curr = curr.next;
			}
			tail = curr;
			curr.next = null;
			size--;
			return new Position(r,c);
		}
	}

	/**
	    * Return the last item in stack
	    */
	@Override
	public Position peek() throws EmptyStackException {
		if (size == 0)
			throw new EmptyStackException();
		return new Position(tail.row,tail.col);
	}

	/**
	    * To see if the stack is empty
	    * @param other another MazeRunnerNode
	    */
	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}
	
	/**
	    * Push item 
	    * @param other another MazeRunnerNode
	    */
	public boolean contains(Position p) {
		//Reports whether the Position p can be found within the stack
		MazeRunnerNode curr = head;
		while (curr.next != null) {
			if (curr.col == p.col && curr.row == p.row)
				return true;
			curr = curr.next;
		}
		if (tail.col == p.col && tail.row == p.row)
			return true;
		return false;
	}

}
