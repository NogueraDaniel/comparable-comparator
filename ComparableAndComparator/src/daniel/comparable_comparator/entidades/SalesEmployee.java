package daniel.comparable_comparator.entidades;

public class SalesEmployee extends Employee {

	// STATICS ATTRIBUTES
	private final static float COMMISSION = 1f;
	private final static float MIN_SALES = 0f;
	// ATTRIBUTES
	private float sales;

	// METHODS

	public SalesEmployee(String nameAndSurname, int age, float salary, float sales) {
		super(nameAndSurname, age, salaryWithCommission(salary, sales));
		setSales(sales);
	}

	private static float salaryWithCommission(float salary, float sales) {

		return salary += sales * COMMISSION / 100;
	}



	private void setSales(float sales) {

		if (sales < MIN_SALES) {

			throw new IllegalArgumentException(String.format("'sales' cannot be less than %.2f", MIN_SALES));

		}

		this.sales = sales;
	}

	public float getSales() {
		return sales;
	}
	
	@Override
	public String toString() {
		return String.format(super.toString()+"Sales: %.2f - Type: %s ", this.sales, this.getClass().getSimpleName());
	}

}
