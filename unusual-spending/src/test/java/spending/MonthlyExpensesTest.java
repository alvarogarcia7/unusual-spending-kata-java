package spending;

import org.hamcrest.core.Is;
import org.junit.Test;
import spending.expense.CategoryExpense;
import spending.expense.MonthlyExpenses;
import spending.report.UnusualSpendingReport;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


public class MonthlyExpensesTest {

	@Test
	public void matches_when_over_50_percent() {
		MonthlyExpenses previousMonth = new MonthlyExpenses(new CategoryExpense("groceries", 0), new CategoryExpense("travel", 0));
		MonthlyExpenses currentMonth = new MonthlyExpenses(new CategoryExpense("groceries", 148), new CategoryExpense("travel", 928));

		assertThat(previousMonth.compareUnusualSpendingReport(currentMonth), Is.is(new UnusualSpendingReport(List.of(new CategoryExpense("groceries", 148), new CategoryExpense("travel", 928)))));
	}

	@Test
	public void some_category_over_50_percent() {
		MonthlyExpenses previousMonth = new MonthlyExpenses(new CategoryExpense("groceries", 0), new CategoryExpense("travel", 0));
		MonthlyExpenses currentMonth = new MonthlyExpenses(new CategoryExpense("groceries", 0), new CategoryExpense("travel", 928));

		assertThat(previousMonth.compareUnusualSpendingReport(currentMonth), Is.is(new UnusualSpendingReport(List.of(new CategoryExpense("travel", 928)))));
	}


	@Test
	public void all_categories_below_50_percent() {
		MonthlyExpenses previousMonth = new MonthlyExpenses(new CategoryExpense("groceries", 100), new CategoryExpense("travel", 100));
		MonthlyExpenses currentMonth = new MonthlyExpenses(new CategoryExpense("groceries", 100), new CategoryExpense("travel", 100));

		assertThat(previousMonth.compareUnusualSpendingReport(currentMonth), Is.is(new UnusualSpendingReport(List.of())));
	}

}
