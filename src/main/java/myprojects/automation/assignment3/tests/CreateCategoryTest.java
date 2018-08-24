package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment2.tests.ScriptA.LoginToAdminPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CreateCategoryTest {
    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
        //open chrome browser
        WebDriver driver = runChrome();
        driver.manage().window().maximize();

        // login
        Login(driver);

        //go to Каталог -> категории
        Thread.sleep(500);
        WebElement catalog = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#subtab-AdminCatalog")));
        Actions hover = new Actions(driver);
        hover.moveToElement(catalog).build().perform();
        Thread.sleep(500);
        WebElement subcat = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#subtab-AdminCategories")));
        subcat.click();

        // create category
        WebElement AddCat = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#toolbar-nav > li:nth-child(1)")));
        AddCat.click();

        //Entering new name
        WebElement newname = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.translatable-field.lang-1 > div.col-lg-9 > input")));
        newname.sendKeys("New name");

        //clicking on "Сохранить" button
        driver.findElement(By.cssSelector("#category_form_submit_btn")).click();

        //Sorting by name
        WebElement sort = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#table-category > thead > tr:nth-child(1) > " +
                                "th:nth-child(3) > span > a:nth-child(2)")));
        sort.click();

        // check that new category appears in Categories table
        boolean check;
        try
        {
            driver.findElement(By.xpath("//*[contains(text(), 'New name')]"));
            check = true;
        }

        catch (Exception e)
        {
            check = false;
        }

        if (!check)
        {
            String url = driver.getCurrentUrl();
            System.out.print(url + " - Category was not created");
        }

        //close browser
        driver.quit();
    }

    public static WebDriver runChrome() {
        String Browser = "C:\\Users\\User\\IdeaProjects\\Selenium\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", Browser);
        return new ChromeDriver();
    }

    public static void Login(WebDriver driver) {
        //opening Admin panel page
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        //entering login
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");

        //entering password
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");

        //clicking on "Вход" button
        driver.findElement(By.name("submitLogin")).click();
    }

}
