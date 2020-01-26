package connect4;

import javax.swing.*;

import java.net.*;
import java.awt.Component;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClientTest {

	static protected ObjectOutputStream myoutput;
	static boolean connected = false;
	final GridTest grid = new GridTest();
	static Socket mysocket;

	 public static void main(String[] args) throws UnknownHostException, IOException {
	     
	  ClientTest client = new ClientTest();
	    
	      //test
	   }



public ClientTest() throws UnknownHostException, IOException {
	
	System.out.println("Client is connected");
    Window window1=new Window();
		
		window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
class Window extends JFrame{
	
	public Window(){
		
		setBounds(600,300,280,350);
				
		WindowClient winClient=new WindowClient();
		
		add(winClient);
		
		setVisible(true);
		}	
	
}

class WindowClient extends JPanel{
	
	public WindowClient(){
	
		JLabel text=new JLabel("CLIENT");
		
		add(text);
	
		
	
				
	
		JButton mybutton = new JButton("Send");
		
		SendText textfield= new SendText();
		
		mybutton.addActionListener(textfield);
		
		add(mybutton);	
		
	}
	
	public  boolean hostAvailabilityCheck() { 
	    try (Socket s = new Socket("localhost",9999)) {
	        return true;
	    } catch (IOException ex) {
	        /* ignore */
	    }
	    return false;
	}
	
private class SendText implements ActionListener {

	
		
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				Socket mysocket = new Socket("localhost",9999);
				ObjectOutputStream myoutput = new ObjectOutputStream(mysocket.getOutputStream());	
				myoutput.writeObject(GridTest.gamefield);
				System.out.println("Data was sent:");
				myoutput.flush();
				connected = true;
				mysocket.close();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
				//fall wenn client net connected -> dann server aufrufen.
				
			}// meine IP und eine freie Port
			
		}
		

public void sendData() {
	try {
		
		
		Socket mysocket = new Socket("localhost",9999);
		ObjectOutputStream myoutput = new ObjectOutputStream(mysocket.getOutputStream());	
		
		myoutput.writeObject(grid.gamefield);
		System.out.println("Data was sent:");
		myoutput.flush();
	
		
	} catch (UnknownHostException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		System.out.println(e1.getMessage());
		//fall wenn client net connected -> dann server aufrufen.
		
	}// meine IP und eine freie Port
}
}

	
}}

