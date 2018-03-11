
public class JobLList implements WaitingListADT<JobNode> {
	private JobNode head;
	private int size;
	
	public JobLList() {
		head = null;
		size = 0;
	}
	
	public JobNode getHead() {
		return head;
	}
	public int getSize() {
		return size;
	}
	public void setHead(JobNode head) {
		this.head = head;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public void schedule(JobNode newJob) {
		if(newJob.getPriority() == 0) {
			if (size == 0) {
				head = newJob;
				size++;
			}else {
				JobNode curr = head;
				while (curr.getNext() != null) {
					curr = curr.getNext();
				}
				curr.setNext(newJob);
				size++;
			}
		}else if(newJob.getPriority() == 1) {
			if (size == 0) {
				head = newJob;
				size++;				
			}else if (head.getPriority() == 0){
				newJob.setNext(head);
				head = newJob;
				size++;
			}else{
				JobNode curr = head;
				while (curr.getNext() != null && curr.getNext().getPriority() == 1) {
					curr = curr.getNext();
				}
				JobNode next = curr.getNext();
				curr.setNext(newJob);
				newJob.setNext(next);
				size++;
			}
		}
		
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int clean(float cleaningTime) {
		int cleaned = 0;
		
		if (size == 0) {
			return 0;
		}
		if (size == 1) {
			if (head.getArrivalTime() + head.getTimeToLive() < cleaningTime) {
				head = null;
				size = 0;
				return 1;
			}
			return 0;
		}
		
		JobNode curr = head;
		while (curr.getNext() != null) {
			if (curr.getNext().getArrivalTime() + curr.getNext().getTimeToLive() < cleaningTime) {
				curr.setNext(curr.getNext().getNext());
				cleaned++;
				size--;
				continue;
			}
			curr = curr.getNext();
			
		}
		if (size == 1 && head.getArrivalTime() + head.getTimeToLive() < cleaningTime) {
			head = null;
			size = 0;
			cleaned++;
		}else if (head.getArrivalTime() + head.getTimeToLive() < cleaningTime) {
			head = head.getNext();
			size--;
			cleaned++;
		}
		return cleaned;
	}

	@Override
	public void clear() {
		size = 0;
		head = null;
		
	}

	@Override
	public WaitingListADT<JobNode> duplicate() {
		JobLList copyList = new JobLList();
		copyList.setHead(this.head.copy());
		JobNode curr = head;
		JobNode currC = copyList.getHead();
		while (curr.getNext() != null) {
			curr = curr.getNext();
			currC.setNext(curr.copy());
		}
		return copyList;
	}
	
	@Override
	public String toString() {
		String result = "";
		result += "Job List is empty: ";
		result += isEmpty();
		result += "\nThe size is: ";
		result += size;
		result += " job(s).\n";
		if (size == 0)
			return result;
		JobNode curr = head;
		while (true) {
			result += "job #";
			result += curr.getJobId();
			result += " : ";
			result += curr.getDescription();
			result += " (UID ";
			result += curr.getUserId();
			result += ") ";
			result += curr.getPriority();	
			result += "\n";
			if (curr.getNext() == null)
				break;
			else
				curr = curr.getNext();
		}
		return result;
	}

}
