

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class FitxersProva {
	private static String archivo = "alumnes.csv";
	private static String archivoCopiaSeguretat = "alumnes_CopiaSeguretat.bak";
	private static String rutaDefault = "";
	private static String[] parts;
	private static String ruta;
	private static String rutaCSV;
	private static String rutaCopiesSeguretat;
	private static String leerRutaCSV;
	private static String leerRutaCopiesSeguretat;
	private static String leerRutaLlistesGrups;
	private static String rutaLlistesGrups;
	public static void main(String[] args) {
		// TODO
		//Menu amb que vol fer que pot ser:
		//Opcio1: Configuració
		//Menu con subopciones:S'ha de comprovar que siguin directoris.
		//On esta el fitxer csv
		//On volen guardar les copies de seguretat
		//on es volen guardar les llistes dels grups.

		//Copia de seguretat.
		//1.Crear còpia de seguretat de l'arxiu alumnes.csv. En aquest cas es tracta de copiar aquest mateix arxiu amb extensió .bak. Opcional: Com pot haver més d'una còpia es pot afegir a l'extensió el dia i hora actuals.
		//2.Eliminar còpia de seguretat. Es llista totes les còpies de seguretat i es deixa escollir l'usuari quina vol eliminar. Es valora que al llistat només apareguin els fitxers de còpia de seguretat.
		//3.Restaurar còpia de seguretat.  Es llista totes les còpies de seguretat i es deixa escollir l'usuari quina vol restaurar. La que vol restaurar ara s'anomenarà alumnes.csv, eliminant l'anterior alumnes.csv . Es valora que al llistat només apareguin els fitxers de còpia de seguretat.
		//-----------------------Variables-----------------------------//
		int menuPrincipal = 0;
		int subMenuConfig = 0;
		File fitxer = null;



		//-------------------------------------------------------------//
		while (menuPrincipal!=4) {

			System.out.println ("");      
			System.out.println ("TREBALLANT AMB CSV");
			System.out.println ("");
			System.out.println ("");
			System.out.println ("Quina opcio vols fer?");
			System.out.println ("1.CONFIGURACIO");
			System.out.println ("2.CREAR LES LLISTES DE CLASSE DE CADA CURS");
			System.out.println ("3.COPIA DE SEGURETAT");
			System.out.println ("4.SORTIR");

			//C:\Usuarios\nuria\Im�genes
			Scanner lector=new Scanner (System.in);//quan no hi han cap scanner primer es posa aixo

			boolean scaner = lector.hasNextInt();//Toda esta parte comprovara si es un numero 
			if(scaner==true){
				menuPrincipal = lector.nextInt();

				switch(menuPrincipal){//Menu amb que vol fer que pot ser:
				case 1://Configuració
					System.out.println ("Has escollit CONFIGURACIO");
					System.out.println (" ");
					System.out.println ("Quin apartat vols fer?");
					System.out.println ("1.Insertar ruta del fitxer csv");
					System.out.println ("2.Insertar ruta on volen guardar les copies de seguretat");
					System.out.println ("3.Insertar ruta on es volen guardar les llistes dels grups");
					boolean scanerConf = lector.hasNextInt();//Toda esta parte comprovara si es un numero 
					if(scanerConf==true){
						subMenuConfig = lector.nextInt();


						switch(subMenuConfig){
						case 1://Insertar ruta del fitxer csv
							do{
								System.out.println ("A quina ruta es el fitxer csv?");

								leerRutaCSV = Ruta(ruta);//lector de la ruta
								if(EsRuta(leerRutaCSV)==true){//mirar si es una ruta
									rutaCSV=leerRutaCSV;
									System.out.println ("Dacord el fitxer csv es trova a "+rutaCSV);

								}else{
									System.out.println ("La ruta indicada no es correcte, intenta amb una que existeixi");//el usuari fica una ruta incorrecte
								}
							}while(EsRuta(leerRutaCSV)==false);

							break;

						case 2://Insertar ruta on volen guardar les copies de seguretat

							do{
								System.out.println ("A quina ruta vols guardar les copies de seguretat?");

								leerRutaCopiesSeguretat = Ruta(ruta);
								if(EsRuta(leerRutaCopiesSeguretat)==true){
									rutaCopiesSeguretat=leerRutaCopiesSeguretat;
									System.out.println ("Dacord les copies de seguretat es guardaran a "+rutaCopiesSeguretat);

								}else{
									System.out.println ("La ruta indicada no es correcte, intenta amb una que existeixi");
								}
							}while(EsRuta(leerRutaCopiesSeguretat)==false);

							break;
						case 3://Insertar ruta on es volen guardar les llistes dels grups
							do{
								System.out.println ("A quina ruta vols guardar les llistes dels grups?");

								leerRutaLlistesGrups = Ruta(ruta);
								if(EsRuta(leerRutaLlistesGrups)==true){
									rutaLlistesGrups=leerRutaLlistesGrups;
									System.out.println ("Dacord les llistes dels grups es guardaran a "+rutaLlistesGrups);

								}else{
									System.out.println ("La ruta indicada no es correcte, intenta amb una que existeixi");
								}
							}while(EsRuta(leerRutaLlistesGrups)==false);
							break;
						}
					}else{
						System.out.println ("No has introduit un numero, prova de nou");
					}
					break;

				case 2://Crear llistes
					System.out.println ("Has escollit CREAR LES LLISTES DE CLASSE DE CADA CURS");

					fitxer=CreaFitxer(ruta,archivo);

					if(fitxer.canRead()){//si el cvs es pot llegir
						try (BufferedReader read = new BufferedReader(new FileReader(fitxer.getAbsolutePath()))) {
							File fileESO1 =  CreaFitxer(ruta,"ESO1.csv");//Crea un nou csv
							FileWriter fileWriterE1 = new FileWriter(fileESO1);//Es com el BufferedWriter. per a poder scriure dintre del file
							File fileESO2 = new File("ESO2.csv");
							FileWriter fileWriterE2 = new FileWriter(fileESO2);
							File fileESO3 = new File("ESO3.csv");
							FileWriter fileWriterE3 = new FileWriter(fileESO3);
							File fileESO4 = new File("ESO4.csv");
							FileWriter fileWriterE4 = new FileWriter(fileESO4);
							File fileBAT1 = new File("BAT1.csv");
							FileWriter fileWriterB1 = new FileWriter(fileBAT1);
							File fileBAT2 = new File("BAT2.csv");
							FileWriter fileWriterB2 = new FileWriter(fileBAT2);

							String line;

							while ((line = read.readLine()) != null) {

								parts = line.split(";");//Separa la linia per ; y el guarda a un array

								switch(parts[1]){
								case "11":
								case "12":
									//Escriu la linia en memoria
									//concatena un retorno de carro para ir al principi de la linia y salt de linia
									fileWriterE1.write(line+"\r\n");
									break;
								case "13":
									fileWriterE2.write(line+"\r\n"); 
									break;
								case "14":
									fileWriterE3.write(line+"\r\n");
									break;
								case "15":
									fileWriterE4.write(line+"\r\n");
									break;
								case "16":
									fileWriterB1.write(line+"\r\n");
									break;
								case "17":
									fileWriterB2.write(line+"\r\n");
									break;
								}
							}
							fileWriterE1.flush();//llan�a el fileWriter
							fileWriterE1.close();	//tanca el fileWriter
							fileWriterE2.flush();
							fileWriterE2.close();
							fileWriterE3.flush();
							fileWriterE3.close();
							fileWriterE4.flush();
							fileWriterE4.close();
							fileWriterB1.flush();
							fileWriterB1.close();
							fileWriterB2.flush();
							fileWriterB2.close();
							System.out.println("Les llistes ja shan creat");

						} catch (FileNotFoundException fail) {
							System.out.println("No se encuetra el archivo seleccionado");
						} catch (IOException fail) {
							System.out.println("No se puede leer el archivo seleccionado");
						}
					}else{
						System.out.println ("El fitxer no es pot llegir");
					}
					break;



				case 3://Copia de seguretat
					System.out.println ("Has escollit COPIA DE SEGURETAT");
					System.out.println (" ");
					System.out.println ("Quin apartat vols fer?");
					System.out.println ("1.Crear copia de seguretat de l'arxiu alumnes.csv");
					System.out.println ("2.Eliminar copia de seguretat.");
					System.out.println ("3.Restaurar copia de seguretat.");
					boolean scanerMenuSeg = lector.hasNextInt();//Toda esta parte comprovara si es un numero 
					if(scanerMenuSeg==true){
						int subMenuSeg = lector.nextInt();

						switch(subMenuSeg){
						case 1://Crear copia de seguretat de l'arxiu alumnes.csv
							if(EsRuta(rutaCSV)==true){
								if(EsRuta(rutaCopiesSeguretat)==true){
									System.out.println ("Utilitzarem per copiar les rutes proporcionades de la ruta CSV i de la de copia Seguretat");
									CopyAction(rutaCSV,rutaCopiesSeguretat);
								}else{
									System.out.println ("Utilitzarem per copiar la ruta proporcionada de la ruta CSV i la ruta default de copia Seguretat");
									CopyAction(rutaCSV,rutaDefault);
								}
							}else if (EsRuta(rutaCSV)==false){
								if(EsRuta(rutaCopiesSeguretat)==true){
									System.out.println ("Utilitzarem per copiar la ruta default de la ruta CSV i la ruta proporcionada de copia Seguretat");
									CopyAction(rutaDefault,rutaCopiesSeguretat);
								}else{
									System.out.println ("Utilitzarem per copiar les rutes default de la ruta CSV i de la de copia Seguretat");
									CopyAction(rutaDefault,rutaDefault);
								}
							}
							break;
						case 2:
							File fichero=CreaFitxer(ruta,archivo);
							if (fichero.delete()){//si selimina
								   System.out.println("El fitxer sha esborrat");
							}else{
								   System.out.println("El fitxer no es pot esborrar");
							}
							break;
						case 3:
							break;
						}
						break;
					}else{
						System.out.println ("No has introduit un numero, prova de nou");
					}
				}
			}else{
				System.out.println ("No has introduit un numero, prova de nou");
			}
		}
	}

	public static void CopyAction (String rutaCSV,String rutaCopiesSeguretat) {
		try {
			File origen = new File (rutaCSV+ "/" + archivo);
			File destino = new File (rutaCopiesSeguretat + "/" + archivoCopiaSeguretat);
			FileChannel in = (new FileInputStream(origen)).getChannel();
			FileChannel out = (new FileOutputStream(destino)).getChannel();
			in.transferTo(0, origen.length(), out);
			in.close();
			out.close();
			System.out.println("Copia de seguretat feta.");

		} catch(Exception fail) {
			System.out.println("No se puede copiar el archivo");
		}
	}
	private static boolean EsRuta(String leerRutaCSV) {//mira si la ruta ficada es una ruta que existeix y k no stigui null
		File fitxer = new File (leerRutaCSV+archivo);
		if (leerRutaCSV!=null){//si ruta es diferent a null 
			if(fitxer.exists()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}


	private static String Ruta(String ruta) {//fa de lector per a les rutes

		Scanner lector=new Scanner (System.in);//quan no hi han cap scanner primer es posa aixo
		ruta = lector.next();
		File fitxer = new File (ruta);
		return ruta;

	}


	private static File CreaFitxer(String ruta, String archivo) {
		File fitxer=null;
		if (ruta!=null){//si ruta es diferent a null 
			fitxer = new File (ruta+"\\"+archivo);//crea un file amb la ruta mes el fitxer
			if(fitxer.exists()){
				System.out.println ("S'utilitza la ruta proporcionada anteriorment");
			}else{
				System.out.println ("El fitxer no existeix a la ruta indicada. Utilitzarem la ruta default");
				fitxer = new File (rutaDefault+"\\"+archivo);
			}
		}else{
			fitxer = new File (rutaDefault+"\\"+archivo);
			System.out.println ("S'utilitza la ruta default");
		}
		return fitxer;

	}
}
