package ee_t07_generador_datos;
/**
 * @author Carolina Martinez
 */
import java.io.*;
import javax.swing.*;
public class Generador {
	String[] Nombres, apellidos, edades,direcciones, ciudades, telefonos, correosElectronicos, datoscompuestos;
	
	public String[] leerNombres(){
		Nombres = new String[999];
		String cadena;
		Integer contador = 0;
	      try{
	    	  BufferedReader br = new BufferedReader(new FileReader("Nombres.txt"));
	    	  while((cadena = br.readLine()) != null && contador < 999){
	    		  Nombres[contador] = cadena;
	    		  contador++;
	    	  }
	    	  br.close();
	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null, "ERROR AL ABRIR EL ARCHIVO!");
	      }
	      return Nombres;
	}
	
	public String[] leerApellidos(){
		apellidos = new String[999];
		String cadena;
		Integer contador = 0;
	      try{
	    	  BufferedReader br = new BufferedReader(new FileReader("Apellidos.txt"));
	    	  while((cadena = br.readLine()) != null && contador < 999){
	    		  apellidos[contador] = cadena;
	    		  contador++;
	    	  }
	    	  br.close();
	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null, "ERROR AL ABRIR EL ARCHIVO!");
	      }
	      return apellidos;
	}
	
	public String[] leerEdades(){
		edades = new String[999];
		String cadena;
		Integer contador = 0;
	      try{
	    	  BufferedReader br = new BufferedReader(new FileReader("Edades.txt"));
	    	  while((cadena = br.readLine()) != null && contador < 999){
	    		  edades[contador] = cadena;
	    		  contador++;
	    	  }
	    	  br.close();
	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null, "ERROR AL ABRIR EL ARCHIVO!");
	      }
    	  return edades;
	}
		
	public String[] leerDirecciones(){
		direcciones = new String[999];
		String cadena;
		Integer contador = 0;
	      try{
	    	  BufferedReader br = new BufferedReader(new FileReader("Direcciones.txt"));
	    	  while((cadena = br.readLine()) != null && contador < 999){
	    		  direcciones[contador] = cadena;
	    		  contador++;
	    	  }
	    	  br.close();
	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null, "ERROR AL ABRIR EL ARCHIVO!");
	      }
    	  return direcciones;
	}
	
	public String[] leerCiudades(){
		ciudades = new String[999];
		String cadena;
		Integer contador = 0;
	      try{
	    	  BufferedReader br = new BufferedReader(new FileReader("Ciudades.txt"));
	    	  while((cadena = br.readLine()) != null && contador < 999){
	    		  ciudades[contador] = cadena;
	    		  contador++;
	    	  }
	    	  br.close();
	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null, "ERROR AL ABRIR EL ARCHIVO!");
	      }
    	  return ciudades;
	}
	
	public String[] leerTelefonos(){
		telefonos = new String[999];
		String cadena;
		Integer contador = 0;
	      try{
	    	  BufferedReader br = new BufferedReader(new FileReader("Telefonos.txt"));
	    	  while((cadena = br.readLine()) != null && contador < 999){
	    		  telefonos[contador] = cadena;
	    		  contador++;
	    	  }
	    	  br.close();
	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null, "ERROR AL ABRIR EL ARCHIVO!");
	      }
    	  return telefonos;
	}
	
	public String[] leerCorreosElectronicos(){
		correosElectronicos = new String[999];
		String cadena;
		Integer contador = 0;
	      try{
	    	  BufferedReader br = new BufferedReader(new FileReader("CorreosElectronicos.txt"));
	    	  while((cadena = br.readLine()) != null && contador < 999){
	    		  correosElectronicos[contador] = cadena;
	    		  contador++;
	    	  }
	    	  br.close();
	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null, "ERROR AL ABRIR EL ARCHIVO!");
	      }
    	  return correosElectronicos;
	}
	
	public Integer numeroAleatorio(){
        Integer aux=(int)(Math.random()*999);
        return aux;
    }
	public void generar(Integer numeroDatos, String...datos){
		datoscompuestos = new String[numeroDatos];
		leerNombres();
		leerApellidos();
		leerEdades();
		leerDirecciones();
		leerCiudades();
		leerTelefonos();
		leerCorreosElectronicos();
		String datosGenerados= " ";  
	          
		 try{
	            File nvoarchivo = new File("DATOS-GENERADOS.txt");
	            PrintWriter salida = new PrintWriter(new PrintWriter(nvoarchivo));
	        
	            for(int i = 0; i < datos.length; i++)
	        	   datosGenerados = datos[i]; 
	               
	               salida.println(datosGenerados); 	                         
	               salida.close();
	              
	        }catch (IOException e) {
	        	System.out.println("ERROR AL ABRIR EL ARCHIVO!");
		}
	}
}



