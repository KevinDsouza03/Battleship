package application;

import java.io.Serializable;

/***
 * Player class to represent what a Battleship player would have!
 * @author dsouz
 *
 */
public abstract class player implements Serializable {
	/***
	 * Represents all the player's ships
	 */
	private String name;
	private ship fleet[]; 
	//create special moves
	private specialMove rowA = new rowAttack();
	private specialMove bomb = new bomb();
	boolean rowAUsed = false;
	boolean bombUsed = false;
	
	/***
	 * Default Constructor for Player
	 */
	public player() {
		fleet = new ship[5];
		name = "Bob";
	}
	/***
	 * Parameterized constructor for player
	 * @param n name
	 * @param f ship[] of all ships
	 */
	public player(String n, ship[] f) {
		fleet = f;
		name = n;
	}
	
	/***
	 * set player name, from first scene
	 * @param n name
	 */
	public void setName(String n) {name = n;}
	/***
	 * return player name set above or in constructor.
	 * @return string name
	 */
	public String getName() {return name;}
	
	/***
	 * return fleet
	 * @return ship[] / locations of all fleet
	 */
	public ship[] getFleet() {
		return fleet;
	}
	/***
	 * add ship to fleet array
	 * @param s ship[] of all ships
	 */
	public void setFleet(ship []s) {
		fleet = s;
	}
	
	/**
	 * getter function returns rowAttack
	 * @return rowA
	 */
	public specialMove getRowA() {
		return rowA;
	}

	/**
	 * getter function returns bomb
	 * @return bomb
	 */
	public specialMove getBomb() {
		return bomb;
	}
	
	/**
	 * getter function returns whether row attack has been used
	 * @return rowAUsed
	 */
	public boolean getRowAUsed() {
		return rowAUsed;
		
	}
	
	/**
	 * getter function returns whether bomb has been used
	 * @return bombUsed
	 */
	public boolean getBombUsed() {
		return bombUsed;
		
	}
	
	/**
	 * setter function returns whether row attack has been used
	 * @param b - true if used and false when not used
	 */
	public void setRowAUsed(boolean b) {
		rowAUsed = b;
		
	}
	/**
	 * setter function returns whether bomb has been used
	 * @param b - true if used and false when not used
	 */
	public void setBombUsed(boolean b) {
		bombUsed = b;
		
	}
	/***
	 * function to be implemented as to how a player fires a shot.
	 * attack
	 * @param x
	 * @param y
	 * @param attack gameboard to attack
	 * @return boolean for successful shot
	 */
	public abstract boolean fire(int x, int y, gameBoard attack);
	
	
	
}
