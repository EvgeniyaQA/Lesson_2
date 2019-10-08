import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.naming.Context;

import static java.lang.Thread.*;

public class SeleniumSignIn {
    WebDriver driver;
    private static final String PATH_TO_DRIVER = "/Users/evgeniyak/Documents/Webdrivers/chromedriver";
    //private String buttonAddToCart = "//a[@title='Add to cart']";
    private static final String BASE_URL = "http://automationpractice.com/index.php";
    private String inputEmail = "email_create";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
    }
    @Test
    public void registration() throws InterruptedException {
    clickSignIn();
    sleep(2000);
    enterIntoSearchField("water19111@gmail.com");
        sleep(000);
    clickSubmit();
        sleep(2000);
    enterFirstName("Jane");
        sleep(2000);
    enterLastName("Kucheriavets");
        sleep(2000);
    enterPassword("ew34jhj8");
        sleep(2000);
        enterAddress("Dragomanova Street");
        sleep(2000);

        enterCity("Kyiv");
        sleep(2000);

        chooseState("California");
        sleep(2000);

        enterPostcode("02068");
        sleep(2000);

        enterMobile("0667551405");
        sleep(2000);

        enterAlias("Street other");
        sleep(2000);

        clickRegister();
        Context actualResult = driver.findElement(By.id("//*[@id='email_create']").findElement("@"));
String  expectedResult="@";
        Assert.assertEquals("@ not found " + expectedResult + ".", expectedResult, actualResult);


    }

    private void clickRegister() {
        driver.findElement(By.id("submitAccount")).click();
    }

    private void enterAlias(String str) {
        driver.findElement(By.id("alias")).sendKeys(str);
    }

    private void enterMobile(CharSequence mob) {
        driver.findElement(By.id("phone_mobile")).sendKeys(mob);
    }

    private void enterPostcode(CharSequence po) {
        driver.findElement(By.id("postcode")).sendKeys(po);
    }

    private void chooseState(String sta) {
        driver.findElement(By.xpath("//*[@id='id_state']/option[5]")).click();
    }
    private void enterCity(String ci) {
        driver.findElement(By.id("city")).sendKeys(ci);
    }
    private void enterAddress(String a) {
        driver.findElement(By.id("address1")).sendKeys(a);
    }

    private void enterPassword(String p) {
        driver.findElement(By.id("passwd")).sendKeys(p);
    }
    //private void enterEmail(String s) {
       // driver.findElement(By.id("email")).sendKeys(s);
    //}
    private void enterLastName(String l) {
        driver.findElement(By.id("customer_lastname")).sendKeys(l);
    }
    private void enterFirstName(String f) {
        driver.findElement(By.id("customer_firstname")).sendKeys(f);
    }
    private void clickSubmit() {
        driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
    }

    private void enterIntoSearchField(String s) {
        driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys(s);

    }

    private void clickSignIn() {
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();

    }
    }
