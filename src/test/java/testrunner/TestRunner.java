package testrunner;

import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        /*features="Features/makemytrip.feature",
        glue={"stepdefmakemytrip"},*/

        features="Features/makemytripcompletetest.feature",
        glue={"stepdefmakemytripcomplete"},

        monochrome = false,
        publish = true,
        plugin={"pretty","html:test-output.html","json:json_output/report.json","junit:junit-output/cucumber.xml" })


public class TestRunner {

}
