package application;

import java.io.Serializable;
import java.util.ArrayList;
/***
 * 
 * @author dsouz
 *
 */
public class ship implements Serializable{
	//size and location of ship
	private int length;
	private ArrayList<tile> location;
	
	/**
	 * constructor that sets the size and location of the ship
	 * @param len
	 * @param loc
	 */
	public ship(int len) {
		length = len;
		location = new ArrayList<tile>(len);
		
	}
	
	/**
	 * checks if ship is sunk or not
	 * @return whether ship sunk
	 */
	public boolean isSunk(gameBoard checkAgainst) {
		for(tile t: location){
			if(!checkAgainst.getTile(t.x, t.y).isHit()) { return false;} // if isnt hit, we arent sunk
			else {
				t.updateHit(true); //else, update our own tile to ensure
			}
		}
		return true;
	}

	/**
	 * getter function that returns location
	 * @return length of ship
	 */
	public int getLength() {
		return length;
	}

	/**
	 * getter function that returns location
	 * @return
	 */
	public ArrayList<tile> getLocation() {
		return location;
	}

	/**
	 * adds location of ship
	 * @param location
	 */
	public void addLocation(tile loc) {
		location.add(loc);
	}


}
