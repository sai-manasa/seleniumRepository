package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles/additon.feature",glue="stepdefinations",dryRun=false,
plugin={"com.cucumber.listener.ExtentCucumberFormatter:Reports/CalciTestReport.html"})
public class RunAdd {

}
