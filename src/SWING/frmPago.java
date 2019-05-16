package SWING;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controller.clsController;
import ObjetosDominio.clsUsuarioDTO;
import ObjetosDominio.clsVueloDTO;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class frmPago extends JDialog implements ActionListener
{
	Toolkit mipantalla;
	Dimension screenSize;
	
	JButton btnPaypal;
	JButton btnVisa;
	JLabel lblEligeUnMtodo;
	JPanel panelVacio;
	JLabel labelvacio;
	clsController contr = null;
	clsVueloDTO vuelo;
	clsUsuarioDTO usuario;
	int numAsiento;
	String nomViajero;
	
	public frmPago(frmReserva padre, boolean block, clsController controller, clsUsuarioDTO usuario, String nomViajero, clsVueloDTO vuelo, int numAsiento)
	{
	  super(padre, "Método de pago", block);
	  contr = controller;
	  this.vuelo=vuelo;
	  this.usuario = usuario;
	  this.numAsiento=numAsiento;
	  this.nomViajero=nomViajero;
	  
	  mipantalla=Toolkit.getDefaultToolkit();
	  screenSize=mipantalla.getScreenSize();
	  this.setLocation(screenSize.width/3, screenSize.height/4);
	  this.setSize(screenSize.width/2, screenSize.height/2);
	  setResizable(false);
	  
	  getContentPane().setLayout(new GridLayout(3,2));
	  
	  lblEligeUnMtodo = new JLabel("    Elige un m\u00E9todo de pago:");
	  lblEligeUnMtodo.setFont(lblEligeUnMtodo.getFont().deriveFont(18f));
	  getContentPane().add(lblEligeUnMtodo, BorderLayout.NORTH);
	  
	  //Label para ocupar el panel superior derecho
	  labelvacio = new JLabel("");
	  getContentPane().add(labelvacio);
	  
	  btnPaypal = new JButton("PayPal");
	  getContentPane().add(btnPaypal, BorderLayout.WEST);
	  try {
		    Image img = ImageIO.read(getClass().getResource("../Resources/paypal-logo.png"));
		    Image newimg = img.getScaledInstance( 500, 300,  java.awt.Image.SCALE_SMOOTH ) ;
		    btnPaypal.setIcon(new ImageIcon(newimg));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
	  btnPaypal.addActionListener(new ActionListener() 
	  {		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			btnPaypal.setSelected(true);
			 try {
				    Image img = ImageIO.read(getClass().getResource("../Resources/paypal-selec.jpg"));
				    Image newimg = img.getScaledInstance( 500, 300,  java.awt.Image.SCALE_SMOOTH ) ;
				    btnPaypal.setIcon(new ImageIcon(newimg));
				  } catch (Exception ex) {
				    System.out.println(ex);
				  }
			btnVisa.setSelected(false);
			try {
			    Image img = ImageIO.read(getClass().getResource("../Resources/visa.png"));
			    Image newimg = img.getScaledInstance( 550, 300,  java.awt.Image.SCALE_SMOOTH ) ;
			    btnVisa.setIcon(new ImageIcon(newimg));
			  } catch (Exception ex) {
			    System.out.println(ex);
			  }
		}
	  });
	  
	  
	  btnVisa = new JButton("Visa");
	  getContentPane().add(btnVisa, BorderLayout.EAST);
	  try {
		    Image img = ImageIO.read(getClass().getResource("../Resources/visa.png"));
		    Image newimg = img.getScaledInstance( 550, 300,  java.awt.Image.SCALE_SMOOTH ) ;
		    btnVisa.setIcon(new ImageIcon(newimg));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
	  btnVisa.addActionListener(new ActionListener() 
	  {		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Image img;
			try {
				img = ImageIO.read(getClass().getResource("../Resources/visa-selec.png"));
				Image newimg = img.getScaledInstance( 550, 300,  java.awt.Image.SCALE_SMOOTH ) ;
				 btnVisa.setIcon(new ImageIcon(newimg));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			btnVisa.setSelected(true);			   
			btnPaypal.setSelected(false);
			 try {
				    img = ImageIO.read(getClass().getResource("../Resources/paypal-logo.png"));
				    Image newimg = img.getScaledInstance( 500, 300,  java.awt.Image.SCALE_SMOOTH ) ;
				    btnPaypal.setIcon(new ImageIcon(newimg));
				  } catch (Exception ex) {
				    System.out.println(ex);
				  }
		}
	  });
	  
	  panelVacio = new JPanel();
	  getContentPane().add(panelVacio);
	  JPanel panelConfirmar = new JPanel();
	  JButton btnConfirmar = new JButton("Confirmar");
	 
	  btnConfirmar.addActionListener(this);
	  btnConfirmar.setActionCommand("CONFIRMAR");
	  panelConfirmar.setLayout(null);
	  panelConfirmar.add(btnConfirmar);
	  btnConfirmar.setBounds(262, 100, 200, 50);
	  getContentPane().add(panelConfirmar);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case "CONFIRMAR":
				
				if(btnPaypal.isSelected()||btnVisa.isSelected())
				{
					contr.RealizarPagoyReserva(usuario, vuelo, numAsiento, nomViajero);
					JOptionPane.showMessageDialog(this,
							"Tu reserva ha sido realizada con éxito ¡ Buen viaje !",
						    "Reserva realizada", 1);	
					this.dispose();
					((Window) this.getParent()).dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this,
							"Por favor, indica un método de pago",
						    "Método de pago no seleccionado",
						    JOptionPane.WARNING_MESSAGE);
				}
				break;
				
			default:
				break;
		}
	}
}
