package Recursivitat;
import java.util.Arrays;
import java.util.Scanner;

public class FraseAmbMesAs {
	public static void main(String[] args) {
	
		int contador2=0;
		char[]comparaFrases = null;
		frases(contador2,comparaFrases);
	}
	public static void frases(int contador2,char[]comparaFrases){
		int contador=0;
		System.out.println("Diguem una frase");
		Scanner lector = new Scanner(System.in);
		String frase= lector.next();
		if (frase.equalsIgnoreCase("fi")){
			System.out.println("La frase amb més 'a' és: "+String.valueOf(comparaFrases));
			System.out.println("Té "+contador2+" 'a'.");
		}else{
			char[] arrayChar = frase.toCharArray();
			for(int i=0; i<arrayChar.length; i++){
				if( Character.toLowerCase(arrayChar[i])==('a')){
					contador++;
				}
			}
			
			if(contador>contador2){
				comparaFrases=arrayChar;
				contador2=contador;
				System.out.println("La frase amb més 'a' és: "+String.valueOf(comparaFrases));
				System.out.println("Té "+contador2+" 'a'.");	
			}else{
				System.out.println("La frase amb més 'a' és: "+String.valueOf(comparaFrases));
				System.out.println("Té "+contador2+" 'a'.");	
			}
			frases(contador2,comparaFrases);
		}
	}
}