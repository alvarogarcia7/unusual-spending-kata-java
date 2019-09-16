package spending;

import java.util.function.Function;

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
		final int total = unusualSpendingReport.map(CategoryExpense::getValue).mapToInt(value -> value).sum();
		send(new Alert(stringBuffer.toString(), "Unusual spending of $" + total + " detected!"));
	}

	protected void send(Alert alert) {
		//TODO implement the real email sending code
	}
}
