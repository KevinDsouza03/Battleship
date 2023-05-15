package application;

import java.io.Serializable;

import javafx.scene.paint.Color;
/***
 * 
 * @author vanessali
 *
 */
public class bomb implements specialMove, Serializable{
	/**
	 * attacks tiles around chosen tile
	 */
	@Override
	public void specialAttack(int x, int y, gameBoard attack) {
		// TODO Auto-generated method stub
		attack.getTile(x, y).updateHit(true);
		attack.getTile(x, y).setFill(Color.AQUA);
		if((x+1) <= 10) {
			attack.getTile(x+1, y).updateHit(true);
			attack.getTile(x+1, y).setFill(Color.AQUA);
			
			if((y+1) <= 10) {
				attack.getTile(x+1, y+1).updateHit(true);
				attack.getTile(x+1, y+1).setFill(Color.AQUA);
				
			}
			if((y-1) >= 0) {
				attack.getTile(x+1, y-1).updateHit(true);
				attack.getTile(x+1, y-1).setFill(Color.AQUA);
			
			}
			
		}
		
		if((x-1) >= 0) {
			attack.getTile(x-1, y).updateHit(true);
			attack.getTile(x-1, y).setFill(Color.AQUA);
			
			if((y+1) <= 10) {
				attack.getTile(x-1, y+1).updateHit(true);
				attack.getTile(x-1, y+1).setFill(Color.AQUA);
				
			}
			if((y-1) >= 0) {
				attack.getTile(x-1, y-1).updateHit(true);
				attack.getTile(x-1, y-1).setFill(Color.AQUA);
				
			}
		}
		
		if((y+1) <= 10) {
			attack.getTile(x, y+1).updateHit(true);
			attack.getTile(x, y+1).setFill(Color.AQUA);
			
		}
			
		
		if((y-1) >= 0) {
			attack.getTile(x, y-1).updateHit(true);
			attack.getTile(x, y-1).setFill(Color.AQUA);
			
		}
		}
}
	
