package org.testrun;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\NAREN\\eclipse-workspace\\CucumberPom\\src\\test\\resources\\Feature\\cucumberPom.feature",
glue="org.teststep",
dryRun=false)
public class TestRunnerClass {

}
