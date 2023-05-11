package application;
import java.util.Random;
import java.util.Scanner;
public class consoleRunner {
	
	public consoleRunner() {
		ship temp[] = new ship[5];
		temp[0] = new ship(5);
		temp[1] = new ship(4);
		temp[2] = new ship(3);
		temp[3] = new ship(3);
		temp[4] = new ship(2);
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < temp[j].getLength(); i++) {
				tile tempTile = new tile(j,j+i);
				tempTile.updateOccupied(true);
				temp[j].addLocation(tempTile);
			}
		}
		
		humanPlayer player1 = new humanPlayer("p1",temp);
		
		temp = new ship[5];
		temp[0] = new ship(5);
		temp[1] = new ship(4);
		temp[2] = new ship(3);
		temp[3] = new ship(3);
		temp[4] = new ship(2);
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < temp[j].getLength(); i++) {
				tile tempTile = new tile(j,j+i);
				temp[j].addLocation(tempTile);
			}
		}
		
		computerPlayer compPlayer1 = new computerPlayer("c1",temp);
		
		//now play game
		gameBoard p1Board = new gameBoard(player1);
		gameBoard p2Board = new gameBoard(compPlayer1);
//		play(player1,p1Board,compPlayer1,p2Board);
//		
//		
		
	}
	
	public consoleRunner(humanPlayer human, computerPlayer computer, gameBoard hBoard, gameBoard cBoard,int x, int y) {
		
		//now play game
		humanvsComputer(human,hBoard,computer,cBoard,x,y);
//		
//		
		
	}
	/***
	 * This will take all need
	 * @param p1
	 * @param p1Board
	 * @param p2
	 * @param p2Board
	 */
	public void play(player p1, gameBoard p1Board, player p2, gameBoard p2Board) {
		Random rand = new Random();
//		Scanner scanner = new Scanner(System.in);
		///while(!(p1Board.checkWin(p1) || p2Board.checkWin(p2))) {
		for (int i = 0; i < 50; i++) {
			System.out.println("Player1 Board");
			p1Board.printBoard();
			System.out.println("Player2 Board");
			p2Board.printBoard();
			System.out.println("Player1 First Move. Prompting user to play");
//			int x = scanner.nextInt();
//			int y = scanner.nextInt();
			p1.fire(rand.nextInt(10), rand.nextInt(10), p2Board);
//			p1.fire(x, y, p2Board);
			System.out.println("Player 1 fired");
			System.out.println("Player2 play");
			p2.fire(rand.nextInt(10), rand.nextInt(10), p1Board);
		}
		System.out.println("Player1 Final Board");
		p1Board.printBoard();
		System.out.println("Player2 Final Board");
		p2Board.printBoard();
		System.out.println("Game Over");
	}
	
	public void humanvsComputer(humanPlayer p1, gameBoard p1Board, computerPlayer p2, gameBoard p2Board,int x, int y) {
		Random rand = new Random();
		System.out.println("Player1 Board");
		p1Board.printBoard();
		System.out.println("Player2 Board");
		p2Board.printBoard();
		System.out.println("Player1 First Move. Prompting user to play");
		p1.fire(x, y, p2Board);
		System.out.println("Player 1 fired");
		System.out.println("Player2 play");
		p2.fire(rand.nextInt(10), rand.nextInt(10), p1Board);
		System.out.println("Player1 After Fire");
		p1Board.printBoard();
		System.out.println("Player2 After Fire");
		p2Board.printBoard();
	}

	
}
