package Recursivitat;

import java.util.Scanner;

public class ValorMin {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		System.out.println("Escogeix dos numeros entre 3, 6, 10 i 15");
		System.out.println("Primer numero");
		int a= lector.nextInt();
		System.out.println("Segon numero");
		int b= lector.nextInt();
		//Paràm. entrada: els valors a tractar són dos enters
		//Paràm. sortida: el mínim entre els dos, un enter
		int res = minim(a,b);
		System.out.println(res+" es mes petit");

		
	}
	public static int minim (int a, int b) {
		//"a" i "b" contenen els valors a tractar
		int min = b;
		if (a < b) {
		min = a;
		}
		//"min" conté el resultat
		return min;
		}
}
