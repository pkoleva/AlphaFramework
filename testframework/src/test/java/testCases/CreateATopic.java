package testCases;

import org.junit.Test;

public class CreateATopic extends BaseTest {
	String searchCriterion= "Telerik Academy";
	@Test
	public void simpleGoogleSearch() {
		actions.typeValueInField(searchCriterion, "search.Input");
		actions.waitForElementVisible("search.Button",3);
		actions.clickElement("search.Button");
		actions.waitForElementVisible("search.Result",3);
		actions.assertElementPresent("search.Result");
	}
}
