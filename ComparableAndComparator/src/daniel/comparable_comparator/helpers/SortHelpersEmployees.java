package daniel.comparable_comparator.helpers;

import java.util.Comparator;

import daniel.comparable_comparator.entidades.Employee;
import daniel.comparable_comparator.entidades.OfficeEmployee;
import daniel.comparable_comparator.entidades.SalesEmployee;

public class SortHelpersEmployees {

	// Implementation of comparator methods in static fields

	// Compare by name
	public static Comparator<Employee> comparatorName = new Comparator<>() {

		@Override
		public int compare(Employee o1, Employee o2) {

			return o1.getNameAndSurname().compareTo(o2.getNameAndSurname());
		}

	};

	// Compare by age
	public static Comparator<Employee> comparatorAge = new Comparator<>() {

		@Override
		public int compare(Employee o1, Employee o2) {

			return o1.getAge() - o2.getAge();
		}

	};

	// Compare by salary
	public static Comparator<Employee> comparatorSalary = new Comparator<>() {

		@Override
		public int compare(Employee o1, Employee o2) {

			return ((Float) o1.getSalary()).compareTo(o2.getSalary());
		}

	};

	// Compare by sales
	public static Comparator<Employee> comparatorSales = new Comparator<>() {

		@Override
		public int compare(Employee o1, Employee o2) {

			SalesEmployee s1 = (SalesEmployee) o1;
			SalesEmployee s2 = (SalesEmployee) o2;

			return ((Float) s1.getSales()).compareTo(s2.getSales());
		}

	};

	// Compare by awards
	public static Comparator<Employee> comparatorAwards = new Comparator<>() {

		@Override
		public int compare(Employee o1, Employee o2) {

			OfficeEmployee of1 = (OfficeEmployee) o1;
			OfficeEmployee of2 = (OfficeEmployee) o2;

			return of1.getAmountAwards() - of2.getAmountAwards();
		}

	};

}
