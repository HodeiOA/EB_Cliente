package COMUN;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import ObjetosDominio.clsAeropuertoDTO;
import ObjetosDominio.clsUsuarioDTO;
import ObjetosDominio.clsVueloDTO;

public class clsController
{
	private clsServiceLocator sl = null;
	
	
	public static void main(String[] args) throws RemoteException
	{
		new clsController(args);
	}
	
	public clsController(String[] args) throws RemoteException
	{
		sl = new clsServiceLocator();
		sl.setService(args[0], args[1], args[2]);
		
		//new GUI();
	}
	
	boolean RegistrarUsuario(clsUsuarioDTO usuario)
	{
		//return sl.getService().RegistrarUsuario(usuario);
		
		return false;
	}
	
	clsUsuarioDTO LoginUsuario (clsUsuarioDTO nuevoUsuario)
	{
		//return sl.getService().LoginUsuario(usuario);
		
		return null;
	}
	
	ArrayList<clsAeropuertoDTO> getListaAeropuertos()
	{
		//return sl.getService().getListaAeropuertos();
		
		return null;
	}
	
	ArrayList<clsVueloDTO> BuscarVueloIda (clsAeropuertoDTO aeropuesrtoPred, Date fecha, String ciudadOrigen, String ciudadDestino)
	{
		//return sl.getService().BuscarVueloIda(aeropuertoPred, fecha, ciudadOrigen, ciudadDestino);
		
		return null;
	}
	ArrayList<clsVueloDTO> BuscarVueloIdayVuelta (clsAeropuertoDTO aeropuesrtoPred, Date fechaIda, Date fechaVuelta, String ciudadOrigen, String ciudadDestino)
	{
		//return sl.getService().BuscarVueloIdayVuelta(aeropuertoPred, fechaIda, fechaVuelta, ciudadOrigen, ciudadDestino);
		
		return null;
	}
	
	ArrayList<clsVueloDTO> BuscarVueloCualquierMomento (clsAeropuertoDTO aeropuesrtoPred, String ciudadOrigen, String ciudadDestino)
	{
		//return sl.getService().BuscarVueloCualquierMomento(aeropuertoPred, ciudadOrigen, ciudadDestino);
		
		return null;
	}
	
	boolean RealizarPagoyReserva (clsUsuarioDTO usuario, clsVueloDTO vuelo, int numAsiento, int nomViajero)
	{
		//return sl.getService().RealizarPagoyReserva();
		
		return false;
	}


}
