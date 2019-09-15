package testCases;

import org.junit.Test;

public class CreateATopicTest extends BaseTest {
	String searchCriterion= "Telerik Academy";
	@Test
	public void simpleGoogleSearch() {
		actions.typeValueInField(searchCriterion, "search.Input");
		actions.waitForElementVisible("search.Button",5);
		actions.clickElement("search.Button");
		actions.waitForElementVisible("search.Result",5);
		actions.assertElementPresent("search.Result");
	}
}
