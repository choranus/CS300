//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Sequence Generator
// Files:           ArithmeticNumberGenerator.java FibonacciNumberGenerator.java 
//				    GeometricNumberGenerator.java NumberGenerator.java Sequence.java 
//                  Sequence.java SequenceIterator.java
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
 * an interface for NumberGenerator classes
 * @author Zhanhe Lyu
 * @version 1.0
 */

public interface NumberGenerator {
	
	/**
	 * generates and returns the number of order n in a sequence of numbers
	 * @param n order of the generated number in the sequence
	 * @return the nth number in the sequence
	 */
    public int generateNumber(int n);
}