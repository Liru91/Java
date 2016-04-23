import java.util.Scanner;

public class endivinaParaula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Quin es el teu nom?");
		Scanner lector=new Scanner (System.in);//quan no hi han cap scanner primer es posa aixo
		String nom = lector.next(); //Introducci√≥ variable jugador
		//Posar primera lletra en minuscula i la ultima en majus.
		for(int lletra = 0; lletra < nom.length(); lletra++){ //Amb el for defino la posiscio fins el length de la paraula
			if(lletra == 0) {
				nom = nom.replace(nom.charAt(lletra), nom.toLowerCase().charAt(lletra));//converteix nom en un char i despres o pasa a minusculas
			}else if (lletra ==nom.length()-1){
				nom = nom.replace(nom.charAt(lletra), nom.toUpperCase().charAt(lletra));
			}	
		}	
		System.out.println(nom); 
		System.out.println("Endivina la paraula !!");
		System.out.println("Reglas:");
		System.out.println("-Tens 5 intents per endivinar la paraula");
		System.out.println("-Al comenÁament tens 100 punts");
		System.out.println("-Per cada intent 20 punts menys");
		System.out.println("-Pots demanar pistes (mentres tinguis punts), per a cada pista son 5 punts menys.");
		System.out.println("COMENCEM!!"+nom);
		
		//Definir paraula clau
		String paraula="hardcoded";
		//Convertir string a CharArray
		char[] CharArray = paraula.toCharArray();
		boolean seguir=false;
		int contador_pista=0;
		int intento=1;
		byte pista=0;
		//fer bucle per anar preguntant que vol
		int punts=100;
		byte joc=0;
			do
			{
				System.out.println("Escull una opcio "+nom);
				//Menu per escollir seguent pas al joc.
					System.out.println("(1) Introduir paraula.");
			        System.out.println("(2) Demana una pista.");
			        System.out.println("(3) Recuperar punts.");
			        boolean error_pregunta1=true; 
			        error_pregunta1=lector.hasNextByte();
			       
			        
			        if (error_pregunta1==true){//perque nomes entrin els bytes
			        	
			        	joc = lector.nextByte();
				        if (joc==1 || joc==2 || joc==3 )//opcions per si han posat be o no el numero
				        {
						    //Switch per posar els casos del menu escollit  
							switch (joc)
							{
							case 1://Introduir paraula
								System.out.println("Quina paraula introdueixes?");
								String lletra1 = lector.next();
								intento=intento+1;
								//Si encerta la paraula
									if (lletra1.equalsIgnoreCase(paraula))//compara la paraula introduida amb la que te que encertar
									{
										System.out.println("MOLT BE!!!! ES AQUESTA PARAULA!!");
										seguir=true;
										break;
									}
								//Sino la encerta
									else
									{
										punts=punts-20;
										System.out.println("No era aquesta. Ara tens "+punts+" punts.");
										seguir=false;
											if (intento>5){
												System.out.println("Aquest era el teu 5 intent, Has perdut");
											}
										break;
									}
									
							case 2://Demanar pistes
								do
								{
								System.out.println("Quina pista vols demanar? Recorda cada una son 5 o 15 punts menys");
								System.out.println("Ara tens "+punts+" punts");
								//Un altre menu per escollir la pista
								System.out.println("(1) Quina lletra es a una posicio");
						        System.out.println("(2) Quantes lletres te la paraula.");
						        System.out.println("(3) Les dues primeres lletres.");
						        System.out.println("(4) Quantes vegades apareix una lletra");
						        System.out.println("(5) Mostrar consonants paraula. Aquesta pista resta 15 punts");
						        System.out.println("(6) Sortir de pistes");
						        boolean pistes=lector.hasNextByte();//Asegurarse que hi han bytes
							        if(pistes){
							        pista = lector.nextByte();
								        if (pista==1 || pista==2 || pista==3|| pista==4|| pista==5)
								        {
								        	switch (pista)
								        	{
								        	case 1://Quina lletra es a una posicio
								        		int posicio=0;
								        		System.out.println("Quina posicio vols saber?");
								        		boolean esnumero=lector.hasNextInt();
								        		if (esnumero){
								        		posicio = lector.nextInt();
								        		posicio=posicio-1;
								        		punts=punts-5;
								        			if (posicio>=paraula.length()){
								        				System.out.println("A la paraula no existeix aquesta posicio");
								        			}else{
								        				System.out.println("A la posicio numero "+(posicio+1)+" hi ha la lletra: "+CharArray[posicio]);
								        			}
								        		}else{
								        			String numincorrecte = lector.next();
								        			System.out.println(numincorrecte+" no es un numero");
								        		}
								        		break;
								        	case 2://Quantes lletres te la paraula.
								        		System.out.println("La paraula te "+CharArray.length);
								        		punts=punts-5;
								        		break;
								        	case 3://les dues primeres lletres
								        		 System.out.println("Les dues primeres lletres son: "+(CharArray[0])+(CharArray[1]));
								        		 punts=punts-5;
								        		break;
								        	case 4://quantes vegades apareix una lletra
								        		System.out.println("Quina lletra vols saber quantes vegades apareix?");
								        		String vegades_lletra = lector.next();
								        		int contador_vegades_lletra=0;
								        		for(int i = 0; i<CharArray.length;i++){
								        			if(CharArray[i]==vegades_lletra.charAt(0)){
								        				contador_vegades_lletra= contador_vegades_lletra + 1;
								        			}
								        		}
								        		System.out.println("Les vegades que apareix "+vegades_lletra +" es "+contador_vegades_lletra);
								        		punts=punts-5;
								        		break;
								        	case 5://mostrar consonants paraula
								                 //int contador = 0;//Ira contando la cantidad de consonantes
								                 char[] CharArrayCons = CharArray;
								                 for(int x=0;x<paraula.length();x++) {  //contar el num de consonants fins a la llargaria de la paraula
								                	
								                	 if(CharArrayCons[x] == 'a' || CharArrayCons[x] == 'e' || CharArrayCons[x] == 'i' || CharArrayCons[x] == 'o' || CharArrayCons[x] == 'u'){
								                		 CharArrayCons[x] = '*';
								                	 }
								                	 
								                 }
								                 System.out.println(CharArrayCons);
								        		punts=punts-15;
								        		break;
								        	}
								        	
								        }else{
								        	System.out.println("El valor introduit no es al menu prova amb 1,2,3,4,5 o 6");
								        }
							        }else{
							        	String numincorrecte = lector.next();
							        	System.out.println(numincorrecte+" no es un numero prova amb 1,2,3,4,5 o 6");
							        }
									}while (pista!=6 && punts>0);
						    break;//break de caso dos de primer menu
							case 3://Recuperar punts
								if (contador_pista<1){
									System.out.println("Endivina les ultimes tres lletres");
									String ult_lletres = lector.next();
										if (ult_lletres.equals(CharArray[CharArray.length-3]+""+CharArray[CharArray.length-2]+""+CharArray[CharArray.length-1])){
											System.out.println("Molt be, sÛn aquestes lletres!");
											punts=punts+10;
										}else{
											System.out.println("No eren aquestes, ho sento.");
										}
									contador_pista++;
								}else{
									System.out.println("Ja ho has intentat, no ho pots fer una altre vegada");
								}
							}
						}else{
							System.out.println("El valor introduit no es al menu prova amb 1,2 o 3");
						}
			        }else{			        	
			        	String incorrecte = lector.next();
			        	System.out.println("El valor introduit "+incorrecte+" no es al menu prova amb 1,2 o 3");
			        }
				}while (seguir==false && punts>0 && intento<=5);
			if (punts<=0){
				System.out.println("Estas sense punts, has perdut");
			}
				
	}
}
		
