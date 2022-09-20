package d_19_09_2022;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootstrapTableTests {
//	Kreirati BootstrapTableTests klasu koja ima:
//		Base url: https://s.bootsnipp.com

	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://s.bootsnipp.com";
	private String firstName = "Conrad";
	private String lastName = "Watts";
	private String middleName = "Luke";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@BeforeMethod
	public void beforeMethod() {
//		driver.get(baseUrl);

	}

//	Test #1: Edit Row
//	Podaci:
//	● First Name: ime polaznika
//	● Last Name: prezime polaznika
//	● Middle Name: srednje ime polanzika
//	Koraci:
//	● Ucitati stranu /iframe/K5yrx
//	● Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//	● Klik na Edit dugme prvog reda
//	● Sacekati da dijalog za Editovanje bude vidljiv
//	● Popuniti formu podacima.
//	○ Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se
//	koristi metoda clear. Koristan link
//	● Klik na Update dugme
//	● Sacekati da dijalog za Editovanje postane nevidljiv
//	● Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//	● Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//	● Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//	● Za sve validacije ispisati odgovarajuce poruke u slucaju greske

	@Test(priority = 1)
	public void editRow() throws InterruptedException {
		driver.get(baseUrl + "/iframe/K5yrx");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Table with Edit and Update Data - Bootsnipp.com";
		Assert.assertEquals(actualTitle, expectedTitle, "ERROR:Title didn't match.");
		driver.findElement(By.xpath("//*[@data-target = '#edit'][1]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(), 'Update Data')]")));
		driver.findElement(By.id("fn")).clear();
		driver.findElement(By.id("fn")).sendKeys(firstName);
		driver.findElement(By.id("ln")).clear();
		driver.findElement(By.id("ln")).sendKeys(lastName);
		driver.findElement(By.id("mn")).clear();
		driver.findElement(By.id("mn")).sendKeys(middleName);
		driver.findElement(By.id("up")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[contains(text(), 'Update Data')]")));
		Assert.assertEquals(driver.findElement(By.id("f1")).getText(), this.firstName,
				"Error: First name doesn't match.");
		Assert.assertEquals(driver.findElement(By.id("l1")).getText(), this.lastName,
				"Error: Last name doesn't match.");
		Assert.assertEquals(driver.findElement(By.id("m1")).getText(), this.middleName,
				"Error: Middle name doesn't match.");
	}

//	Koraci:
//		● Ucitati stranu /iframe/K5yrx
//		● Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//		● Klik na Delete dugme prvog reda
//		● Sacekati da dijalog za brisanje bude vidljiv
//		● Klik na Delete dugme iz dijaloga
//		● Sacekati da dijalog za Editovanje postane nevidljiv
//		● Verifikovati da je broj redova u tabeli za jedan manji
//		● Za sve validacije ispisati odgovarajuce poruke u slucaju greske

	@Test(priority = 2)
	public void deleteRow() throws InterruptedException {
		driver.get(baseUrl + "/iframe/K5yrx");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Table with Edit and Update Data - Bootsnipp.com";
		Assert.assertEquals(actualTitle, expectedTitle, "ERROR:Title didn't match.");
		driver.findElement(By.xpath("//*[@data-target = '#delete'][1]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(), 'Delete Data')]")));
		driver.findElement(By.id("del")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[contains(text(), 'Delete Data')]")));
		List<WebElement> row = driver.findElements(By.xpath("//*[@id = 'd1']/td"));
		int actualSize = row.size();
		int expectedSize = 0;
		Assert.assertEquals(actualSize, expectedSize, "ERROR:Delete row fail.");

	}

//	● Ucitati stranu /iframe/K5yrx
//	● Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//	● Kreirati screenshot stranice. 
//	● Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji:
//	src/paket_za_domaci/nazivslike.png

	@Test(priority = 3)
	private void takeAScreenshot() throws IOException {
		driver.get(baseUrl + "/iframe/K5yrx");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Table with Edit and Update Data - Bootsnipp.com";
		Assert.assertEquals(actualTitle, expectedTitle, "ERROR:Title didn't match.");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(
				"C:\\Users\\anupp\\eclipse-workspace\\SeleniumOsnove\\src\\d_19_09_2022\\screenshot\\screenshot.png"));

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
