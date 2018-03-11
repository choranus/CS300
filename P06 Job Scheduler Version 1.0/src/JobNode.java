/**
 * File Header COMES HERE
 */
 
/**
 * JavaDoc Class Header COMES HERE
 *
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
	 * Description of the constructor comes here
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
	
	// You can overload your class by other constructors
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