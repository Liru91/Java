package package2;

public class Clients extends Persona{
	private static int TelefonContacte;

	public int getTelefonContacte() {
		return TelefonContacte;
	}

	public void setTelefonContacte(int telefonContacte) {
		TelefonContacte = telefonContacte;
	}
	public static int MostrarTel(){
		return TelefonContacte;
	}
}
