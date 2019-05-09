package COMUN;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class clsServiceLocator
{
	private itfFacade servicio = null;
	
	public clsServiceLocator()
	{
		
	}
	
	public void setService()
	{
		String IP = "127.0.0.1";
		String Puerto = "1099";
		String NombreServicio = "EasyBooking";
		
		
		if (System.getSecurityManager() == null) 
		{
			System.setSecurityManager(new SecurityManager());
		}
    	
    	try 
		{
			Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
			String name = "//" + IP + ":" + Puerto + "/" + NombreServicio;			
			this.servicio = (itfFacade) registry.lookup(name);		
		} 
		catch (Exception e) 
		{
			System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public itfFacade getService()
	{
		return this.servicio;
	}
}
