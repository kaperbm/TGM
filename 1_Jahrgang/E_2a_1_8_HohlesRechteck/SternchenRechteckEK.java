package sew_1chit;
/**
 * Die Klasse macht ein hohles Rechteck
 * @author Kacper Bohaczyk
 * @date 22-04-2022
 */
public class SternchenRechteckEK {
	/**
	 * Die main Klasse gibt das hohle Rechteck aus
	 * @param args Argumente
	 */
	public static void main(String[] args){
	    int hoehe = 5;  					// Die hoehe wird deklariert
	    int breite = 9;					// Die breite wird deklariert
	    hoehe = hoehe - 2;					// Die vollen Felder werden subtrahiert
	    
	    
        /* 
         * Es wird jetzt eine ganze Zeile von Sternchen ausgegeben 
         */
	        for(int laenge = breite;laenge > 0;laenge--){
	        	System.out.print('*');			// Gibt ein Sternchen aus
	        }	
	        
	        /* 
	         * Es werden jetzt die hohlen Zeilen des Rechteckes ausgegeben
	         */
	        System.out.println();					// Es wird jetzt eine neue Zeile erstellt (geht auch mit \n)
	        for(int hoehe2 = hoehe ;hoehe2 > 0;hoehe2-- ){		// Eine for schleife für die leeren Plätze
	        	int breiteOhneRand = breite - 2;		// Die umrandungen werden subtrahiert
	            System.out.print('*');				// Gibt ein Sternchen aus
	            while(breiteOhneRand > 0){				// Eine Schleife um das innere des Rechtecks mit Leerzeichen zu füllen 
	            	breiteOhneRand--;				// zieht 1 ab von breiteOhneRand
	                 System.out.print(' ');				// Gibt ein Leerzeichen aus
	            }
	            System.out.print('*');				// Gibt Sternchen aus
	            System.out.println();				// Macht eine neue Zeile
	        }
	        
	        /* 
	         * Es wird jetzt eine volle Zeile ausgegeben um das Rechteck zu Schließen 
	         */
	        for(int laenge = breite;laenge > 0;laenge--){
	        	System.out.print('*');				// Gibt ein Sternchen aus
	        }
	    }
}
