

public class UsaGat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GatRenat Collin = new GatRenat();//instancia un nou objecte de la classe gat
        System.out.println("Collin menja "+Collin.getMenjar());//amb el get ens diu el menjar
        //ens diu les vides que te
        System.out.println("Collin s'enverina y perd una de les seves "+Collin.getVides()+" vides");
        Collin.setVides(Collin.getVides()-1);//li resta una vida
        System.out.println("Ara Collin tindra "+Collin.getVides()+" vides");//ens diu les vides que te
        //es crea variable per que no es perdi el valor mes tard
        String menjava=Collin.getMenjar();
        //guarda el valor 
        Collin.setMenjar("olives");
        //utilitza la variable on era el valor anterior y tambe crida al nou valor de menjar amb el get
        System.out.println("Collin no vol mes "+menjava+" ara vol menjar "+Collin.getMenjar());
        Collin.miola();//Crida al metode miola
	}

}
