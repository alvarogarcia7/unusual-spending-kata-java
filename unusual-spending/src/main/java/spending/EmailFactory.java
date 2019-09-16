package spending;

public class EmailFactory {
	public void aNew(UnusualSpendingReport unusualSpendingReport) {
		send(new Alert("Hello card user!\n" +
			"\n" +
			"We have detected unusually high spending on your card in these categories:\n" +
			"\n" +
			"* You spent $148 on groceries\n" +
			"* You spent $928 on travel\n" +
			"\n" +
			"Love,\n" +
			"\n" +
			"The Credit Card Company"));
	}

	protected void send(Alert alert) {
		//TODO implement the real email sending code
	}
}
