package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseTest;
import myprojects.automation.assignment4.model.ProductData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateProductTest extends BaseTest {

    public static ProductData productData = ProductData.generate();

    @Test(dataProvider = "Authentication")
    public void createNewProduct(String login, String password) {
        actions.login(login, password);
        actions.createProduct(productData);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Настройки обновлены.')]"))
                .getText()
                .contains("Настройки обновлены."));
    }

    @Test(dependsOnMethods = {"createNewProduct"})
    public void CheckProduct(){
        actions.checkProduct();
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'" + productData.getName() + "')]"))
                .getText()
                .contains(productData.getName()), "product is not found!");
    }

    @DataProvider(name = "Authentication")
    public Object[][] getData() {
        return new Object[][]{{"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}};
    }
}
