package spending;

public class MockEmailFactory extends EmailFactory {
	public Alert get(int index) {
		return new Alert();
	}
}
