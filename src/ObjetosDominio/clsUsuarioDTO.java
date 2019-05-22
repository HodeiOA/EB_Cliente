package ObjetosDominio;

import java.io.Serializable;
import java.util.ArrayList;

public class clsUsuarioDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String email;
	private String numTarjetaCredito;
	private clsAeropuerto aeroPreder;
	
	public clsUsuarioDTO(String email, String numTarjetaCredito, clsAeropuerto aeroPreder) 
	{
		this.email = email;
		this.numTarjetaCredito = numTarjetaCredito;
		this.aeroPreder = aeroPreder;
	}

	public clsUsuarioDTO() 
	{
	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTarjetaCredito() {
		return numTarjetaCredito;
	}

	public void setNumTarjetaCredito(String numTarjetaCredito) {
		this.numTarjetaCredito = numTarjetaCredito;
	}

	public clsAeropuerto getAeroPreder() {
		return aeroPreder;
	}

	public void setAeroPreder(clsAeropuerto aeroPreder) {
		this.aeroPreder = aeroPreder;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
