package application;
import java.util.Scanner;
public class humanPlayer extends player{

	public humanPlayer() {
		
	}

	@Override
	public void fire() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Where to shoot? x y");
		//Unaware of how to ask for input. If i ask for input in the function, how do we implement with javaFX?
		//if I take it in from the function, is there anypoint for abstract? Unless theres a different function such as
		// play() or something.
	}

}
