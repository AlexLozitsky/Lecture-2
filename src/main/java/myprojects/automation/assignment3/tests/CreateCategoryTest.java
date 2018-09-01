package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static myprojects.automation.assignment3.BaseScript.doLogin;
import static myprojects.automation.assignment3.BaseScript.getDriver;
import static myprojects.automation.assignment3.utils.Properties.getBaseAdminUrl;

public class CreateCategoryTest {

    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
        //open chrome browser
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        //generator for new name of Category
        Random rand = new Random();
        String nameCategory = BaseScript.nameCategory();

        //opening Admin panel page
        driver.get(getBaseAdminUrl());

        //Logining
        doLogin(driver);

        //go to Каталог -> категории;
        WebElement catalog = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subtab-AdminCatalog")));
        Actions hover = new Actions(driver);
        hover.moveToElement(catalog).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subtab-AdminCategories"))).click();

        // create category
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("page-header-desc-category-new_category"))).click();

        //Entering new name
        WebElement newname = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name_1")));
        newname.sendKeys(rand.nextInt(99999) + nameCategory);
        String text = newname.getAttribute("value");

        //clicking on "Сохранить" button
        driver.findElement(By.cssSelector("#category_form_submit_btn")).click();

        //Sorting by name
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"icon-caret-up\"]/.."))).click();

        // check that new category appears in Categories table
        boolean check;
        try
        {
            driver.findElement(By.xpath("//*[contains(text(), '"+text+"')]"));
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

}
