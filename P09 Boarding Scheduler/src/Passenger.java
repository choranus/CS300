//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Boarding Scheduler
// Files:           BoardingHeap.java BoardingScheduler.java Passenger.java
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
 * The Passenger class represents a single passenger, 
 * 	including all information about that passenger. 
 * @author Zhanhe Lyu
 * @version 1.0
 */
public class Passenger implements Comparable<Passenger> {
	private String name;		// name of the passenger
	private int time;			// time a passenger checked in
	private String seat;		// seat number of the passenger
	private int preferredBoarding;	// extra priority
	private int doneTimeEstimate;		// estimated boarding completion time
									// a component of their priority
	private int doneTime;		// actual done time of the passenger
	
    /**
     * Constructor of Passenger.
     * @param name
     * @param time
     * @param seat
     */
    public Passenger(String name, int time, String seat) {
    		this.name = name;
    		this.time = time;
    		this.seat = seat;
    		this.preferredBoarding = 0;
    }
    
    /**
     * Constructor of Passenger.
     * @param name
     * @param time
     * @param seat
     * @param preferredBoarding
     */
    public Passenger(String name, int time, String seat, int preferredBoarding) {
		this.name = name;
		this.time = time;
		this.seat = seat;
		this.preferredBoarding = preferredBoarding;
    }
    
    /**
     * Get "time" field.
     */
    public int getTime() {
    		return time;
    }
    
    /**
     * Get "name" field.
     */
    public String getName() {
    		return name;
    }
    
    /**
     * Get "seat" field.
     */
    public String getSeat() {
    		return seat;
    }
    
    /**
     * Set "doneTime" field.
     */
    public void setDoneTime(int doneTime) {
    		this.doneTime = doneTime;
    }
    
    /**
     * Get "doneTime" field.
     */
    public int getDoneTime() {
    		return this.doneTime;
    }
    
    /**
     * Store a passenger’s estimated boarding completion time.
     * @param estimated boarding completion time
     */
    public void setDoneTimeEstimate(int estimate) {
    		this.doneTimeEstimate = estimate;
    }

    /**
     * Determine whether two passengers should be swapped.
     * Required for implementing Comparable.
     * @param another passenger
     */
    public int compareTo(Passenger otherP) {
    		if (this.preferredBoarding > otherP.preferredBoarding) {
    			return 1;
    		}else if (this.preferredBoarding < otherP.preferredBoarding) {
    			return -1;
    		}else {
    			return otherP.doneTimeEstimate - this.doneTimeEstimate;
    		}
    }
}