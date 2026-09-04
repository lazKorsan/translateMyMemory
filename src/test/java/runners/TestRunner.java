package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import utilities.LoggerHelper;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "stepdefinitions.LoggingPlugin",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        features = {"src/test/resources/features/api"},
        glue = {"stepdefinitions","hooks","utilities"},


        publish = true,

        tags="@manyTranslate",

        dryRun = false
)
public class TestRunner {

        public static LoggerHelper logger = new LoggerHelper();
    /*
        Allure Report Oluşturma Adımları:
        1- Testleri çalıştırın (Runner veya 'mvn clean test')
        2- Terminale şu komutu yazarak raporu açın:
           mvn allure:serve
      yada todo
             allure serve target/allure-results


    */


}
