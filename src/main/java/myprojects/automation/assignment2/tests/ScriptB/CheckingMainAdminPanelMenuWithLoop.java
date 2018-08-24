package myprojects.automation.assignment2.tests.ScriptB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckingMainAdminPanelMenuWithLoop {

    public static void main(String[] args) {

        //open chrome browser
        WebDriver driver = runChrome();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

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

            boolean breakIt = true;
            while (true) {
                breakIt = true;
                try {
                    //finding all menu items
                    Thread.sleep(2000);
                    List<WebElement> pagination = driver.findElements(By.cssSelector("#nav-sidebar > ul > li > ul.submenu > li"));
                    Iterator<WebElement> link = pagination.iterator();

                    //clicking on each element
                    while(link.hasNext()) //check for next page
                    {
                        //output title
                        String title = driver.findElement(By.className("breadcrumb-current")).getText();
                        System.out.print(title);

                        //refresh page
                        driver.navigate().refresh();
                        Thread.sleep(2000);

                        //title after  refresh page
                        String titleRefresh = driver.findElement(By.className("breadcrumb-current")).getText();

                        if (!title.equals(titleRefresh))
                        {
                            String url = driver.getCurrentUrl();
                            System.out.print(url + " - User in another section after reloading the page - " + titleRefresh );
                        }
                        //click on next menu item
                        WebElement next = link.next();
                        if (next.isEnabled())
                        {
                            next.click();
                        }

                    }

                } catch (Exception e)
                {
                    if (e.getMessage().contains("element is not attached")) {
                        breakIt = false;
                    }
                }
                if (breakIt)
                {
                    break;
                }

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
