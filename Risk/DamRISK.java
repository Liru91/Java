package Risk;
import FuncionsRisk.Funcions;
import java.util.Random;
import java.util.Scanner;
public class DamRISK {

	//DEFINICI� DE CONSTANTS
	//V�ctor (array) amb els noms dels continents. La posici� del continent dins del vector l'identifica en les 
	//diferents matrius o arrays on es relaciona. Seria la seva clau prim�ria.
	public static final String[] continents = {"Am�rica Nord","Am�rica Sud","�frica","Europa","�sia","Oceania"};

	//Vector (array) amb els noms dels territoris. Es relacionen amb el seu continent ja que el nombre de fila correspon 
	//a la posici� del array continents. 
	public static final String[] territoris={"Alaska","Territorio del nor-oeste","Groenlandia","Alberta","Ontario","Labrador","Territorio del oeste","Territorio del este","America central",
			"Venezuela","Per�","Argentina","Brasil","�frica del norte","Egipto","Africa Oriental","Congo","�frica del sur","Magadascar","Europa Occidental","Gran Breta�a","Islandia","Escandinavia","Europa del norte","Europa del sur","Ucrania",
			"Ural","Afganistan","Oriente Medio","Siberia","Yakutia","Chita","Kamchatka","Mongolia","Japon","China","Siam","India","Indonesia","Nueva Guinea","Australia Occidental","Australia Oriental"};

	//Matriu (array de dues dimensions) que ens permet identificar els pa�ssos ve�ns i aix� poder moure ex�rcits entre ells 
	//o atacar. Segons moment de la partida.
	public static final String[][] veins={{"Alaska,Kamchatka"}};

	//V�ctor (array) amb els objectius del joc. La posici� de l'objectiu dins del vector l'identifica en les diferents 
	//matrius o arrays on es relaciona. Seria la seva clau prim�ria.
	public static final String[] objectius = {"Am�rica sur i �frica","Am�rica del nord i Oceania","�frica i �sia"};

	//V�ctor (array) amb la quantitat d'ex�rcits inicials. En la posici� 0 correspon a 3 jugadors i la posici� 3 a 6 jugadors.
	public static final int[] exercicitsInicials = {35,30,25,20};

	//V�ctor (array) amb la quantitat d'ex�rcits que guanyes per continent conquistat. En la posici� 0 correspon a 
	//Am�rica del Nord i la 5 a Oceania.
	public static final int[] continentsComplets = {5,2,3,5,7,2};

	//Nombre que divideix els pa�ssos conquerits per saber les unitats de refor�.
	public static final int divisioTerritori = 3;

	//Nombre m�xims de jugadors que poden jugar al DamRISK.
	public static final int maxJugadors = 6;

	//Nombre m�nim de jugadors que poden jugar al DamRISK.
	public static final int minJugadors = 3;


	public static void main (String[] args){
		int jugadors=0;
		do{
			//Codi per demanar el nombre de jugadors
			System.out.println ("Quants jugadors jugaran? Al RISK poden jugar de 3 a 6 jugadors");
			Scanner lector = new Scanner(System.in);
			boolean scaner = lector.hasNextInt();//boolean per saber que ficaran un numero
			if(scaner){//entrara si es compleix el hasNextInt()
				jugadors = lector.nextInt();
				if (jugadors<=maxJugadors && jugadors>=minJugadors){//Mirar si tienen la condicion de los jugadores

					//Matriu que representa el tauler de joc. Cada posici� t� un array on es guarda la informaci� seg�ent
					//{Id jugador, N�mero exercits}
					//Cada posici� �s un territori.
					//{{1,14},{0,15}.....}
					int[][] tauler = new int[territoris.length][2];

					//Inicialitzem el tauler sense jugadors, valor -1. Doncs el jugador 0 existeix  
					for(int territori=0;territori<tauler.length;territori++){
						tauler[territori][0]=-1;
					}

					//Vector per guardar els noms dels jugadors. La posici� dins del vector �s l'identificador de jugador.
					String[] nomsJugadors=null;

					//Matriu on guardem la informaci� del joc per a cada jugador. On guardem la informaci� del jugador. Per a cada jugador guardem
					//nomsJugadors[0] li correspon la infoJugadors
					//{objectiu,exercits,infanteria, cavalleria,cano, comodi }
					int[][]infoJugadors =null;

					//Enter que indicar� el nombre de jugador que li toca tirar. 
					int torn=0;
					//Dimensionar els vectors nomsJugadors i infoJugadors
					nomsJugadors=new String [jugadors+1];
					infoJugadors= new int [jugadors+1][6];
					//Calcular nombre d'ex�rcits inicials
					int exercits=0;
					switch (jugadors) {
					case 3:
						exercits=exercicitsInicials[0];//guardar a una variable el valor
						break;

					case 4:
						exercits=exercicitsInicials[1];
						break;

					case 5:
						exercits=exercicitsInicials[2];
						break;

					case 6:
						exercits=exercicitsInicials[3];
						break;

					default:
						break;
					}
					System.out.println("Al ser " +jugadors+" cada jugador tindra "+exercits+" exercits inicials.");
					//Demanar les dades als jugadors i preparar-los per poder iniciar el joc.
					for(int numJugador=1;numJugador<jugadors+1;numJugador++){//Para que me la info de los jugadores i meterlos en la array
						nomsJugadors=nombrarJugador(numJugador,nomsJugadors);//funcio per noms jugadors

						infoJugadors=informeJugador(numJugador,nomsJugadors,infoJugadors,exercits);//funcio per informe jugador
					}
					//Repartir territorios
					int jugadorsTemp=1;
					for (int i=0;i<territoris.length;i++){//recorrera la longitut dels territoris per anar repartinlos
						boolean bucle=true;
						do{
							Random random2 = new Random();
							int randomTerri=random2.nextInt(territoris.length);//random dels territoris
							if(tauler[randomTerri][0]==-1){//mira si el territori te un -1 per asignarlo al jugador
								tauler[randomTerri][0]=jugadorsTemp;//asigna el territori al jugador
								tauler[randomTerri][1]=1;//asigna una tropa del jugador al territori
								infoJugadors[jugadorsTemp][1]=infoJugadors[jugadorsTemp][1]-1;//li resta una tropa al total que te el jugador
								bucle=false;//bucle fals es per que no faci una altre vegada el bucle
							}
						}while(bucle==true);
						jugadorsTemp++;//passa al seguent jugador
						if(jugadorsTemp>jugadors){//quant ja a recorregut tots els jugadors posa el contador a 1 per a que torni a repartir a tots
							jugadorsTemp=1;
						}
					}
					//Assignar tropes
					for(int i=1;i<=jugadors;i++){//for per recorrer els jugadors 
						System.out.println("Territoris del jugador " +nomsJugadors[i]+" son: ");
						for(int x=0;x<=territoris.length-1;x++){
							if(tauler[x][0]==i){//mira si el territori es del jugador per pintar nomes els daquest jugador
								System.out.println(x+" - "+territoris[x]+" te "+tauler[x][1]+" tropes.");
							}
						}
						System.out.println("Tens "+infoJugadors[i][1]+" tropes per possar.");
						do{//do per fer bucle fins que assigni totes les tropes
							System.out.println(nomsJugadors[i]+" a quin territori vol posar tropes?");
							boolean hasTropas = lector.hasNextInt();//boolean per saber que ficaran un numero
							if(hasTropas){
								int quinTerri = lector.nextInt();
								if(quinTerri==i){
									System.out.println("Quantes tropes possara?");
									int posarTropes = lector.nextInt();
									tauler[quinTerri][1]=tauler[quinTerri][1]+posarTropes;//asigna tropes
									infoJugadors[i][1]=infoJugadors[i][1]-posarTropes;//resta tropes del total
									System.out.println("Ara tindra "+tauler[quinTerri][1]+" tropes en "+territoris[quinTerri]+". Queden "+infoJugadors[i][1]+" tropes per possar.");
								}else{
									System.out.println("Aquest territori no es teu o no existeix, prova amb un de la llista.");
								}
							}else{
								System.out.println("El valor introduit no es correcte prova amb un numero que estigui dintre de les tropes que tens.");
								String var2=lector.next();
							}
						}while(infoJugadors[i][1]>0);
					}
					/**
					 * Pinta el tauler com ha quedat 
					 */
					for(int territori=0;territori<tauler.length;territori++){
						System.out.println(territoris[territori]+"-"+nomsJugadors[tauler[territori][0]]+"-"+tauler[territori][1]);
					}
					//Decidir qui comen�a a jugar i dir-ho per pantalla
					Random random = new Random();
					int randomComen�ar=random.nextInt(jugadors);//random de la quantitat de jugadors total
					System.out.println("Ja esta tot preparat, comen�arem el joc per el jugador "+randomComen�ar);
				}else{
					System.out.println("El valor introduit no es correcte, fica un numero de jugadors de 3 a 6.");
				}
			}else{
				System.out.println("El valor introduit no es correcte, fica un numero de jugadors de 3 a 6.");
			}
		}while(jugadors!=3 || jugadors!=4 || jugadors!=5 || jugadors!=6);//fer mestres sigui diferent
	}
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
