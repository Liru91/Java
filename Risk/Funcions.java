package FuncionsRisk;

import java.util.Random;
import java.util.Scanner;

public class Funcions {
	public static int[][] informeJugador(int numJugador,String nomsJugadors[], int infoJugadors[][],int exercits){
		//Assignar objetiu
		Random random = new Random();
		int var=random.nextInt(2);
		System.out.println(var);
		infoJugadors[numJugador][0]= var;//guarda objectiu al array
		System.out.println("El objectiu del jugador " +nomsJugadors[numJugador]+" sera "+objectius[infoJugadors[numJugador][0]]);
		//Asignar exercits a infojugadors
		infoJugadors[numJugador][1]=exercits;//guardar quantitat exercits total
		return infoJugadors;
	}
	public static String[] nombrarJugador(int numJugador,String nomsJugadors[]) {
		//Demanar el nom i guardar-ho en el vector
		System.out.println("Quin sera el nom del jugador " +numJugador);
		Scanner lector = new Scanner(System.in);
		String nomJugador = lector.next();
		nomsJugadors[numJugador] = nomJugador;//guardar el nom del jugador al array
		System.out.println("Dacord el nom del jugador " +numJugador+" sera "+nomsJugadors[numJugador]);
		return nomsJugadors;//retornara nomes el nomsJugadors
	}
}
