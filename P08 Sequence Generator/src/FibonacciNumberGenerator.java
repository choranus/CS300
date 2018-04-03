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
 * a class that can generate Fibonacci Sequence
 * @author Zhanhe Lyu
 * @version 1.0
 */
 
public class FibonacciNumberGenerator implements NumberGenerator {
	
    /**
	 * generates the number of index n in a fibonacci sequence
	 * @param n order of the generated number in the sequence
	 * @return the nth number in the sequence
	 */
	
	@Override
	public int generateNumber(int n) {
		// Time complexity: O(N)
		
		if (n == 0) {
			return 0;
		}else if (n == 1) {
			return 1;
		}else {
			int fst = 0;
			int sec = 1;
			int result = 0;
			
			for (int i = 0; i < n-1; i++) {
				result = fst + sec;
				fst = sec;
				sec = result;
			}
			return result;
		}
	}
}