
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
