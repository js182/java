package connect4;

import java.io.IOException;
import java.net.UnknownHostException;

public class Connect4 {
	
/* diese klasse wird aufgerufen, wenn erfolgreiche verbindung zum server besteht
 * wir müssen einen spieler erzeugen, wenn verbindung erfolgt und das display.
 * wenn spieler 2 sich verbinden will, müssen wir prüfen ob das objekt spieler1 bereits exestiert
 * und dann einen ein neun spieler2 erzeugen + neues feld2 etc. damit wir unterscheiden können, welches spiefeld zu welchem spieler
 * gehört etc und zugriff haben auf daten von spieler1 und spieler2, sowie deren spielfeld1 und spielfeld2! das geht ez mit if-abfrage!
 * 
 * -> counter für objekte einbauen, wenn counterPlayeranzahl = 1 , dann gibts Spieler1 schon -> so in etwa
 * 
 * connect4 klasse mit server/client verbinden -> vllt ruf client einmal Connec4 auf und einmal Server?
 * 
 * herausfinden, wie man das macht!
 * 
 * -> übertragung von informationen von spielfeld1 zu spielfeld 2 nach jeder runde! -> aktualliserung des spielfelds!
 * 
 * -> farbe über boolen bestimmen = wenn spieler1 farbe = true -> farbe1 und dann automatisch mit if abfrage dem spieler2 false geben ->farbe2
 * 
 * -> 
 * 
 * 
 */static protected GridTest test;
	
	 
 public Connect4() throws ClassNotFoundException{
	 run();
 }
 
 public void run() throws ClassNotFoundException  {
	 	 
	  GridTest test = new GridTest();
		Client2 client = new Client2();
		//oder Server <- the way to go. Nicht grid in server erzeugen.
	 
 }
 
 public static void main(String[] args) throws ClassNotFoundException {
	      
	Connect4 game = new Connect4();
	


}}
