/************* For Logging for XXX Website URL, Browser Type etc **************************
************ Author : Jabbar Ali Mirza (Framework Developer (BDD / Hybrid / Keyword for Web)*********************
************** https://www.linkedin.com/in/jabbarali/ ******************************/


package com.amazon.test_runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = {"src/test/resources/features/validate.feature"},
                tags = {"@AddItems"},
                plugin = {
                                "pretty", "html:target/cucumber-report/",
                                "json:target/cucumber.json",
                                "html:target/reports/cucumber-pretty"
                        },
                glue = {"com.amazon.step_definitions"}
        )

public class RunnerTest {




}
