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
	           	this.setTileOccupied(t.x, t.y);
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
	public boolean getTileisHit(int m, int n) { return board[m][n].isHit(); }
	/***
	 * returns user specified index occupied value
	 * @param m
	 * @param n
	 * @return
	 */
	public boolean getTileisOccupied(int m, int n) { return board[m][n].isOccupied(); }


	public int getHeight() {return gameBoard.height;}
	
	public int getWidth() {return gameBoard.width;}
	
	public void printBoard() {
		String temp = "";
		for(int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (this.getTileisOccupied(i, j) && this.getTileisHit(i, j)) {
					temp = "* "; // is the space occupied and not hit?
				}
				else if (this.getTileisOccupied(i,j)) {temp = "O ";}
				else if (this.getTileisHit(i, j)) {
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
	public void setTileOccupied(int m, int n) {
		board[m][n].updateOccupied(true);
	}
	public void setTileHit(int m, int n) {
		board[m][n].updateHit(true);
	}
	/***
	 * Function to check if all ships are sunk for a given player. Compares board to actual player.
	 * @param ifLost
	 * @return
	 */
	public boolean checkWin(player ifLost) { //function essentially checks if I have lost by seeing if all my occupied are hit.
		ship toCheck[] = new ship[5];
		System.arraycopy(ifLost.getFleet(), 0, toCheck, 0, 5);
		// now we have our copy of the fleet and iterate through it all to check for a win.
		for (ship shipLocationArray : toCheck) { // get our locationArray from the players ship(s)
			for (tile shipLocation : shipLocationArray.getLocation()) { // check each location for being hit on our board.
				if (this.getTileisHit(shipLocation.x, shipLocation.y)) {
					continue;
				}
				else {
					System.out.println("Not all ships are sunk");
					return false;
				}
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
