import java.util.Scanner;
public class Atletisme {

	//Constants per al CP-------------------------------------------------------------------------
	private static final String SantAdriaDelBesos = "Sant Adria del Besos";
	private static final String Berga = "Berga";
	private static final String Granollers = "Granollers";
	private static final String Mataro = "Mataro";
	private static final String Sabadell = "Sabadell";
	private static final String CabreraAnoia = "Cabrera DAnoia";
	private static final String error = "Indeterminada";
	//--------------------------------------------------------------------------------------------
	//Constants per a categories------------------------------------------------------------------
	private static final String micros="Micros";
	private static final String benjamin="Benjamin";
	private static final String alevin="Alevin";
	private static final String infantil="Infantil";
	private static final String cadete="Cadete";
	private static final String juvenil="Juvenil";
	private static final String senior="Senior";
	//---------------------------------------------------------------------------------------------
	String guion = "-";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables
		String sexolector = null;
		String sexo;
		String nombre;
		String apellidos;
		int menu=0;
		int edad=0;
		boolean preguntaedad;
		int i=0;
		String[][] atleta = new String [100][8];//el club de atletismo tendra un aforo max de 100 socios.matriz para poder introducir todos los datos//
		String CANVIOAtleta;

		//----------------------------------------
		do
		{
			System.out.println ("GESTION CLUB ATLETISMO");
			System.out.println ("Que opcion quieres hacer?");
			System.out.println ("1- Introducir un nuevo atleta.");
			System.out.println ("2- Lista de atletas");
			System.out.println ("3- Modificar datos atleta");
			System.out.println ("4- Salir");

			Scanner lector=new Scanner (System.in);
			boolean scaner = lector.hasNextInt();//Toda esta parte comprovara si es un numero 
			if(scaner==true){
				menu = lector.nextInt();
			}else{
				do{
					String variable = lector.next();
					System.out.println("El valor introducido no es un numero. Prueba con 1,2,3 o 4");
					scaner = lector.hasNextInt();
					if(scaner == true){
						menu = lector.nextInt();
					}else{
						variable = lector.next();
					}
				}while(!scaner);
			}

			//Switch para escojer opciones
			switch (menu)
			{
			case 1://Introducir un nuevo atleta.			
				if(i<100){
					System.out.println ("Vamos a introducir los datos para el nuevo atleta:");
					//NOMBRE
					System.out.println ("Cual es su nombre?");
					nombre = lector.next();
					atleta [i][1]= nombre;
					System.out.println ("Cual es su apellido?");
					apellidos = lector.next();
					atleta [i][2]= apellidos;
					//HOMBRE O MUJER

					do{
						System.out.println ("Es mujer o hombre (Indica hombre con 0 mujer con 1)?");
						sexo=lector.next();

						switch(sexo){
						case "0":
							sexo="Home";
							atleta [i][3]= sexo;
							break;
						case"1":
							sexo="Dona";
							atleta [i][3]= sexo;
							break;
						default:
							System.out.println ("El valor introducido es incorrecto, prueba con 0 si es hombre 1 si es mujer");
							break;
						}

					}while(sexo!="Dona"&&sexo!="Home");

					//EDAD
					do{//hacer switch para las categorias en la edad
						System.out.println ("Que edad tiene?");
						lector=new Scanner(System.in);
						preguntaedad =lector.hasNextInt();
						if(preguntaedad){//mira si es un int
							edad = lector.nextInt();
							if(edad<151 && edad>3){//mira si entra en el rango entre 4 y 150
								String stringedad = Integer.toString(edad);//pasar edad a string para poder ponerlo en matriz
								atleta [i][4]= stringedad;
							}else{
								System.out.println ("El valor introducido es incorrecto, prueba con un numero del 4 al 150");
							}
						}

					}while(edad>150 || edad<3||preguntaedad==false);
					//QUOTA
					if (edad>=4&&edad<=17){
						atleta [i][7]= "17,5";
					}else{
						atleta [i][7]= "23,7";
					}
					//CATEGORIA (Tambien se puede hacer con switch)
					if(edad<=7 && edad>=4)
					{
						atleta [i][5]= micros;
					}
					else if(edad<=9 && edad>=8)
					{
						atleta [i][5]= benjamin;
					}
					else if(edad<=11 && edad>=10)
					{
						atleta [i][5]= alevin;
					}
					else if(edad<=13 && edad>=12)
					{
						atleta [i][5]= infantil;
					}
					else if(edad<=15 && edad>=14)
					{
						atleta [i][5]= cadete;
					}
					else if(edad<=17 && edad>=16)
					{
						atleta [i][5]= juvenil;
					}
					else if(edad>=18 && edad<=150){
						atleta [i][5]= senior;
					}

					//CODIGO POSTAL
					System.out.println ("Selecciona el codigo postal donde vive?");
					String cp = lector.next();
					switch(cp)
					{
					case "08930":
						atleta [i][6]= SantAdriaDelBesos;//guardar el cp en la posicion 6
						break;
					case "08600":
						atleta [i][6]= Berga;
						break;
					case "08402":
						atleta [i][6]= Granollers;
						break;
					case "08304":
						atleta [i][6]= Mataro;
						break;
					case "08206":
						atleta [i][6]= Sabadell;
						break;
					case "08718":
						atleta [i][6]= CabreraAnoia;
						break;	
					default://en caso de que no introduzcan un cp guardado
						atleta [i][6]= error;		
					}

					nombre = nombre.replace(nombre.charAt(0), nombre.toUpperCase().charAt(0));//Poner primera letra nom en may
					apellidos = apellidos.replace(apellidos.charAt(0), apellidos.toUpperCase().charAt(0));//Poner primera letra nom en may
					atleta [i][5]=atleta [i][5].toUpperCase();//categoria a mayuscules
					if (atleta [i][4].length()==1){//EDAD mirar la cantidad de numeros en la edad para un tipo de contrasenya o otra
						char[] codigofinal = new char[7];//crear variable contrasenya
						codigofinal[0] = nombre.toUpperCase().charAt(0);//posicionar, poner may o min la letra selecionada
						codigofinal[1] = nombre.toLowerCase().charAt(1);
						codigofinal[2] = apellidos.toUpperCase().charAt(0);
						codigofinal[3] = apellidos.toLowerCase().charAt(apellidos.length()-1);
						codigofinal[4] = atleta [i][4].charAt(0);
						codigofinal[5] = atleta [i][5].toUpperCase().charAt(0);
						codigofinal[6] = atleta [i][5].toUpperCase().charAt(1);
						atleta[i][0] = String.valueOf(codigofinal);
					}else if(atleta [i][4].length()==2){//edad longitud
						char[] codigofinal = new char[8];//crear variable contrasenya
						codigofinal[0] = nombre.toUpperCase().charAt(0);//posicionar, poner may o min la letra selecionada
						codigofinal[1] = nombre.toLowerCase().charAt(1);
						codigofinal[2] = apellidos.toUpperCase().charAt(0);
						codigofinal[3] = apellidos.toLowerCase().charAt(apellidos.length()-1);
						codigofinal[4] = atleta [i][4].charAt(0);
						codigofinal[5] = atleta [i][4].charAt(1);
						codigofinal[6] = atleta [i][5].toUpperCase().charAt(0);//categoria
						codigofinal[7] = atleta [i][5].toUpperCase().charAt(1);//categoria
						atleta[i][0] = String.valueOf(codigofinal);

					}else if (atleta [i][4].length()==3){//edad logitud
						char[] codigofinal = new char[9];//crear variable contrasenya
						codigofinal[0] = nombre.toUpperCase().charAt(0);//posicionar, poner may o min la letra selecionada
						codigofinal[1] = nombre.toLowerCase().charAt(1);
						codigofinal[2] = apellidos.toUpperCase().charAt(0);
						codigofinal[3] = apellidos.toLowerCase().charAt(apellidos.length()-1);
						codigofinal[4] = atleta [i][4].charAt(0);
						codigofinal[5] = atleta [i][4].charAt(1);
						codigofinal[6] = atleta [i][4].charAt(2);
						codigofinal[7] = atleta [i][5].toUpperCase().charAt(0);//categ
						codigofinal[8] = atleta [i][5].toUpperCase().charAt(1);//categ
						atleta[i][0] = String.valueOf(codigofinal);
					}
					//atleta [i][8]=codigofinal.toString();						
					System.out.println ("Datos Atleta: ");
					System.out.println (atleta [i][0]+" - "+atleta [i][1]+" - "+atleta [i][2]+" - "+atleta [i][3]+" - "+atleta [i][4]+" anyos"+" - "+atleta [i][6]+" - "+atleta [i][5]+" - "+atleta [i][7]);
					i++;
				}
				break;
			case 2://Lista de atletas
				System.out.println ("------------------------");
				System.out.println ("Lista de Atletas");
				System.out.println ("------------------------");
				for (int lista=0;lista<i;lista++){
					System.out.println (atleta [lista][0]+" - "+atleta [lista][1]+" - "+atleta [lista][2]+" - "+atleta [lista][3]+" - "+atleta [lista][4]+" anyos"+" - "+atleta [lista][6]+" - "+atleta [lista][5]+" - "+atleta [lista][7]);
				}	
				break;
			case 3://Modificar datos atleta
				System.out.println ("Introducir codigo del atleta a modificar");
				String ModAtleta =lector.next();
				int var=0;
				for (int lista=0;lista<i;lista++){

					if(ModAtleta.equals(atleta [lista][0])){
						var++;
						//se pone lista dentro porque sera la posicion del atleta
						System.out.println (atleta [lista][0]+" - "+atleta [lista][1]+" - "+atleta [lista][2]+" - "+atleta [lista][3]+" - "+atleta [lista][4]+" anyos"+" - "+atleta [lista][6]+" - "+atleta [lista][5]+" - "+atleta [lista][7]);
						System.out.println ("Quieres canviar los datos de este atleta?");

						boolean boleanAtleta = lector.hasNext();
						if(boleanAtleta==true){//mira si es string
							CANVIOAtleta =lector.next();
						}else{
							do{//si no es string
								CANVIOAtleta = lector.next();
								System.out.println("El valor introducido no es un numero. Prueba con 1,2,3 o 4");
								boleanAtleta = lector.hasNextInt();//lee direxctamente la siguiente respuesta
								if(boleanAtleta == true){//mira de nuevo si es string
									menu = lector.nextInt();
								}else{
									CANVIOAtleta = lector.next();
								}
							}while(!boleanAtleta);
						}
						if(CANVIOAtleta=="Si"||CANVIOAtleta=="si"||CANVIOAtleta=="s"){
							//NOMBRE
							System.out.println ("Cual es su nombre?");
							String nombre1 = lector.next();
							atleta [i][1]= nombre1;
							System.out.println ("Cual es su apellido?");
							String apellidos1 = lector.next();
							atleta [i][2]= apellidos1;
							//HOMBRE O MUJER
							System.out.println ("Es mujer o hombre (Indica hombre con 0 mujer con 1)?");

							sexo=lector.next();
							do{
								switch(sexo){
								case "0":
									sexo="Home";
									atleta [i][3]= sexo;
									break;
								case"1":
									sexo="Dona";
									atleta [i][3]= sexo;
									break;
								default:
									System.out.println ("El valor introducido es incorrecto, prueba con 0 si es hombre 1 si es mujer");
								}

							}while(sexo!="Dona"&&sexo!="Home");


							//EDAD
							do{//hacer switch para las categorias en la edad
								System.out.println ("Que edad tiene?");
								lector=new Scanner(System.in);
								preguntaedad =lector.hasNextInt();
								if(preguntaedad){//mira si es un int
									edad = lector.nextInt();
									if(edad<151 && edad>3){//mira si entra en el rango entre 4 y 150
										String stringedad = Integer.toString(edad);//pasar edad a string para poder ponerlo en matriz
										atleta [i][4]= stringedad;
									}else{
										System.out.println ("El valor introducido es incorrecto, prueba con un numero del 4 al 150");
									}
								}

							}while(edad>150 || edad<3||preguntaedad==false);
							//QUOTA
							if (edad>=4&&edad<=17){
								atleta [i][7]= "17,5";
							}else{
								atleta [i][7]= "23,7";
							}
							//CATEGORIA (Tambien se puede hacer con switch)
							if(edad<=7 && edad>=4)
							{
								atleta [i][5]= micros;
							}
							else if(edad<=9 && edad>=8)
							{
								atleta [i][5]= benjamin;
							}
							else if(edad<=11 && edad>=10)
							{
								atleta [i][5]= alevin;
							}
							else if(edad<=13 && edad>=12)
							{
								atleta [i][5]= infantil;
							}
							else if(edad<=15 && edad>=14)
							{
								atleta [i][5]= cadete;
							}
							else if(edad<=17 && edad>=16)
							{
								atleta [i][5]= juvenil;
							}
							else if(edad>=18 && edad<=150){
								atleta [i][5]= senior;
							}

							//CODIGO POSTAL
							System.out.println ("Selecciona el codigo postal donde vive?");
							String cp2 = lector.next();
							switch(cp2)
							{
							case "08930":
								atleta [i][6]= SantAdriaDelBesos;//guardar el cp en la posicion 6
								break;
							case "08600":
								atleta [i][6]= Berga;
								break;
							case "08402":
								atleta [i][6]= Granollers;
								break;
							case "08304":
								atleta [i][6]= Mataro;
								break;
							case "08206":
								atleta [i][6]= Sabadell;
								break;
							case "08718":
								atleta [i][6]= CabreraAnoia;
								break;	
							default://en caso de que no introduzcan un cp guardado
								atleta [i][6]= error;		
							}

							nombre = nombre1.replace(nombre1.charAt(0), nombre1.toUpperCase().charAt(0));//Poner primera letra nom en may
							apellidos = apellidos1.replace(apellidos1.charAt(0), apellidos1.toUpperCase().charAt(0));//Poner primera letra nom en may
							atleta [i][5]=atleta [i][5].toUpperCase();//categoria a mayuscules
							if (atleta [i][4].length()==1){//EDAD mirar la cantidad de numeros en la edad para un tipo de contrasenya o otra
								char[] codigofinal = new char[7];//crear variable contrasenya
								codigofinal[0] = nombre.toUpperCase().charAt(0);//posicionar, poner may o min la letra selecionada
								codigofinal[1] = nombre.toLowerCase().charAt(1);
								codigofinal[2] = apellidos.toUpperCase().charAt(0);
								codigofinal[3] = apellidos.toLowerCase().charAt(apellidos.length()-1);
								codigofinal[4] = atleta [i][4].charAt(0);
								codigofinal[5] = atleta [i][5].toUpperCase().charAt(0);
								codigofinal[6] = atleta [i][5].toUpperCase().charAt(1);
								atleta[i][0] = String.valueOf(codigofinal);
							}else if(atleta [i][4].length()==2){//edad longitud
								char[] codigofinal = new char[8];//crear variable contrasenya
								codigofinal[0] = nombre.toUpperCase().charAt(0);//posicionar, poner may o min la letra selecionada
								codigofinal[1] = nombre.toLowerCase().charAt(1);
								codigofinal[2] = apellidos.toUpperCase().charAt(0);
								codigofinal[3] = apellidos.toLowerCase().charAt(apellidos.length()-1);
								codigofinal[4] = atleta [i][4].charAt(0);
								codigofinal[5] = atleta [i][4].charAt(1);
								codigofinal[6] = atleta [i][5].toUpperCase().charAt(0);//categoria
								codigofinal[7] = atleta [i][5].toUpperCase().charAt(1);//categoria
								atleta[i][0] = String.valueOf(codigofinal);

							}else if (atleta [i][4].length()==3){//edad logitud
								char[] codigofinal = new char[9];//crear variable contrasenya
								codigofinal[0] = nombre.toUpperCase().charAt(0);//posicionar, poner may o min la letra selecionada
								codigofinal[1] = nombre.toLowerCase().charAt(1);
								codigofinal[2] = apellidos.toUpperCase().charAt(0);
								codigofinal[3] = apellidos.toLowerCase().charAt(apellidos.length()-1);
								codigofinal[4] = atleta [i][4].charAt(0);
								codigofinal[5] = atleta [i][4].charAt(1);
								codigofinal[6] = atleta [i][4].charAt(2);
								codigofinal[7] = atleta [i][5].toUpperCase().charAt(0);//categ
								codigofinal[8] = atleta [i][5].toUpperCase().charAt(1);//categ
								atleta[i][0] = String.valueOf(codigofinal);
							}
							//atleta [i][8]=codigofinal.toString();						
							System.out.println ("Datos Atleta: ");
							System.out.println (atleta [i][0]+" - "+atleta [i][1]+" - "+atleta [i][2]+" - "+atleta [i][3]+" - "+atleta [i][4]+" anyos"+" - "+atleta [i][6]+" - "+atleta [i][5]+" - "+atleta [i][7]);
						}else if(CANVIOAtleta=="No"||CANVIOAtleta=="no"||CANVIOAtleta=="n"){
							break;
						}else{
							System.out.println ("El valor introducido no es correcto, prueba con Si o con No");
						}
					}
					if(var==0){
						System.out.println ("El codigo introducido no es correcto");
					}
				}
				break;
			case 4://CIERRA APLICACION
				break;
			default://Si no pone los parametros correctos
				System.out.println ("Ese valor no concuerda, prueba con 1,2,3 o 4");
				break;
			}
		}while(menu!=4);
		System.out.println ("Nos Vemos!");

	}		
}
