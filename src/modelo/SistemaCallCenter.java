package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaCallCenter {

	private List<Llamada> lstLlamadas;
	private List<Persona> lstPersonas;
	public SistemaCallCenter() {
		super();
		this.lstLlamadas = new ArrayList<Llamada>();
		this.lstPersonas = new ArrayList<Persona>();
	}
	public List<Llamada> getLstLlamadas() {
		return lstLlamadas;
	}
	public void setLstLlamadas(List<Llamada> lstLlamadas) {
		this.lstLlamadas = lstLlamadas;
	}
	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}
	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}
	@Override
	public String toString() {
		return "SistemaCallCenter [lstLlamadas=" + lstLlamadas + ", lstPersonas=" + lstPersonas + "]";
	}
	
	public Persona traerPersona(long dni) {
		int i = 0;
		Persona p = null;
		while (i<lstPersonas.size() && p == null) {
			if(lstPersonas.get(i).getDni() == dni) {
				p = lstPersonas.get(i);
			}
			i++;
		}
		return p;
	}
	
	public boolean agregarCliente (String nombre, String apellido, long dni, boolean activo)throws Exception {
		if((Cliente)traerPersona(dni)!=null) throw new Exception ("Ya existe un cliente con el dni:"+dni);
		int id =1;
		if(!lstPersonas.isEmpty()) {
			id = lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		}
		return lstPersonas.add(new Cliente(id, nombre, apellido, dni, activo));
	}
	
	public boolean agregarEmpleado(String nombre, String apellido, long dni, int sueldoBase) throws Exception{
		if((Empleado)traerPersona(dni)!=null) throw new Exception ("Ya existe un empleado con el dni:"+dni);
		int id =1;
		if(!lstPersonas.isEmpty()) {
			id = lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		}
		return lstPersonas.add(new Empleado(id, nombre, apellido, dni, sueldoBase));
	}
	
	public boolean agregarLlamada(LocalDate fecha, Cliente cliente, Empleado empleado, int nivelDeSatisfaccion) throws Exception {
		int id = 1;
		if(!lstLlamadas.isEmpty()) {
			id = lstLlamadas.get(lstLlamadas.size()-1).getIdLlamada()+1;
		}
		return lstLlamadas.add(new Llamada(id, cliente, empleado, fecha, nivelDeSatisfaccion));
	}
	
	public List<Cliente> traerClientes(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		for (Persona p: lstPersonas) {
			if(p instanceof Cliente) {
				clientes.add((Cliente) p);
			}
		}
		
		return clientes;
	}
	
	public List<Empleado> traerEmpleados(){
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		for (Persona p: lstPersonas) {
			if(p instanceof Empleado) {
				empleados.add((Empleado) p);
			}
		}
		
		return empleados;	
	}
	
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta){
		List<Llamada> llamadas = new ArrayList<Llamada>();
		
		for (Llamada l: lstLlamadas) {
			if (l.getFecha().isAfter(desde) || l.getFecha() == desde && l.getFecha() == hasta || l.getFecha().isBefore(hasta)) {
				llamadas.add(l);
			}
		}
		return llamadas;
	}
	
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, int nivelDeSatisfaccion){
		List<Llamada> llamadas = traerLlamada(desde, hasta);
		List<Llamada> llamadasnivel = new ArrayList<Llamada>();
		
		for ( Llamada l : llamadas) {
			if (l.getNivelDeSatisfaccion() == nivelDeSatisfaccion) {
				llamadasnivel.add(l);
			}
		}
		return llamadasnivel;
	}
	
	public double calcularPorcentajeDeNivelSatisfaccionLlamada(LocalDate desde, LocalDate hasta, int nivelDeSatisfaccion) {
		List<Llamada> llamadasnivel = traerLlamada(desde, hasta, nivelDeSatisfaccion);
		double porcentaje = 0;
		double dato1 = (lstLlamadas.size()) * 1.0;
		double dato2 = (llamadasnivel.size()) * 1.0;
		
		porcentaje = (dato2/dato1)*100;
		
		return porcentaje;
	}
	
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, Empleado empleado){
		List<Llamada> llamadas = traerLlamada(desde, hasta);
		List<Llamada> llamadasempleado = new ArrayList<Llamada>();
		
		for (Llamada l: llamadas) {
			if (l.getEmpleado() == empleado) {
				llamadasempleado.add(l);
			}
		}
		
		return llamadasempleado;
	}
	
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, Empleado empleado, int nivelDeSatisfaccion){
		List<Llamada> llamadas = traerLlamada(desde, hasta, empleado);
		List<Llamada> llamadasnivel = new ArrayList <Llamada>();
		
		for (Llamada l: llamadas) {
			if (l.getNivelDeSatisfaccion() == nivelDeSatisfaccion) {
				llamadasnivel.add(l);
			}
		}
		
		return llamadasnivel;
	}
	
	public double calcularPorcentajeNivelDeSatisfaccionLlamada(LocalDate desde, LocalDate hasta, Empleado empleado, int nivelDeSatisfaccion) {
		List<Llamada> llamadasnivel = traerLlamada(desde, hasta,empleado, nivelDeSatisfaccion);
		List<Llamada> llamadasempleado = traerLlamada(desde, hasta, empleado);
		double porcentaje = 0;
		double dato1 = (llamadasempleado.size()) * 1.0;
		double dato2 = (llamadasnivel.size()) * 1.0;
		
		porcentaje = (dato2/dato1)*100;
		
		return porcentaje;
	}
}
