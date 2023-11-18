public class GameOfLife {
	boolean[] [] feld = {
			{false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false},
			{false, false, false, true, false, false, false},
			{false, false, false, true, false, false, false},
			{false, false, true, true, true, false, false},
			{false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false} 
	};
	
	void print(){
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				if (feld[i][j]) {
					System.out.print(" o ");
				} else {
					System.out.print(" . ");
				}
			}
			System.out.println();
		}
	}
	
	 void nextGeneration() {
		    // Neues Array anlegen. Dabei sind alle Werte bereits mit false initialisiert.
		    boolean[][] newFeld = new boolean[feld.length][feld[0].length];
		    // Ueber Nicht-Rand-Felder iterieren
		    for (int i = 1; i < feld.length - 1; i++) {
		      for (int j = 1; j < feld[i].length - 1; j++) {
		        // Berechnen der Anzahl der lebenden Nachbarn, die eigene Zelle mitgezaehlt
		        int nachbarn = 0;
		        for (int k = i - 1; k <= i + 1; k++) {
		          for (int l = j - 1; l <= j + 1; l++) {
		            if (feld[k][l]) nachbarn++;
		          }
		        }
		        // Lebende Zellen mit 2 oder 3 Nachbarn (+ der eigenen Zelle) leben weiter
		        if (feld[i][j] && (nachbarn == 3 || nachbarn == 4)) {
		          newFeld[i][j] = true;
		        } else {
		          // Tote Zellen mit exakt drei Nachbarn erwachen zum Leben
		          if (!feld[i][j] && nachbarn == 3) {
		            newFeld[i][j] = true;
		          }
		        }
		      }
		    }
		    feld = newFeld;
	 }
	public static void main(String[] args) {
		GameOfLife myGame = new GameOfLife();
		for(int i = 0; i < 10; i++) {
			myGame.nextGeneration();
			myGame.print();
			System.out.println();
		}
	}
}
