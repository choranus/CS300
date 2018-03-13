//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Job Scheduler Version 1.0
// Files:           WaitingListADT.java JobNode.java JobLList.java JobScheduler.java
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
 * @author Zhanhe Lyu
 * @version 1.0
 */

public interface WaitingListADT<T> {
	public void schedule(T newObject); // adds an item of type <T> to the waiting list
	   								  // according to a specific scheduling policy
		   
	public boolean isEmpty(); // checks if the waiting list is empty
							 // returns true if the waiting list empty
							 // false otherwise	
	
	public int size(); // returns the number of items in the waiting list
	
	public int clean(float cleaningTime); // removes the obsolete items from the waiting list
	
	public void clear(); // removes all the items in the waiting list
	
	public WaitingListADT<T> duplicate(); // returns a new reference to a duplicate copy of the list
}
