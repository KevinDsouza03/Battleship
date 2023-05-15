
/***
 * Object that holds all relevant individual tile information.
 */
package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/***
 * tile to represent invidual board spaces/ship locations
 * @author dsouz
 *
 */
public class tile extends Rectangle {
	private boolean hit;
	private boolean occupied;
	int x;
	int y;
	
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
	 * @param x row on board
	 * @param y col on board
	 */
	public tile(int x, int y) {
		super(x, y, 50, 50);
		//adding border
		this.x = x;
		this.y = y;
		super.setStrokeWidth(2);
		super.setStroke(Color.WHITE);
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
	 * @return boolean for occupied
	 */
	public boolean isOccupied() {return this.occupied;}
	/***
	 * when hit is received, update hit variable. Can be used for
	 * both display and gameplay purposes
	 * @param t boolean to update if hit or not
	 */
	public void updateHit(boolean t) {this.hit = t;}
	/***
	 * when a player places their ship on the board, update.
	 * @param t boolean if occupied or not
	 */
	public void updateOccupied(boolean t) {this.occupied = t;}
}
