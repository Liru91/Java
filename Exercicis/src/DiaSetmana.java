package package2;

public class DiaSetmana { 
	 public static void main (String[] args) {
	  		 DiaSetmana programa = new DiaSetmana();
	   		programa.inici();
	 }
	 
	 public void inici() {
	   String nom = diaDeLaSetmana(3);
	   System.out.println("El tercer dia de la setmana és " + nom);
	   nom = diaDeLaSetmana(5);
	   System.out.println("El cinquè dia de la setmana és " + nom);
	   nom = diaDeLaSetmana(15);
	   System.out.println("El quinzè dia de la setmana és " + nom);
	 }
	 
	 //Param. entrada: número del dia
	 //Param. sortida: el nom del dia
	 public String diaDeLaSetmana(int numDia) {
	  switch(numDia){
	  case 1:
		  return "dilluns";
	case 2:
		  return "dimarts";
	  case 3:
		  return "dimecres";
	  case 4:
		  return "dijous";
	  case 5:
		  return "divendres";
	  case 6:
		  return "disabte";
	  case 7:
		  return "diumenge";
	  default:
		  return "No existeix aquest dia de la setmana";	  
	  }
	 }
	}

