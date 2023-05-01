package application;
import java.util.ArrayList;

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
	private ArrayList<ship>[] fleet; 
	
	
	public player() {
		fleet = new ArrayList<ship>();
		name = "Bob";
	}
	
	public player(String n) {
		fleet = new ArrayList<ship>();
		name = n;
	}
	
	/***
	 * function to be implemented as to how a player fires a shot.
	 * attack
	 */
	
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
	
	public abstract void fire();
	
	
}
