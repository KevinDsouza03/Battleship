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
				if (this.getTileisOccupied(i, j) && this.getTileisHit(i, j) != true) {
					temp = "O "; // is the space occupied and not hit?
				}
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
}
