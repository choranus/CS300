import java.util.EmptyStackException;
class MazeRunnerNode {
	int col;
	int row;
	MazeRunnerNode next;
	
	MazeRunnerNode(Position p){
		this.col = p.col;
		this.row = p.row;
		this.next = null;
	}
	
	boolean equals(MazeRunnerNode other) {
		return this.col==other.col && this.row==other.row;
	}
}
public class MazeRunnerStack implements StackADT<Position>{
	private MazeRunnerNode head;
	private MazeRunnerNode tail;
	private int size;
	
	@Override
	public void push(Position item) {
		if (item == null)
			throw new IllegalArgumentException();
		MazeRunnerNode newNode = new MazeRunnerNode(item);
		if (size == 0) {
			head = newNode;
			tail = newNode;
			size++;
		}else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
		
	}

	@Override
	public Position pop() throws EmptyStackException {
		if (size == 0) {
			throw new EmptyStackException();
		}else if (size == 1) {
			int c = head.col;
			int r = head.row;
			head = null;
			tail = null;
			size = 0;
			return new Position(c,r);
		}else {
			int c = tail.col;
			int r = tail.row;
			MazeRunnerNode curr = head;
			while (curr.next.next != null) {
				curr = curr.next;
			}
			tail = curr;
			size--;
			return new Position(c,r);
		}
	}

	@Override
	public Position peek() throws EmptyStackException {
		if (size == 0)
			throw new EmptyStackException();
		return new Position(tail.col,tail.row);
	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}
	
	public boolean contains(Position p) {
		//Reports whether the Position p can be found within the stack
		MazeRunnerNode curr = head;
		while (curr.next != null) {
			if (curr.col == p.col && curr.row == p.row)
				return true;
			curr = curr.next;
		}
		if (tail.col == p.col && tail.row == p.row)
			return true;
		return false;
	}

}
