package d_15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1a {

	public static void main(String[] args) throws InterruptedException{
		// (ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		List<WebElement> closeBtn = driver.findElements(By.className("close"));

		for (int i = 0; i < closeBtn.size(); i++) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[1]/button")).click();
			Thread.sleep(1000);
			try {
				int broj = closeBtn.size() - 1;
				System.out.println("Uspesno brisanje.");
			} catch (Exception e) {
				System.out.println("Neuspelao brisanje");
			}

		}

		Thread.sleep(5000);
		driver.quit();
	}

}


