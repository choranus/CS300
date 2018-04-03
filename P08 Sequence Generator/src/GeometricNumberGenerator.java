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
 * generates and returns the number of order n in a Geometric sequence
 * @author Zhanhe Lyu
 * @version 1.0
 */

public class GeometricNumberGenerator implements NumberGenerator {
    private final int init;  // The first term in the sequence
    private final int ratio; // The common ratio
    
    /**
     * Constructs a geometric number generator with given
     * start value init and common ratio ratio
     * @param init start value
     * @param diff common difference
     * @throws IllegalArgumentException if any of the input arguments
     * is illegal
     */
    public GeometricNumberGenerator(int init, int ratio) throws IllegalArgumentException{
    		if (init <= 0 || ratio <= 0) {
			throw new IllegalArgumentException();
		}
    		this.init = init;
    		this.ratio = ratio;
    }
    
    /**
	 * generates the number of index n in a geometric sequence recursively
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
        		return ratio * generateNumber(n);
        }
    }
    
}