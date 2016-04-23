import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IndexBoira {


	public static void main(String[] args) {
		String texto="";
		String[] paraula = null;
		String rutaFitxer = null;
		boolean trueOFalse=false;
		//PART1 LLEGIR EL FITXER DEL TEXT A ANALITZAR
		do{//mentres no sigui una ruta correcta
			System.out.println (" ");
			//*-*DEMANAR A L'USUARI EL PATH DEL FITXER*-*
			System.out.println ("Quina es la ruta del fitxer a analitzar?");
			System.out.println (" ");
			rutaFitxer=Funcions.StringLector(rutaFitxer);
			
			if(Funcions.EsRuta(rutaFitxer)){//mirar si es una ruta (igual que posar EsRuta(leerRutaFitxer)==true)
				trueOFalse=true;
				rutaFitxer=rutaFitxer;
				System.out.println (" ");
				System.out.println ("Dacord el fitxer es troba a "+rutaFitxer);
			}else{
				trueOFalse=false;
			}
			
		}while(trueOFalse==false);//mentres sigui false que continuï
		System.out.println (" ");
		System.out.println ("El contingut de "+rutaFitxer+" es el seguent");
		System.out.println ("");
		//*-*RETORNAR UNA CADENA AMB TOT EL CONTINGUT*-*
		texto=Funcions.RetornaContingutRuta(rutaFitxer,texto);
		
		System.out.println (texto);
		System.out.println (" ");

		//PART2 SABER QUANTES PARAULES HI HA
		int numParaules;
		paraula =texto.split(" ");//posar al main el valor de paraula
		numParaules=Funcions.contarPalabras(texto,paraula);
		System.out.println ("La quantitat de paraules al text es: "+numParaules);

		//COMPTAR NUMERO DE FRASES QUE HI HA
		int numFrases;
		numFrases=Funcions.contarFrases(texto);
		System.out.println ("La quantitat de frases al text es: "+numFrases);

		//FER MITJA DE PARAULES / FRASES
		int laMitja;
		laMitja=Funcions.mitja(numFrases,numParaules);
		System.out.println ("La mitja de Paraules entre Frases es: "+laMitja);

		//CONTAR LETRAS PALABRAS SI +5 SUMAR 1 AL CONTADOR
		int contadorLetras=Funcions.ContarLetras(paraula);
		System.out.println ("El numero de paraules llargues al text es: "+contadorLetras);
		
		//INDEX BOIRA
		System.out.println ("Formula INDEX BOIRA");
		System.out.println ("0.4*(mitjana de paraules+percentatge de paraules complexes)");
		String complexes;
		double percentatgeComplexes;
		percentatgeComplexes=Funcions.PercentatgeParaulesComplexes(contadorLetras,numParaules);
		System.out.println ("Es a dir:0.4*("+laMitja+"+"+percentatgeComplexes+")");
		double index;
		index=Funcions.IndexBoira(percentatgeComplexes,laMitja);
		System.out.println ("El resultat de la operacio per el Index Boira es: "+index);
		
		//GUARDAR RESULTAT
		 FileWriter fichero = null;
	     PrintWriter escribir = null;
	        try
	        {
	            fichero = new FileWriter("resultat.txt");
	            escribir = new PrintWriter(fichero);

	                escribir.println("Mitja de paraules per frase");
	                escribir.println(laMitja);
	                escribir.println("Nombre paraules llargues");
	                escribir.println(contadorLetras);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }

	}



}
