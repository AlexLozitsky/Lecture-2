package myprojects.automation.assignment4;

import myprojects.automation.assignment4.model.ProductData;
import myprojects.automation.assignment4.utils.Properties;
import myprojects.automation.assignment4.utils.logging.CustomReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static myprojects.automation.assignment4.tests.CreateProductTest.productData;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private By catalog = By.id("subtab-AdminCatalog");
    private By goods = By.id("subtab-AdminProducts");
    private By newProductButton = By.id("page-header-desc-configuration-add");
    private By nameOfProductField = By.id("form_step1_name_1");
    private By qty = By.id("tab_step3");
    private By qtyField = By.id("form_step3_qty_0");
    private By price = By.id("tab_step2");
    private By priceField = By.id("form_step2_price");
    private By switcher = By.className("switch-input");
    private By message = By.xpath("//*[contains(text(),'Настройки обновлены.')]");
    private By saveButton = By.xpath("//button[@class='btn btn-primary js-btn-save']");
    private By allProduct = By.xpath("//a[@class='all-product-link pull-xs-left pull-md-right h4']");
    private By product = By.xpath("//a[text()='" + productData.getName() + "']");

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void login(String login, String password) {
        CustomReporter.log("login as user: " + login);
        driver.navigate().to(Properties.getBaseAdminUrl());
        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("passwd"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block ladda-button']"));
        email.sendKeys(login);
        pass.sendKeys(password);
        loginButton.click();
    }

    public void createProduct(ProductData newProduct) {
        Actions actions = new Actions(driver);
        waitForContentLoad(catalog);
        WebElement catalog = driver.findElement(this.catalog);
        actions.moveToElement(catalog).perform();
        waitForContentLoad(goods);
        WebElement goods = driver.findElement(this.goods);
        goods.click();
        waitForContentLoad(newProductButton);
        WebElement newProductButton = driver.findElement(this.newProductButton);
        newProductButton.click();
        waitForContentLoad(nameOfProductField);
        WebElement nameOfProductField = driver.findElement(this.nameOfProductField);
        nameOfProductField.sendKeys(newProduct.getName());
        WebElement qty = driver.findElement(this.qty);
        qty.click();
        waitForContentLoad(qtyField);
        WebElement qtyField = driver.findElement(this.qtyField);
        qtyField.sendKeys(Keys.chord(Keys.CONTROL, "a"), newProduct.getQty().toString());
        WebElement price = driver.findElement(this.price);
        price.click();
        waitForContentLoad(priceField);
        WebElement priceField = driver.findElement(this.priceField);
        priceField.sendKeys(Keys.chord(Keys.CONTROL, "a"), newProduct.getPrice());
        waitForContentLoad(switcher);
        WebElement switcher = driver.findElement(this.switcher);
        switcher.click();
        waitForContentLoad(message);
        WebElement saveButton = driver.findElement(this.saveButton);
        saveButton.click();
        waitForContentLoad(message);
    }

    public void checkProduct(){
        driver.navigate().to(Properties.getBaseUrl());
        waitForContentLoad(allProduct);
        WebElement allProduct = driver.findElement(this.allProduct);
        scrollToElement(allProduct);
        allProduct.click();
        waitForContentLoad(product);
        WebElement product = driver.findElement(this.product);
        scrollToElement(product);
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForContentLoad(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}