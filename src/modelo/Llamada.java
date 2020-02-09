package modelo;

import java.time.LocalDate;

public class Llamada {

	private int idLlamada;
	private Cliente cliente;
	private Empleado empleado;
	private LocalDate fecha;
	private int nivelDeSatisfaccion;
	
	public Llamada(int idLlamada, Cliente cliente, Empleado empleado, LocalDate fecha, int nivelDeSatisfaccion) throws Exception {
		super();
		this.idLlamada = idLlamada;
		this.cliente = cliente;
		this.empleado = empleado;
		this.fecha = fecha;
		setNivelDeSatisfaccion(nivelDeSatisfaccion);
	}

	public int getIdLlamada() {
		return idLlamada;
	}

	public void setIdLlamada(int idLlamada) {
		this.idLlamada = idLlamada;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNivelDeSatisfaccion() {
		return nivelDeSatisfaccion;
	}

	public void setNivelDeSatisfaccion(int nivelDeSatisfaccion) throws Exception{
		if(validarNivelDeSatisfaccion(nivelDeSatisfaccion)== false) throw new Exception("No es posible colocar el nivel de satisfaccion:" + nivelDeSatisfaccion);
		this.nivelDeSatisfaccion = nivelDeSatisfaccion;
	}


	
	@Override
	public String toString() {
		return "Llamada [idLlamada=" + idLlamada + ", cliente=" + cliente.getDni() + ", empleado=" + empleado.getDni() + ", fecha="
				+ fecha + ", nivelDeSatisfaccion=" + nivelDeSatisfaccion + "] \n";
	}

	public boolean validarNivelDeSatisfaccion(int nivelDeSatisfaccion) {
		boolean validado = false;
		
		if (nivelDeSatisfaccion>=1 && nivelDeSatisfaccion<= 5) {
			validado = true;
		}
		
		return validado;
	}
}
