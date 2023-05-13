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
	
	
	
    public void updateMove(int x, int y) {
        if (!playList.isEmpty()) {
            Pair<Integer, Integer> lastMove = playList.remove(playList.size()-1);
            x = lastMove.getKey();
            y = lastMove.getValue();
        }
    }
	/***
	 * This function works as a helper function to generate random ships and populate the computerPlayer calling it.
	 * It works by trying to place a ship 100 times (which will almost always result in placement), and then
	 * it creates a list of possible placements for both vertical and horizontal and checks if that is present
	 * occupiedTiles. If good placement and put that into ship and the occupiedTiles.
	 * Then keep going for other ships. If bad placement, check the next generated, valid location and
	 * continue 100 times.
	 * @return
	 */
    public computerPlayer generatePlayer() {
        // Generate fleet
        ship carrier = new ship(5);
        ship battleship = new ship(4);
        ship cruiser = new ship(3);
        ship submarine = new ship(3);
        ship destroyer = new ship(2);
        ship[] ships = {carrier, battleship, cruiser, submarine, destroyer};

        ArrayList<tile> occupiedTiles = new ArrayList<tile>();

        Random rand = new Random();

        for (ship currShip : ships) {
            boolean fits = false;
            int attempts = 0;

            while (!fits && attempts < 100) {
                attempts++;

                ArrayList<tile> potentialTiles = new ArrayList<tile>();

                // Place length 2 ships near the edges
                if (currShip.getLength() == 2) {
                    int x, y;
                    boolean horizontal;

                    if (rand.nextBoolean()) {
                        // Place horizontally on top or bottom row
                        y = rand.nextInt(2) * 9;
                        x = rand.nextInt(10 - currShip.getLength() + 1);
                        horizontal = true;
                    } else {
                        // Place vertically on left or right column
                        x = rand.nextInt(2) * 9;
                        y = rand.nextInt(10 - currShip.getLength() + 1);
                        horizontal = false;
                    }

                    for (int i = 0; i < currShip.getLength(); i++) {
                        if (horizontal) {
                            potentialTiles.add(new tile(x + i, y));
                        } else {
                            potentialTiles.add(new tile(x, y + i));
                        }
                    }
                } else {
                    // Place length 3 ships near the middle
                    int x = rand.nextInt(6) + 2;
                    int y = rand.nextInt(6) + 2;
                    boolean horizontal = rand.nextBoolean();

                    for (int i = 0; i < currShip.getLength(); i++) {
                        if (horizontal) {
                            potentialTiles.add(new tile(x + i, y));
                        } else {
                            potentialTiles.add(new tile(x, y + i));
                        }
                    }
                }

                // Check if all potential tiles are within the grid boundaries
                boolean outOfBounds = false;
                for (tile t : potentialTiles) {
                    if (t.x < 0 || t.x >= 10 || t.y < 0 || t.y >= 10) {
                        outOfBounds = true;
                        break;
                    }
                }
                if (outOfBounds) {
                    continue;
                }

                boolean tileConflict = false;
                for (tile t : potentialTiles) {
                    for (tile occupiedTile : occupiedTiles) {
                        if (t.x == occupiedTile.x && t.y == occupiedTile.y) {
                            tileConflict = true;
                            break;
                        }
                    }
                    if (tileConflict) {
                        break;
                    }
                }

                if (!tileConflict) {
                    for (tile t : potentialTiles) {
                        currShip.addLocation(t);
                        occupiedTiles.add(t);
                    }
                    fits = true;
                }
            }
        }
        for (ship t : ships) {
            for (tile d : t.getLocation()) {
                System.out.println(t.getLength() + " (" + d.x + ", " + d.y + ")");
            }
        }
        // Create the computer player and return it
        computerPlayer generatedPlayer = new computerPlayer("Computer", ships);
        return generatedPlayer;
    }

	
	@Override
	/***
	 * As this is the computer player, it makes informed decisions based on the last shot. If we hit, add adjacent shots and do not repeat already put shots.
	 */
	 public boolean fire(int x, int y, gameBoard attack) {
        played.add(new Pair<Integer,Integer>(x,y));
        attack.getTile(x, y).updateHit(true);;
        if (attack.getTile(x, y).isOccupied()) {
            System.out.println("Good shot Computer. Adding adjacency.");
            if (x+1 > 0 && y > 0 && !played.contains(new Pair<Integer,Integer>(x+1,y)) && (x+1 < 10 && y < 10)) {
                playList.add(new Pair<Integer,Integer>(x+1,y));
            }
            if (x-1 > 0 && y > 0 && !played.contains(new Pair<Integer,Integer>(x-1,y)) && (x-1 < 10 && y < 10)) {
                playList.add(new Pair<Integer,Integer>(x-1,y));
            }
            if (x > 0 && y+1 > 0 && !played.contains(new Pair<Integer,Integer>(x,y+1)) && (x < 10 && y+1 < 10)) {
                playList.add(new Pair<Integer,Integer>(x,y+1));
            }
            if (x > 0 && y-1 > 0 && !played.contains(new Pair<Integer,Integer>(x,y-1)) && (x < 10 && y-1 < 10)) { 
                playList.add(new Pair<Integer,Integer>(x,y-1));
            }
            return true;
        }
        System.out.println("Bad shot");
        return false;
    }
}

