package application;

/***
 * Player class to represent what a Battleship player would have!
 * @author dsouz
 *
 */
public abstract class player {
	/***
	 * Represents all the player's ships
	 */
	private String name;
	private ship fleet[]; 
	
	
	public player() {
		fleet = new ship[5];
		name = "Bob";
	}
	
	public player(String n, ship[] f) {
		fleet = f;
		name = n;
	}
	
	/***
	 * set player name, from first scene
	 * @param n
	 */
	public void setName(String n) {name = n;}
	/***
	 * return player name set above or in constructor.
	 * @return
	 */
	public String getName() {return name;}
	
	/***
	 * return fleet
	 * @return
	 */
	public ship[] getFleet() {
		return fleet;
	}
	public void setFleet(ship []s) {
		fleet = s;
	}
	
	/***
	 * function to be implemented as to how a player fires a shot.
	 * attack
	 */
	public abstract boolean fire(int x, int y, gameBoard attack);
	
	
}
