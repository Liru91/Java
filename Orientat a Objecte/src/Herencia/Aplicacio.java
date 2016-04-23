package Herencia;


public class Aplicacio {
	public static void main(String[] args) {
	
	Persona persona1 = new Persona();
	Estudiant estudiant1 = new Estudiant();
	Treballador treballador1 = new Treballador();
	

		System.out.println(persona1);
		System.out.println(estudiant1);
		System.out.println(treballador1);
		
	Persona personaA = new Persona("Jordi","Andreu","Garcia",20);
	Persona personaB =new Estudiant("Nuria","Peralta","Herrero",24,'B',"DAM",7);
	Persona personaC =new Treballador("Marcos","Garcia","Ruiz",28,2000,"Programador Senior");

	System.out.println(personaA);
	System.out.println(personaB);
	System.out.println(personaC);
		
	}
}