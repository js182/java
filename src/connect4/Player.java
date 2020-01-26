package connect4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Player {
	

	
	private static String playername;
	private static String playerIP;
	private static String playerPort;
	
	
	
	//getting username input from user and assigning it to player
	
	public String getPlayername() {
		
		return playername;
		
	}
	
	public void setPlayername(String username) {
		
		playername = username;
		
		
		
	}
	
	//getting ip adress from user input and assigning it to the player

	public void setPlayerIP(String ipadress) {
		
		this.playerIP = ipadress;
	
	}
	
	public static String getPlayerIP() {
		
		return playerIP;
		
		}

	
	//getting port number from user input
	
public void setPlayerPort(String portnumber) {
		
		this.playerPort = portnumber;
	
	}
	
	public static String getPlayerPort() {
		
		return playerPort;
	}



	
	
	
	//just for testing
		public void printplayerInfo() {
			
			System.out.println("Spielername: " + playername);
			System.out.println("IP Adress of Player 1: " + playerIP);		
			System.out.println("Port Number of Player 1: " + playerPort);
		
		
		}
		

		public void newGrid() {
		GridTest testgrid = new GridTest();
		}

//füg mal hier dein zeug ein wir commiten zsm dann ist auf dem anderen lapi alles komme gerade net da ran wenn ich morgen alles reinfüge kannst du ja schnell commiten


//jetzt haste zugriff aufd alles








}