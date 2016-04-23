import java.io.*;
import java.nio.channels.FileChannel;
public abstract class Sergi {
	public static void get_Files (String directorio) {
			File directorio_aux = new File (directorio);
			if (directorio_aux.isDirectory()) {
				File[] archivos = directorio_aux.listFiles();
				System.out.println("El contenido del directorio es :\n");
				for (int i = 0; i < archivos.length; ++i) {
					System.out.println(archivos[i].getName());
				}
			}
			else {
			System.out.println("No has introducido una ruta correcta");
			}
		}
	public static void read_File (String directorio, String archivo) {
		try (BufferedReader read = new BufferedReader(new FileReader(directorio + "/" + archivo))) {
			String line;
			System.out.println("El contenido del archivo es :\n");
			while ((line = read.readLine()) != null) {
				System.out.println(line);
				KnowActionToDo(directorio, line);
			}
		} catch (FileNotFoundException fail) {
			System.out.println("No se encuetra el archivo seleccionado");
		} catch (IOException fail) {
			System.out.println("No se puede leer el archivo seleccionado");
		}
	}
	public static void KnowActionToDo (String directorio, String line) {
		String delimitadores = " ";
		String[] archivo_separado = line.split(delimitadores);
		if (archivo_separado[0].equals("mv")) {
			RenameAction(directorio, archivo_separado);
		}
		else if (archivo_separado[0].equals("borra")) {
			DeleteAction(directorio, archivo_separado);
		}
		else {
			CopyAction(directorio, archivo_separado);
		}
	}
	public static void RenameAction (String directorio, String[] archivo_separado) {
		File origen = new File (directorio + "/" + archivo_separado[1]);
		File destino = new File (directorio + "/" + archivo_separado[2]);
		origen.renameTo(destino);
	}
	public static void DeleteAction (String directorio, String[] archivo_separado) {
		File origen = new File (directorio + "/" + archivo_separado[1]);
		origen.delete();
	}
	public static void CopyAction (String directorio, String[] archivo_separado) {
		File origen = new File (directorio + "/" + archivo_separado[1]);
		File destino = new File (directorio + "/" + archivo_separado[2]);
		try {
            FileChannel in = (new FileInputStream(origen)).getChannel();
            FileChannel out = (new FileOutputStream(destino)).getChannel();
            in.transferTo(0, origen.length(), out);
            in.close();
            out.close();
		} catch(Exception fail) {
          System.out.println("No se puede copiar el archivo");
		}
	}
}