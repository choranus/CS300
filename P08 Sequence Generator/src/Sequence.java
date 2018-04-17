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
 * a class that represents any sequence of integer numbers
 * @author Zhanhe Lyu
 * @version 1.0
 */
 
public class Sequence implements Iterable<Integer>{
    private NumberGenerator generator; // a NumberGenerator object
			// that generates and returns a number of index n in a 
			// sequence of numbers
    private int size; // Number of items in the sequence
    
    /**
     * Creates a Sequence of Integers with a given instance of
     * NumberGenerator and a given size
     * @param generator
     * @param size
     * @throws IllegalArgumentException if size is negative
     */
    public Sequence(NumberGenerator generator, int size) throws IllegalArgumentException{
    		if (size < 0)
    			throw new IllegalArgumentException();
    		this.generator = generator;
    		this.size = size;
    }

    /**
     * this method returns an iterator of the sequence
     * @return an iterator of the sequence
     */
    @Override
    public Iterator<Integer> iterator() {
        return new SequenceIterator(generator, size);
    }
    
    /**
     * overrides the toString method of java.lang.Object
     * The different numbers of the sequence would be separated by a single space
     * @return a String representation of the sequence
     */   
    @Override
    public String toString(){
    		String result = "";
    		Iterator<Integer> i = iterator();
    		result += generator.generateNumber(0);
		result += " ";
    		while(i.hasNext()) {
    			result += i.next();
    			result += " ";
    		}
        return result;
    }
    
    /**
     * the main function of class
     * @param args
     */
    public static void main(String[] args) {
	    	System.out.println("****************************************");
	    	System.out.println("           Sequence Generator");
	    	System.out.println("****************************************");
	    	         
	    	System.out.println("==========Arithmetic Sequence==========");
	    	Sequence sequence = new Sequence(new ArithmeticNumberGenerator(2,2),4);
	    	System.out.println(sequence.toString());
	    	         
	    	System.out.println("==========Geometric Sequence==========");
	    	sequence = new Sequence(new GeometricNumberGenerator(2,2),10);
	    	System.out.println(sequence.toString());
	    	         
	    	System.out.println("==========Fibonacci Sequence==========");
	    	sequence = new Sequence(new FibonacciNumberGenerator(),20);
	    	System.out.println(sequence.toString());
	    	Sequence s = new Sequence(new ArithmeticNumberGenerator(3,3),4);
    }
    
}