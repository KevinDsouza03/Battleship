package application;
public class humanPlayer extends player{

	public humanPlayer() {
		super();
	}

	public humanPlayer(String n, ship[] f) {
		super(n,f);
	}
	@Override
	public boolean fire(int x, int y, gameBoard attack) {
		if (attack.getTileisHit(x, y)) {
			//if already hit, invalid move: return false
			System.out.println(this.getName() + ", bad shot Lose turn");
			return false;
		}
		//human so just shoot and display if good or not
		attack.setTileHit(x, y);
		if (attack.getTileisOccupied(x, y)) {
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
