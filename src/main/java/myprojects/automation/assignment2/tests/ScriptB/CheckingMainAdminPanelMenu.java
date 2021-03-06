package myprojects.automation.assignment2.tests.ScriptB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static myprojects.automation.assignment2.BaseScript.doLogin;
import static myprojects.automation.assignment2.BaseScript.getDriver;
import static myprojects.automation.assignment2.utils.Properties.getBaseAdminUrl;

public class CheckingMainAdminPanelMenu {

    public static void main(String[] args) {

        //open chrome browser
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        try
        {
            //opening Admin panel page
            driver.get(getBaseAdminUrl());

            //Logining
            doLogin(driver);

            //check page
            check(driver);

            //Заказы
            driver.findElement(By.id("subtab-AdminParentOrders")).click();

            //check page
            check(driver);

            //Каталог
            driver.findElement(By.id("subtab-AdminCatalog")).click();

            //check page
            String title = driver.findElement(By.cssSelector("#main-div > div.header-toolbar > h2")).getText();
            System.out.println(title);

            //refresh page
            driver.navigate().refresh();

            //title after  refresh page
            String titleRefresh = driver.findElement(By.cssSelector("#main-div > div.header-toolbar > h2")).getText();

            if (!title.equals(titleRefresh))
            {
                String url = driver.getCurrentUrl();
                System.out.print(url + " - User in another section after reloading the page - " + titleRefresh );
            }

            //Клиенты
            driver.findElement(By.cssSelector("body > nav > ul > li:nth-child(5)")).click();
            Thread.sleep(2000);

            //check page
            String title1 = driver.findElement(By.className("page-title")).getText();
            System.out.println(title1);

            //refresh page
            driver.navigate().refresh();

            //title after  refresh page
            String titleRefresh1 = driver.findElement(By.className("page-title")).getText();

            if (!title1.equals(titleRefresh1))
            {
                String url = driver.getCurrentUrl();
                System.out.print(url + " - User in another section after reloading the page - " + titleRefresh1 );
            }


                //Служба поддержки
                driver.findElement(By.id("subtab-AdminParentCustomerThreads")).click();
                Thread.sleep(2000);

                //check page
                String title2 = driver.findElement(By.className("page-title")).getText();
                System.out.println(title2);

                //refresh page
                driver.navigate().refresh();

                //title after  refresh page
                String titleRefresh2 = driver.findElement(By.className("page-title")).getText();

                if (!title2.equals(titleRefresh2))
                {
                    String url = driver.getCurrentUrl();
                    System.out.print(url + " - User in another section after reloading the page - " + titleRefresh2 );
                }

            //Статистика
            driver.findElement(By.id("subtab-AdminStats")).click();
            Thread.sleep(2000);

            //check page
            String title3 = driver.findElement(By.className("page-title")).getText();
            System.out.println(title3);

            //refresh page
            driver.navigate().refresh();

            //title after  refresh page
            String titleRefresh3 = driver.findElement(By.className("page-title")).getText();

            if (!title2.equals(titleRefresh2))
            {
                String url = driver.getCurrentUrl();
                System.out.print(url + " - User in another section after reloading the page - " + titleRefresh3 );
            }

                //Modules
                driver.findElement(By.id("subtab-AdminParentModulesSf")).click();
                Thread.sleep(2000);

                //check page
                String title4 = driver.findElement(By.cssSelector("#main-div > div.header-toolbar > h2")).getText();
                System.out.println(title4);

                //refresh page
                driver.navigate().refresh();

                //title after  refresh page
                String titleRefresh4 = driver.findElement(By.cssSelector("#main-div > div.header-toolbar > h2")).getText();

                if (!title4.equals(titleRefresh4))
                {
                    String url = driver.getCurrentUrl();
                    System.out.print(url + " - User in another section after reloading the page - " + titleRefresh4 );
                }

            //Design
            driver.findElement(By.cssSelector("body > nav > ul > li:nth-child(10)")).click();
            Thread.sleep(2000);

            //check page
            String title5 = driver.findElement(By.cssSelector("#content > div.bootstrap > div > ul > li.breadcrumb-container")).getText();
            System.out.println(title5);

            //refresh page
            driver.navigate().refresh();

            //title after  refresh page
            String titleRefresh5 = driver.findElement(By.cssSelector("#content > div.bootstrap > div > ul > li.breadcrumb-container")).getText();

            if (!title5.equals(titleRefresh5))
            {
                String url = driver.getCurrentUrl();
                System.out.print(url + " - User in another section after reloading the page - " + titleRefresh5 );
            }

                //Доставка
                driver.findElement(By.id("subtab-AdminParentShipping")).click();
                Thread.sleep(2000);

                //check page
                String title6 = driver.findElement(By.cssSelector("#content > div.bootstrap > div > ul > li.breadcrumb-container")).getText();
                System.out.println(title6);

                //refresh page
                driver.navigate().refresh();

                //title after  refresh page
                String titleRefresh6 = driver.findElement(By.cssSelector("#content > div.bootstrap > div > ul > li.breadcrumb-container")).getText();

                if (!title6.equals(titleRefresh6))
                {
                    String url = driver.getCurrentUrl();
                    System.out.print(url + " - User in another section after reloading the page - " + titleRefresh6 );
                }

            //Способ оплаты
            driver.findElement(By.id("subtab-AdminParentPayment")).click();
            Thread.sleep(2000);

            //check page
            String title7 = driver.findElement(By.cssSelector("#content > div.bootstrap > div > ul > li.breadcrumb-container")).getText();
            System.out.println(title7);

            //refresh page
            driver.navigate().refresh();

            //title after  refresh page
            String titleRefresh7 = driver.findElement(By.cssSelector("#content > div.bootstrap > div > ul > li.breadcrumb-container")).getText();

            if (!title7.equals(titleRefresh7))
            {
                String url = driver.getCurrentUrl();
                System.out.print(url + " - User in another section after reloading the page - " + titleRefresh7 );
            }

                //International
                driver.findElement(By.id("subtab-AdminInternational")).click();
                Thread.sleep(2000);

                //check page
                String title8 = driver.findElement(By.cssSelector("#content > div.bootstrap > div > ul > li.breadcrumb-container")).getText();
                System.out.println(title8);

                //refresh page
                driver.navigate().refresh();

                //title after  refresh page
                String titleRefresh8 = driver.findElement(By.cssSelector("#content > div.bootstrap > div > ul > li.breadcrumb-container")).getText();

                if (!title8.equals(titleRefresh8))
                {
                    String url = driver.getCurrentUrl();
                    System.out.print(url + " - User in another section after reloading the page - " + titleRefresh8 );
                }

            //Shop Parameters
            driver.findElement(By.id("subtab-ShopParameters")).click();
            Thread.sleep(2000);

            //check page
            String title9 = driver.findElement(By.cssSelector("#content > div.bootstrap > div > ul > li.breadcrumb-container")).getText();
            System.out.println(title9);

            //refresh page
            driver.navigate().refresh();

            //title after  refresh page
            String titleRefresh9 = driver.findElement(By.cssSelector("#content > div.bootstrap > div > ul > li.breadcrumb-container")).getText();

            if (!title9.equals(titleRefresh9))
            {
                String url = driver.getCurrentUrl();
                System.out.print(url + " - User in another section after reloading the page - " + titleRefresh9 );
            }

                //Shop Parameters
                driver.findElement(By.id("subtab-AdminAdvancedParameters")).click();
                Thread.sleep(2000);

                //check page
                String title10 = driver.findElement(By.cssSelector("#content > div.bootstrap > div > ul > li.breadcrumb-container")).getText();
                System.out.println(title10);

                //refresh page
                driver.navigate().refresh();

                //title after  refresh page
                String titleRefresh10 = driver.findElement(By.cssSelector("#content > div.bootstrap > div > ul > li.breadcrumb-container")).getText();

                if (!title10.equals(titleRefresh10))
                {
                    String url = driver.getCurrentUrl();
                    System.out.print(url + " - User in another section after reloading the page - " + titleRefresh10 );
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

    public static void check(WebDriver driver) {
        //output title
        String title = driver.findElement(By.className("page-title")).getText();
        System.out.println(title);

        //refresh page
        driver.navigate().refresh();

        //title after  refresh page
        String titleRefresh = driver.findElement(By.className("page-title")).getText();

        if (!title.equals(titleRefresh))
        {
            String url = driver.getCurrentUrl();
            System.out.print(url + " - User in another section after reloading the page - " + titleRefresh );
        }
    }

}
