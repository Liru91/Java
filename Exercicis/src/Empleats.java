package package2;

public class Empleats extends Persona{
	private static int SouBrut;

	public static int getSouBrut() {
		return SouBrut;
	}

	public static void setSouBrut(int souBrut) {
		SouBrut = souBrut;
	}
	public static int MostrarSou(){
		return SouBrut;
	}
}
