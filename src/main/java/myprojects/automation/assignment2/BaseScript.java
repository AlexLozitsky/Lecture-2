package myprojects.automation.assignment2;

import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     * @return New instance of {@link WebDriver} object.
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

    /*script for login*/
    public static void doLogin(WebDriver driver) {
        //entering login
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");

        //entering password
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");

        //clicking on "Вход" button
        driver.findElement(By.name("submitLogin")).click();
    }
}
