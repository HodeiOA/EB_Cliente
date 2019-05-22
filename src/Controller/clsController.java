package Controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ObjetosDominio.clsAeropuertoDTO;
import ObjetosDominio.clsUsuarioDTO;
import ObjetosDominio.clsVueloDTO;
import Remote.clsServiceLocator;
import Remote.itfFacade;
import SWING.frmInicio;

public class clsController
{
	private clsServiceLocator sl = null;
	
	public clsController() throws RemoteException
	{
		sl = new clsServiceLocator();
		sl.setService();
		
		new frmInicio(this);
	}
	
	public boolean RegistrarUsuario(clsUsuarioDTO nuevoUsuario, boolean modo)  throws RemoteException
	{
		return sl.getService().RegistrarUsuario(nuevoUsuario, modo);
	}
	
	public clsUsuarioDTO LoginUsuario(clsUsuarioDTO nuevoUsuario, boolean modo)  throws RemoteException
	{
		return sl.getService().LoginUsuario(nuevoUsuario, modo);
	}
	
	public ArrayList<clsAeropuertoDTO> getListaAeropuertos()
	{
		//return sl.getService().getListaAeropuertos();
		
		return null;
	}
	
	public List<clsVueloDTO> BuscarVueloIda (clsAeropuertoDTO aeropuertoPred, String fecha, String ciudadOrigen, String ciudadDestino)  throws RemoteException
	{
		return sl.getService().BuscarVueloIda(aeropuertoPred, fecha, ciudadOrigen, ciudadDestino);
	}
	public List<clsVueloDTO>BuscarVueloIdayVuelta (clsAeropuertoDTO aeropuertoPred, String fechaIda, String fechaVuelta, String ciudadOrigen, String ciudadDestino)  throws RemoteException
	{
		return sl.getService().BuscarVueloIdayVuelta(aeropuertoPred, fechaIda, fechaVuelta, ciudadOrigen, ciudadDestino);
	}
	
	public List<clsVueloDTO>BuscarVueloCualquierMomento (clsAeropuertoDTO aeropuertoPred, String ciudadOrigen, String ciudadDestino)  throws RemoteException
	{
		return sl.getService().BuscarVueloCualquierMomento(aeropuertoPred, ciudadOrigen, ciudadDestino);
	}
	
	public boolean RealizarPagoyReserva (clsUsuarioDTO usuario, clsVueloDTO vuelo, int numAsiento, String nomViajero, boolean pasarela)  throws RemoteException
	{
		return sl.getService().RealizarPagoyReserva(usuario, vuelo, numAsiento, nomViajero, pasarela);
	}


}
