import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public abstract class Funcions {


public static double PercentatgeParaulesComplexes(int contadorLetras,int numParaules) {
	double resultat;
	resultat=(double)contadorLetras/numParaules;
	resultat=resultat*100;
	return resultat;
		
	}



public static double IndexBoira(double percentatgeComplexes, int mitja) {
	double index;
	index=0.4*(mitja+percentatgeComplexes);
	return index;
		
	}

public static int ContarLetras(String[] paraula) {
	int contadorLetras=0;
	for(int i=0;i < paraula.length;i++){//recorre la array
		if(paraula[i].length()>=5){//mide la largura de la palabra si tiene mas de 5 se suma +1
			contadorLetras=contadorLetras+1;
		}
	}
		return contadorLetras;
	}

public static int mitja(int numFrases, int numParaules) {
	int mitja;
	mitja=numParaules/numFrases;//operacio per aconseguir la mitja
	return mitja;	
	}

public static int contarFrases(String texto) {
	int contadorFrases = 0;
	 for(int i=0; i<texto.length(); i++)//for per recorrer el text
     {
         if(texto.charAt(i) == '.'||texto.charAt(i) == ';'||texto.charAt(i) == ':')//Quan hagi un . un ; o un : em sumara una frase
             contadorFrases++;
     }
		return contadorFrases;
	}

public static String RetornaContingutRuta(String rutaFitxer, String texto) {//guarda tot el text en una variable
		File fitxer = new File(rutaFitxer);
		if(fitxer.canRead()){//si el fitxer es pot llegir
			try (BufferedReader read = new BufferedReader(new FileReader(fitxer.getAbsolutePath()))) {//es carrega larxiu a lleguir

				String line;

				while ((line = read.readLine()) != null) {//mentres el contigut de line sigui diferent a null
					texto=texto+line;
					
				}
				
			} catch (FileNotFoundException fail) {
				System.out.println("No se encuetra el archivo seleccionado");
			} catch (IOException fail) {
				System.out.println("No se puede leer el archivo seleccionado");
			}
		}else{
			System.out.println ("El fitxer no es pot llegir");
		}
		return texto;
	}

public static int contarPalabras(String texto,String[] paraula) {
	    int contadorParaula = 0;
	   
	    String line = null;
	    	
			paraula =texto.split(" ");// separar per espais
			
				return paraula.length;//retorna la llargaria de la array paraula

	}

public static String StringLector(String ruta) {//un lector de strings
	Scanner lector=new Scanner (System.in);//quan no hi han cap scanner primer es posa aixo
	ruta = lector.next();
	return ruta;
}

public static boolean EsRuta(String leerRuta) {//mira si la ruta ficada es una ruta que existeix y k no stigui null
	File fitxer = new File (leerRuta);
	if (leerRuta!=null){//si ruta es diferent a null 
		if(fitxer.exists()){
			if(fitxer.isFile()){//mirar que sigui un fitxer
				if(fitxer.canRead()){
					Boolean encontrado;
					encontrado= leerRuta.contains(".txt");
					if(encontrado){
						return true;
					}else{
						System.out.println ("La ruta no termina en txt");//el usuari fica una ruta incorrecte
						return false;
					}
				}else{
					System.out.println ("No tens permisos per a la ruta indicada");//el usuari fica una ruta incorrecte
					return false;
				}	
			}else{
				System.out.println ("La ruta indicada no es correcte, falta insertar el fitxer");//el usuari fica una ruta incorrecte
				return false;	
			}
		}else{
			System.out.println ("La ruta indicada o el nom del fitxer no es correcte, intenta amb una que existeixi");//el usuari fica una ruta incorrecte
			return false;
		}
	}else{
		System.out.println ("La ruta indicada es buida");//el usuari fica una ruta incorrecte
		return false;
	}
}
}
