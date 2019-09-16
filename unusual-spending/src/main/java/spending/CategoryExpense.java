package spending;

import java.util.Objects;

public class CategoryExpense {
	private final String title;
	private final int value;

	public CategoryExpense(String title, int value) {
		this.title = title;
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CategoryExpense that = (CategoryExpense) o;
		return title.equals(that.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public String toString() {
		return "CategoryExpense{" +
			"title='" + title + '\'' +
			", value=" + value +
			'}';
	}

	public String getTitle() {
		return title;
	}

	public int getValue() {
		return value;
	}
}
