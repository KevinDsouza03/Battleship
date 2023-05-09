package application;
public class humanPlayer extends player{

	public humanPlayer() {
		super();
	}

	public humanPlayer(String n, ship[] f) {
		
	}
	@Override
	public boolean fire(int x, int y, gameBoard attack) {
		if (attack.getTileisHit(x, y)) {
			//if already hit, invalid move: return false
			return false;
		}
		//human so just shoot and display if good or not
		attack.setTileHit(x, y);
		if (attack.getTileisOccupied(x, y)) {
			//if we hit a ship, return a good instance
			return true;
		}
		return false;
	}

}
