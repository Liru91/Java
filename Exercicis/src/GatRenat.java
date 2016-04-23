

public class GatRenat extends Gat {
	private boolean potParlar=true;
	String estat ="estrirado";
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
    		System.out.println("MARRAMEEEEEEU");
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
