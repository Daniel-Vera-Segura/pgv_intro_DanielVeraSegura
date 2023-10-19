import java.io.*;

public class Actividad1_1{

	public static void main(String [] args ) throws FileNotFoundException, IOException{

		//Inicializamos el RandomAccessFile 
		var f = new File("ArchivoAleatorioEmpleados.dat");
		var raf = new RandomAccessFile(f, "rw"); //Utilizamos "rw" porque vamos a leer y escribir

		StringBuffer sb; //Inicializar StringBuffer para escribir el nombre y el apellido mas adelante

		try{
			//inicializamos los datos nuevos, introducidos al iniciar el programa 
			var id = Integer.parseInt(args[0]);
			var nombre = args[1];
			var apellido = args[2];
			var dep = Integer.parseInt(args[3]);
			var sueldo = Double.parseDouble(args[4]);
			
			if((raf.length()/76)<id){ // comprobamos que la ID introducida esté en el archivo
	
				System.out.println("El ID no es válido");

			}else{
			
				raf.seek(((id-1)*76)+4); //colocamos puntero después de la ID al skipear 4 bytes con el "+4"

				//escribimos los nuevos datos 
				sb = new StringBuffer(nombre);
				sb.setLength(10);
				raf.writeChars(sb.toString());
		
	
				sb = new StringBuffer(apellido);
				sb.setLength(20); 
				raf.writeChars(sb.toString());

	
				raf.writeInt(dep); 

		
				raf.writeDouble(sueldo);

			}

		}catch(NumberFormatException nfe){ //catch para NumberFormatException que salta cuando se intenta convertir una String a un formato númerico

			System.out.println("Debe introduucir un número: " + nfe);

		}finally{

			raf.close(); // cerramos flujo

		}	
	}
}