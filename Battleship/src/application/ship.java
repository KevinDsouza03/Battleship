package application;


public class ship {
	//size and location of ship
	private int length;
	private tile location[];
	//private tile shipLoc[];
	
	/**
	 * constructor that sets the size and location of the ship
	 * @param len
	 * @param loc
	 */
	public ship(int len, tile loc[]) {
		length = len;
		location = loc;
	}
	
	/**
	 * checks if ship is sunk or not
	 * @return whether ship sunk
	 */
	public boolean isSunk() {
		for(int i = 0; i < length; i++){
			if(!location[i].isHit()) return false;
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
	public tile[] getLocation() {
		return location;
	}

	/**
	 * sets location of ship
	 * @param location
	 */
	public void setLocation(tile location[]) {
		this.location = location;
	}


}
