/***
 * gameBoard class that holds all information about a player/ai's board
 */
package application;
import java.util.ArrayList;

public class gameBoard {
	/***
	 * Constant width and height for arrays
	 */
	private static final int width = 10;
	private static final int height = 10;
	private ArrayList<tile>[][] board;
	/***
	 * Tile object that holds all info about specific tiles.
	 * For example, bool isHit "has a shot been fired here
	 * , bool isOccupied() "has the player this board belongs to 
	 * put a ship there", ship Ship() "the ship placed there.
	 * mayb a pointer or reference to the player ship" <- ?
	 */
	
	/***
	 * Default constructor which is all that is needed for the
	 * initial board.
	 */
	public gameBoard() {
	    board = new ArrayList[width][height];
	    for (int i = 0; i < width; i++) {
	        for (int j = 0; j < height; j++) {
	            board[i][j] = new ArrayList<tile>();
	            board[i][j].add(new tile());
	        }
	    }
		/***
		 * go through the entire arrayList and add a defaulted tile
		 * we can update after user places their ships.
		 */
	}

	/***
	 * returns user specified index hit Value
	 * Done since this will be something that is constantly called.
	 * @param m
	 * @param n
	 * @return
	 */
	public boolean getTileisHit(int m, int n) { return board[m][n].get(0).isHit(); }
	/***
	 * returns user specified index occupied value
	 * @param m
	 * @param n
	 * @return
	 */
	public boolean getTileisOccupied(int m, int n) { return board[m][n].get(0).isOccupied(); }


}
