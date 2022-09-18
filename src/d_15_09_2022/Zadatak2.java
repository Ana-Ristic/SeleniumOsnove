package d_15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
//		Napisati program koji ucitava stranicu https://geodata.solutions/
//			Bira Country, State i City po vasoj zelji
//			Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//			I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//			Izabrerit Country, State i City tako da imate podatke da selektujete!
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//		Posto stranica iz zadatka ne radi, pronasla sam drugu koja ima iste funkcije.
		driver.get("https://www.plus2net.com/jquery/msg-demo/dropdown3.php");
		driver.findElement(By.id("country_code")).click();
		Select selectCountry = new Select(driver.findElement(By.id("country_code")));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Thread.sleep(5000);
		selectCountry.selectByVisibleText("USA");
		driver.findElement(By.id("state_id")).click();
		Select selectState = new Select(driver.findElement(By.id("state_id")));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Thread.sleep(5000);
		selectState.selectByVisibleText("16:California");
		driver.findElement(By.id("city_id")).click();
		Select selectCity = new Select(driver.findElement(By.id("city_id")));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Thread.sleep(5000);
		selectCity.selectByVisibleText("San Diego");
		Thread.sleep(5000);
		driver.quit();
		

		
		
		

	}

}
