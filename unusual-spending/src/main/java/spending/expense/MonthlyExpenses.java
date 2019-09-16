package spending.expense;

import spending.report.UnusualSpendingReport;

import java.util.*;

public class MonthlyExpenses {
	private final List<CategoryExpense> categories;

	public MonthlyExpenses(CategoryExpense... categories) {
		this.categories = Arrays.asList(categories);
	}

	public UnusualSpendingReport compareUnusualSpendingReport(MonthlyExpenses other) {
		Map<CategoryExpense, Integer> categories = new HashMap<>();

		for (CategoryExpense category : this.categories) {
			final boolean contains = other.categories.contains(category);
			if (!contains) {
				continue;
			}
			final CategoryExpense otherCategory = other.categories.get(other.categories.indexOf(category));
			if (otherCategory.getValue() > category.getValue() * 1.5F) {
				categories.put(new CategoryExpense(category.getTitle(), otherCategory.getValue()), otherCategory.getValue());
			}
		}

		return new UnusualSpendingReport(new ArrayList<>(categories.keySet()));
	}
}
