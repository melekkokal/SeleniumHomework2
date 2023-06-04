package Homework2;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.*;

public class TestCase1 {
    @Test
    public void testcase1() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

        String actualTitle = driver.getTitle().trim();
        Assert.assertEquals(actualTitle, "Web Orders Login");

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement button = driver.findElement(By.cssSelector(".button"));
        button.click();

        String actualTitle1 = driver.getTitle().trim();
        Assert.assertEquals(actualTitle1, "Web Orders");

        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = BrowserUtils.getText(header);
        Assert.assertEquals(actualHeader, "List of All Orders");
    }

    @Test
    public void testcase2() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement button = driver.findElement(By.cssSelector(".button"));
        button.click();

        BrowserUtils.switchByTitle(driver, "Web Orders");
        WebElement allProducts = driver.findElement(By.xpath("//a[contains(text(), 'View all products')]"));
        allProducts.click();


        BrowserUtils.switchByTitle(driver, "View all products");
        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(BrowserUtils.getText(header), "List of Products");

        Assert.assertTrue(driver.getCurrentUrl().contains("Products"));

    }

    @Test
    public void testcase3() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement button = driver.findElement(By.cssSelector(".button"));
        button.click();

        WebElement defaultHref = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        String linkOfDefault = defaultHref.getAttribute("href");
        Assert.assertTrue(linkOfDefault.contains("Default.aspx"));

        WebElement productsHref = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        String linkOfProducts = productsHref.getAttribute("href");
        Assert.assertTrue(linkOfProducts.contains("Products.aspx"));

        WebElement processHref = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        String linkOfProcess = processHref.getAttribute("href");
        Assert.assertTrue(linkOfProcess.contains("Process.aspx"));


    }

    @Test
    public void testcase4() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement button = driver.findElement(By.cssSelector(".button"));
        button.click();

        Actions actions = new Actions(driver);
        WebElement order = driver.findElement(By.xpath("//a[contains(text(), 'Order')]"));
        actions.moveToElement(order).perform();
        order.click();

        WebElement product = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Select products = new Select(product);
        products.selectByValue("ScreenSaver");

        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("5");

        WebElement name = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        name.sendKeys("CodeFish IT School");

        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E devon");

        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");

        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");

        WebElement zipcode = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipcode.sendKeys("60018");

        WebElement creditcard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        creditcard.click();

        WebElement cardnumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardnumber.sendKeys("444993876233");

        WebElement expiration = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expiration.sendKeys("03/24");

        WebElement process = driver.findElement(By.cssSelector(".btn_light"));
        process.click();

        WebElement text = driver.findElement(By.xpath("//strong"));
        String actualText = BrowserUtils.getText(text);
        String expectedText = "New order has been successfully added.";
        Assert.assertEquals(actualText, expectedText);
        Assert.assertTrue(text.isDisplayed());

        WebElement allorders = driver.findElement(By.xpath("//a[contains(text(), 'View all orders')]"));
        allorders.click();

        BrowserUtils.switchByTitle(driver, "View all orders");
        WebElement neworder = driver.findElement(By.xpath("//tr//td//td[.='CodeFish IT School']"));
        if (neworder.equals("CodeFish IT School")) {
            BrowserUtils.getText(neworder);
        }

    }

}
