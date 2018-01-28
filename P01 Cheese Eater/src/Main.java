//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           CHEESE EATER
// Files:           NA
// Course:          CS 300, Spring 2018
//
// Author:          Zhanhe Lyu
// Email:           zlyu8@wisc.edu
// Lecturer's Name: Alexi Brooks
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    NA
// Partner Email:   NA
// Lecturer's Name: NA
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
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

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		char[][] room = new char[10][20];
		Random randGen = new Random();
		placeWalls(room, 20, randGen);
		int[][] cheesePositions = new int[10][2];
		placeCheeses(cheesePositions, room, randGen);
		System.out.println("Welcome to the Cheese Eater simulation.\n" + 
				"=======================================");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of steps for this simulation to run: ");
		int times = sc.nextInt();
		int mouseX = randGen.nextInt(room[0].length);
		int mouseY = randGen.nextInt(room.length);
		printRoom(room, cheesePositions, mouseX, mouseY);
		int counter = 0;
		for (int j = 0; j < times; j++) {
			System.out.println("Enter the next step you'd like the mouse to take (WASD): ");
			char move = sc.next().charAt(0);
			int[] mousePosition = moveMouse(mouseX, mouseY, room, move);
			mouseX = mousePosition[0];
			mouseY = mousePosition[1];
			if(tryToEatCheese(mouseX, mouseY, cheesePositions)) {
				counter++;
			}
			System.out.println("The mouse has eaten " + counter + " cheese!");
			printRoom(room, cheesePositions, mouseX, mouseY);
		}
		System.out.println("==================================================\n" + 
				"Thank you for running the Cheese Eater simulation.\n");
	}
	public static void placeWalls(char[][] room, int numberOfWalls, Random randGen) {
		for (int i = 0; i < numberOfWalls; i++) {
			int x = randGen.nextInt(room[0].length);
			int y = randGen.nextInt(room.length);
			if (room[y][x] != '#') {
				room[y][x] = '#';
			}else {
				i--;
			}
		}
		for (int m = 0; m < room.length; m++) {
			for (int n = 0; n < room[0].length; n++) {
				if (room[m][n] != '#') {
					room[m][n] = '.';
				}
			}
		}
	}
	public static void placeCheeses(int[][] cheesePositions, char[][] room, Random randGen) {
		for (int i = 0; i < cheesePositions.length; i++) {
			int x = randGen.nextInt(room[0].length);
			int y = randGen.nextInt(room.length);
			int[] position = {x,y};
			if (room[y][x] == '.' && !ifContain(position,cheesePositions)) {
				cheesePositions[i][0] = x;
				cheesePositions[i][1] = y;
			}else {
				i--;
			}
		}
	}
	public static void printRoom(char[][] room, int[][] cheesePositions, int mouseX, int mouseY) {
		for (int m = 0; m < room.length; m++) {
			for (int n = 0; n < room[0].length; n++) {
				int[] position = {n,m};
				if (m == mouseY && n == mouseX) {
					System.out.print('@');
				}else if(ifContain(position,cheesePositions)){
					System.out.print('%');
				}else {
					System.out.print(room[m][n]);
				}
			}
			System.out.println();
		}
	}
	public static boolean ifContain(int[] position, int[][] cheesePositions) {
		for (int[] cp: cheesePositions) {
		    if (cp[0] == position[0] && cp[1] == position[1]) {
		    		return true;
		    }
		}
		return false;
	}
	public static int[] moveMouse(int mouseX, int mouseY, char[][] room, char move) {
		if (move == 'w' || move == 'W') {
			if (mouseY == 0) {
				System.out.print("WARNING: Mouse cannot move outside the room.");
				return null;
			}else if(room[mouseY - 1][mouseX] == '#') {
				System.out.print("WARNING: Mouse cannot move into wall.");
				return null;				
			}else {
				int[] result = {mouseX,mouseY - 1};
				return result;
			}
		}else if(move == 's' || move == 'S') {
			if (mouseY + 1 == room.length) {
				System.out.print("WARNING: Mouse cannot move outside the room.");
				return null;
			}else if(room[mouseY + 1][mouseX] == '#') {
				System.out.print("WARNING: Mouse cannot move into wall.");
				return null;				
			}else {
				int[] result = {mouseX,mouseY + 1};
				return result;
			}			
		}else if(move == 'a' || move == 'A') {
			if (mouseX == 0) {
				System.out.print("WARNING: Mouse cannot move outside the room.");
				return null;
			}else if(room[mouseY][mouseX - 1] == '#') {
				System.out.print("WARNING: Mouse cannot move into wall.");
				return null;				
			}else {
				int[] result = {mouseX - 1,mouseY};
				return result;
			}			
		}else if(move == 'd' || move == 'D') {
			if (mouseX + 1 == room[0].length) {
				System.out.print("WARNING: Mouse cannot move outside the room.");
				return null;
			}else if(room[mouseY][mouseX + 1] == '#') {
				System.out.print("WARNING: Mouse cannot move into wall.");
				return null;			
			}else {
				int[] result = {mouseX + 1,mouseY};
				return result;
			}
		}else {
			System.out.print("WARNING: Didn’t recognize move command: " + move);
			return null;
		}
	}
	public static boolean tryToEatCheese(int mouseX, int mouseY, int[][] cheesePositions) {
		for (int[] cp: cheesePositions) {
		    if (cp[0] == mouseX && cp[1] == mouseY) {
		    		cp[0] = -1;
		    		cp[1] = -1;
		    		return true;
		    }
		}
		return false;
	}
	
}