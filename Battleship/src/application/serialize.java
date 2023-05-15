package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
        ArrayList<Object> serilaizedata = new ArrayList<Object>();
        serilaizedata.add(gameBoards);
        serilaizedata.add(players);

    try {
        FileOutputStream outStream = new FileOutputStream("data.dat");
        ObjectOutputStream ObjectOutStream = new ObjectOutputStream(outStream);
        ObjectOutStream.writeObject(serilaizedata);
        ObjectOutStream.close();
        outStream.close();
        System.out.print("Data serialized");
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    }
//loading data
    public void loadData() {
        ArrayList<Object> deserializedData = new ArrayList<Object>();
        //loading data
        try {
            FileInputStream inStream = new FileInputStream("data.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
            deserializedData = (ArrayList<Object>)objectInputFile.readObject();
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

        //deserialized data
        gameBoard[] retrievedGameBoards = (gameBoard[]) deserializedData.get(0);
        player[] retrievedPlayers = (player[]) deserializedData.get(1);

        //printing players and their boards
        for(int i =0; i < retrievedPlayers.length; i++) {
            System.out.println("Player: " + retrievedPlayers[i].getName());
            System.out.println("Player fleet: " + retrievedPlayers[i].getFleet());
            //System.out.println("Players Board: " + "width " + retrievedGameBoards[i].getWidth() + "height " + retrievedGameBoards[i].getHeight());
            System.out.println("Players Board");
            retrievedGameBoards[i].printBoard();

        }

    }
}