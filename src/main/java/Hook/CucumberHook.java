package Hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class CucumberHook {

    private TestContext testContext;

    public CucumberHook(TestContext testContext) {
        this.testContext = testContext;
    }
    @Before
    public void setup(){
        testContext.getHook().start();
    }

    @After
    public void close(){
        testContext.getHook().close();
    }

}
