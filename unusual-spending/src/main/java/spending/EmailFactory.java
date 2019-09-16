package spending;

public class EmailFactory {
	public void aNewUnusualSpending(MonthExpense previousMonthExpense, MonthExpense currentMonthExpense) {
		send(new Alert());
	}

	protected void send(Alert alert) {

	}
}
