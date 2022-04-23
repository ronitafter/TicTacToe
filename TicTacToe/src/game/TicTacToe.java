package game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

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
		return "";
	}

}
