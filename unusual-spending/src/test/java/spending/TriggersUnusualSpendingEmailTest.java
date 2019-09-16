package spending;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TriggersUnusualSpendingEmailTest {

	@Test
	public void trigger() {

		MonthExpense previousMonth = new MonthExpense(new CategoryExpense("groceries", 0), new CategoryExpense("travel", 0));
		MonthExpense currentMonth = new MonthExpense(new CategoryExpense("groceries", 148), new CategoryExpense("travel", 928));
		MonthExpenseRepository monthExpenseRepository = mock(MonthExpenseRepository.class);
		when(monthExpenseRepository.getPreviousMonthExpense(anyLong())).thenReturn(previousMonth);
		when(monthExpenseRepository.getCurrentMonthExpense(anyLong())).thenReturn(currentMonth);
		MockEmailFactory emailFactory = new MockEmailFactory();

		new TriggersUnusualSpendingEmail(monthExpenseRepository, emailFactory).trigger(1);

		Alert alert = emailFactory.get(0);

		assertThat(alert.getText(), Is.is("Hello card user!\n" +
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
}
