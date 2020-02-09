package test;

import java.time.LocalDate;

import modelo.Cliente;
import modelo.Empleado;
import modelo.SistemaCallCenter;

public class test {

	public static void main(String[] args) {
		//creo el sistema de callcenter
		SistemaCallCenter s = new SistemaCallCenter();
		
		//añado clientes y empleados (Punto 1)
		System.out.println("Añado empleados y clientes, imprimo la lista de persona: \n");
		try {
			s.agregarEmpleado("Luis", "Lopez", 33333333, 10000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			s.agregarEmpleado("Lucas", "Gomes", 44444444, 9000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			s.agregarCliente("Pedro", "Perez", 11111111, true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			s.agregarCliente("Pablo", "Pereyra", 22222222, true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//imprimo lista de personas (Punto 1)
		System.out.println(s.getLstPersonas());
		
		//traigo e imprimo el cliente con dni = 11111111 (Punto 2)
		System.out.println("Traigo el cliente con dni 11111111 \n");
		System.out.println(s.traerPersona(11111111));
		
		//traigo e imprimo el empleado con dni = 33333333 (Punto 3)
		System.out.println("Traigo el empleado con dni 33333333 \n");
		System.out.println(s.traerPersona(33333333));
		
		//tratar de agregar el cliente  (Punto 4)
		System.out.println("Trato de agregar un cliente con un dni existente. \n");
		try {
			s.agregarCliente("Marcos", "Rios", 22222222, true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//tratar de agregar el empleado (Punto 5)
		System.out.println("Trato de agregar un empleado con un dni existente. \n");
		try {
			s.agregarEmpleado("Miguel", "Martinez", 44444444, 9500);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//agregar llamadas (Punto 6)
		System.out.println("Agrego e imprimo llamadas. \n");
		LocalDate fecha1 = LocalDate.of(2019, 12, 1);
		LocalDate fecha2 = LocalDate.of(2019, 12, 2);
		LocalDate fecha3 = LocalDate.of(2019, 12, 3);
		
		try {
			s.agregarLlamada(fecha1, (Cliente)s.traerPersona(11111111), (Empleado) s.traerPersona(33333333), 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s.agregarLlamada(fecha1, (Cliente)s.traerPersona(11111111), (Empleado) s.traerPersona(44444444), 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s.agregarLlamada(fecha1, (Cliente)s.traerPersona(22222222), (Empleado) s.traerPersona(33333333), 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s.agregarLlamada(fecha2, (Cliente)s.traerPersona(11111111), (Empleado) s.traerPersona(33333333), 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s.agregarLlamada(fecha2, (Cliente)s.traerPersona(11111111), (Empleado) s.traerPersona(33333333), 3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s.agregarLlamada(fecha2, (Cliente)s.traerPersona(11111111), (Empleado) s.traerPersona(33333333), 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s.agregarLlamada(fecha3, (Cliente)s.traerPersona(11111111), (Empleado) s.traerPersona(33333333), 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//imprimo llamadas (Punto 6)
		System.out.println(s.getLstLlamadas());
		
		//tratar de agregar la llamada (Punto 7)
		System.out.println("Trato de agregar una llamada con un numero de satisfaccion incorrecto. \n");
		try {
			s.agregarLlamada(fecha1, (Cliente) s.traerPersona(11111111), (Empleado) s.traerPersona(33333333), 6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//traer todos los clientes del sistema (Punto 8)
		System.out.println("Imprimo todos los clientes del sistema \n");
		System.out.println(s.traerClientes());
		
		//traer todos los empleados del sistema (Punto 9)
		System.out.println("Imprimo todos los empleados del sistema \n");
		System.out.println(s.traerEmpleados());
		
		//traer e imprimir las llamadas entre las fechas 01/12 y 03/12 (Punto 10)
		System.out.println("Imprimo las llamadas entre las fechas 01/10 y 03/12 \n");
		System.out.println(s.traerLlamada(fecha1, fecha3));
		
		//traer todas las llamads con nivel de satisfaccion = 5 entre el 01/12 y el 03/12 (Punto 11)
		System.out.println("Imprimo las llamadas entre las fechas 01/10 y 03/12  con nivel de satisfaccion = 5 \n");
		System.out.println(s.traerLlamada(fecha1, fecha3, 5));
		
		//calcular el porcentaje de nivel de satisfaccion de llamads cinco entre el 01/12 y el 03/12 (Punto 12)
		System.out.println("Calculo porcentaje de nivel de satisfaccion 5 entre el 01/12 y el 03/12 \n");
		System.out.println(s.calcularPorcentajeDeNivelSatisfaccionLlamada(fecha1, fecha3, 5));
		
		//traer e imprimir las llamadas entre el 01/12 y el 03/12 del empleado con dni 33333333 (Punto 13)
		System.out.println("Imprimo las llamadas entre las fechas 01/10 y 03/12 del empleado con dni 33333333 \n");
		System.out.println(s.traerLlamada(fecha1, fecha3, (Empleado) s.traerPersona(33333333)));
		
		//traer e imprimir las llamadas entre el 01/12 y el 03/12 del empleado con dni 33333333 y nivel de satisfaccion 5 (Punto 14)
		System.out.println("Imprimo las llamadas entre las fechas 01/10 y 03/12 del empleado con dni 33333333 y nivel de satisfaccion 5 \n");
		System.out.println(s.traerLlamada(fecha1, fecha3, (Empleado) s.traerPersona(33333333), 5));
		
		//calcular el porcentaje de nivel de satisfaccion 5 entre el 01/12 y el 03/12 del empleado con dni 33333333
		System.out.println("Calculo el porcentaje de nivel de satisfaccion cinco entre el 01/12 y el 03/12 del empleado con dni 33333333 \n");
		System.out.println(s.calcularPorcentajeNivelDeSatisfaccionLlamada(fecha1, fecha3, (Empleado) s.traerPersona(33333333), 5));
		

		

	}

}
