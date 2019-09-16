package spending;

public class EmailFactory {
	public void aNew(UnusualSpendingReport unusualSpendingReport) {
		final StringBuilder stringBuffer = new StringBuilder().append("Hello card user!\n" +
			"\n" +
			"We have detected unusually high spending on your card in these categories:\n" +
			"\n");
		unusualSpendingReport.map(categoryExpense -> "* You spent $" + categoryExpense.getValue() + " on " + categoryExpense.getTitle() + "\n").forEach(stringBuffer::append);
		stringBuffer.append("\n" +
			"Love,\n" +
			"\n" +
			"The Credit Card Company");
		send(new Alert(stringBuffer.toString()));
	}

	protected void send(Alert alert) {
		//TODO implement the real email sending code
	}
}
