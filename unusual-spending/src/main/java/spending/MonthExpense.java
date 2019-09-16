package spending;

import java.util.*;

public class MonthExpense {
	private final List<CategoryExpense> categories;

	public MonthExpense(CategoryExpense... categories) {
		this.categories = Arrays.asList(categories);
	}

	public UnusualSpendingReport compareUnusualSpendingReport(MonthExpense other) {
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
