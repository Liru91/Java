package Herencia;

public class Estudiant extends Persona{

	//ATRIBUTS
	private char grup;
	private String cicle;
	private int notaAcces;
//********************************************************************************************************************

	//CONSTRUCTOR PER DEFECTE
	public Estudiant(){
		
	}
//********************************************************************************************************************

	//CONSTRUCTOR 
	public Estudiant(String nom, String primerCognom, String segonCognom, int edat, char grup, String cicle, int notaAcces) {
		setNom(nom);
		setPrimerCognom(primerCognom);
		setSegonCognom(segonCognom);
		setEdat(edat);
		this.cicle=cicle;
		this.grup=grup;
		this.notaAcces=notaAcces;
		
	}
//********************************************************************************************************************
	//METODE TOSTRING
		public String toString(){
			
			return "Nom: "+this.getNom()+", Primer Cognom: "+this.getPrimerCognom()+" Segon Cognom: "+this.getSegonCognom()+" Edat: "+this.getEdat()+" Grup: "+this.grup+" Cicle: "+this.cicle+" Nota Acces: "+this.notaAcces;

		}
//********************************************************************************************************************
		//EQUALS
		public boolean equals(Estudiant estudiant){
			if(estudiant.toString().equals(this.toString())){
				return true;
			}else{
				return false;
			}
		}
//********************************************************************************************************************
		//GETTERS AND SETTERS
		public char getGrup() {
			return grup;
		}

		public void setGrup(char grup) {
			this.grup = grup;
		}

		public String getCicle() {
			return cicle;
		}

		public void setCicle(String cicle) {
			this.cicle = cicle;
		}

		public int getNotaAcces() {
			return notaAcces;
		}

		public void setNotaAcces(int notaAcces) {

			this.notaAcces = notaAcces;
		}

//********************************************************************************************************************

}

