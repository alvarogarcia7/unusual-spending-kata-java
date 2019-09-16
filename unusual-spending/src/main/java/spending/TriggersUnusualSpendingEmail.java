package spending;

import spending.alert.EmailFactory;
import spending.expense.MonthExpenseRepository;
import spending.expense.MonthlyExpenses;
import spending.report.UnusualSpendingReport;

public class TriggersUnusualSpendingEmail {

	private final MonthExpenseRepository monthExpenseRepository;
	private final EmailFactory emailFactory;

	public TriggersUnusualSpendingEmail(MonthExpenseRepository monthExpenseRepository, EmailFactory emailFactory) {
		this.monthExpenseRepository = monthExpenseRepository;
		this.emailFactory = emailFactory;
	}

	public void trigger(long userId) {
		final MonthlyExpenses previousMonthlyExpenses = monthExpenseRepository.getPreviousMonthExpense(userId);
		final MonthlyExpenses currentMonthlyExpenses = monthExpenseRepository.getCurrentMonthExpense(userId);
		final UnusualSpendingReport unusualSpendingReport = previousMonthlyExpenses.compareUnusualSpendingReport(currentMonthlyExpenses);
		this.emailFactory.aNew(unusualSpendingReport);
	}

}
