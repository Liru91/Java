
public class Mioladors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GatRenat Renat = new GatRenat();//instancia un nou objecte de la classe gatrenat
		Gat Misifu = new Gat();//instancia un nou objecte de la classe gat
		Renat.parla();//per assegurarnos que renat pot parlar
		System.out.println("El gat Renat li pregunta a Misifu");
		Renat.miola();//crida al metode miola que es trova a GatRenat
		System.out.println("A lo que Misifu lhi contesta");
		Misifu.miola();//crida al metode miola que es trova a Gat
	}
}
