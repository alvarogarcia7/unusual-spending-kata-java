package spending;

public class Cell {

	public boolean isGoingToRevive(AliveNeighbours neighbours) {
		return neighbours.equalTo(3);
	}

	public boolean isGoingToDie(AliveNeighbours neighbours) {
		return (neighbours.greaterThan(3) || neighbours.smallerThan(2));
	}

}
