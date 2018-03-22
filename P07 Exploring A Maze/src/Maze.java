//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Exploring A Maze
// Files:           StackADT.java MazeRunnerStack.java TestStack.java Maze.java
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
 * This class can build a maze, display a maze and solve a maze.
 * @author Zhanhe Lyu
 * @version 1.0
 */
public class Maze {
	/**
	    * The solution of maze
	    */
	private MazeRunnerStack path;
	
	/**
	    * Represents if the mazed has been solved
	    */
	private Boolean solved;
	
	/**
	    * The information of the maze
	    * A 2-dimensional array of characters
	    */
	private char[][] mazeInfo;
	
	/**
	    * The start position of maze
	    */
	private int[] startP;
	
	/**
	    * The finish position of maze
	    */
	private int[] finalP;
	
	/**
	    * Constructor initializing mazeInfo to Maze.
	    * @param mazeInfo information of maze
	    */
	public Maze(char[][] mazeInfo) {
		this.mazeInfo = mazeInfo;
		solved = null;
		path = null;
	}
	
	/**
	    * Set start position of maze.
	    * @param row row of start position
	    * @param col column of start position
	    */
	public void setStart(int row, int col) {
		startP = new int[] {row,col};
	}
	
	/**
	    * Set finish position of maze.
	    * @param row row of finish position
	    * @param col column of finish position
	    */
	public void setFinish(int row, int col) {
		finalP = new int[] {row,col};
	}
	
	/**
	    * Display Maze.
	    * Produce an ASCII-graphics version of the maze.
	    */
	public void displayMaze() {
		String result = "";		// contains the result
		int width = mazeInfo[0].length;		// width of maze
		int height = mazeInfo.length;		// length of maze
		int Scase = 0;		// if the mazed has been solved
		if (solved == null) {
			Scase = 0;
		}else if (solved == true){
			Scase = 1;
		}else if(solved == false) {
			Scase = 2;
		}
		if (Scase == 1) {
			result += "Solution is:\n";
			for (int i = 0; i < width; i++)
				result += "+---";
			result += "+\n";
			for (int k = 0; k < height; k++) {
				for (int z = 0; z < width; z++) {
					if (mazeInfo[k][z] == 'L' || mazeInfo[k][z] == '|') {
						if (k == startP[0] && z == startP[1]) {
							result += "| S ";
						}else if (k == finalP[0] && z == finalP[1]) {
							result += "| F ";
						}else {
							if (path.contains(new Position(k,z))) {
								result += "| * ";
							}else {
								result += "|   ";
							}
						}
					}else {
						if (k == startP[0] && z == startP[1]) {
							result += "  S ";
						}else if (k == finalP[0] && z == finalP[1]) {
							result += "  F ";
						}else {
							if (path.contains(new Position(k,z))) {
								result += "  * ";
							}else {
								result += "    ";
							}
						}
					}
				}
				result += "|\n";
				for (int z = 0; z < width; z++) {
					if (mazeInfo[k][z] == 'L' || mazeInfo[k][z] == '_') {
						result += "+---";
					}else {
						result += "+   ";
					}
				}
				result += "+\n";
			}
			result += "Path is: [";
			result += startP[0];
			result += ",";
			result += startP[1];
			result += "]";
			Position[] duplicatePath = new Position[4 * mazeInfo.length * mazeInfo[0].length];
			int size = 0;
			while(!path.isEmpty()) {
				duplicatePath[size] = path.pop();
				size++;
			}
			path.push(duplicatePath[size-1]);
			for (int i = size-2; i >= 0; i--) {
				path.push(duplicatePath[i]);
				result += " --> [";
				result += duplicatePath[i].row;
				result += ",";
				result += duplicatePath[i].col;
				result += "]";
			}
			
		}else {
			if (Scase == 2)
				result += "No solution could be found.\n";
			for (int i = 0; i < width; i++)
				result += "+---";
			result += "+\n";
			for (int k = 0; k < height; k++) {
				for (int z = 0; z < width; z++) {
					if (mazeInfo[k][z] == 'L' || mazeInfo[k][z] == '|') {
						if (k == startP[0] && z == startP[1]) {
							result += "| S ";
						}else if (k == finalP[0] && z == finalP[1]) {
							result += "| F ";
						}else {
							result += "|   ";
						}
					}else {
						if (k == startP[0] && z == startP[1]) {
							result += "  S ";
						}else if (k == finalP[0] && z == finalP[1]) {
							result += "  F ";
						}else {
							result += "    ";
						}
					}
				}
				result += "|\n";
				for (int z = 0; z < width; z++) {
					if (mazeInfo[k][z] == 'L' || mazeInfo[k][z] == '_') {
						result += "+---";
					}else {
						result += "+   ";
					}
				}
				result += "+\n";
			}
		
		}
		System.out.print(result);
	}
	
	/**
	    * Solve a maze by right hand rule.
	    */
	public void solveMaze() {
		int orient = 3;		// front0 left1 back2 right3, initial orientation is 3
		path = new MazeRunnerStack();
		path.push(new Position(startP[0],startP[1]));
		int[] curr = new int[] {startP[0],startP[1]};
		int step = 0;
		while (curr[0] != finalP[0] || curr[1] != finalP[1]) {
			if (step > 4 * mazeInfo.length * mazeInfo[0].length) {
				solved = false;
				path = null;
				break;
			}
			step++;
			if (orient == 0) {
				if (curr[1] == mazeInfo[0].length-1 || mazeInfo[curr[0]][curr[1]+1] == 'L' || 					mazeInfo[curr[0]][curr[1]+1] == '|') {
					if (curr[0] == 0 || mazeInfo[curr[0]-1][curr[1]] == '_' || mazeInfo[curr[0]-1]					[curr[1]] == 'L') {
						if (curr[1] == 0 || mazeInfo[curr[0]][curr[1]] == 'L' || mazeInfo[curr[0]]						[curr[1]] == '|') {
							orient = 2;
							curr[0]++;
						}else {
							orient = 1;
							curr[1]--;
						}
					}else {
						orient = 0;
						curr[0]--;
					}
				}else {
					orient = 3;
					curr[1]++;
				}
			}else if (orient == 1) {
				if (curr[0] == 0 || mazeInfo[curr[0]-1][curr[1]] == '_' || mazeInfo[curr[0]-1]					[curr[1]] == 'L') {
					if (curr[1] == 0 || mazeInfo[curr[0]][curr[1]] == 'L' || mazeInfo[curr[0]]					[curr[1]] == '|') {
						if (curr[0] == mazeInfo.length-1 || mazeInfo[curr[0]][curr[1]] == 'L' || 					mazeInfo[curr[0]][curr[1]] == '_') {
							orient = 3;
							curr[1]++;
						}else {
							orient = 2;
							curr[0]++;
						}
					}else {
						orient = 1;
						curr[1]--;
					}
				}else {
					orient = 0;
					curr[0]--;
				}
			}else if (orient == 2) {
				if (curr[1] == 0 || mazeInfo[curr[0]][curr[1]] == 'L' || mazeInfo[curr[0]]						[curr[1]] == '|') {
					if (curr[0] == mazeInfo.length-1 || mazeInfo[curr[0]][curr[1]] == 'L' || 							mazeInfo[curr[0]][curr[1]] == '_') {
						if (mazeInfo[curr[0]][curr[1]+1] == 'L' || mazeInfo[curr[0]][curr[1]+1] == 					'|' || curr[1] == mazeInfo[0].length-1) {
							orient = 0;
							curr[0]--;
						}else {
							orient = 3;
							curr[1]++;
						}
					}else {
						orient = 2;
						curr[0]++;
					}
				}else {
					orient = 1;
					curr[1]--;
				}
			}else if (orient == 3){
				if (curr[0] == mazeInfo.length-1 || mazeInfo[curr[0]][curr[1]] == 'L' || 							mazeInfo[curr[0]][curr[1]] == '_') {
					if (curr[1] == mazeInfo[0].length-1 || mazeInfo[curr[0]][curr[1]+1] == 'L' || 					mazeInfo[curr[0]][curr[1]+1] == '|') {
						if (curr[0] == 0 || mazeInfo[curr[0]-1][curr[1]] == '_' || 										mazeInfo[curr[0]-1][curr[1]] == 'L') {
							orient = 1;
							curr[1]--;
						}else {
							orient = 0;
							curr[0]--;
						}
					}else {
						orient = 3;
						curr[1]++;
					}
				}else {
					orient = 2;
					curr[0]++;
				}
			}
			Position currPosition = new Position(curr[0],curr[1]);
			if (path.contains(currPosition)) {
				while (!path.peek().equals(currPosition)) {
					path.pop();
				}
			}else {
				path.push(currPosition);
			}
		}
		if (solved == null) {
			solved = true;
		}
	}
}
