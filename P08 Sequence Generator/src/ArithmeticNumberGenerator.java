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
 * generates and returns the number of order n in an Arithmetic sequence
 * @author Zhanhe Lyu
 * @version 1.0
 */
 
public class ArithmeticNumberGenerator implements NumberGenerator {
    private final int init; // first term in the sequence
    private final int diff; // common difference
    
    /**
     * Constructs an arithmetic number generator with given
     * start value init and common difference diff
     * @param init start value
     * @param diff common difference
     * @throws IllegalArgumentException if any of the input arguments
     * is illegal
     */
    public ArithmeticNumberGenerator(int init, int diff) throws IllegalArgumentException{
    		if (init < 0 || diff < 0) {
    			throw new IllegalArgumentException();
    		}
    		this.init = init;
    		this.diff = diff;
    }
    

    /**
	 * generates the number of index n in an arithmetic sequence recursively
	 * @param n order of the generated number in the sequence
	 * @return the nth number in the sequence
	 */
    @Override
    public int generateNumber(int n) {
		// Time Complexity: O(N)
 
	    	if (n == 0) {
	    		return init;
	    }else {
	    		n--;
	    		return diff + generateNumber(n);
	    }
    }
    
}