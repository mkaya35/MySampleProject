package com.mysample;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue= {"com.mysample"},
        plugin={"pretty"},
        features= "src/test/java/com/mysample/features",
        tags= "@smoke"
)
public class ApiTestRunner {
}
