package com.GitHub.InvestApp.LoanServices.Karate;


import com.intuit.karate.junit5.Karate;
import cucumber.api.CucumberOptions;


@CucumberOptions(features = "classpath:karate")
public class KarateTesting {
    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }
}
