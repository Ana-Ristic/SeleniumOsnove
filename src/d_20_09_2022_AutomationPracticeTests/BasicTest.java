package d_20_09_2022_AutomationPracticeTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import d_20_09_2022_AutomationPracticePages.BuyBoxPage;
import d_20_09_2022_AutomationPracticePages.HeaderPage;
import d_20_09_2022_AutomationPracticePages.LayerCartPage;
import d_20_09_2022_AutomationPracticePages.TopMenuPage;

public class BasicTest {

	    protected WebDriver driver;
	    protected WebDriverWait wait;
	    protected String baseUrl = "http://automationpractice.com/";
	    protected BuyBoxPage buyBoxPage;
	    protected LayerCartPage layerCartPage;
	    protected TopMenuPage topMenuPage;
	    protected HeaderPage headerPage;
	    protected SoftAssert softAssert;

	    @BeforeClass
	    public void beforeClass() {
	    	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	        buyBoxPage = new BuyBoxPage(driver, wait);
	        layerCartPage = new LayerCartPage(driver, wait);
	        topMenuPage = new TopMenuPage(driver, wait);
	        headerPage = new HeaderPage(driver, wait);
	        softAssert = new SoftAssert();

	    }
	    @BeforeMethod
	    public void beforeMethod() {
	        driver.get(baseUrl);
	    }

	    @AfterMethod
	    public void afterMethod() {

	    }

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	}
	


