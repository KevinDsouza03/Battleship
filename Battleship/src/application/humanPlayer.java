package application;
/***
 * humanPlayer to represent our normal player
 * @author dsouz
 *
 */
public class humanPlayer extends player{

	/***
	 * Default constructor
	 */
	public humanPlayer() {
		super();
	}
	/***
	 * paramaterized constructor for humanPlayer
	 * @param n name
	 * @param f ship[] of all ships
	 */
	public humanPlayer(String n, ship[] f) {
		super(n,f);
	}
	/***
	 * as this is a human fire, we take in an x,y and check for validity, then simply update.
	 */
	@Override
	public boolean fire(int x, int y, gameBoard attack) {
		if (attack.getTile(x, y).isHit()) {
			//if already hit, invalid move: return false
			System.out.println(this.getName() + ", bad shot Lose turn");
			return false;
		}
		//human so just shoot and display if good or not
		attack.getTile(x, y).updateHit(true);;
		if (attack.getTile(x, y).isOccupied()) {
			//if we hit a ship, return a good instance
			System.out.println("Good Shot!");
			return true;
		}
		else {
			System.out.println("Miss! ");
		}
		return false;
	}

}
