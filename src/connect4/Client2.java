package connect4;
import javax.swing.*;
import java.net.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Client2  {
	
	
	String ip = Player.getPlayerIP();
	 String port = Player.getPlayerPort();
	 String username = Player.getPlayerIP();
	
		static Socket server = null;
	
	static protected boolean connectedClient = false;
	 static GridTest clientGrid = new GridTest();
	
/*	 
	public static void main(String[] args) throws ClassNotFoundException{
	
		new Client2();	
	
	}*/
	
public Client2() {
	System.out.println("Client is started");
	GridTest.clientConnected = true;
	this.receive();
}



public static  void sendToServer() throws ClassNotFoundException {
// hier datensendung ausführen mit actionlister, der auf die buttons von GridTest hört.	

	try {
		// send data to server
		ObjectOutputStream myoutput = new ObjectOutputStream(server.getOutputStream());
		myoutput.writeObject(GridTest.gamefield);
		System.out.println("Data was sent:");

		myoutput.flush();

	} catch (UnknownHostException e1) {
		e1.printStackTrace();
	} catch (IOException e1) {
		System.out.println(e1.getMessage());
	}

	
}

public void receive() {

	try {
		server = new Socket("localhost", 8086);
		
		while (true) {

			try {
				ObjectInputStream myinput = new ObjectInputStream(server.getInputStream());
				Object mymessage = myinput.readObject();
				
				GridTest.gamefield = (GridArray) mymessage;
				clientGrid.updateGrid();
				clientGrid.checkGrid();
			}
			catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
}

}

		
