package Controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import ObjetosDominio.clsAeropuertoDTO;
import ObjetosDominio.clsUsuarioDTO;
import ObjetosDominio.clsVueloDTO;
import Remote.clsServiceLocator;

public class clsController
{
	private clsServiceLocator sl = null;
	
	public clsController() throws RemoteException
	{
		sl = new clsServiceLocator();
		sl.setService();
		
		//new GUI();
	}
	
	public boolean RegistrarUsuario(clsUsuarioDTO usuario)
	{
		//return sl.getService().RegistrarUsuario(usuario);
		
		return false;
	}
	
	public clsUsuarioDTO LoginUsuario (clsUsuarioDTO nuevoUsuario)
	{
		//return sl.getService().LoginUsuario(usuario);
		
		return null;
	}
	
	public ArrayList<clsAeropuertoDTO> getListaAeropuertos()
	{
		//return sl.getService().getListaAeropuertos();
		
		return null;
	}
	
	public ArrayList<clsVueloDTO> BuscarVueloIda (clsAeropuertoDTO aeropuesrtoPred, Date fecha, String ciudadOrigen, String ciudadDestino)
	{
		//return sl.getService().BuscarVueloIda(aeropuertoPred, fecha, ciudadOrigen, ciudadDestino);
		
		return null;
	}
	public ArrayList<clsVueloDTO> BuscarVueloIdayVuelta (clsAeropuertoDTO aeropuesrtoPred, Date fechaIda, Date fechaVuelta, String ciudadOrigen, String ciudadDestino)
	{
		//return sl.getService().BuscarVueloIdayVuelta(aeropuertoPred, fechaIda, fechaVuelta, ciudadOrigen, ciudadDestino);
		
		return null;
	}
	
	public ArrayList<clsVueloDTO> BuscarVueloCualquierMomento (clsAeropuertoDTO aeropuesrtoPred, String ciudadOrigen, String ciudadDestino)
	{
		//return sl.getService().BuscarVueloCualquierMomento(aeropuertoPred, ciudadOrigen, ciudadDestino);
		
		return null;
	}
	
	public boolean RealizarPagoyReserva (clsUsuarioDTO usuario, clsVueloDTO vuelo, int numAsiento, String nomViajero)
	{
		//return sl.getService().RealizarPagoyReserva();
		
		return false;
	}


}
