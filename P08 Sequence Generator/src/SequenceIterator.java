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

import java.util.Iterator;

/**
 * a class that implements the interface Iterator<Integer> of java.util package 
 * and can iterate over any sequence of numbers
 * @author Zhanhe Lyu
 * @version 1.0
 */
 
public class SequenceIterator implements Iterator<Integer>{
    private NumberGenerator generator; // a NumberGenerator object
    			// that generates and returns a number of index n in a 
    			// sequence of numbers
    
    private int size;  // size of the sequence
    private int index; // index of the next number to be generated in the sequence
    
    /**
     * Constructs a SequenceIterator with given number generator and size
     * This constructs initializes also the index to 0
     * @param generator
     * @param size
     */
    public SequenceIterator(NumberGenerator generator, int size) {
        this.generator = generator;
    		this.size = size;
        this.index = 0;
    }
    
    /**
     * see if the sequence has a next element
     * @return if the sequence has a next element
     */
    @Override
    public boolean hasNext() {
        if (index+1 == size)
        		return false;
        else
        		return true;
    }
    
    /**
     * this method returns the next element in the sequence
     * @param generator
     * @return the next element in the sequence
     */
    @Override
    public Integer next() {
        return new Integer(generator.generateNumber(index++));
    }
 
}