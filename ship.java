package application;

import javafx.util.Pair;

public class ship {
	//size and location of ship
	private int length;
	private Pair<Integer, Integer> location[];
	//private tile shipLoc[];
	
	/**
	 * constructor that sets the size and location of the ship
	 * @param len
	 * @param loc
	 */
	public ship(int len, Pair<Integer, Integer> loc[]) {
		length = len;
		location = loc;
	}
	
	/**
	 * checks if ship is sunk or not
	 * @return whether ship sunk
	 */
	public boolean isSunk() {
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
