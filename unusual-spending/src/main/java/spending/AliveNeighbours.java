package spending;

public class AliveNeighbours {

	private final int value;

	public AliveNeighbours(int value) {

		this.value = value;
	}

	public boolean equalTo(int rawValue) {
		return this.value == rawValue;
	}

	public boolean greaterThan(int rawValue) {
		return this.value > rawValue;
	}

	boolean smallerThan(int rawValue) {
		return value < rawValue;
	}
}
