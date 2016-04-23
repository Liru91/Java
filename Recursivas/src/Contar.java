	package Recursivitat;
	
	import java.util.Scanner;
	
	public class Contar {
		public static void main(String[] args) {
			Scanner lector = new Scanner(System.in);
			System.out.println("inserta un numero");
			int numero = lector.nextInt();
			int x=1;
			calcula(numero, x);
	
		}
		public static void calcula(int numero,int x){
			if (x<=numero){
				System.out.print("*");
			calcula(numero,x+1); 
			}
		}
	}
