package daniel.comparable_comparator.entidades;

public class OfficeEmployee extends Employee {

	// STATICS ATTRIBUTES
	private final static float LABOR_AWARDS = 0.05f;
	private final static int MIN_AWARDS = 0;

	// ATTRIBUTES
	private int amountAwards;

	// METHODS

	public OfficeEmployee(String nameAndSurname, int age, float salary, int amountAwards) {

		super(nameAndSurname, age, salaryWithAwards(salary, amountAwards));

		setAmountAwards(amountAwards);
	}

	private static float salaryWithAwards(float salary, int amountAwards) {
		
		checkSalary(salary);

		return salary += salary * amountAwards * LABOR_AWARDS;
	}



	private void setAmountAwards(int amountAwards) {

		if (amountAwards < MIN_AWARDS) {

			throw new IllegalArgumentException(String.format("'amountAwards' cannot be less than %d", MIN_AWARDS));

		}

		this.amountAwards = amountAwards;
	}

	public int getAmountAwards() {
		return amountAwards;
	}

	@Override
	public String toString() {
		return String.format(super.toString()+"Awards: %d - Type: %s ", this.amountAwards, this.getClass().getSimpleName());
	}
}
