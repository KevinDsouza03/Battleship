package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.io.Serializable;

public class serialize implements Serializable {

    //player data
    //string name, ship fleet[]

    //gameboard data
    //tile[][] board, int width = 10, int height = 10

    public serialize() {

    }

    gameBoard humanBoard;
    gameBoard computerBoard;
    player humanPlayer;
    player computerPlayer;

    //array list to store the gameboard and player objects
    //ArrayList<gameBoard> gameBoards = new ArrayList<gameBoard>();
    //ArrayList<player> players = new ArrayList<player>();

    //getting gameboard data
//    /public void getGameBoardsData (gameBoard gb) {
//        gameBoards.add(gb);
//    }
//
//    //getting player data
//    public void getPlayerData (player p) {
//        players.add(p);
//    }/

    public void getGameHumanBoardsData (gameBoard gb) {
        //gameBoards.add(gb);
        humanBoard = gb;
    }

    public void getGameComputerBoardsData (gameBoard gb) {
        //gameBoards.add(gb);
        computerBoard = gb;
    }

    public void getGameComputerPlayerData (player p) {
        //gameBoards.add(gb);
        computerPlayer = p;
    }

    public void getGameHumanPlayerData (player p) {
        //gameBoards.add(gb);
        humanPlayer = p;
    }
//saving data
    public void saveData() {
        //ArrayList<Object> serilaizedata = new ArrayList<Object>();
        //serilaizedata.add(gameBoards);
        //serilaizedata.add(players);

    try {
        FileOutputStream outStream = new FileOutputStream("data.dat");
        ObjectOutputStream ObjectOutStream = new ObjectOutputStream(outStream);
        //ObjectOutStream.writeObject(serilaizedata);
        ObjectOutStream.writeObject(humanBoard);
        ObjectOutStream.writeObject(computerBoard);
        ObjectOutStream.writeObject(humanPlayer);
        ObjectOutStream.writeObject(computerPlayer);
        ObjectOutStream.close();
        outStream.close();
        System.out.print("Data serialized");
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    }

    //loading data
    public player loadHuman() {
    	try {
       	 FileInputStream inStream = new FileInputStream("data.dat");
         ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
         humanPlayer deserializedHumanPlayer = (humanPlayer) objectInputFile.readObject();
         objectInputFile.close();
         inStream.close();
         return deserializedHumanPlayer;
    	}
    	catch (Exception e){e.printStackTrace();}
		return null;
    }
    
    public player loadComputer() {
    	try {
       	 FileInputStream inStream = new FileInputStream("data.dat");
         ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
         computerPlayer deserializedComputerPlayer = (computerPlayer) objectInputFile.readObject();
         objectInputFile.close();
         inStream.close();
         return deserializedComputerPlayer;
    	}
    	catch (Exception e){e.printStackTrace();}
    	return null;
    }
    public gameBoard loadHumanBoard() {
    	try {
       	 FileInputStream inStream = new FileInputStream("data.dat");
         ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
         gameBoard deserializedHumanBoard = (gameBoard) objectInputFile.readObject();
         objectInputFile.close();
         inStream.close();
         return deserializedHumanBoard;
    	}
    	catch (Exception e){e.printStackTrace();}
		return null;
    }
    
    public gameBoard loadComputerBoard() {
    	try {
       	 FileInputStream inStream = new FileInputStream("data.dat");
         ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
         gameBoard deserializedComputerBoard = (gameBoard) objectInputFile.readObject();
         objectInputFile.close();
         inStream.close();
         return deserializedComputerBoard;
    	}
    	catch (Exception e){e.printStackTrace();}
		return null;
    }
    public void loadData() {
        //ArrayList<Object> deserializedData = new ArrayList<Object>();
        //loading data
        try {
            FileInputStream inStream = new FileInputStream("data.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
            gameBoard deserializedHumanBoard = (gameBoard) objectInputFile.readObject();
            gameBoard deserializedComputerBoard = (gameBoard) objectInputFile.readObject();
            player deserializedHumanPlayer = (player) objectInputFile.readObject();
            player deserializedComputerPlayer = (player) objectInputFile.readObject();
            gameBoard retrievedHumanBoard = deserializedHumanBoard;
            gameBoard retrievedComputerBoard = deserializedComputerBoard;
            player retrievedHumanPlayer = deserializedHumanPlayer;
            player retrievedComputerPlayer = deserializedComputerPlayer;

            System.out.println("Human player: " + retrievedHumanPlayer.getName());
            System.out.println("Human player Board: ");
            retrievedHumanBoard.printBoard();

            System.out.println("Computer player: " + retrievedComputerPlayer.getName());
            System.out.println("Computer player Board: ");
            retrievedComputerBoard.printBoard();
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



        }

    }