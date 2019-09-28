package stepdefinitions;

import com.telerikacademy.testframework.UserActions;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;

public class BaseStepDefinitions {
    @BeforeStories
    public void beforeStories(){
        UserActions.loadBrowser();
    }

    @AfterStories
    public void afterStories(){
        UserActions.quitDriver();
    }
}
