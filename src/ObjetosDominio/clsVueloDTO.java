package ObjetosDominio;

import java.io.Serializable;
import java.util.ArrayList;

public class clsVueloDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String fecha;
	private ArrayList<Integer> Asientos;
	private double precio;
	private ArrayList<Integer> AsientosOcupados;
	
	public clsVueloDTO(String fecha,ArrayList<Integer> Asientos, double precio,  ArrayList<Integer> AsientosOcupados) 
	{
		this.fecha = fecha;
		this.Asientos = Asientos;
		this.precio = precio;
		this.AsientosOcupados = AsientosOcupados;
	}

	public ArrayList<Integer> getAsientosOcupados() {
		return AsientosOcupados;
	}

	public void setAsientosOcupados(ArrayList<Integer> asientosOcupados) {
		AsientosOcupados = asientosOcupados;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Integer> getAsientos() {
		return Asientos;
	}

	public void setAsientos(ArrayList<Integer> asientos) {
		Asientos = asientos;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() 
	{ 
		int asientosLibres = Asientos.size()-AsientosOcupados.size();
		return "VUELO Fecha:" + fecha + ", Asientos libres:" + asientosLibres + ", Precio:" + precio;
	}
	
	
	
}
