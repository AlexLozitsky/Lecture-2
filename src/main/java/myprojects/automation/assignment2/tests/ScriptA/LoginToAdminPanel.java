package myprojects.automation.assignment2.tests.ScriptA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginToAdminPanel {

    public static void main(String[] args) {

        //open chrome browser
        WebDriver driver = runChrome();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        try
        {
            //opening Admin panel page
            driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

            //entering login
            driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");

            //entering password
            driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");

            //clicking on "Вход" button
            driver.findElement(By.name("submitLogin")).click();

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

    public static WebDriver runChrome() {
        String Browser = "C:\\Users\\User\\IdeaProjects\\Selenium\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", Browser);
        return new ChromeDriver();
    }

}
