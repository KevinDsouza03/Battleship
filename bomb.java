package application;

import javafx.scene.paint.Color;

public class bomb implements specialMove{
	/**
	 * attacks tiles around chosen tile
	 */
	@Override
	public void specialAttack(int x, int y, gameBoard attack) {
		// TODO Auto-generated method stub
		attack.getTile(x, y).updateHit(true);
		if(attack.hitAShip(x, y)) {
			attack.getTile(x, y).setFill(Color.ORANGE);
		}
		else {
			attack.getTile(x, y).setFill(Color.KHAKI);
		}
		if((x+1) < 10) {
			attack.getTile(x+1, y).updateHit(true);
			if(attack.hitAShip(x+1, y)) {
				attack.getTile(x+1, y).setFill(Color.ORANGE);
			}
			else {
				attack.getTile(x+1, y).setFill(Color.KHAKI);
			}
			
		}
		
		if((x-1) > 0) {
			attack.getTile(x-1, y).updateHit(true);
			if(attack.hitAShip(x-1, y)) {
				attack.getTile(x-1, y).setFill(Color.ORANGE);
			}
			else {
				attack.getTile(x-1, y).setFill(Color.KHAKI);
			}
		}
		
		if((y+1) < 10) {
			attack.getTile(x, y+1).updateHit(true);
			if(attack.hitAShip(x, y+1)) {
				attack.getTile(x, y+1).setFill(Color.ORANGE);
			}
			else  {
				attack.getTile(x, y+1).setFill(Color.KHAKI);
			}
		}
		
		if((y-1) > 0) {
			attack.getTile(x, y-1).updateHit(true);
			if(attack.hitAShip(x, y-1)) {
				attack.getTile(x, y-1).setFill(Color.ORANGE);
			}
			else {
				attack.getTile(x, y-1).setFill(Color.KHAKI);
			}
		}
	}

}
