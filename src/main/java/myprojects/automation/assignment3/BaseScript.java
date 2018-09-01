package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     *
     * @return New instance of {@link WebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    public static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        switch (browser) {
            // TODO prepare required WebDriver instance according to browser type
            default:
                System.setProperty(
                        "webdriver.chrome.driver",
                        new File(BaseScript.class.getResource("/chromedriver.exe").getFile()).getPath());
                return new ChromeDriver();
        }
    }

    /**
     * Creates {@link WebDriver} instance with timeout and browser window configurations.
     *
     * @return New instance of {@link EventFiringWebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    public static EventFiringWebDriver getConfiguredDriver() {
        WebDriver driver = getDriver();

        // TODO configure browser window (set timeouts, browser pindow position) and connect loggers.
        throw new UnsupportedOperationException("Method doesn't return configured WebDriver instance");
    }
    /*script for login*/
    public static void doLogin(WebDriver driver) {
        //entering login
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");

        //entering password
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");

        //clicking on "Вход" button
        driver.findElement(By.name("submitLogin")).click();
    }
    public static String nameCategory() {
        //generator for location
        String[] WordsOne = {"new", "london", "Martin", "germany", "USA", "Canada", "Bug",
                "China", "Cadi", "Brazil", "Ireland", "UK", "Ukraine",
                "Japan", "Austria", "Australia", "California", "Lamb", "Mase"};
        //finding how many words in String
        int oneLength = WordsOne.length;
        //random numbers
        int ran1=(int) (Math.random() *oneLength);
        //building random Phrase
        return WordsOne[ran1];
    }
}
