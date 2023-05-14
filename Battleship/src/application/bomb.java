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
<<<<<<< HEAD
		attack.getTile(x, y).setFill(Color.AQUA);
		if((x+1) <= 10) {
			attack.getTile(x+1, y).updateHit(true);
			attack.getTile(x+1, y).setFill(Color.AQUA);
			
			if((y+1) <= 10) {
				attack.getTile(x+1, y+1).updateHit(true);
				attack.getTile(x+1, y+1).setFill(Color.AQUA);
=======
		if(attack.hitAShip(x, y)) {
			attack.getTile(x, y).setFill(Color.ORANGE);
		}
		else {
			attack.getTile(x, y).setFill(Color.KHAKI);
		}
		if((x+1) <= 10) {
			attack.getTile(x+1, y).updateHit(true);
		
			
			if((y+1) <= 10) {
				attack.getTile(x+1, y+1).updateHit(true);
>>>>>>> acc7035f765cfaf57dff4344d5b4a6f4f5aa049b
				
			}
			if((y-1) >= 0) {
				attack.getTile(x+1, y-1).updateHit(true);
<<<<<<< HEAD
				attack.getTile(x+1, y-1).setFill(Color.AQUA);
=======
>>>>>>> acc7035f765cfaf57dff4344d5b4a6f4f5aa049b
			
			}
			
		}
		
		if((x-1) >= 0) {
			attack.getTile(x-1, y).updateHit(true);
<<<<<<< HEAD
			attack.getTile(x-1, y).setFill(Color.AQUA);
			
			if((y+1) <= 10) {
				attack.getTile(x-1, y+1).updateHit(true);
				attack.getTile(x-1, y+1).setFill(Color.AQUA);
=======
			
			
			if((y+1) <= 10) {
				attack.getTile(x-1, y+1).updateHit(true);
>>>>>>> acc7035f765cfaf57dff4344d5b4a6f4f5aa049b
				
			}
			if((y-1) >= 0) {
				attack.getTile(x-1, y-1).updateHit(true);
<<<<<<< HEAD
				attack.getTile(x-1, y-1).setFill(Color.AQUA);
=======
>>>>>>> acc7035f765cfaf57dff4344d5b4a6f4f5aa049b
				
			}
		}
		
		if((y+1) <= 10) {
			attack.getTile(x, y+1).updateHit(true);
<<<<<<< HEAD
			attack.getTile(x, y+1).setFill(Color.AQUA);
=======
			
>>>>>>> acc7035f765cfaf57dff4344d5b4a6f4f5aa049b
			
		}
			
		
		if((y-1) >= 0) {
			attack.getTile(x, y-1).updateHit(true);
<<<<<<< HEAD
			attack.getTile(x, y-1).setFill(Color.AQUA);
=======
			
>>>>>>> acc7035f765cfaf57dff4344d5b4a6f4f5aa049b
			
		}
		}
}
<<<<<<< HEAD
	
=======
	
>>>>>>> acc7035f765cfaf57dff4344d5b4a6f4f5aa049b
