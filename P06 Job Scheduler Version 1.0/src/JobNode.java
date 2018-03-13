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

public class JobNode {
		
	// Class Fields
	private static int jobCount = 0; // number of jobs already created
	
	// Object Fields
	private int jobId; 			// unique job identifier
	private float arrivalTime;  // arrival time in seconds
	private int userId;			// identifier of the user that created the job
	private int priority; 		// job priority
	private int timeToLive; 	// job Time To Live in seconds
	private String description; // job description
	
	private JobNode next; // reference to the next job in the linked list
	
	// Constructor using fields
	/**
	 * Constructor of JobNode
	 * @param arrivalTime
	 * @param userId
	 * @param priority
	 * @param ttl
	 * @param description
	 */
	public JobNode(float arrivalTime, int userId, int priority, 
			int ttl, String description) {
		jobCount++;
		jobId = jobCount;
		this.arrivalTime = arrivalTime;
		this.userId = userId;
		this.priority = priority;
		this.timeToLive = ttl;
		this.description = description;
		
	}
	
	// overload other constructors
	public JobNode(JobNode n) {
		jobId = n.getJobId();
		this.arrivalTime = n.getArrivalTime();
		this.userId = n.getUserId();
		this.priority = n.getPriority();
		this.timeToLive = n.getTimeToLive();
		this.description = n.getDescription();
	}
	
	// getters and setters
	public static int getJobCount() {
		return jobCount;
	}
	public int getJobId() {
		return jobId;
	}
	public float getArrivalTime() {
		return arrivalTime;
	}
	public int getUserId() {
		return userId;
	}
	public int getPriority() {
		return priority;
	}
	public int getTimeToLive() {
		return timeToLive;
	}
	public String getDescription() {
		return description;
	}
	public JobNode getNext() {
		return next;
	}
	public static void setJobCount(int jobcount) {
		jobCount = jobcount;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public void setArrivalTime(float arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public void setTimeToLive(int timeToLive) {
		this.timeToLive = timeToLive;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setNext(JobNode next) {
		this.next = next;
	}
	
	/**
	 * This method returns a new reference to a copy of the current JobNode
	 * @return a new reference to a copy of this (instanceof JobNode)
	 */
	public JobNode copy() {
		return new JobNode(this);
	}
}