
class Position {
	int col;
	int row;
	Position(int row, int col) {
		this.col = col;
		this.row = row;
	}
	boolean equals(Position other) {
		return this.col==other.col && this.row==other.row;
	}
}
