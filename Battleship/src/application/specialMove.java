package application;
/***
 * 
 * @author vanessali
 *
 */
public interface specialMove {
	/***
	 * defines the specialMoves/powerups for humanPlayer use.
	 * @param m x
	 * @param n y
	 * @param attack board To attack
	 */
	public void specialAttack(int m, int n, gameBoard attack);
}
