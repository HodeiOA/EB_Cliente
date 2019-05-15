package ObjetosDominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class clsVueloDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Date fecha;
	private ArrayList<Integer> Asientos;
	private double precio;
	private ArrayList<Integer> AsientosOcupados;
	
	public clsVueloDTO(Date fecha, int numAsientosLibres,ArrayList<Integer> AsientosLibres, double precio,  ArrayList<Integer> AsientosOcupados) 
	{
		this.fecha = fecha;
		this.Asientos = AsientosLibres;
		this.precio = precio;
		this.AsientosOcupados = AsientosOcupados;
	}

	public ArrayList<Integer> getAsientosOcupados() {
		return AsientosOcupados;
	}

	public void setAsientosOcupados(ArrayList<Integer> asientosOcupados) {
		AsientosOcupados = asientosOcupados;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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
	
}
