package d_20_09_2022_AutomationPracticePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyBoxPage {
//	BuyBoxPage koja pribavlja:
//	● input za kolicinu
//	● select za velicinu
//	● add to cart dugme
//	● add to wishlist dugme
//	● metodu koja vraca element boje.
//	Metoda kao parametar prima naziv boje
//	(npr: “Orange”, “Blue”) a vraca link koji ima atribut title
//	prema trazenoj vrednosti.
//	● metodu koja skrola do ovog dela stranice
	
	
	
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public BuyBoxPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	public WebElement getQuantityInput() {
		return driver.findElement(By.id("quantity_wanted"));
	}
	
	public WebElement getSizeSelect(String size) {
       if(size.equals ("S")){
    	   return driver.findElement(By.xpath("//option[contains(text(), 'S')]"));
       } else if (size.equals("M")) {
    	   return driver.findElement(By.xpath("//option[contains(text(), 'M')]"));
       } else if (size.equals("L")) {
    	   return driver.findElement(By.xpath("//option[contains(text(), 'L')]"));
       }
       return null;
    }
	
	public WebElement getAddToCartButton() {
		return driver.findElement(By.name("Submit"));
	}
	
	public WebElement getWhishlistButton() {
		return driver.findElement(By.id("wishlist_button"));
	}
	
	public WebElement getColor(String color) {
		if(color.equals("Orange")) {
			return driver.findElement(By.name("Orange"));
		} else if(color.equals("Blue")) {
			return driver.findElement(By.name("Blue"));
		} return null;
	}
	
	public void ScrollToBuyBox() {
		WebElement scroll = driver.findElement(By.id("buy_block"));
		new Actions(driver)
        .scrollToElement(scroll)
        .perform();
	}
	
}
