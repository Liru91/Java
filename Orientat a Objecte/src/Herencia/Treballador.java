package Herencia;

public class Treballador extends Persona{
	//ATRIBUTS
	private int salari;
	private String categoria;
//********************************************************************************************************************
	
	//GETTERS AND SETTERS
	public int getSalari() {
		return salari;
	}
	public void setSalari(int salari) {
		this.salari = salari;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
//********************************************************************************************************************
	
	//METODE TOSTRING
		public String toString(){
			
			return "Nom: "+this.getNom()+", Primer Cognom: "+this.getPrimerCognom()+" Segon Cognom: "+this.getSegonCognom()+" Edat: "+this.getEdat()+" Salari: "+this.salari+" Categoria: "+this.categoria;

		}
//********************************************************************************************************************
		//CONSTRUCTOR PER DEFECTE
		public Treballador(){
			
		}
//********************************************************************************************************************

		//CONSTRUCTOR 
		public Treballador(String nom, String primerCognom, String segonCognom, int edat, int salari,String categoria) {
			setNom(nom);
			setPrimerCognom(primerCognom);
			setSegonCognom(segonCognom);
			setEdat(edat);
			this.salari=salari;
			this.categoria=categoria;
			
		}
//********************************************************************************************************************
		
}