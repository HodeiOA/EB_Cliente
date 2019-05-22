package ObjetosDominio;

import java.io.Serializable;
import java.util.ArrayList;

public class clsAeropuertoDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String codAeropuerto;
	private String ciudad;
	private String pais;
	
	public clsAeropuertoDTO(String codAeropuerto, String ciudad, String pais) 
	{
		this.codAeropuerto = codAeropuerto;
		this.ciudad = ciudad;
		this.pais = pais;
	}
	
	public String getCodAeropuerto() {
		return codAeropuerto;
	}
	public void setCodAeropuerto(String codAeropuerto) {
		this.codAeropuerto = codAeropuerto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
