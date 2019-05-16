package Remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import ObjetosDominio.clsAeropuertoDTO;
import ObjetosDominio.clsUsuarioDTO;
import ObjetosDominio.clsVueloDTO;


public interface itfFacade extends Remote
{
	boolean RegistrarUsuario (clsUsuarioDTO nuevoUsuario, boolean modo)  throws RemoteException;
	clsUsuarioDTO LoginUsuario (clsUsuarioDTO nuevoUsuario, boolean modo)  throws RemoteException;
	public List<clsVueloDTO> BuscarVueloIda (clsAeropuertoDTO aeropuesrtoPred, String fecha, String ciudadOrigen, String ciudadDestino)  throws RemoteException;
	public List<clsVueloDTO>BuscarVueloIdayVuelta (clsAeropuertoDTO aeropuesrtoPred, String fechaIda, String fechaVuelta, String ciudadOrigen, String ciudadDestino)  throws RemoteException;
	public List<clsVueloDTO>BuscarVueloCualquierMomento (clsAeropuertoDTO aeropuesrtoPred, String ciudadOrigen, String ciudadDestino)  throws RemoteException;
	boolean RealizarPagoyReserva (clsUsuarioDTO usuario, clsVueloDTO vuelo, int numAsiento, String nomViajero, boolean pasarela)  throws RemoteException;
}
