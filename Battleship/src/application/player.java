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
		fleet = new ship[5];
		System.arraycopy(f, 0, fleet, 0, 5);
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
	 * function to be implemented as to how a player fires a shot.
	 * attack
	 */
	public abstract void fire();
	
	
}
