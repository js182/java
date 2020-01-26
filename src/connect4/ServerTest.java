package connect4;
import javax.swing.*;
import java.net.*;

import java.awt.*;
import java.io.*;

public class ServerTest  {
	private static char [][] spot = new char [6][7];
	GridTest game = new GridTest();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerTest test = new ServerTest();
	}	



public ServerTest() {
	WindowServer mywindow=new WindowServer();
	
	mywindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
class WindowServer extends JFrame implements Runnable  {
	
	public WindowServer(){
		
		setBounds(1200,300,280,350);				
			
		JPanel newpanel= new JPanel();
		
		newpanel.setLayout(new BorderLayout());
		
		textarea=new JTextArea();
		
		newpanel.add(textarea,BorderLayout.CENTER);
		
		add(newpanel);
		
		setVisible(true);
		
		Thread mythread = new Thread(this);
		
		mythread.start();
		
		}
	
	private	JTextArea textarea;

	
	
	@Override
	public void run() {
		
		try {
			ServerSocket server=new ServerSocket(9999);//port öfnnen listen und Verbindungen akzeptieren
			
			while(true) {
			Socket mysocket= server.accept();
			
			
			ObjectInputStream myinput=new ObjectInputStream(mysocket.getInputStream());
			Object mymessage = myinput.readObject();
			game.gamefield = (GridArray)mymessage; //-<< save object into gamefield
			textarea.append("\n" + mymessage);
			System.out.println(mymessage);
			System.out.println("Data recieved...");
			game.updateGrid();
			mysocket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}}