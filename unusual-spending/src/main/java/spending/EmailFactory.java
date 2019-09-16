package spending;

public class EmailFactory {
	public void aNew(UnusualSpendingReport unusualSpendingReport) {
		send(new Alert());
	}

	protected void send(Alert alert) {
		//TODO implement the real email sending code
	}
}
