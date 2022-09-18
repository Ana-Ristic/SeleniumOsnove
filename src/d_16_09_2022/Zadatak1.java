package d_16_09_2022;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@alt = 'image 1']")).click();
		driver.findElement(By.xpath("//*[contains(@class, 'sc-efBctP bmiVF')]/img")).click();
		driver.findElement(By.xpath("//*[contains(@class, 'sc-dvwKko cQnIzc')]/img")).click();
		Thread.sleep(5000);
		// dodavanje slika / sa .getAbsolutePath() nije htelo da upload-uje slike. prijavljivalo je gresku da put do fajla nije dobar,
		// ali kada tu putanju koja je prijavljena kao greska kopiram i uradim kao ovde, slike se upload-uju bez problema.
		driver.findElement(By.xpath("//*[@alt = '+ Add photo']")).click();
		driver.findElement(By.xpath("//*[@for = 'imageUpload']"));
		WebElement uploadImg1 = driver.findElement(By.id("imageUpload"));
		uploadImg1.sendKeys(
				"C:\\Users\\anupp\\eclipse-workspace\\SeleniumOsnove\\src\\d_16_09_2022\\img\\front_slika.jpg");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@for = 'imageUpload']"));
		WebElement uploadImg2 = driver.findElement(By.id("imageUpload"));
		uploadImg2.sendKeys(
				"C:\\Users\\anupp\\eclipse-workspace\\SeleniumOsnove\\src\\d_16_09_2022\\img\\left_slika.jpg");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@for = 'imageUpload']"));
		WebElement uploadImg3 = driver.findElement(By.id("imageUpload"));
		uploadImg3.sendKeys(
				"C:\\Users\\anupp\\eclipse-workspace\\SeleniumOsnove\\src\\d_16_09_2022\\img\\right_slika.jpg");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@for = 'imageUpload']"));
		WebElement uploadImg4 = driver.findElement(By.id("imageUpload"));
		uploadImg4.sendKeys(
				"C:\\Users\\anupp\\eclipse-workspace\\SeleniumOsnove\\src\\d_16_09_2022\\img\\back_slika.jpg");
		Thread.sleep(1000);

		// ubacivanje slika u kocku
		// prva slika
		driver.findElement(By.xpath("//div[last()]/div[4]/div[1]/img")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'sc-gYMRRK gMENHs')]")));
		driver.findElement(By.xpath("//*[contains(@class, 'sc-fbPSWO bbpaUa')]/button[1]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-testid = 'cropper']")));
		driver.findElement(By.xpath("//*[contains(@class, 'sc-eKBdFk iCACbi')]/button")).click();
		Thread.sleep(1000);
		// druga slika
		driver.findElement(By.xpath("//*[@alt = 'image 2']")).click();
		driver.findElement(By.xpath("//*[@alt = '+ Add photo']")).click();
		driver.findElement(By.xpath("//div[last()]/div[3]/div[1]/img")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'sc-gYMRRK gMENHs')]")));
		driver.findElement(By.xpath("//*[contains(@class, 'sc-fbPSWO bbpaUa')]/button[1]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-testid = 'cropper']")));
		driver.findElement(By.xpath("//*[contains(@class, 'sc-eKBdFk iCACbi')]/button")).click();
		Thread.sleep(1000);
		// treca slika
		driver.findElement(By.xpath("//*[@alt = 'image 3']")).click();
		driver.findElement(By.xpath("//*[@alt = '+ Add photo']")).click();
		driver.findElement(By.xpath("//div[last()]/div[2]/div[1]/img[1]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'sc-gYMRRK gMENHs')]")));
		driver.findElement(By.xpath("//*[contains(@class, 'sc-fbPSWO bbpaUa')]/button[1]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-testid = 'cropper']")));
		driver.findElement(By.xpath("//*[contains(@class, 'sc-eKBdFk iCACbi')]/button")).click();
		Thread.sleep(1000);
		// cetvrta slika
		driver.findElement(By.xpath("//*[@alt = 'image 4']")).click();
		driver.findElement(By.xpath("//*[@alt = '+ Add photo']")).click();
		driver.findElement(By.xpath("//div[last()]/div[3]/div[1]/img")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'sc-gYMRRK gMENHs')]")));
		driver.findElement(By.xpath("//*[contains(@class, 'sc-fbPSWO bbpaUa')]/button[1]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-testid = 'cropper']")));
		driver.findElement(By.xpath("//*[contains(@class, 'sc-eKBdFk iCACbi')]/button")).click();
		Thread.sleep(1000);

		// confetti
		List<WebElement> confetti = driver.findElements(By.xpath("//*[contains(@class, 'sc-hZgfyJ kFlYLE')]/div"));
		int konfeti = confetti.size();
		Random r = new Random();
		int random = r.nextInt(konfeti);
		confetti.get(random).click();

		driver.findElement(By.xpath("//*[@type = 'submit']")).click();

		boolean oops = false;
		try {
			driver.findElement(By.xpath("//*[contains(text(),'Oops! It looks like you`ve not added\r\n"
					+ "any text to this field, please add one before continuing.')]"));
			oops = true;
		} catch (Exception e) {
			oops = false;
		}
		if (!oops) {
			System.out.println(
					"Oops! It looks like you`ve not added any text to this field, please add one before continuing.");
		}

		Thread.sleep(5000);
		driver.quit();
	}

}
