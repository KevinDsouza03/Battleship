package application;

import java.util.ArrayList;

public class ship {
	//size and location of ship
	private int length;
	private ArrayList<tile> location;
	//private tile shipLoc[];
	
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
	public boolean isSunk() {
		for(int i = 0; i < length; i++){
			if(!location.get(i).isHit()) return false;
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
