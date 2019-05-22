package SWING;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Controller.clsController;
import ObjetosDominio.clsUsuarioDTO;
import ObjetosDominio.clsVueloDTO;

public class frmBusquedaVuelo extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 295472610848871509L;

	List <String> listaVuelos;
	
	//Listeners
	ActionListener pulsarContinuar;
	private Dimension screenSize;
	private static Toolkit mipantalla;
	
	//Paneles
	private JPanel panelFormulario;
	private JPanel panelContinuar;
	private JPanel panelTexto;
	private JPanel panelImagen;

	private JButton botonContinuar;
	private JTextField textFieldOrigen;
	private JTextField textFieldDestino;
	private JTextField textFieldIda;
	private JTextField textFieldVuelta;

	private JLabel lblOrigen;
	private JLabel lblDestino;
	private JLabel lblIda;
	private JLabel lblVuelta;
	private JLabel lblTexto;
	private JLabel lblImagen;
	
	clsController contr;
	clsUsuarioDTO usuario;
//	clsVueloDTO vuelo;

	public frmBusquedaVuelo(clsController controller, clsUsuarioDTO usuario) 
	{
		contr=controller;
		this.usuario=usuario;

		mipantalla=Toolkit.getDefaultToolkit();
		screenSize=mipantalla.getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Búsqueda de vuelo");
		setResizable(true);
		
		//Layout 
		getContentPane().setLayout(null);
		
		//Parte superior
		
		int posX = (int) (screenSize.width*0.05);
		int posY = (int) (screenSize.height*0.02);
		int width = (int) (screenSize.width*0.9);
		int heigth = (int) (screenSize.height*0.1);
		
		panelFormulario = new JPanel();
		panelFormulario.setLayout(new GridLayout(2, 4));
		panelFormulario.setBounds(posX, posY, width, heigth);
		getContentPane().add(panelFormulario);
		
		textFieldOrigen = new JTextField();
		textFieldDestino = new JTextField();
		textFieldIda = new JTextField();
		textFieldVuelta = new JTextField();
		textFieldOrigen.setFont(textFieldOrigen.getFont().deriveFont(18f));
		textFieldDestino.setFont(textFieldDestino.getFont().deriveFont(18f));
		textFieldIda.setFont(textFieldIda.getFont().deriveFont(18f));
		textFieldVuelta.setFont(textFieldVuelta.getFont().deriveFont(18f));
		
		lblOrigen = new JLabel("Aeropuerto de origen*: ");
		lblDestino = new JLabel("Aeropuerto de destino*: ");
		lblIda = new JLabel("Fecha de ida: ");
		lblVuelta = new JLabel("Fecha de vuelta: ");
		lblOrigen.setFont(lblOrigen.getFont().deriveFont(18f));
		lblDestino.setFont(lblDestino.getFont().deriveFont(18f));
		lblIda.setFont(lblIda.getFont().deriveFont(18f));
		lblVuelta.setFont(lblVuelta.getFont().deriveFont(18f));

		panelFormulario.add(lblOrigen);
		panelFormulario.add(lblDestino);
		panelFormulario.add(lblIda);
		panelFormulario.add(lblVuelta);
		panelFormulario.add(textFieldOrigen);
		panelFormulario.add(textFieldDestino);
		panelFormulario.add(textFieldIda);
		panelFormulario.add(textFieldVuelta);

		//continuar
		
		posX = (int) (screenSize.width*0.85);
		posY = (int) (screenSize.height*0.2);
		width = (int) (screenSize.width*0.1);
		heigth = (int) (screenSize.height*0.05);
		
		panelContinuar = new JPanel();
		panelContinuar.setLayout(new FlowLayout());
		panelContinuar.setBounds(posX, posY, width, heigth);
		getContentPane().add(panelContinuar);
		
		botonContinuar = new JButton("Continuar");
		botonContinuar.setFont(botonContinuar.getFont().deriveFont(18f));
		panelContinuar.add(botonContinuar);
		
		botonContinuar.addActionListener(pulsarContinuar);
		botonContinuar.setActionCommand("Continuar");
		botonContinuar.addActionListener(this);
		
		//parte medio/centro
		
		posX = (int) (screenSize.width*0.2);
		posY = (int) (screenSize.height*0.5);
		width = (int) (screenSize.width*0.5);
		heigth = (int) (screenSize.height*0.5);
		
		panelImagen = new JPanel();
		panelImagen.setLayout(new FlowLayout());
		panelImagen.setBounds(posX, posY, width, heigth);
		getContentPane().add(panelImagen);
		
		lblImagen = new JLabel(new ImageIcon(getClass().getResource("easybook.png")));
		panelImagen.add(lblImagen);
		
//		Image img= new ImageIcon("easybook.png").getImage();
//		ImageIcon img2=new ImageIcon(img.getScaledInstance(78, 124, Image.SCALE_SMOOTH));
//
//		lblImagen.add(img2);
//		et1.setIcon(img2);
		
		//parte de abajo
		
		posX = (int) (screenSize.width*0.7);
		posY = (int) (screenSize.height*0.85);
		width = (int) (screenSize.width*0.3);
		heigth = (int) (screenSize.height*0.1);
		
		panelTexto = new JPanel();
		panelTexto.setLayout(new FlowLayout());
		panelTexto.setBounds(posX, posY, width, heigth);
		getContentPane().add(panelTexto);
		
		lblTexto = new JLabel("(*)Los campos son obligatorios");
		lblTexto.setFont(lblTexto.getFont().deriveFont(18f));
		panelTexto.add(lblTexto);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case "Continuar":				
				if((textFieldOrigen.getText()).equals("")||(textFieldDestino.getText()).equals("")) 
				{
					JOptionPane.showMessageDialog(this,
							"Por favor, añade los campos obligatorios (origen y destino)",
							"Por favor, añade los campos obligatorios (origen y destino)",
						    JOptionPane.WARNING_MESSAGE);
				}
				else
				{
//					listaVuelos = new ArrayList<String>();
//					
//					listaVuelos.add("Vuelo1");
//					listaVuelos.add("Vuelo2");
//					listaVuelos.add("Vuelo3");
			//terminar_.-------------------------
					if(textFieldIda.getText().equals("")&&textFieldVuelta.getText().equals(""))
					{
						try {
							contr.BuscarVueloCualquierMomento(usuario.getAeroPreder(), textFieldOrigen.getText(), textFieldDestino.getText());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(!textFieldIda.getText().equals("")&&textFieldVuelta.getText().equals(""))
					{
						try {
							contr.BuscarVueloIda(usuario.getAeroPreder(),textFieldIda.getText(), textFieldOrigen.getText(), textFieldDestino.getText());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(!textFieldIda.getText().equals("")&&!textFieldVuelta.getText().equals(""))
					{
						try {
							contr.BuscarVueloIdayVuelta(usuario.getAeroPreder(),textFieldIda.getText(), textFieldVuelta.getText(),textFieldOrigen.getText(), textFieldDestino.getText());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(this,
								"Por favor, indique correctamente los datos de ida y vuelta",
								"Por favor, indique correctamente los datos de ida y vuelta",
							    JOptionPane.WARNING_MESSAGE);
					}
					
//					ESTO LO HACEMOS EN CONTROLLER:
//					frmSeleccionVuelo ventanaSelecVuel = new frmSeleccionVuelo(listaVuelos);
//					ventanaSelecVuel.setVisible(true);
					this.setVisible(false);

				}
				
			break;
		
			default:
			break;
		}	
	}

}
