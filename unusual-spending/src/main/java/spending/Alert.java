package spending;

public class Alert {
	public String getText() {
		return "Hello card user!\n" +
			"\n" +
			"We have detected unusually high spending on your card in these categories:\n" +
			"\n" +
			"* You spent $148 on groceries\n" +
			"* You spent $928 on travel\n" +
			"\n" +
			"Love,\n" +
			"\n" +
			"The Credit Card Company";
	}
}
