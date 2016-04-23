package package2;

import java.util.Scanner;

public class MitjanaTresMaxims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lector = new Scanner(System.in);
		int array[] = new int [10];
		  for(int i=0;i<10;i++){
			System.out.println("Diguem un numero");
			int num= lector.nextInt();
			array[i] =num;
		  }
			System.out.println("La media dels numeros es: "+media(array));

	}

	private static double media(int[] array) {
		double media = 0.0;
		for (int i=0; i < array.length; i++) {
			 media = media + array[i];
			}
		media = media / array.length;
		return media;
	}

}
