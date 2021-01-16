package co.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldr;

	public LoginPage(WebDriver rdr) {
		ldr = rdr;
		PageFactory.initElements(rdr, this);
	}

	@FindBy(xpath = "/html/body/form/div[3]/div[2]/div/div/div/img")
	@CacheLookup
	WebElement unPup;

	@FindBy(name = "myLogin$UserName")
	@CacheLookup
	WebElement txt_UN;

	@FindBy(name = "myLogin$Password")
	@CacheLookup
	WebElement txt_PWD;

	@FindBy(id = "myLogin_LoginButton")
	@CacheLookup
	WebElement btn_login;

//		
//		Thread.sleep(10000);
//		WebElement dropdwn1 = dr.findElement(By.xpath("//a[@class='toggle-sidebar bs-tooltip']"));
//		dropdwn1.click();
//		
//		Thread.sleep(10000);
//		WebElement dropdwn2 = dr.findElement(By.id("ctl00_rptMenu_ctl05_masters"));
//		dropdwn2.click();
//		
//		Thread.sleep(10000);
//		WebElement dropdwn3 = dr.findElement(By.id("ctl00_rptMenu_ctl05_rptSubMenu_ctl00_HyperLink1"));
//		dropdwn3.click();
//		
//		Thread.sleep(5000);
//		WebElement btn_Addbook = dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnNew"));
//		btn_Addbook.click();
//		
//		Thread.sleep(5000);
//		System.out.println(dr.getTitle());
//		
//	}

	public void removePopu() {
		unPup.click();
	}

	public void setuserName(String username) {
		txt_UN.sendKeys(username);
	}

	public void setpasswOrd(String password) {
		txt_PWD.sendKeys(password);
	}

	public void clicksubmit() {
		btn_login.click();
	}

}
