package com.pet.store.journey.runner;

import com.pet.store.journey.utils.Retry;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com/pet/store/journey/stepdefinitions"},
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class PetStoreTests extends AbstractTestNGCucumberTests {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {
        for (ITestNGMethod method : context.getSuite().getAllMethods()) {
            method.setRetryAnalyzerClass(Retry.class);
        }
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}