package spending;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class UnusualSpendingReport {
	private final List<CategoryExpense> categoryExpenses;

	public UnusualSpendingReport(List<CategoryExpense> categoryExpenses) {
		this.categoryExpenses = categoryExpenses;
	}

	<R> Stream<R> map(Function<? super CategoryExpense, ? extends R> mapper) {
		return categoryExpenses.stream().map(mapper);
	}

}
