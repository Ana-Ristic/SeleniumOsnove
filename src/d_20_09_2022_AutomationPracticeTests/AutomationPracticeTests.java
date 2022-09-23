package d_20_09_2022_AutomationPracticeTests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import d_20_09_2022_AutomationPracticePages.BuyBoxPage;
import d_20_09_2022_AutomationPracticePages.HeaderPage;
import d_20_09_2022_AutomationPracticePages.LayerCartPage;
import d_20_09_2022_AutomationPracticePages.TopMenuPage;

public class AutomationPracticeTests extends BasicTest{
	
	@Test
	public void AddingProductToTheCart() {

		driver.navigate().to(baseUrl + "/index.php?id_product=1&controller=product");
		buyBoxPage.ScrollToBuyBox();
		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("3");
		buyBoxPage.getSizeSelect("L").click();
		buyBoxPage.getColor("Blue").click();
		buyBoxPage.getAddToCartButton().click();
		layerCartPage.waitForDialogToBeVisible();
		Assert.assertEquals(layerCartPage.getQuantity().getText(), "3", "ERROR: Incorrect Quantity.");
		Assert.assertEquals(layerCartPage.getProductAttributes().getText(), "Blue, L", "ERROR: Incorrect Color.");
		String total = layerCartPage.getTotalPrice().getText().replaceAll("[^0-9]", "");
		double totalPrice = Double.parseDouble(total) * 0.01;
		String price = driver.findElement(By.id("our_price_display")).getText().replaceAll("[^0-9]", "");
		double Itemprice = Double.parseDouble(price) * 0.01;
		Assert.assertEquals(totalPrice, Itemprice * 3, "ERROR: Check your cart. Total price is not correct." );
		layerCartPage.getContinueShoppingButton().click();
		layerCartPage.waitForDialogToBeInvisible();
		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("1");
		buyBoxPage.getSizeSelect("S").click();
		buyBoxPage.getColor("Orange").click();
		buyBoxPage.getAddToCartButton().click();
		layerCartPage.waitForDialogToBeVisible();
		layerCartPage.getProceedToCheckputButton().click();
		Assert.assertEquals(driver.getTitle(), "Order - My Store", "ERROR: Incorrect Title.");
	}

	@Test
	public void TopMenuMouseOver() {
		new Actions(driver).moveToElement(topMenuPage.getWomenLink()).perform();
		boolean isWomenSubmenuVisible = topMenuPage.getWomenSubMenu().isDisplayed();
		softAssert.assertTrue(isWomenSubmenuVisible, "ERROR: Women submenu is not visible");
		new Actions(driver).moveToElement(topMenuPage.getDressesLink()).perform();
		wait.until(ExpectedConditions.invisibilityOf(topMenuPage.getWomenSubMenu()));
		boolean isDressesSubmenuVisible = topMenuPage.getDressesSubMenu().isDisplayed();
		softAssert.assertTrue(isDressesSubmenuVisible, "ERROR: Dresses submenu is not visible");
		new Actions(driver).moveToElement(topMenuPage.getTShirtsLink()).perform();
		wait.until(ExpectedConditions.invisibilityOf(topMenuPage.getDressesSubMenu()));
		softAssert.assertFalse(isWomenSubmenuVisible, "ERROR: Women submenu is visible");
		softAssert.assertFalse(isDressesSubmenuVisible, "ERROR: Dresses submenu is visible");
	}

	@Test
	public void PhoneNumberVisibilityCheckOnResize() {
		driver.manage().window().maximize();
		softAssert.assertTrue(headerPage.getShopPhone().isDisplayed(), "ERROR: Shop Phone is not visible.");
		driver.manage().window().setSize(new Dimension(767, 700));
		softAssert.assertFalse(headerPage.getShopPhone().isDisplayed(), "ERROR: Shop Phone is visible.");
		driver.manage().window().setSize(new Dimension(768, 700));
		softAssert.assertTrue(headerPage.getShopPhone().isDisplayed(), "ERROR: Shop Phone is not visible.");
		driver.manage().window().maximize();
	}

	@Test
	public void HeaderLinksCheck() {
		headerPage.getContactUsLink().click();
		softAssert.assertEquals(headerPage.getContactUsLink().getText(), "Contact us - My Store",
				"ERROR: Title mismatch.");

		headerPage.getSignInLink().click();

		softAssert.assertEquals(headerPage.getSignInLink().getText(), "Login - My Store", "ERROR: Title mismatch.");

	}

}
