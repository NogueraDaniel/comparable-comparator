package daniel.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import daniel.comparable_comparator.entidades.Employee;
import daniel.comparable_comparator.entidades.OfficeEmployee;
import daniel.comparable_comparator.entidades.SalesEmployee;
import daniel.comparable_comparator.helpers.SortHelpersEmployees;

public class Program {

	public static void main(String arg[]) {

		try {

			ArrayList<Employee> employees = new ArrayList<>();

			employees.add(new OfficeEmployee("Jorge Vega", 65, 2120, 7));
			employees.add(new SalesEmployee("Maria Nuñez", 18, 1200, 2100));
			employees.add(new OfficeEmployee("Ricardo Gomez", 25, 1400, 3));
			employees.add(new SalesEmployee("Daniel Noguera", 21, 1300, 500));
			employees.add(new OfficeEmployee("Benito Delafuente", 35, 1900, 0));
			employees.add(new SalesEmployee("Veronica Gimenez", 40, 1800, 200));
			employees.add(new OfficeEmployee("Luisa Herrera", 55, 1400, 2));
			employees.add(new SalesEmployee("Carlos Rodriguez", 44, 1900, 900));
			employees.add(new OfficeEmployee("Juana Herrera", 29, 1700, 8));
			employees.add(new SalesEmployee("John Cash", 32, 1200, 1400));

			System.out.println("Muestro a los empleados por el orden 'natural' establecido en la"
					+ " implementacion del metodo compareTo(Employee o) de la interfaz Comparable:\n");

			employees.stream().forEach(e -> System.out.println(e + "\n"));
			
			System.out.println("---------------------------------------------------------------------------------------------");

			System.out.println("\nOrdeno a los empleados por edad usando un Comparator y los muestro: \n");
			Collections.sort(employees, SortHelpersEmployees.comparatorAge);
			employees.stream().forEach(e -> System.out.println(e + "\n"));

			System.out.println("---------------------------------------------------------------------------------------------");
			
			System.out.println("\nOrdeno a los empleados por nombre usando un Comparator y los muestro: \n");
			Collections.sort(employees, SortHelpersEmployees.comparatorName);
			employees.stream().forEach(e -> System.out.println(e + "\n"));
			
			System.out.println("---------------------------------------------------------------------------------------------");

			System.out
					.println("\nOrdeno a los vendedores por cantidad de ventas usando un Comparator y los muestro: \n");

			// Obtengo una lista reducida solo con instancias de vendedores
			List<Employee> vendors = employees.stream().filter(e -> e instanceof SalesEmployee)
					.collect(Collectors.toList());

			Collections.sort(vendors, SortHelpersEmployees.comparatorSales);
			vendors.stream().forEach(e -> System.out.println(e + "\n"));
			
			System.out.println("---------------------------------------------------------------------------------------------");

			System.out.println(
					"\nOrdeno a los oficinistas por cantidad de premios usando un Comparator y los muestro: \n");

			// Obtengo una lista reducida solo con instancias de oficinistas
			List<Employee> offworkers = employees.stream().filter(e -> e instanceof OfficeEmployee)
					.collect(Collectors.toList());

			Collections.sort(offworkers, SortHelpersEmployees.comparatorAwards);
			offworkers.stream().forEach(e -> System.out.println(e + "\n"));

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

}