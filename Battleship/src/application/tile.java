
/***
 * Object that holds all relevant individual tile information.
 */
package application;

public class tile {
	private boolean hit;
	private boolean occupied;
	/***
	 * hit for if a shot has been fired. If fired, change to true
	 * and each frame can check isHit() everytime. 
	 */
	//private ship boat;
	//ship commented as it may eliminate the use for occupied
	//since we can just put null if there is no ship.
	
	/***
	 * Only a default constructor as we can just update each
	 * tile individually
	 */
	public tile() {
		hit = false;
		occupied = false;
	}
	/***
	 * 
	 * @return boolean
	 * isHit: True/False
	 */
	public boolean isHit() {return this.hit;}
	/***
	 * Check for occupied tile
	 * @return
	 */
	public boolean isOccupied() {return this.occupied;}
	/***
	 * when hit is received, update hit variable. Can be used for
	 * both display and gameplay purposes
	 * @param t
	 */
	public void updateHit(boolean t) {this.hit = t;}
	/***
	 * when a player places their ship on the board, update.
	 * @param t
	 */
	public void updateOccupied(boolean t) {this.occupied = t;}
}
