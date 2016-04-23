package Herencia;

public class Persona {
	
	//ATRIBUTS
	private String nom;
	private String primerCognom;
	private String segonCognom;
	private int edat;
//********************************************************************************************************************
	//CONSTRUCTOR PER DEFECTE
	public Persona(){
		
	}
//********************************************************************************************************************

	//GETTERS AND SETTERS
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrimerCognom() {
		return primerCognom;
	}
	public void setPrimerCognom(String primerCognom) {
		this.primerCognom = primerCognom;
	}
	public String getSegonCognom() {
		return segonCognom;
	}
	public void setSegonCognom(String segonCognom) {
		this.segonCognom = segonCognom;
	}
	public int getEdat() {
		return edat;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}
//************************************************************************************************************************
	//METODE TOSTRING
	public String toString(){
		
		return "Nom: "+this.nom+", Primer Cognom: "+this.primerCognom+" Segon Cognom: "+this.segonCognom+" Edat: "+this.edat;

	}
//************************************************************************************************************************
	//CONTRUCTOR PER INSTANCIAR 
	public Persona(String nom, String primerCognom, String segonCognom, int edat) {
		// dos maneras:
		// setMotor(pMotor)
		// Motor=pMotor;
		this.nom= nom;
		this.primerCognom=primerCognom;
		this.segonCognom=segonCognom;
		this.edat=edat;
		
	}
//************************************************************************************************************************

}