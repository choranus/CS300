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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Boarding Scheduler
 * @author Zhanhe Lyu
 * @version 1.0
 */
public class BoardingScheduler {
	
	private ArrayList<Passenger> boarding = new ArrayList<Passenger>();	
	//a record of passengers have begun boarding 
	
    /**
     * Store a passenger’s estimated boarding completion time.
     * @param passengers iterator of passengers
     * @param the earliest time any passenger is allowed to begin boarding
     */
	public static void boardFlight(Iterator<Passenger> passengers, int startTime) {
		BoardingScheduler bs = new BoardingScheduler();
		// a new instance of BoardingScheduler
		BoardingHeap bh = new BoardingHeap();	// a new instance of BoardingHeap
		ArrayList<Passenger> allP = new ArrayList<Passenger>();// records all passengers
		System.out.println(startTime + " Boarding begins\n");
		
		int time = 0;
		Passenger omit = null;	// hold the omit passenger
		while (true) {
			// begin enqueue passengers
			boolean ifW = true;
			if (omit != null) {
				if (omit.getTime() == time) {
					omit.setDoneTimeEstimate(bs.calculateDoneTimeEstimate(omit));
					bh.enqueue(omit);
					omit = null;
				}else {
					ifW = false;
				}
			}
			while (passengers.hasNext() && ifW) {
				Passenger p = passengers.next();
				if (p.getTime() == time) {
					p.setDoneTimeEstimate(bs.calculateDoneTimeEstimate(p));
					bh.enqueue(p);
				}else {
					omit = p;
					break;
				}
			}
			
			// remove the passengers who have completed boarding
			for (int i = 0; i < bs.boarding.size(); i++) {
				if (time >= bs.boarding.get(i).getDoneTime())
					bs.boarding.remove(i);
			}
			
			// begin dequeue passengers
			if (!bh.isEmpty() && time >= startTime) {
				Passenger removed = bh.dequeue();
				removed.setDoneTime(bs.calculateDoneTime(time,removed));
				System.out.print(time +" " +removed.getName() + " "+ removed.getSeat());
				System.out.println(" (done " +removed.getDoneTime()+ ")");
				bs.boarding.add(removed);
				allP.add(removed);
			}
			if (!passengers.hasNext() && bh.isEmpty() && omit == null) {
				break;
			}else {
				time++;
			}
		}
		
		// get the last passenger who completes boarding
		int maxDone = 0;
		for (Passenger pas : allP) {
			if (pas.getDoneTime() > maxDone)
				maxDone = pas.getDoneTime();
		}
		maxDone += 1;
		System.out.println("" + maxDone + " All passengers have boarded!");
	}
	
	/**
     * A private helper method that get the number of seat
     * @param passengers iterator of passengers
     * @return the number part of seat
     */
	public int calculateDoneTimeEstimate(Passenger p) {
		ArrayList<Passenger> sOi = new ArrayList<Passenger>();
		for (Passenger pp : boarding) {
			if (getSeat(pp.getSeat()) <= getSeat(p.getSeat()))
				sOi.add(pp);
		}
		int max = 0;
		
		if (sOi.size() == 0)
			return p.getTime() + 5;
		
		for (Passenger pa : sOi) {
			if (pa.getDoneTime() > max)
				max = pa.getDoneTime();
		}
		return max + 5;
	}
	
	/**
     * A private helper method that get the actual done time.
     * @param dequeue time
     * @param passenger
     * @return the number part of seat
     */
	private int calculateDoneTime(int time, Passenger p) {
		ArrayList<Passenger> sOi = new ArrayList<Passenger>();
		for (Passenger pp : boarding) {
			if (getSeat(pp.getSeat()) <= getSeat(p.getSeat()))
				sOi.add(pp);
		}
		int max = 0;
		
		if (sOi.size() == 0)
			return time + 5;
		
		for (Passenger pa : sOi) {
			if (pa.getDoneTime() > max)
				max = pa.getDoneTime();
		}
		return max + 5;
	}
	
	/**
     * A private helper method that get the number of seat.
     * @param seat
     * @return the number part of seat
     */
	private int getSeat(String seat) {
		String result = "";
		for (int i = 0; i < seat.length(); i++) {
			if (seat.charAt(i) >= '0' && seat.charAt(i) <= '9')
				result += seat.charAt(i);
			else
				break;
		}
		return Integer.parseInt(result);
	}
}
