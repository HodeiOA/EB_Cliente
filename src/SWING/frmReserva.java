package SWING;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Controller.clsController;
import ObjetosDominio.clsUsuarioDTO;
import ObjetosDominio.clsVueloDTO;

public class frmReserva extends JFrame implements ActionListener
{
	//Listeners
	ActionListener reserva;
	private Dimension screenSize;
	private static Toolkit mipantalla;
	
	//Paneles
	private JPanel panel1;
	private JPanel panel2;
	JPanel panel11;
	JPanel panel12;
	
	private ArrayList<JButton> Botones = new ArrayList <JButton>();
	private JScrollPane scrollLista;
	private DefaultListModel model = new DefaultListModel();
	private JList listAsientos=new JList(model);
	private JTextField textFieldNomViajero;
	private JButton btnRealizarReserva;
	private JLabel lblViajero;
	clsController contr;
	clsUsuarioDTO usuario;
	clsVueloDTO vuelo;
	/*
	 * En principio, intentaremos poner los asiestos de manera que mostremos botones cuyos colores varían según si está
	o no reservados. Para ello, tendremos que leer de la BD externa el vuelo en concreto y comparar sus asientos globales
	y compararlos con los de todas las reservas
	 */
	
	/*
	 * Si lo de los botones no fnciona, lo haremos con una lista que muestre todos los asientos disponibles (lo que tambiñen
	 se tendrá que hacer comparando las reservas y los del vuelo
	 */
	
	public frmReserva(clsVueloDTO vuelo, clsController controller, clsUsuarioDTO usuario)
	{
		mipantalla=Toolkit.getDefaultToolkit();
		screenSize=mipantalla.getScreenSize();
		setSize(screenSize.width, screenSize.height - 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Reserva");
		setResizable(true);
		contr=controller;
		this.usuario = usuario;
		this.vuelo = vuelo;
		//Layout 
		getContentPane().setLayout(new GridLayout());
		
		
		//Parte superior
	//	panel2 = new JPanel();
		//getContentPane().add(panel2);
		//panel2.setBounds(0,0, 1798, 40);
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(10, 40, 1321, 868);
		getContentPane().add(panel1);
		
//		//Solución con LISTA-----------------------------
//		
//		vuelo = new JTextArea ("Realizando reserva para " + nombreVuelo);
//		vuelo.setBounds(0, 91, 705, -91);
//		vuelo.setFont(vuelo.getFont().deriveFont(18f));
//		vuelo.setEditable(false);
//		vuelo.setBackground(new Color(0,0,0,0));
//		panel1.add(vuelo);
//		
//		
//		 for (int i = 0; i < 15; i++)
//			 for (int j = 0; j < 15; j++)
//		      model.addElement("Asiento " + i +"-" + j);
//		      
//		
//		scrollLista = new JScrollPane(listAsientos);
//		scrollLista.setLocation(98, 129);
//		scrollLista.setSize(348,500);
//		
//		panel1.add(scrollLista);
//		
//		listAsientos=new JList(model);
//		listAsientos.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
//		scrollLista.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
//		
//		lblAsientosDisponibles = new JLabel("Asientos disponibles:");
//		lblAsientosDisponibles.setFont(lblAsientosDisponibles.getFont().deriveFont(18f));
//		lblAsientosDisponibles.setBounds(97, 104, 296, 20);
//		panel1.add(lblAsientosDisponibles);
//		//FIN solución lista
		
		//Solución con BOTONES ---------------
		panel11 = new JPanel();
		panel11.setBounds(52, 108, 375, 577);
		panel1.add(panel11);

		panel12 = new JPanel();
		panel12.setBounds(490, 108, 375, 577);
		panel1.add(panel12);
		
		ArrayList<Integer>asientosOcupados  = vuelo.getAsientosOcupados();
		ArrayList<Integer>asientos = vuelo.getAsientos();
		
		 for (int i = 0; i < asientos.size(); i++)
		 {
			 for (int j = 0; j < 2; j++)
			 {
				 if(asientosOcupados.contains(i))
				 {
					 JButton ji = new JButton("Asiento " + i +"-" + j);
					 panel11.add(ji);
					 ji.setActionCommand("Asiento " + i +"-" + j);
					 ji.addActionListener(this);
					 Botones.add(ji);
					 if(ComprobarAsientoElegido("Asiento " + i +"-" + j))
					 { 
						 ji.setEnabled(false);
						 ji.setBackground(Color.red);
					 }
				 }
				 else
				 {
					 JButton ji = new JButton("Asiento " + i +"-" + j);
					 panel12.add(ji);
					 ji.setActionCommand("Asiento " + i +"-" + j);
					 ji.addActionListener(this);
					 Botones.add(ji);
				 }
				
			 }
		 }
		//FIN solución con botones-------------------------------------	 	
		
		lblViajero = new JLabel("Nombre del/a viajero/a:");
		lblViajero.setFont(lblViajero.getFont().deriveFont(18f));;
		lblViajero.setBounds(103, 736, 246, 20);
		panel1.add(lblViajero);
		
		textFieldNomViajero = new JTextField();
		textFieldNomViajero.setBounds(349, 734, 464, 26);
		panel1.add(textFieldNomViajero);
		textFieldNomViajero.setColumns(10);
		textFieldNomViajero.setActionCommand("NOMBRE");
		textFieldNomViajero.addActionListener(this);
		
		//Panel3
		panel2= new JPanel();
		this.getContentPane().add(panel2);
		panel2.setLayout(null);
		btnRealizarReserva = new JButton("REALIZAR RESERVA");
		btnRealizarReserva.setFont(btnRealizarReserva.getFont().deriveFont(18f));
		panel2.add(btnRealizarReserva);
		btnRealizarReserva.setBounds(250, 333, 402, 291);
		
		btnRealizarReserva.addActionListener(reserva);
		btnRealizarReserva.setActionCommand("RESERVA");
		btnRealizarReserva.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().contains("Asiento"))
		{
			marcarAsientoElegido(e);
		}
		else
		{
			switch(e.getActionCommand())
			{
				case "RESERVA":
					//Recorremos todos los botones para ver si ha pulsardo alguno
					boolean botonSelec = false;
					for(JButton a : Botones)
					{
						if(a.isSelected())botonSelec=true;
					}
					//Comprobamos en la lista si ha seleccionado algo
//					boolean listaSelec = listAsientos.isSelectionEmpty();
					if((textFieldNomViajero.getText()).equals("")||botonSelec) //Cambiar por listaSelec si se hace lista
					{
						JOptionPane.showMessageDialog(this,
								"Por favor, añade un nombre y elige un asiento antes de reservar",
							    "Rellena todos los campos",
							    JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						JButton boton = (JButton)e.getSource();
						String asiento = boton.getText();
						int numAsiento = Integer.parseInt(asiento);
						frmPago ventanaPago = new frmPago(this,true, contr,usuario, textFieldNomViajero.getText(),vuelo, numAsiento);
						ventanaPago.setVisible(true);
					}
						
				break;
			
				default:
				break;
			}	
		}
	}
	public void marcarAsientoElegido(ActionEvent e)
	{
		//Poner el resto de asientos nomal
		for(JButton a : Botones)
		{
			String texto = a.getText();
			if(!ComprobarAsientoElegido(texto))
			{ 
				JButton b = new JButton();
				a.setEnabled(true);
				a.setBackground(b.getBackground());
			}
		}
		//Marcar el actual
		((JButton)e.getSource()).setEnabled(false);
		((JButton)e.getSource()).setBackground(Color.green);
	}
	
	public boolean ComprobarAsientoElegido(String nombre)
	{
		//Leemos en la BD qué asientos están ya ocupados
		return false;
	}

}
