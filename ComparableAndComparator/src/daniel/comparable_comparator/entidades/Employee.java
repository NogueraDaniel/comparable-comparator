package daniel.comparable_comparator.entidades;

/* Example Interface Comparator vs Comparable */

public abstract class Employee implements Comparable<Employee> {

	// STATIC ATTRIBUTES
	private static int ID_COUNTER = 1;
	private static final int MIN_AGE = 18;
	private static final int MAX_AGE = 65;
	protected static final float MINIMUN_SALARY = 1200f;

	// ATTRIBUTES
	private int idEmployee;
	private String nameAndSurname;
	private int age;
	private float salary;

	// METHODS

	// Implementation of the comparable method
	@Override
	public int compareTo(Employee o) {

		return this.idEmployee - o.idEmployee;
	}

	public Employee(String nameAndSurname, int age, float salary) {

		this.idEmployee = ID_COUNTER;

		setNameAndSurname(nameAndSurname);
		setAge(age);
		setSalary(salary);

		increaseId();
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public String getNameAndSurname() {
		return nameAndSurname;
	}

	public int getAge() {
		return age;
	}

	public float getSalary() {
		return salary;
	}

	private void increaseId() {

		Employee.ID_COUNTER++;
	}

	public static void checkSalary(float salary) {
		if (salary < MINIMUN_SALARY) {

			throw new IllegalArgumentException(
					String.format("'salary' cannot be less than %.2f", MINIMUN_SALARY));
		}
	}

	private void setNameAndSurname(String nameAndSurname) {

		if (nameAndSurname == null || nameAndSurname.isBlank()) {

			throw new IllegalArgumentException("'nameAndSurname' cannot be null or blank");

		}

		this.nameAndSurname = nameAndSurname;
	}

	private void setAge(int age) {

		if (age < MIN_AGE || age > MAX_AGE) {

			throw new IllegalArgumentException(
					String.format("'years' cannot be less than %d or greater than %d", MIN_AGE, MAX_AGE));

		}

		this.age = age;
	}

	protected void setSalary(float salary) {
		
		this.salary = salary;
	};

	@Override
	public String toString() {
		return String.format("ID: %d - Name: %s - Age: %d - Salary: U$S %.2f - ", this.idEmployee,this.nameAndSurname, this.age, this.salary);
	}

}