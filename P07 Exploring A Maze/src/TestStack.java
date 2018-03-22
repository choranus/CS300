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

/**
 * This program runs tests on given stack implementations.
 * @author Zhanhe Lyu
 * @version 1.0
 */
public class TestStack {
	
	/**
	    * Test constructor
	    * see if it is constructible
	    */
	private static boolean testConstructor1() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			return true;
		}catch (Exception e) {
			System.out.println("Failure: MazeRunnerStack is not constructible.");
			return false;
		}
	}
	
	/**
	    * Test constructor
	    * see if no-argument constructor is non-static
	    */
	private static boolean testConstructor2() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			MazeRunnerStack s2 = new MazeRunnerStack();
			s1.push(new Position(2,2));
			s2.push(new Position(1,1));
			if (s1.peek().row != 2 || s1.peek().col != 2) {
				System.out.println("Failure: no-argument constructor should be non-static.");
				return false;
			}else {
				return true;
			}
		}catch (Exception e) {
			System.out.println("Failure: MazeRunnerStack is not constructable.");
			return false;
		}
	}
	
	/**
	    * Test constructor
	    * see if stack is empty when it is constructed
	    */
	private static boolean testConstructor3() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			if (s1.isEmpty()) {
				return true;
			}else {
				System.out.println("Failure: MazeRunnerStack should be empty when it is constructed.");
				return false;
			}
		}catch (Exception e) {
			System.out.println("Failure: MazeRunnerStack is not constructible or isEmpty cause exception.");
			return false;
		}
	}
	
	/**
	    * Test push method
	    * see if throw EmptyStackException when push a null item
	    */
	private static boolean testPush1() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			s1.push(null);
			System.out.println("Failure: push a null item to stack. Expected IllegalArgumentException. Got no exception.");
			return false;
		}catch (Exception e) {
			return true;
		}
	}
	
	/**
	    * Test push method
	    */
	private static boolean testPush2() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			s1.push(new Position(0,0));
			s1.push(new Position(1,1));
			s1.push(new Position(2,2));
			if (s1.peek().row != 2 || s1.peek().col != 2) {
				System.out.println("Failure: push a Positions (0,0), (1,1), (2,2) to stack then peek(). Expected Position(2,2). Got Position(" + s1.peek().row + "," + s1.peek().col + ").");
				return false;
			}else {
				return true;
			}
		}catch (Exception e) {
			System.out.println("Failure: constructor or push or peek method cause exception.");
			return false;
		}
	}
	
	/**
	    * Test pop method
	    * see is there a EmptyStackException when pop from an empty stack
	    */
	private static boolean testPop1() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			Position p = s1.pop();
			System.out.println("Failure: pop from an empty stack. Expected EmptyStackException. Got Position(" + p.row + "," + p.col + ").");
			return false;
		}catch (Exception e) {
			return true;
		}
	}
	
	/**
	    * Test pop method
	    */
	private static boolean testPop2() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			s1.push(new Position(1,1));
			s1.push(new Position(2,2));
			s1.push(new Position(3,3));
			Position p = s1.pop();
			if (p.row != 3 || p.col != 3) {
				System.out.println("Failure: push Positions (1,1), (2,2), (3,3) to stack then pop(). Expected Position(1,1). Got Position(" + p.row + "," + p.col + ").");
				return false;
			}else {
				return true;
			}
		}catch (Exception e) {
			System.out.println("Failure: constructor or push or pop method cause exception.");
			return false;
		}
	}
	
	/**
	    * Test push method
	    * see is there a EmptyStackException when peep an empty stack
	    */
	private static boolean testPeek1() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			Position p = s1.peek();
			System.out.println("Failure: peek an empty stack. Expected EmptyStackException. Got Position(" + p.row + "," + p.col + ").");
			return false;
		}catch (Exception e) {
			return true;
		}
	}
	
	/**
	    * Test peek method
	    */
	private static boolean testPeek2() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			s1.push(new Position(1,1));
			s1.push(new Position(2,2));
			s1.push(new Position(3,3));
			Position p = s1.peek();
			if (p.row != 3 || p.col != 3) {
				System.out.println("Failure: push Positions (1,1), (2,2), (3,3) to stack then peek(). Expected Position(3,3). Got Position(" + p.row + "," + p.col + ").");
				return false;
			}else {
				return true;
			}
		}catch (Exception e) {
			System.out.println("Failure: constructor or push or peek method cause exception.");
			return false;
		}
	}
	
	/**
	    * Test isEmpty method
	    */
	private static boolean testIsEmpty1() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			if (s1.isEmpty()) {
				return true;
			}else {
				System.out.println("Failure: run isEmpty() on an empty stack. Expected true. Got false.");
				return false;
			}
		}catch (Exception e) {
			System.out.println("Failure: constructor or isEmpty method cause exception.");
			return false;
		}
	}
	
	/**
	    * Test isEmpty method
	    */
	private static boolean testIsEmpty2() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			s1.push(new Position(1,1));
			if (!s1.isEmpty()) {
				return true;
			}else {
				System.out.println("Failure: run isEmpty() on an empty stack. Expected true. Got false.");
				return false;
			}
		}catch (Exception e) {
			System.out.println("Failure: constructor or push or isEmpty method cause exception.");
			return false;
		}		
	}
	
	/**
	    * Test contains method
	    */
	private static boolean testContains1() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			s1.push(new Position(1,1));
			s1.push(new Position(2,2));
			s1.push(new Position(3,3));
			if (!s1.contains(new Position(2,2))) {
				System.out.println("Failure: push Positions (1,1), (2,2), (3,3) to stack then run contains(Position(2,2)). Expected true. Got false.");
				return false;
			}else {
				return true;
			}
		}catch (Exception e) {
			System.out.println("Failure: constructor or push or contains method cause exception.");
			return false;
		}
	}
	
	/**
	    * Test if stack can contain more than 100 items
	    */
	private static boolean test100Items() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			for (int i = 0; i < 100; i++){
				s1.push(new Position(1,1));
			}
			s1.push(new Position(2,2));
			if (s1.peek().row != 2 || s1.peek().col != 2) {
				System.out.println("Failure: the stack cannot contain more than 100 items.");
				return false;
			}else {
				return true;
			}
		}catch (Exception e) {
			System.out.println("Failure: the stack cannot contain more than 100 items.");
			return false;
		}
	}
	
	/**
	    * Test contains method
	    */
	private static boolean testContains2() {
		try {
			MazeRunnerStack s1 = new MazeRunnerStack();
			s1.push(new Position(1,1));
			s1.push(new Position(2,2));
			s1.push(new Position(3,3));
			if (s1.contains(new Position(2,1))) {
				System.out.println("Failure: push Positions (1,1), (2,2), (3,3) to stack then run contains(Position(2,1)). Expected false. Got true.");
				return false;
			}else {
				return true;
			}
		}catch (Exception e) {
			System.out.println("Failure: constructor or push or contains method cause exception.");
			return false;
		}
	}
	
	/**
	    * Tests on stack implementation to verify if it works as expected
	    * Return false if any test fail.
	    */
	public static boolean runTests() {
		boolean result = true;
		if (!testConstructor1()) {
			result = false;
		}
		if (!testConstructor2()) {
			result = false;
		}
		if (!testConstructor3()) {
			result = false;
		}
		if (!testPush1()) {
			result = false;
		}
		if (!testPush2()) {
			result = false;
		}
		if (!testPop1()) {
			result = false;
		}
		if (!testPop2()) {
			result = false;
		}
		if (!testPeek1()) {
			result = false;
		}
		if (!testPeek2()) {
			result = false;
		}
		if (!testIsEmpty1()) {
			result = false;
		}
		if (!testIsEmpty2()) {
			result = false;
		}
		if (!testContains1()) {
			result = false;
		}
		if (!testContains2()) {
			result = false;
		}
		if (!test100Items()) {
			result = false;
		}
		if (result)
			System.out.println("No error found.");
		
		return result;
	}
	
	/**
	    * Main method
	    * Run runTest()
	    */
	public static void main(String[] args) {
		runTests(); 
	}
}
