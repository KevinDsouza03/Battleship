package application;

import javafx.scene.paint.Color;

public class rowAttack implements specialMove{
	/**
	 * attacks the whole row
	 */
	@Override
	public void specialAttack(int m, int n, gameBoard attack) {
		for(int i = 0; i < 10; i++) {
			attack.getTile(m, i).updateHit(true);
			if(attack.hitAShip(m, n)) {
				attack.getTile(m, i).setFill(Color.ORANGE);
			}
			else if(attack.getTile(m, i).isHit()) {
				attack.getTile(m, i).setFill(Color.KHAKI);
			}
		}
		
	}
	
}
