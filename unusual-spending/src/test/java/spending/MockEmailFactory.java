package spending;

import spending.alert.Alert;
import spending.alert.EmailFactory;

import java.util.ArrayList;
import java.util.List;

public class MockEmailFactory extends EmailFactory {
	private List<Alert> values = new ArrayList<Alert>();

	public Alert get(int index) {
		return values.get(index);
	}

	@Override
	protected void send(Alert alert) {
		this.values.add(alert);
	}
}
