package application;
import java.util.ArrayList;
import javafx.util.Pair;
import java.util.Random;

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
	
	
	/***
	 * This function works as a helper function to generate random ships and populate the computerPlayer calling it.
	 * It randomly generates boolean to determine orientation, a number within the bounds of the board,
	 * and then checks if the coordinates are occupied or illegal. If they are, repeat above
	 * Otherwise, the fits variable is allowed and will then update a holdLocation ArrayList<tile> that populates
	 * the temp, which represents the fleet of the player superclass.
	 * @return
	 */
	public computerPlayer generatePlayer() {
	    // Generate fleet
	    ship carrier = new ship(5);
	    ship battleship = new ship(4);
	    ship cruiser = new ship(3);
	    ship submarine = new ship(3);
	    ship destroyer = new ship(2);
        ArrayList<tile> holdLocation = new ArrayList<tile>();
	    ship[] temp = {carrier, battleship, cruiser, submarine, destroyer};
	    
	    Random rand = new Random();
	    for (int i = 0; i < 5; i++) {
	        boolean fits = false;
	        while (!fits) {
	            fits = true;
	            int x = rand.nextInt(10);
	            int y = rand.nextInt(10); //select two random coordinates. now check originally if any other ships have them.
	            boolean horizontal = rand.nextBoolean(); // determine if our ship will be horizontal or not
	            if ( horizontal && x + temp[i].getLength() <= 10) {
	                for (int j = 0; j < i; j++) {
	                    for (tile t : temp[j].getLocation()) { /**
	                     loop through all initialized ships to check if coordinates are good*/
	                        for (int jumps = 0; jumps < temp[i].getLength(); jumps++) {
	                            if (x+jumps == t.x && y == t.y) {
	                                fits = false;
	                                break;
	                            }
	                        }
	                        if (!fits) {
	                            break;
	                        }
	                    }
	                    if (!fits) {
	                        break;
	                    }
	                }
	                if (fits) {
	                    /**
	                     * every check passed, so populate
	                     */
	                    for (int jumps = 0; jumps < temp[i].getLength(); jumps++) {
	                        tile tempTile = new tile(x+jumps,y);
	                        tempTile.updateOccupied(true);
	                        holdLocation.add(tempTile);
	                    }
	                }
	            }
	            else if (!horizontal && y + temp[i].getLength() <= 10) {/***
	             check for y fit
	             */
	                for (int j = 0; j < i; j++) {
	                    for (tile t : temp[j].getLocation()) { /***
	                     loop through all initialized ships to check if coordinates are good*/
	                        for (int jumps = 0; jumps < temp[i].getLength(); jumps++) {
	                            if (x == t.x && y+jumps == t.y) {
	                                fits = false;
	                                break;
	                            }
	                        }
	                        if (!fits) {
	                            break;
	                        }
	                    }
	                    if (!fits) {
	                        break;
	                    }
	                }
	                if (fits) {
	                    /***
	                     * every check passed, so populate
	                     */
	                    for (int jumps = 0; jumps < temp[i].getLength(); jumps++) {
	                        tile tempTile = new tile(x,y+jumps);
	                        tempTile.updateOccupied(true);
	                        holdLocation.add(tempTile);
	                    }
	                }
	            }
	        }
	        /***
	         * Add the ship's tiles to the ship's location list and clear the holdLocation list for next iteration
	         */
	        for (tile goodTile : holdLocation) {
	            temp[i].addLocation(goodTile);
	        }
	        holdLocation.clear();
	    
	    }

	    // Create the computer player and return it
	    computerPlayer generatedPlayer = new computerPlayer("Computer", temp);
	    return generatedPlayer;
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
		System.out.println("Bad shot");
		return false;	
	}

}
