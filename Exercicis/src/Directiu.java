package package2;

public class Directiu extends Empleats{
	private static String Categoria;

	public static String getCategoria() {
		return Categoria;
	}

	public static void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public static String MostrarCategoria(){
		return Categoria;
	}
}
