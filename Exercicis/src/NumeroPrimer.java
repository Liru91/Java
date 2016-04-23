package package2;

import java.util.Scanner;

public class NumeroPrimer {

	public static void main(String[] args) {
		   Scanner lector = new Scanner(System.in);
		   System.out.println("Diguem un numero");
			int num= lector.nextInt();
			EsPrimer(num);
			System.out.println(EsPrimer(num));

	}

	private static boolean EsPrimer(int num) {
		int contador = 2;
		boolean primo=true;
		 
		while ((primo) && (contador!=num)){
		  if (num % contador == 0)
		    primo = false;
		  contador++;
		}
		return primo;
		
	}

}
