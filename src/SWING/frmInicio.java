package SWING;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.clsController;
import ObjetosDominio.clsAeropuertoDTO;
import ObjetosDominio.clsUsuarioDTO;

/**
 * Ventana de di�logo para registro
 */
public class frmInicio extends JFrame
{
	private static Logger logger = Logger.getLogger(frmInicio.class.getName());
	private static Handler handlerPantalla;
	private static Handler handlerArchivo;
	
	private JTextField tfEmail;
	private JTextField tfTarjeta;
	private JLabel lbEmail;
	private JLabel lbTarjeta;
	private JLabel lbAeropuerto;
	private JLabel lbGoogle;
	private JLabel lbFacebook;
	private JButton btnIniciarSesion;
    private JButton btnRegistro;
    private JPanel panelUsuario;
    private JPanel panelAutorizaci�n;
    private JPanel panelBotonera;
    private JComboBox cbAeropuerto;
    
    private clsUsuarioDTO usuario;
    
    private ArrayList<clsAeropuertoDTO> lAeropuertos;

    private int altura = 300;
    private int anchura = 330;
	private int x = 100;
	private int y = 100;
	private boolean modo;
	
//	private ImageIcon imgGoogle = new ImageIcon("../images/Google.png");
//	private ImageIcon imgFacebook = new ImageIcon("../images/Facebook.png");
//	private ImageIcon imgValidado = new ImageIcon("../images/Validado.png");
	
	private boolean autorizacion = false;

	/**
	 * Constructor de la ventana de registro o inicio de sesi�n
	 */	
	public frmInicio (clsController controller)
	{		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Definimos el tama�o y la localizaci�n central en la pantalla
        this.setSize(anchura, altura);
        this.setLocation(x, y);
        setResizable(false);
        setTitle("EasyBooking");
        
        //Panel usuario
        panelUsuario= new JPanel();
        
        lbEmail = new JLabel("Email:");
        panelUsuario.add(lbEmail);
        
		tfEmail = new JTextField ();
		tfEmail.setSize(20, 10);
        panelUsuario.add(tfEmail);
        tfEmail.setColumns(10);
        
        lbTarjeta = new JLabel("Tarjeta de cr�dito:");
        panelUsuario.add(lbTarjeta);
        
        tfTarjeta = new JTextField();
        tfTarjeta.setSize(20, 10);
        panelUsuario.add(tfTarjeta);
        tfTarjeta.setColumns(10);
        
        lbAeropuerto = new JLabel("Aeropuerto:");
        panelUsuario.add(lbAeropuerto);
        
        cbAeropuerto = new JComboBox();
        panelUsuario.add(cbAeropuerto);
        
        lAeropuertos = controller.getListaAeropuertos();
        
        for(clsAeropuertoDTO aer: lAeropuertos)
        {
        	cbAeropuerto.addItem(aer);
        }
        
        //Panel autorizaci�n
        panelAutorizaci�n= new JPanel();
        
        lbGoogle = new JLabel();
//        lbGoogle.setIcon(imgGoogle);
        panelAutorizaci�n.add(lbGoogle);
        lbGoogle.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				modo = false;
			}
		});
        
        lbFacebook = new JLabel();
        panelAutorizaci�n.add(lbFacebook);
//        lbFacebook.setIcon(imgFacebook);
        lbFacebook.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				modo = true;
			}
		});
        
        //Panel botonera
        panelBotonera = new JPanel();
        
        btnIniciarSesion = new JButton("Iniciar Sesi�n");
        panelBotonera.add(btnIniciarSesion);
        
      	btnRegistro = new JButton("Registrarme"); 
      	panelBotonera.add(btnRegistro);
      	
      	btnIniciarSesion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try {
					IniciarSesion(controller);
				} catch (InterruptedException | RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
      	
      	btnRegistro.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try {
					Registro(controller);
				} catch (InterruptedException | RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

      	//Layout
      	this.getContentPane().setLayout(new BorderLayout());  
      	
      	this.getContentPane().add(panelUsuario,BorderLayout.PAGE_START);
      	panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.PAGE_AXIS));
      	
		this.getContentPane().add(panelAutorizaci�n,BorderLayout.CENTER);
      	panelAutorizaci�n.setLayout(new FlowLayout());
      	
		this.getContentPane().add(panelBotonera, BorderLayout.PAGE_END);
      	panelBotonera.setLayout(new FlowLayout());
 	}
	
	/**
	 * M�todo para gestionar el registro de un usuario
	 * @param controller 
	 * @throws InterruptedException 
	 * @throws RemoteException 
	 */
	public void Registro(clsController controller) throws InterruptedException, RemoteException
	{
		boolean aux = controller.RegistrarUsuario(usuario, modo);
		
		if( aux && !modo)
		{
//			lbGoogle.setIcon(imgValidado);
		}
		
		if( aux && modo)
		{
//			lbFacebook.setIcon(imgValidado);
		}
		
		wait(1000);
		
		tfEmail.setText("");
		tfTarjeta.setText("");
//		lbGoogle.setIcon(imgGoogle);
//		lbFacebook.setIcon(imgFacebook);
	}
	
	/**
	 * M�todo para gestionar el inicio de sesi�n de un usuario
	 * @param controller 
	 * @throws InterruptedException 
	 * @throws RemoteException 
	 */
	public void IniciarSesion(clsController controller) throws InterruptedException, RemoteException
	{
		boolean aux;
		
		usuario = controller.LoginUsuario(usuario, modo);
		
		if( usuario != null && !modo)
		{
//			lbGoogle.setIcon(imgValidado);
		}
		
		if( usuario != null && modo)
		{
//			lbFacebook.setIcon(imgValidado);
		}
		
		wait(1000);
		
		new frmBusquedaVuelo(controller, usuario);
	}
}

