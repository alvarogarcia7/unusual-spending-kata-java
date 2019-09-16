package spending;

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
