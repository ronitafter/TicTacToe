package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> computerPositions = new ArrayList<Integer>();


	public static void main(String[] args) {
		char [][] gameBoard = {
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}};
	
		pringGameBoard(gameBoard);
//		Scanner scan = new Scanner(System.in);
		
		while(true) {
			Scanner scan = new Scanner(System.in);

			System.out.println("Enter your placement(1-9):");
			int pos =  scan.nextInt();
			System.out.println(pos);
			
			placePiece(gameBoard, pos, "player");
			
			Random random = new Random();
			int computerPos= random.nextInt(9)+1;
			placePiece(gameBoard, computerPos, "computer");
			pringGameBoard(gameBoard);
			
			checkWinner();
		}
		

	}
	
	public static void pringGameBoard(char[][]gameBoard) {
		
		for(char[] row: gameBoard) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
			
		}
		
	}
	
	public static void placePiece(char[][]gameBoard, int pos, String user) {
		char symbol=' ';
		if(user.equals("player")) {
			symbol = 'X';			
		}else if(user.equals("computer")) {
			symbol='O';
			
		}
		
		switch(pos) {
		case 1:
			gameBoard[0][0]= symbol;
			break;
		case 2:
			gameBoard[0][2]= symbol;
			break;
		case 3:
			gameBoard[0][4]= symbol;
			break;
		case 4:
			gameBoard[2][0]= symbol;
			break;
		case 5:
			gameBoard[2][2]= symbol;
			break;
		case 6:
			gameBoard[2][4]= symbol;
			break;
		case 7:
			gameBoard[4][0]= symbol;
			break;
		case 8:
			gameBoard[4][2]= symbol;
			break;
			
		case 9:
			gameBoard[4][4]= symbol;
			break;
			
			default:
				break;
		}
		
	}
	
	public static String checkWinner() {
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(7,5,3);
		
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List L: winning) {
			if(playerPositions.containsAll(L)) {
				return "You Won!";		
			}else if(computerPositions.containsAll(L)) {
				return "Computer Won...";			
			}else if(playerPositions.size() + computerPositions.size()==9){
				return "it's a tie";
				
			}
			
		}


		return "";
	}

}
