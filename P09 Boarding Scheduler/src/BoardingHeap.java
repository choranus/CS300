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
 * The heap stores the passengers
 * @author Zhanhe Lyu
 * @version 1.0
 */
public class BoardingHeap {
    private Passenger[] heap; // array of passengers currently in the heap
    private int size;		 // size of the heap
 
    /**
     * The only constructor of BoardingHeap.
     */
    public BoardingHeap() {
    		Passenger[] Passengers = new Passenger[100];
    		for (int j=0; j < Passengers.length; j++) {
    			Passengers[j] = null;
    		}
    		this.heap = Passengers;
    		this.size = 0;
    }
    
    /**
     * Insert a Passenger into the BoardingHeap.
     * @param a passenger
     */
    public void enqueue(Passenger p) {
    		// if out of range
    		if (heap.length == size + 1) {
    			Passenger[] temp1 = new Passenger[heap.length * 2];
    			for (int j=0; j < temp1.length; j++) {
    				temp1[j] = null;
        		}
    			for (int i=0; i < heap.length; i++) {
    				temp1[i] = heap[i];
    			}
    			heap = temp1;
    		}
    		
    		heap[++size] = p;
    		if (size == 1) {
    			return;
    		}
    		
    		int i = size;
    		while (true) {
    			if (heap[i/2].compareTo(heap[i]) < 0) {
    				Passenger temp = heap[i];
    				heap[i] = heap[i/2];
    				heap[i/2] = temp;
    			}
    			i /= 2;
    			if (i == 1)
    				break;
    		}
    		
    }
    
     /**
     * Remove the highest priority item from the heap.
     * @return the dequeued passenger
     */
    public Passenger dequeue() {
    		Passenger result = heap[1];
    		heap[1] = heap[size];
    		heap[size] = null;
    		boolean ifC = true;
    		int parent = 1;
    		while (ifC) {
    			
    			if (2*parent >= heap.length || (heap[2*parent] == null 
    					&& heap[2*parent+1] == null)) {
    				// no child
    				ifC = false;
    			} else if (2*parent+1 >= heap.length || heap[2*parent+1] == null) {
    				// only left child
    				if (heap[parent].compareTo(heap[parent*2]) <= 0) {
        				Passenger temp = heap[parent];
        				heap[parent] = heap[parent*2];
        				heap[parent*2] = temp;
    				}
    				ifC = false;
    			} else {
    				if (heap[parent].compareTo(heap[parent*2]) <= 0 
    						&& heap[parent].compareTo(heap[parent*2+1]) <= 0) {
    					if (heap[2*parent].compareTo(heap[2*parent+1]) > 0) {
            				Passenger temp = heap[parent];
            				heap[parent] = heap[parent*2];
            				heap[parent*2] = temp;
            				parent *= 2;
            				continue;
    					}else {
            				Passenger temp = heap[parent];
            				heap[parent] = heap[parent*2+1];
            				heap[parent*2+1] = temp;
            				parent = 2*parent + 1;
            				continue;
    					}
    				}
    				if (heap[parent].compareTo(heap[parent*2]) > 0 
    						&& heap[parent].compareTo(heap[parent*2+1]) <= 0) {
        				Passenger temp = heap[parent];
        				heap[parent] = heap[parent*2+1];
        				heap[parent*2+1] = temp;
        				parent = 2*parent + 1;
        				continue;
    				}
    				if (heap[parent].compareTo(heap[parent*2]) <= 0 
    						&& heap[parent].compareTo(heap[parent*2+1]) > 0) {
        				Passenger temp = heap[parent];
        				heap[parent] = heap[parent*2];
        				heap[parent*2] = temp;
        				parent *= 2;
        				continue;
    				}
    				if (heap[parent].compareTo(heap[parent*2]) > 0 
    						&& heap[parent].compareTo(heap[parent*2+1]) > 0) {
    					ifC = false;
    				}
    			}
    		}
    		size--;
    		return result;
    }
    
    /**
     * Test if the heap is empty.
     */
    public boolean isEmpty() {
    		return size == 0;
    }
}