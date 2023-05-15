package application;

import java.io.Serializable;

import javafx.scene.paint.Color;
/***
 * 
 * @author vanessali
 *
 */
public class rowAttack implements specialMove, Serializable{
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
