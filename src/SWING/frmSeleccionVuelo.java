package SWING;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.sound.midi.ControllerEventListener;
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

public class frmSeleccionVuelo extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 295472610848871509L;
	//listaParam
//	List <String> listaDeVuelos;
	
	//Listeners
	ActionListener pulsarContinuar;
	private Dimension screenSize;
	private static Toolkit mipantalla;
	
	//Paneles
	private JPanel panelFormulario;
	private JPanel panelContinuar;
	private JPanel panelTexto;
	private JPanel panelLista;

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
	
	private JScrollPane scrollLista;
	@SuppressWarnings("rawtypes")
	private DefaultListModel model;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JList jListVuelos;
	
	clsController contr;
	clsUsuarioDTO usuario;
	List <clsVueloDTO> listaDeVuelos;
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public frmSeleccionVuelo(List <clsVueloDTO> listaVuelos, clsUsuarioDTO usuario, clsController controller) 
	{
		
		listaDeVuelos = listaVuelos;
		
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
				
		posX = (int) (screenSize.width*0.05);
		posY = (int) (screenSize.height*0.15);
		width = (int) (screenSize.width*0.2);
		heigth = (int) (screenSize.height*0.1);
		
		panelTexto = new JPanel();
		panelTexto.setLayout(new GridLayout());
		panelTexto.setBounds(posX, posY, width, heigth);
		getContentPane().add(panelTexto);
		
		lblTexto = new JLabel("Escoje tu vuelo: ");
		lblTexto.setFont(lblTexto.getFont().deriveFont(18f));
		panelTexto.add(lblTexto);
		
		//lista
		
		posX = (int) (screenSize.width*0.05);
		posY = (int) (screenSize.height*0.25);
		width = (int) (screenSize.width*0.7);
		heigth = (int) (screenSize.height*0.5);
		
		panelLista= new JPanel();
		panelLista.setLayout(new GridLayout());
		panelLista.setBounds(posX, posY, width, heigth);
		getContentPane().add(panelLista);
		
		model = new DefaultListModel();
		
		
		for (clsVueloDTO vuelo : listaVuelos) 
		{
			//aquí no sé si se muestran los datos de dentro del objeto
			model.addElement(vuelo);
		}
		
		jListVuelos = new JList(model);
		jListVuelos.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
		
		scrollLista = new JScrollPane(jListVuelos);
		scrollLista.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));

//		scrollLista.setLocation(posX, posY);;
//		scrollLista.setSize(348,500);
		panelLista.add(scrollLista);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case "Continuar":				
//				if((textFieldOrigen.getText()).equals("")||(textFieldDestino.getText()).equals("")) 
//				{
//					JOptionPane.showMessageDialog(this,
//							"Por favor, añade los campos obligatorios (origen y destino)",
//							"Por favor, añade los campos obligatorios (origen y destino)",
//						    JOptionPane.WARNING_MESSAGE);
//				}
//				else
//				{
					int index = jListVuelos.getSelectedIndex();
					clsVueloDTO vuelo = listaDeVuelos.get(index);
		//hacer:--------------------------------
					frmReserva ventanaReserva = new frmReserva(vuelo,contr,usuario);
					ventanaReserva.setVisible(true);
					this.setVisible(false);
//				}
				
			break;
		
			default:
			break;
		}
		
	}
	
	

}
