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
			attack.getTile(m, i).setFill(Color.AQUA);
		}
		
	}
	
}
