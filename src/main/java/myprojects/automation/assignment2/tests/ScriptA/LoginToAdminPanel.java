package myprojects.automation.assignment2.tests.ScriptA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static myprojects.automation.assignment2.BaseScript.doLogin;
import static myprojects.automation.assignment2.BaseScript.getDriver;
import static myprojects.automation.assignment2.utils.Properties.getBaseAdminUrl;

public class LoginToAdminPanel {

    public static void main(String[] args) {

        //open chrome browser
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        try
        {
            //opening Admin panel page
            driver.get(getBaseAdminUrl());

            //Logining
            doLogin(driver);

            //clicking on avatar in right corner
            driver.findElement(By.id("employee_infos")).click();

            //clicking on "Выход"
            driver.findElement(By.id("header_logout")).click();


            /*check that logout is successful
            * find "Вход" button*/
            boolean login;
            try
            {
                driver.findElement(By.name("submitLogin"));
                login = true;
            }
            catch (Exception e)
            {
                login = false;
            }

            if (!login)
            {
                String url = driver.getCurrentUrl();
                System.out.print(url + " - Logout is not executed.");
            }

        }
        catch (Exception e)
        {
            //output info if error
            e.printStackTrace();
        }

        //close browser
        driver.quit();
    }

}
