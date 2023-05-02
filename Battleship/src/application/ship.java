package application;

import javafx.util.Pair;

public class ship {
	//size and location of ship
	private int length;
	private Pair<Integer, Integer> location[];
	//private tile shipLoc[];
	private boolean sunk;
	
	/**
	 * constructor that sets the size and location of the ship
	 * @param len
	 * @param loc
	 */
	public ship(int len, Pair<Integer, Integer> loc[]) {
		length = len;
		location = loc;
		sunk = false;
	}
	
	/**
	 * checks if ship is sunk or not
	 * @return whether ship sunk
	 */
	public boolean isSunk(gameBoard gb) {
		if (sunk) {return true;}
		for (Pair<Integer,Integer>i : location) {
			if (gb.getTileisOccupied(i.getKey(), i.getValue() ) && gb.getTileisHit(i.getKey(), i.getValue())) {
				//if both of these are true, go to the next iteration
				continue;
			}
			else { // if at any point, either of those are false, return false
				return false;
			}
		}
		// if we exit the for loop, we are sunk so update sunk for only a one time iteration, and return true.
		sunk = true;
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
	 * getter function that returns locations of ship. 
	 * @return
	 */
	public Pair<Integer, Integer>[] getLocation() {
		return location;
	}

	/**
	 * sets location of ship
	 * @param location
	 */
	public void setLocation(Pair<Integer, Integer> location[]) {
		this.location = location;
	}


}
