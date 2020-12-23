package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage {
	private WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By logo=By.xpath("//img[@alt='My Store']");
	private By create =By.xpath("//h3[text()='Create an account']");
	private By email = By.name("email_create");
	private By submit = By.name("SubmitCreate");
	private By errortxt = By.xpath("//p[contains(text(),'Please enter')]");
	private By invalid = By.xpath("//li[text()='Invalid email address.']");
	
	
	
	public String getTitlePage() {
		return driver.getTitle();
	}
	
	public boolean logoDisp() {
	 return driver.findElement(logo).isDisplayed();
	}
	
	public boolean createDisp() {
		return driver.findElement(create).isDisplayed();
	}
	
	public void enterEmail(String emaildata) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(create));
		Thread.sleep(5000);
		driver.findElement(email).sendKeys(emaildata);
	}
	
	public void clickSubmit() {
		driver.findElement(submit).click();
	}
	
	public boolean erroDisp() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		return driver.findElement(invalid).isDisplayed();
	}

}
