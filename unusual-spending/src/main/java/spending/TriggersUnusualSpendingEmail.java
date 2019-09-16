package spending;

public class TriggersUnusualSpendingEmail {

	private final MonthExpenseRepository monthExpenseRepository;
	private final EmailFactory emailFactory;

	public TriggersUnusualSpendingEmail(MonthExpenseRepository monthExpenseRepository, EmailFactory emailFactory) {
		this.monthExpenseRepository = monthExpenseRepository;
		this.emailFactory = emailFactory;
	}

	public void trigger(long userId) {
		final MonthExpense previousMonthExpense = monthExpenseRepository.getPreviousMonthExpense(userId);
		final MonthExpense currentMonthExpense = monthExpenseRepository.getCurrentMonthExpense(userId);
		this.emailFactory.aNewUnusualSpending(previousMonthExpense, currentMonthExpense);
	}

}
