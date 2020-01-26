package connect4;


public class  GameRules{
	
	protected static boolean check = false;
	protected static boolean draw = false;
	
	private static char [][] spot = new char [6][7];
	protected static boolean yourTurn = true; 
	protected static boolean enemyTurn = false;
	protected static boolean colorSwitch = true;
	
	
	/*
	
	false = yellow // true = red ->  if playerSwitch false= make buttons for other player not clickable
	*/

	static int roundsPlayed = 0;

	
	
	
	
	
	//console output for testing
	public static void WinOrNot() {
	System.out.println("");
	System.out.printf("Round:" + roundsPlayed);
	System.out.println("");
	System.out.print("Win? :");
	if(check == true) {
		System.out.print("YES");
	}
	
	else {
		System.out.print("NO");
	}
	System.out.println("");
}
	
	
	
public static void gridSpot(){
	
	//use gridSpot array as storage, copy gotten array elements into it.

	for (int column=0; column<6; column++) {
		for (int row=0; row<7; row++){
			char element = GridTest.gamefield.getArray(column, row);
			spot[column][row]= element;
    	}
     }
}

public GameRules() {
	gridSpot();
	
	
}

//for switching val for test
public void changeCheck() { //zum testen
	if (check == true) {
		check = false;
	}
		
}




public void printGridSpot() {
	// console output of array 
	for(int i = 0; i < spot.length; i++) {
		for (int j = 0; j < spot[i].length; j++) {
			System.out.print(spot[i][j] + " ");
		}
		System.out.println("");
		
		
		
	}
}




public static  void  winCheck() {
	
	checkYellow();
	checkRed();
	checkDraw();
	WinOrNot();
	//run produceEndscreen here
	
}

/* IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * in the following context of code columns = rows and rows = columns. Basically the opposite, the code works as intended tho.
 */
public static void checkYellow() {
	gridSpot(); //aktualise gridSpot 
	
	
		//Horizonal fuer gelb
        for (int column= 0; column<6; column++){
        	for (int row=0; row<4; row++) {
        	
        	if (	spot[column][row] == 'X' 
        			&& spot[column][row+1] == 'X'
        			&& spot[column][row+2] == 'X'
        			&& spot[column][row+3] == 'X') {
        					check=true;
        			  }
        			 }
        		  }
          //vertical
  for  (int column=0; column <3; column++) {
	  for (int row=0; row<7; row++) {
		  if( spot [column][row] == 'X'
			    && spot[column+1][row] == 'X'
        		&& spot[column+2][row] == 'X'
        		&& spot[column+3][row] == 'X') {
			  		check=true;
		  }
	  }
	  
  }  
  //diagonal up
  for  (int column=0; column <3; column++) {
	  for (int row=0; row<4; row++) {
		  if( spot [column][row] == 'X'
			    && spot[column+1][row + 1] == 'X'
        		&& spot[column+2][row + 2] == 'X'
        		&& spot[column+3][row + 3] == 'X') {
			  		check=true;
			  	}
		  
	  }
  }

  //diagonal down
  
  for  (int column=0; column <6; column++) {
	  for (int row=0; row<4; row++) {
		  if( spot [column][row] == 'X') {
			  if(column> 2
		  
			    && spot[column-1][row +1] == 'X'
        		&& spot[column-2][row +2] == 'X'
        		&& spot[column-3][row +3] == 'X') {
			  	check=true;
		  
			  }
	      }
	  }
}
  
}

  public static void checkRed() {
		gridSpot();
		
		
			//Horizonal fuer rot
	        for (int column= 0; column < 6; column++){
	        	for (int row=0; row<4; row++) {
	        	
	        	if (	spot[column][row] == '0' 
	        			&& spot[column][row+1] == '0'
	        			&& spot[column][row+2] == '0'
	        			&& spot[column][row+3] == '0') {
	        					check=true;
	        			        }
	        			   }
	        		  }
	          //vertical
	  for  (int column=0; column <3; column++) {
		  for (int row=0; row<7; row++) {
			  if( spot [column][row] == '0'
				    && spot[column+1][row] == '0'
	        		&& spot[column+2][row] == '0'
	        		&& spot[column+3][row] == '0') {
				  		check=true;
			  }
		  }
		  
	  }  
	  //diagonal left up
	 for  (int column=0; column <3; column++) {
		  for (int row=0; row<4; row++) {
			  if( spot [column][row] == '0'
				    && spot[column+1][row + 1] == '0'
	        		&& spot[column+2][row + 2] == '0'
	        		&& spot[column+3][row + 3] == '0') {
				  		check=true;
			  }
		  }
		  
	  }
	 
	  //diagonal right up
	 for  (int column=0; column <6; column++) {
		  for (int row=0; row<4; row++) {
			  if( spot [column][row] == '0') {
				  if(column > 2
			  
				    && spot[column -1 ][row + 1] == '0'
	        		&& spot[column -2][row +2] == '0'
	        		&& spot[column -3][row +3] == '0') {
				  	check=true;
			  
				  }
		     }
		}
	}
	  
	  
	  }


public static void checkDraw() {
	if(roundsPlayed >= 41) {
		System.out.print("DRAWWWW");
	}
	
}


}
 /* public static void checkDraw() {
	  gridSpot();
	  if(check == true) {
		  System.out.println("DRAWWWW");
	  }
	  for (int column=0;column >=7;column++) {
		  for (int row=0;row >=7; row++) {
			  if(spot[column][row]!= '-') {
				  check=true;
			  }
				  
		  }
	  }
  }

}
//CLASS GAMERULES

/*
public static void main(String[] args) {
   GameRules logic = new GameRules();
	logic.timerCheckGrid();
    
 }

}
   */









//<<<<<<< HEAD

//Muss PlayerId einsetzen um zu gucken wer immer dran ist, aber auch nochmal nachgucken
/*
 * while (true) {
 *    if(playerId == 1) {
 *    playerId= 2;
 *    }
 *    else{
 *    playerId = 1;
 *    }
 *    */

//Farbe bin ich mir net sicher ob es so klappt muss nochmal nachgucken
/*
 * if(playerId ==1)
 * playerId.setColor (color.red);
 * }
 * else
 * {
 * playerId.setColor (color.yellow);
 * }
 * */
/*=======
}


>>>>>>> branch 'master' of https://github.com/pisonmison/java.git
*/