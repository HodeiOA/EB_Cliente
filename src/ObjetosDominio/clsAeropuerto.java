package ObjetosDominio;

import java.io.Serializable;
import java.util.ArrayList;

public class clsAeropuerto implements Serializable
{
	private String codAeropuerto;
	private String ciudad;
	private String pais;
	
	public clsAeropuerto()
	{
		codAeropuerto = null;
		ciudad = null;
		pais = null;
	}
	
	public clsAeropuerto(String codAeropueto, String ciudad, String pais)
	{
		this.codAeropuerto =  codAeropueto;
		this.ciudad = ciudad;
		this.pais = pais;
	}

	public String getCodAeropuerto()
	{
		return codAeropuerto;
	}

	public String getCiudad()
	{
		return ciudad;
	}

	public String getPais()
	{
		return pais;
	}

	public void setCodAeropuerto(String codAeropuerto)
	{
		this.codAeropuerto = codAeropuerto;
	}

	public void setCiudad(String ciudad)
	{
		this.ciudad = ciudad;
	}

	public void setPais(String pais)
	{
		this.pais = pais;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAeropuerto == null) ? 0 : codAeropuerto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsAeropuerto other = (clsAeropuerto) obj;
		if (codAeropuerto == null) {
			if (other.codAeropuerto != null)
				return false;
		} else if (!codAeropuerto.equals(other.codAeropuerto))
			return false;
		return true;
	}
	
	
}
