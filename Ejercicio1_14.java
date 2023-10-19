import java.io.*;

public class Ejercicio1_14{

	public static void main(String[] s) throws FileNotFoundException, IOException{

		var f = new File("ArchivoAleatorioEmpleados.dat");

		if(s.length != 4){
			
			System.out.println("Se necesitan 4 argumentos");

		}else{
			try{
				StringBuffer sb;

				
				var nombre = s[0];
				var apellido = s[1];
				var dep = Integer.parseInt(s[2]);
				var sueldo = Double.parseDouble(s[3]);
			
				var raf = new RandomAccessFile(f, "rw");	

				var id = ((int)raf.length())/76 + 1;
			
				raf.seek(raf.length());
	
				raf.writeInt(id); 

				sb = new StringBuffer(nombre);
				sb.setLength(10);
				raf.writeChars(sb.toString());

				sb = new StringBuffer(apellido);
				sb.setLength(20);
				raf.writeChars(sb.toString());

				raf.writeInt(dep);
			
				raf.writeDouble(sueldo);

				raf.close();			

			}catch (NumberFormatException nfe){

				System.out.println("Error al convertir datos: " + nfe);

			}
		}
	}
}