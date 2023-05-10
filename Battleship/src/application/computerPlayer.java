package application;
import java.util.ArrayList;
import javafx.util.Pair;

public class computerPlayer extends player{
	
	ArrayList<Pair<Integer,Integer>> playList;
	ArrayList<Pair<Integer,Integer>> played;
	
	
	public computerPlayer() {
		super();
		playList = new ArrayList<Pair<Integer,Integer>>(); //initalize arraylist to store next hits with 10.
		//treat it as a stack so we can pop for the next good move and append the next good moves.
		played = new ArrayList<Pair<Integer,Integer>>();
	}
	
	public computerPlayer(String n,ship[] f) {
		super(n,f);
		playList = new ArrayList<Pair<Integer,Integer>>();
		played = new ArrayList<Pair<Integer,Integer>>();
	}
	
	@Override
	/***
	 * As this is the computer player, it makes informed decisions based on the last shot. If we hit, add adjacent shots and do not repeat already put shots.
	 */
	public boolean fire(int x, int y, gameBoard attack)  {
		//basically, if we already have a move in the list, theres a better move to do so do this move instead of the random x y passed in
		if (!playList.isEmpty()) {x = playList.get(playList.size()-1).getKey();
			y = playList.get(playList.size()-1).getValue();
			playList.remove(playList.get(playList.size()-1)); //pop from stack
		}
		//computer will be using prior hits to determine if they were good or not.
		//first, computer check if our last hit was good and with our x,y.
		played.add(new Pair<Integer,Integer>(x,y));
		attack.setTileHit(x, y);
		if (attack.getTileisOccupied(x, y)) {
			//if we hit a ship, a good hit. add these now to the arrayList for next iteration
			System.out.println("Good shot Computer. Adding adjacency.");
			if (x+1 > 0 && y > 0 && !played.contains(new Pair<Integer,Integer>(x+1,y))) {
				playList.add(new Pair<Integer,Integer>(x+1,y));
			}
			if (x-1 > 0 && y > 0 && !played.contains(new Pair<Integer,Integer>(x-1,y))) {
				playList.add(new Pair<Integer,Integer>(x-1,y));
			}
			if (x > 0 && y+1 > 0 && !played.contains(new Pair<Integer,Integer>(x,y+1))) {
				playList.add(new Pair<Integer,Integer>(x,y+1));
			}
			if (x > 0 && y-1 > 0 && !played.contains(new Pair<Integer,Integer>(x,y-1))) { 
				playList.add(new Pair<Integer,Integer>(x,y-1));
			}
			return true;
		}
		//empty move so we say its empty/bad move.
		return false;	
	}

}
