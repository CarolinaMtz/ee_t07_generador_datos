package ee_t07_generador_datos;
/**
 * 
 * @author Carolina Martinez
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Interfaz extends JFrame implements ActionListener, ChangeListener{
	private static final long serialVersionUID = 1L;
	JCheckBox 	Nombres = new JCheckBox("NOMBRES"), Apellido1 = new JCheckBox("APELLIDO PATERNO"), Apellido2 = new JCheckBox("APELLIDO MATERNO "); 
	JCheckBox   Edades = new JCheckBox("EDAD"), Direcciones = new JCheckBox("DIRECCION"), Ciudades = new JCheckBox("CIUDAD");
	JCheckBox   Telefonos = new JCheckBox("TELEFONO"), CorreosElectronicos = new JCheckBox("CORREO ELECTRONICO");

	JButton generar, aceptar;
	JPanel jpanel = (JPanel) this.getContentPane(), jpanel2 = (JPanel) this.getContentPane(), jpanel3 = (JPanel) this.getContentPane(), jpanel4 = (JPanel) this.getContentPane();
	JLabel jlabel = new JLabel(), jlabel2 = new JLabel();
	
	Generador generador = new Generador();
	String[] nombre, apellidopaterno, apellidomaterno, edad, direccion, ciudad, telefono, correoelectronico,datoscompuestos;
	JTextField jtextfield = new JTextField();
	Integer numeroDatos;
	String datosGenerados;
	
	public Interfaz(){
		setTitle(" -GENERADOR DE DATOS-");
		setLayout(null);
        setBounds(70,110,350,360);        
        setResizable(false);
        jpanel.setLayout(null);
		jpanel2.setLayout(null);
		jpanel3.setLayout(null);
		jpanel4.setLayout(null);
		
        jlabel2.setBounds(new Rectangle(5, 5, 150, 21)); 
		jlabel2.setText("NUMERO DE DATOS");
		jtextfield.setBounds(new Rectangle(165, 5, 80, 21)); 
    	jpanel.add(jlabel2, null);
    	jpanel.add(jtextfield, null);
    	
    	aceptar = new JButton("ACEPTAR");
        aceptar.addActionListener(this);
        aceptar.setBounds(250,5,90,21); 
		jpanel4.add(aceptar,null);
		
        jlabel.setBounds(new Rectangle(5, 30, 300, 21));
		jlabel.setText("SELECCIONE LOS DATOS A GENERAR ");
    	jpanel2.add(jlabel, null);
 
    	setVisible(true);
        setLayout(null);
        Nombres.setBounds(10,50,150,30);
        Nombres.addChangeListener(this);        
        Apellido1.setBounds(10, 75, 150,30);
        Apellido1.addChangeListener(this);
        Apellido2.setBounds(10,100,150,30);
        Apellido2.addChangeListener(this);         
        Edades.setBounds(10,150,140,30);
        Edades.addChangeListener(this);          
        Direcciones.setBounds(10,125,160,30);
        Direcciones.addChangeListener(this);
        Ciudades.setBounds(10,155,160,30);
        Ciudades.addChangeListener(this);
        Telefonos.setBounds(10,200,150,30);
        Telefonos.addChangeListener(this);
        CorreosElectronicos.setBounds(10,178,170,30);
        CorreosElectronicos.addChangeListener(this);
 
        jpanel3.add(Nombres);
        jpanel3.add(Apellido1);
        jpanel3.add(Apellido2);
        jpanel3.add(Edades);
        jpanel3.add(Direcciones);
        jpanel3.add(Ciudades);
        jpanel3.add(Telefonos);
        jpanel3.add(CorreosElectronicos);
    	
        generar = new JButton("GENERAR");
        generar.addActionListener(this);
        generar.setBounds(100,300,100,21);
		jpanel4.add(generar,null);
	}
	
	public void actionPerformed(ActionEvent ap){		
		Integer contador = 0;
        if(ap.getSource() == generar){
        	while(contador < numeroDatos){
        		if(nombre != null)
        			datosGenerados += nombre[numeroAleatorio()] + " ";
        		if(apellidopaterno != null)
        			datosGenerados += apellidopaterno[numeroAleatorio()] + " ";
        		if(apellidomaterno != null)
        			datosGenerados += apellidomaterno[numeroAleatorio()] + " ";
        		if(edad != null)
        			datosGenerados += edad[numeroAleatorio()] + " ";
        		if(direccion != null)
        			datosGenerados += direccion[numeroAleatorio()] + " ";
        		if(ciudad != null)
        			datosGenerados += ciudad[numeroAleatorio()] + " ";
        		if(telefono != null)
        			datosGenerados += telefono[numeroAleatorio()] + " ";
        		if(correoelectronico != null)
        			datosGenerados += correoelectronico[numeroAleatorio()] + " ";
        		    datoscompuestos[contador] = datosGenerados;
        		contador++;
        	}
        	generador.generar(Integer.parseInt(jtextfield.getText()), datoscompuestos);
        	System.exit(0);        	
        }else
        	if(ap.getSource() == aceptar){
        		numeroDatos = Integer.parseInt(jtextfield.getText());
        		datoscompuestos= new String[numeroDatos];
        	}
    }

	@Override
	public void stateChanged(ChangeEvent change) {
			if(	Nombres.isSelected() == true){
				nombre = generador.leerNombres();
			}else
				if(Apellido1.isSelected() == true){
					apellidopaterno = generador.leerApellidos();
				}else
					if(Apellido2.isSelected() == true){
						apellidomaterno = generador.leerApellidos();
					}else 
						if(Edades.isSelected() == true){
							edad = generador.leerEdades();
						}else
							if(Direcciones.isSelected() == true){
								direccion = generador.leerDirecciones();
							}else
								if(Ciudades.isSelected() == true){
									ciudad = generador.leerCiudades();
								}else
								if(Telefonos.isSelected() == true){
									telefono= generador.leerTelefonos();
								}else
									if(CorreosElectronicos.isSelected() == true){
										correoelectronico = generador.leerCorreosElectronicos();
									}

									}
	
	
	public Integer numeroAleatorio(){
        Integer aux=(int)(Math.random()*999);
        return aux;
    }
	
	public static void main(String[] args) {
		Interfaz i = new Interfaz();
		i.setVisible(true);
	}
}
