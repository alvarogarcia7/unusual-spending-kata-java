package spending;

import java.util.List;
import java.util.Objects;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UnusualSpendingReport that = (UnusualSpendingReport) o;
		return Objects.equals(categoryExpenses, that.categoryExpenses);
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryExpenses);
	}

	@Override
	public String toString() {
		return "UnusualSpendingReport{" +
			"categoryExpenses=" + categoryExpenses +
			'}';
	}
}
