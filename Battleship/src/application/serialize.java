package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/***
 * 
 * @author JaydonS
 *
 */
public class serialize {

    //player data
    //string name, ship fleet[]

    //gameboard data
    //tile[][] board, int width = 10, int height = 10

    public serialize() {

    }

    //array list to store the gameboard and player objects
    ArrayList<gameBoard> gameBoards = new ArrayList<gameBoard>();
    ArrayList<player> players = new ArrayList<player>();

    //getting gameboard data
    public void getGameBoardsData (gameBoard gb) {
        gameBoards.add(gb);
    }

    //getting player data
    public void getPlayerData (player p) {
        players.add(p);
    }


    //saving data
    public void saveData() {
    try {
        FileOutputStream outStream = new FileOutputStream("data.dat");
        ObjectOutputStream ObjectOutStream = new ObjectOutputStream(outStream);
        ObjectOutStream.writeObject(gameBoards.get(0));
        ObjectOutStream.writeObject(gameBoards.get(1));
        ObjectOutStream.writeObject(players.get(0));
        ObjectOutStream.writeObject(players.get(1));
        ObjectOutStream.close();
        outStream.close();
        System.out.print("Data serialized ");
    }
}

    //loading data
    public void loadData() {
        ArrayList<Object> deserializedGb = new ArrayList<Object>();//deserialized gameboard arraylist
        ArrayList<Object> deserializedP = new ArrayList<Object>();//deserialized player arraylist

        //loading data
        try {
            FileInputStream inStream = new FileInputStream("data.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
            deserializedGb = (ArrayList<Object>)objectInputFile.readObject();
            deserializedP = (ArrayList<Object>)objectInputFile.readObject();
            objectInputFile.close();
            inStream.close();
        }
        catch (IOException e){ 
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }

        //instantiating data
        for(int i =0; i < 1; i++) {
        gameBoard[] retrievedGameBoards = (gameBoard[]) deserializedGb.get(i);
        System.out.println("Players Board: " + "width " + retrievedGameBoards[i].getWidth() + "height " + retrievedGameBoards[i].getHeight());
        retrievedGameBoards[i].printBoard();
        }

        //getting error
//        for(int i =0; i < 1; i++) {
//            gameBoard[] retrievedPlayers = (gameBoard[]) deserializedP.get(i);
//            System.out.println("Players: " + retrievedPlayers[i].getName());
//            System.out.println("Players: " + retrievedPlayers[i].getFleet());
//            }
    }
}