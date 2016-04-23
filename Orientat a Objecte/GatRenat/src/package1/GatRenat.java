package package1;

public class GatRenat {
	private int vides = 7;   // vides disponibles del gat Renat;
	private boolean potParlar=true;
	String estat ="estrirado";
    public int getVides() {  // mètode que retorna el nombre de vides
        return vides;
    }
    public void setVides(int vides) {
        // modifica el nombre de vides del gat si el paràmetre vides conté un valor vàlid
        if (vides >= 0) {
            this.vides = vides;   // de moment passem per alt aquest "this"
        }
    }
    public void calla(){
    	this.potParlar=false;
    }
    
    public void parla(){
    	this.potParlar=true;
    }
    
    public void miola(){
    	if(potParlar){
    		System.out.println("MEEEEEEEEEEEEEEEEEEUUUUUUUUUUUUU");
    	}else{
    		System.out.println("...");
	    }
    }
    public boolean estaDret(){
    	if (estat.equals("dret")){
    		return true;
    	}else{
    		return false;
    	}	
    }
    public boolean estaViu(){
    	if (vides>0){
    		return true;
    	}else{
    		return false;
    	}	
    }
}
