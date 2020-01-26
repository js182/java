


//////////////////////


package connect4;



import java.net.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Server2 {
	
	
	

	GridTest serverGrid = new GridTest();
	/*public static void main(String[] args) throws ClassNotFoundException, IOException {
				
		new Server2();
		
	}	*/
	
	static Socket client_socket = null;

public Server2() {
	
	initServer();
}

public void initServer() {
	
	
	
	try {
		ServerSocket server = new ServerSocket(8086);

		serverGrid.serverConnected = true;
		System.out.println("server laeuft");

		while (true) {

			try {
				client_socket = server.accept();

				while (true) {
					ObjectInputStream myinput = new ObjectInputStream(client_socket.getInputStream());
					Object mymessage = myinput.readObject();
					GridTest.gamefield = (GridArray) mymessage;
					serverGrid.updateGrid();
					serverGrid.checkGrid();
				}
			}

			catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

}

public static void send2client() {

	try {
		ObjectOutputStream myoutput = new ObjectOutputStream(client_socket.getOutputStream());

		myoutput.writeObject(GridTest.gamefield);
		myoutput.flush();
	} catch (Exception e) {
		System.out.println("fuck");
		e.printStackTrace();
	}

}


}
	
	
