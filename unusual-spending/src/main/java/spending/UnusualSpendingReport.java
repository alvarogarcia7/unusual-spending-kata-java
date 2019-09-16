package spending;

import java.util.List;

public class UnusualSpendingReport {
	private final List<CategoryExpense> categoryExpenses;

	public UnusualSpendingReport(List<CategoryExpense> categoryExpenses) {
		this.categoryExpenses = categoryExpenses;
	}

	public CategoryExpense get(int index) {
		return this.categoryExpenses.get(index);
	}
}
