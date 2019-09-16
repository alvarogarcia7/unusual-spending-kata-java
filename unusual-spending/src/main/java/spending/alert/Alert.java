package spending.alert;

public class Alert {
	private final String text;
	private final String subject;

	public Alert(String text, String subject) {
		this.text = text;
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public String getSubject() {
		return subject;
	}
}
