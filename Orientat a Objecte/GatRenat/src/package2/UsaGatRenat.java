package package2;

import package1.GatRenat;

public class UsaGatRenat {
	public static void main(String[] args) {
	    GatRenat renat = new GatRenat();
	    renat.parla();
	    System.out.println("Al gat Renat li queden " + renat.getVides() + " vides");
	    renat.miola();
	    renat.setVides(3);
	    if(renat.estaViu()==true){
	    	System.out.println("El Gat esta viu!!!!");
	    }else{
	    	System.out.println("El Gat a mort T.T");
	    }
	    renat.miola();
	    System.out.println("Al gat Renat li queden " + renat.getVides() + " vides");
	    if(renat.estaViu()==true){
	    	System.out.println("El Gat esta viu!!!!");
	    }else{
	    	System.out.println("El Gat a mort T.T");
	    }
	    renat.setVides(0);
	    renat.calla();
	    
	    System.out.println("Al gat Renat li queden " + renat.getVides() + " vides");
	    if(renat.estaViu()==true){
	    	System.out.println("El Gat esta viu!!!!");
	    }else{
	    	System.out.println("El Gat a mort T.T");
	    }
	    renat.miola();
	}
	    }
