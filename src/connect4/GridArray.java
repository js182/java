package connect4;
import java.io.Serializable;
import java.util.Arrays;
import java.util.StringJoiner;
public  class GridArray implements Serializable {
	
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	char[][] gameGridArray =  {
			{'-','-', '-', '-', '-', '-', '-'},
			{'-','-', '-', '-', '-', '-', '-'},
			{'-','-', '-', '-', '-', '-', '-'},  //spielfeld
			{'-','-', '-', '-', '-', '-', '-'},
			{'-','-', '-', '-', '-', '-', '-'},
			{'-','-', '-', '-', '-', '-', '-'}};
	public  GridArray() {
		printArray();
	}
	
	
//getter und setter
	
	
public void setArray(char box, int x) {
	for(int i=gameGridArray.length-1;i>=0;i--) {
		if(gameGridArray[i][x]=='-') {
			this.gameGridArray[i][x] = box;
			return;
		}
	}
	System.err.println("Hier kann nicht nochmal gesetzt werden, da die max. Hoehe erreicht wurde.");

	}
	
public char getArray(int y, int x){
	return gameGridArray[y][x];
}

	
//override toString for testing purposes, for printing the object when sent through socket in console or textarea etc.
	
@Override

public String toString(){
StringJoiner sj = new StringJoiner(System.lineSeparator());
for (char[] row : gameGridArray) {
    sj.add(Arrays.toString(row));
}
String s = sj.toString();
	return s;
	
}
	
	///////////////////////////////////
	public void printArray() {
	
	System.out.println("");
	
//print the array in console 
	for(int i = 0; i < gameGridArray.length; i++) { 
		for (int j = 0; j < gameGridArray[i].length; j++) {
			System.out.print(gameGridArray[i][j] + " ");
		}
		System.out.println("");
		
		
		
	}
	System.out.println("_____________"); // for better visual display in consoleAfter
}

}