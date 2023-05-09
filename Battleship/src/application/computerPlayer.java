package application;


public class computerPlayer extends player{
	
	
	
	public computerPlayer() {
		super();
	}
	
	public computerPlayer(String n,ship[] f) {
		super(n,f);
	}

	@Override
	public boolean fire(int x, int y, gameBoard attack)  {
		//computer will be using prior hits to determine if they were good or not.
		//first, computer check if our last hit was good and with our x,y.
		if (attack.getTileisHit(x, y)) {
			//if already hit, invalid move: return false
			return false;
		}
		attack.setTileHit(x, y);
		if (attack.getTileisOccupied(x, y)) {
			//if we hit a ship, a good instance
			return true;
		}
		return false;
		 
		
	}

}
