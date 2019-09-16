package spending;

public class EmailFactory {
	public void aNew(UnusualSpendingReport unusualSpendingReport) {
		final StringBuffer stringBuffer = new StringBuffer().append("Hello card user!\n" +
			"\n" +
			"We have detected unusually high spending on your card in these categories:\n" +
			"\n");
		stringBuffer.append("* You spent $" + unusualSpendingReport.get(0).getValue() + " on " + unusualSpendingReport.get(0).getTitle() + "\n");
		stringBuffer.append("* You spent $" + unusualSpendingReport.get(1).getValue() + " on " + unusualSpendingReport.get(1).getTitle() + "\n");
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
