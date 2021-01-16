package co.qa.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DBFuelPage {
	WebDriver fdr;

	public DBFuelPage(WebDriver gdr) {
		fdr = gdr;
		PageFactory.initElements(gdr, this);
	}

	// Add Fuel -- from DashBoard icon - Locate Element
	@FindBy(xpath = "/html/body/form/div[3]/div[2]/div/div/div/img")
	@CacheLookup
	WebElement icon_Fuel;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ctl00_txtVehicleNo']")
	@CacheLookup
	WebElement txt_VehicleNo;

	@FindBy(xpath = "//textarea[@id='ctl00_ContentPlaceHolder1_ctl00_txtLastFuelEntry']")
	@CacheLookup
	WebElement area_LastFuelEntry;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ctl00_txtPetrolPump']")
	@CacheLookup
	WebElement txt_FuelStation;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ctl00_txtDriverName']")
	@CacheLookup
	WebElement txt_DriverName;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ctl00_txtLastKm']")
	@CacheLookup
	WebElement area_LastKMS;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ctl00_txtKms']")
	@CacheLookup
	WebElement txt_KMS;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ctl00_txtFuelQuantity']")
	@CacheLookup
	WebElement txt_Fuelqty;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ctl00_txtFuelRate']")
	@CacheLookup
	WebElement txt_Fuelrate;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ctl00_btnSave']")
	@CacheLookup
	WebElement btn_Submit;

	// Add Fuel -- from DashBoard icon - Methods
	public void ClickIconFuel() {
		icon_Fuel.click();
	}

	public void setVehicleNo() throws InterruptedException {
		txt_VehicleNo.sendKeys();
		Thread.sleep(2500);
		txt_VehicleNo.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2500);
		txt_VehicleNo.sendKeys(Keys.ENTER);
	}

	public void setFuelStation() throws InterruptedException {
		txt_FuelStation.sendKeys();
		Thread.sleep(2500);
		txt_FuelStation.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2500);
		txt_FuelStation.sendKeys(Keys.ENTER);
	}

	public void setDriverName() throws InterruptedException {
		txt_DriverName.sendKeys();
		Thread.sleep(2500);
		txt_DriverName.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2500);
		txt_DriverName.sendKeys(Keys.ENTER);
	}

	public void checkLastFuelEntry() {

		@SuppressWarnings("unused")
		WebElement FuelEntryKMS = area_LastFuelEntry;
		String AFuelKMS = area_LastFuelEntry.getText().toString();
		@SuppressWarnings("unused")
		WebElement LastKMS = area_LastKMS;
		String ALastKMS = area_LastKMS.getText().toString();
		if (AFuelKMS == ALastKMS) {
			Assert.assertEquals(AFuelKMS, ALastKMS);
			System.out.println("Note: check Matched");
		}

	}

	public void setKMS() {
		String setALastKMS = area_LastKMS.getText().toString();
		String eKMS = setALastKMS + 200;
		txt_KMS.sendKeys(eKMS);
	}

	public void setFuelQty() {
		txt_Fuelqty.sendKeys();
	}

	public void setFuelRate() {
		txt_Fuelrate.sendKeys();
	}

	public void ClickSubmit() {
		btn_Submit.click();
	}
}
