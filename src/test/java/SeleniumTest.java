import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

    WebDriver driver;
    private static final String PATH_TO_DRIVER = "/Users/evgeniyak/Documents/Webdrivers/chromedriver";
    private String buttonAddToCart = "//a[@title='Add to cart']";
    private static final String BASE_URL = "http://automationpractice.com/index.php";
    private String searchInput = "search_query_top";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
    }
/*
    @Test
    public void verifyTotalPrice() throws InterruptedException {

        final String expectedTotalPrice = "$29.00";

        enterIntoSearchField("Blouse");
        clickSearchButton();
        clickListView();
        clickButtonAddToCart();
        Thread.sleep(4000);
        //WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        //webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Proceed to checkout']")))).click(); //подождали пока просидту чекаут будет кликабельным
        clickProceedToCheckoutButton();

        String actualTotalPrice = driver.findElement(By.id("total_price")).getText();

        Assert.assertEquals("Total price is different", expectedTotalPrice, actualTotalPrice);

    }*/

    @Test
    public void verifyTotalSumAndRemoveItemFromCart() throws InterruptedException{

        final String expectedTotalPrice = "$56.00";
        final String ExpectedErrorMessage = "Your shopping cart is empty.";
        enterIntoSearchField("Blouse");
        clickSearchButton();
        clickListView();
        Thread.sleep(4000);
        clickButtonMore();
        clickPlus();
        Thread.sleep(4000);
        clickButtonAddToCart();


        //driver.findElement(By.id("search_query_top")).sendKeys("Blouse");
        ////driver.findElement(By.name("submit_search")).click();
        //driver.findElement(By.id("list")).click();
        //driver.findElement(By.xpath("//a[@title='View']")).click();//можно и текст //span[text()='More'] если только на 1 языке или css.selector
        //driver.findElement(By.id("add_to_cart")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Proceed to checkout']")))).click(); //подождали пока просидту чекаут будет кликабельным

        //Thread.sleep(4000);
        //driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
        String actualTotalPrice = driver.findElement(By.id("total_price")).getText();
        Assert.assertEquals("Total price is different", expectedTotalPrice, actualTotalPrice);

        clickTrashIcon();
        //driver.findElement(By.className("icon-trash")).click();
        String alert = "";
        try {
            alert = webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[contains(@class,'alert-warning')]")))).getText();
        } catch (StaleElementReferenceException e) {
            alert = driver.findElement(By.xpath("//p[contains(@class,'alert-warning')]")).getText();
        }
        Assert.assertEquals("Error message is different", ExpectedErrorMessage, alert);


        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Proceed to checkout']")))).click();
        String actualErrorMessage = driver.findElement(By.xpath("//p[contains(@class")).getText();

    }




    private void enterIntoSearchField(String item) {
        driver.findElement(By.id(searchInput)).sendKeys(item);
    }

    private void clickSearchButton() {
        driver.findElement(By.name("submit_search")).click();
    }

    private void clickListView() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[@class='icon-th-list']")))).click();
        driver.findElement(By.xpath("//i[@class='icon-th-list']")).click();
    }


    private void clickButtonAddToCart() {
        driver.findElement(By.id("add_to_cart")).click();
    }

    private void clickProceedToCheckoutButton() {
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Proceed to checkout']")))).click();
    }
    private void clickButtonMore()  {
        //WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        //webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='View']")))).click();

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div/div[3]/div/div[2]/a[2]")).click();
    }

    private void clickPlus() {
        driver.findElement(By.className("icon-plus")).click();

    }

    private void clickTrashIcon() {
        driver.findElement(By.className("icon-trash")).click();

    }


    @After
    public void close() {
        driver.close();
    }
}


    /*@Test
    public void verifyAddItemToCartViaGridView() {

        final String expectedTotalPrice = "$29.00";

        driver.findElement(By.id("search_query_top")).sendKeys("Blouse");
        driver.findElement(By.name("submit_search")).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(("//div[@class='product-image-container']"))).click().build().perform();"))))
        //driver.findElement(By.id("list")).click();
        driver.findElement(By.xpath(buttonAddToCart)).click();
        WebDriverWait webDriverWait =new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Proceed to checkout']")))).click(); //подождали пока просидту чекаут будет кликабельным

        Thread.sleep(4000);
        //driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
        String actualTotalPrice = driver.findElement(By.id("total_price")).getText();
        Assert.assertEquals("Total price is different",expectedTotalPrice, actualTotalPrice);

        @Test
        Actions actions= new actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@title='Women")))
.build().perform();
        driver.findElement(By.xpath("a[@title='T-shirts']")).click());
        Thread sleep(5000);





        @After
    public void close() {
        driver.close();

*/

