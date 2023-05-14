/***
 * gameBoard class that holds all information about a player/ai's board
 */
package application;
//import java.util.Arrays;

public class gameBoard {
	/***
	 * Constant width and height for arrays
	 */
	private static final int width = 10;
	private static final int height = 10;
	private tile[][] board;
	/***
	 * Tile object that holds all info about specific tiles.
	 * For example, bool isHit "has a shot been fired here
	 * ,bool isOccupied() "has the player this board belongs to 
	 * put a ship there", ship Ship() "the ship placed there.
	 * mayb a pointer or reference to the player ship" <- ?
	 */
	
	/***
	 * Default constructor which is all that is needed for the
	 * initial board.
	 */
	public gameBoard() {
	    board = new tile[width][height];
	    for (int i = 0; i < width; i++) {
	        for (int j = 0; j < height; j++) {
	            board[i][j] = new tile(i, j); // must instantiate otherwise null error
	        }
	    }
		/***
		 * go through the entire arrayList and add a defaulted tile
		 * we can update after user places their ships.
		 */
	}
	
	public gameBoard(player p) {
	    board = new tile[width][height];
	    ship toCheck[] = p.getFleet(); // basically getting all the occupied ships w coordinates.
	    for (int i = 0; i < width; i++) {
	        for (int j = 0; j < height; j++) {
	            board[i][j] = new tile(i, j);
	        }
	    }
	    for (ship s : toCheck) {
	        for (tile t : s.getLocation()) {;
	           	this.getTile(t.x, t.y).updateOccupied(true);
	        }
	    }
	}


	public tile getTile(int m, int n) {
		return board[m][n];
	}
	/***
	 * returns user specified index hit Value
	 * Done since this will be something that is constantly called.
	 * @param m
	 * @param n
	 * @return
	 */

	public int getHeight() {return gameBoard.height;}
	
	public int getWidth() {return gameBoard.width;}
	
	public void printBoard() {
		String temp = "";
		for(int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (this.getTile(i, j).isOccupied() && this.getTile(i, j).isHit()) {
					temp = "* "; // is the space occupied and not hit?
				}
				else if (this.getTile(i,j).isOccupied()) {temp = "O ";}
				else if (this.getTile(i, j).isHit()) {
					temp = "X ";
				}
				else {
					temp = "_ ";
				}
				System.out.print(temp);
			}
			System.out.print("\n");
		}
	}
	
	/***
	 * Function to check if all ships are sunk for a given player. Compares board to actual player.
	 * @param ifLost
	 * @return
	 */
	public boolean checkWin(player ifLost) { //function essentially checks if I have lost by seeing if all my occupied are hit.
		//iterate through fleet to check for a win.
		for (ship shipLocationArray : ifLost.getFleet()) { // get our locationArray from the players ship(s)
			if(shipLocationArray.isSunk(this)) {
				continue;
			}
			else {
				System.out.println("Not all ships are sunk");
				return false;
			}
		}
		
		System.out.println("All ships are sunk! " + ifLost.getName() + " has lost");
		return true;
	}
	
	public boolean validHit(int x, int y) {
		if (board[x][y].isHit()) {
			return false;
		}
		return true;
		
	}
}