package d_20_09_2022_AutomationPracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuPage {
//	TopMenuPage koja pribavlja:
//		● metodu koja vraca WOMEN link iz glavnom menija
//		● metodu koja vraca DRESSES link iz glavnom menija
//		● metodu koja vraca T-SHIRTS link iz glavnom menija
//		● metodu koja vraca podmeni za WOMEN
//		● metodu koja vraca podmeni za DRESSES
	
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public TopMenuPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	public WebElement getWomenLink() {
		return driver.findElement(By.className("sf-menu")).findElement(By.xpath("//*[@title = 'Women']"));
	}
	public WebElement getDressesLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'sf-menu')]/li[2]"));
	}
	public WebElement getTShirtsLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'sf-menu')]/li[3]"));
	}
	public WebElement getWomenSubMenu() {
		return driver.findElement(By.xpath("//*[contains(@class, 'sf-menu')]/li/ul[1]"));
	}
	public WebElement getDressesSubMenu() {
		return driver.findElement(By.xpath("//*[contains(@class, 'sf-menu')]/li[2]/ul"));
	}
}
