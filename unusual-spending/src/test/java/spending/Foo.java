package spending;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;

public class Foo {
	@Test
	public void canary() {
		assertThat(true, Is.is(true));
	}

	@Test
	public void a_dead_cell_is_revived_when_it_has_3_neighbours() {
		Cell cell = new Cell();

		AliveNeighbours neighbours = new AliveNeighbours(3);

		assertThat(cell.isGoingToRevive(neighbours), Is.is(true));
	}

	@Test
	public void a_living_cell_survives_when_in_a_survival_neighbourhood() {
		assertSurvival(2);
	}

	@Test
	public void a_living_cell_survives_when_in_a_survival_neighbourhood_case_3() {
		assertSurvival(3);
	}

	@Test
	public void otherwise_the_cell_dies() {
		assertDeath(0);
		assertDeath(1);
		assertDeath(atLeastThreeNeighbours());
	}

	private void assertSurvival(int aliveNeighbours) {
		Cell cell = new Cell();

		AliveNeighbours neighbours = new AliveNeighbours(aliveNeighbours);

		assertThat(cell.isGoingToDie(neighbours), Is.is(false));
	}


	private int atLeastThreeNeighbours() {
		return Math.abs(new Random().nextInt()) + 3;
	}

	private void assertDeath(int value) {
		Cell cell = new Cell();

		AliveNeighbours neighbours = new AliveNeighbours(value);

		assertThat(cell.isGoingToDie(neighbours), Is.is(true));
	}
}
