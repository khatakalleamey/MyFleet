package co.qa.pageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookingPage {

	WebDriver bdr;

	public BookingPage(WebDriver gdr) {
		bdr = gdr;
		PageFactory.initElements(gdr, this);
	}

	// path
	// --booking
	@FindBy(xpath = "//a[@id='lnkbooking']")
	@CacheLookup
	WebElement btn_book;

	@FindBy(id = "txtCompanyName")
	@CacheLookup
	WebElement txt_cmpName;

	@FindBy(className = "ui-menu-item")
	@CacheLookup
	List<WebElement> listcmpname;

	@FindBy(xpath = "//select[@id='ddlCity']")
	@CacheLookup
	WebElement txt_servCity;

	@FindBy(xpath = "//select[@id='ddlBookingMode']")
	@CacheLookup
	WebElement txt_Bookmode;

	@FindBy(xpath = "//input[@id='txtFromDate']")
	@CacheLookup
	WebElement chose_Date;

	@FindBy(id = "txtBookingGivenBy")
	@CacheLookup
	WebElement txt_BookingGivenby;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtBookingContactNo']")
	@CacheLookup
	WebElement txtBookCN;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtBoookerEmailId']")
	@CacheLookup
	WebElement txtbookEid;

	@FindBy(id = "txtCustomerName_1")
	@CacheLookup
	WebElement txtGuestPr;

	@FindBy(className = "ui-menu-item")
	@CacheLookup
	List<WebElement> listguestNAME;

	@FindBy(xpath = "//input[@id='txtMobileNo_1']")
	@CacheLookup
	WebElement txtGMobileNo;

	@FindBy(xpath = "//input[@id='txtEmailId_1']")
	@CacheLookup
	WebElement txtguestEid;

	@FindBy(xpath = "//input[@id='txtEmployeeId_1']")
	@CacheLookup
	WebElement txtguestEmpid;

	@FindBy(xpath = "//input[@id='txtReportingTime_1']")
	@CacheLookup
	WebElement chooseTime;

	@FindBy(xpath = "//select[@id='ddlPickupPlace_1']")
	@CacheLookup
	WebElement choosePickupA;

	@FindBy(xpath = "//textarea[@id='txtpickuplacefrom_1']")
	@CacheLookup
	WebElement txtPickuplocat;

	@FindBy(xpath = "//select[@id='ddlDropPlace_1']")
	@CacheLookup
	WebElement chooseDropAd;

	@FindBy(xpath = "//textarea[@id='txtpickuplaceto_1']")
	@CacheLookup
	WebElement txtDroplocat;

	@FindBy(xpath = "//input[@id='chkVIP_1']")
	@CacheLookup
	WebElement checkVIP;

	@FindBy(xpath = "//input[@id='chkLady_1']")
	@CacheLookup
	WebElement checkLady;

	@FindBy(xpath = "//input[@name = 'ctl00$ContentPlaceHolder1$Direct' and @type = 'radio']")
	@CacheLookup
	List<WebElement> chooseradio;

	@FindBy(xpath = "//select[@id='ddlVehicalType']")
	@CacheLookup
	WebElement chooseVehicletype;

	@FindBy(xpath = "//select[@id='ddlPackageFor']")
	@CacheLookup
	WebElement choosePackagefor;

	@FindBy(id = "ddlPackageName")
	@CacheLookup
	WebElement choosePackagename;

	@FindBy(xpath = "//input[@id='btnSaveid']")
	@CacheLookup
	WebElement btnSubmit;

	@FindBy(xpath = "//input[@id='btnSaveAllocaion']")
	@CacheLookup
	WebElement btnSubmitnAllocation;

	// path
	// --Allocation

	@FindBy(xpath = "//input[@id='Self' and @type ='radio']")
	@CacheLookup
	WebElement chooseradioA_S;

	@FindBy(xpath = "//input[@id='Vendor' and @type ='radio']")
	@CacheLookup
	WebElement chooseradioA_V;

	@FindBy(xpath = "//select[@id='ddlVehicleNo']")
	@CacheLookup
	WebElement chooseVehNo;

	@FindBy(xpath = "//input[@id='txtDriverSearch']")
	@CacheLookup
	WebElement txtDriverPre;

	@FindBy(className = "ui-menu-item")
	@CacheLookup
	List<WebElement> listDrivername;

	@FindBy(xpath = "//input[@id='btnSavelAllocation']")
	@CacheLookup
	WebElement btnsubmitA;

	// path
	// ReturnPath['Dashboard']
	@FindBy(xpath = "//a[@id='ctl00_lnkdashboard']")
	@CacheLookup
	WebElement btnRdashB;

	// Methods-Booking
	public void clickBook() {
		btn_book.click();
	}

	public void setPrefixName(String PrefixName) {
		txt_cmpName.sendKeys(PrefixName);
	}

	public void setCompanyName(String CompanyName) throws InterruptedException {

		Thread.sleep(3000);

		for (WebElement listview : listcmpname) {
			if (listview.getText().equalsIgnoreCase(CompanyName)) {
				Actions actions = new Actions(bdr);
				actions.moveToElement(listview);
				Thread.sleep(2000);
				listview.click();
			}
		}

	}

	public void setServingCity(String ServingCity) {
		Select servCity = new Select(txt_servCity);
		servCity.selectByVisibleText(ServingCity);
	}

	public void setBookMode(String BookingMode) {
		Select bookMode = new Select(txt_Bookmode);
		bookMode.selectByVisibleText(BookingMode);
	}

	public void chosetheDate() {

		chose_Date.sendKeys(Keys.ENTER);
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy "); Date date = new
		 * Date(); String date1= dateFormat.format(date);
		 * System.out.println("Today's Date " + date1);
		 */

	}

	public void setBookingGiven(String BookingGivenBy) {
		txt_BookingGivenby.sendKeys(BookingGivenBy);
	}

	public void setBookCN(String BookingByContactNo) {
		txtBookCN.sendKeys(BookingByContactNo);
	}

	public void setBookEmailid(String BookingByEmailId) {
		txtbookEid.sendKeys(BookingByEmailId);
	}

	public void setGuestPrefix(String GuestPrefix) {
		txtGuestPr.sendKeys(GuestPrefix);
	}

	public void setGuestName(String GuestName) throws InterruptedException {

		Thread.sleep(3000);
		for (WebElement list : listguestNAME) {
			if (list.getText().equalsIgnoreCase(GuestName)) {
				Actions actions1 = new Actions(bdr);
				actions1.moveToElement(list);
				Thread.sleep(2000);
				list.click();
			}
		}
	}

	public void setGuestMobileNo(String GuestMobileNo) {

		txtGMobileNo.clear();
		txtGMobileNo.sendKeys(GuestMobileNo);

	}

	public void setGuestEmailId(String GuestEmailId) {
		txtguestEid.clear();
		txtguestEid.sendKeys(GuestEmailId);
	}

	public void setEmployeeId(String EmployeeiD) {
		txtguestEmpid.clear();
		txtguestEmpid.sendKeys(EmployeeiD);
	}

	public void setGuestBookingtime(String Time) {

		chooseTime.sendKeys(Time);
	}

	public void choosePickupAddr(String PickupAddress) {
		Select PickpAdd = new Select(choosePickupA);
		PickpAdd.selectByVisibleText(PickupAddress);
	}

	public void setPickupLocation(String PickupLocation) {
		txtPickuplocat.clear();
		txtPickuplocat.sendKeys(PickupLocation);

	}

	public void chooseDropAddr(String DropAddress) {
		Select DropAdd = new Select(chooseDropAd);
		DropAdd.selectByVisibleText(DropAddress);
	}

	public void setDropLocation(String DropLocation) {
		txtDroplocat.clear();
		txtDroplocat.sendKeys(DropLocation);
	}

	public void setCheckVIP(String VIP, String Lady) {
		boolean isVIPSelected = checkVIP.isSelected();
		if (isVIPSelected == false) {
			if (VIP.equalsIgnoreCase("Yes") && Lady.equalsIgnoreCase("No")) {
				checkVIP.click();
			}
		} else if (isVIPSelected == true) {
			if (VIP.equalsIgnoreCase("No") || VIP.equalsIgnoreCase(null)) {
				checkVIP.click();
			}
		}
	}

	public void setCheckLady(String Lady, String VIP) {
		boolean isLadySelected = checkLady.isSelected();
		if (isLadySelected == false) {
			if (Lady.equalsIgnoreCase("Yes") && VIP.equalsIgnoreCase("No")) {
				checkLady.click();
			}
		} else if (isLadySelected == true) {
			if (Lady.equalsIgnoreCase("No") || Lady.equalsIgnoreCase(null)) {
				checkLady.click();
			}
		}
	}

	public void setChoosePaymentType(String PaymenType) {
		for (int i = 0; i < chooseradio.size(); i++) {
			WebElement localRadio = chooseradio.get(i);
			String value = localRadio.getAttribute("value");
			if (value.equals(PaymenType)) {
				localRadio.click();
			}
		}
	}

	public void setVehicletype(String VehicleType) {
		Select TypeVehicle = new Select(chooseVehicletype);
		TypeVehicle.selectByVisibleText(VehicleType);
	}

	public void setPackageFor(String PackageFor) {
		Select ForPackage = new Select(choosePackagefor);
		ForPackage.selectByVisibleText(PackageFor);
	}

	public void setPackageName(String PackageName) {
		Select NamePackage = new Select(choosePackagename);
		NamePackage.selectByVisibleText(PackageName);
	}

	public void Clicksubmit() {
		btnSubmit.click();
	}

	public void ClickSubmitnAllocate() {
		btnSubmitnAllocation.click();
	}

	public void OffAlertSameGuestName() {
		String alert1_msg = bdr.switchTo().alert().getText();
		System.out.println("Alert message is : " + alert1_msg);
//		String expected_msg1 = "Customer Name: AMEY has already Booking with the same Date. Do You want to Continue ?";
		if (alert1_msg.equalsIgnoreCase(
				"Customer Name: AMEY has already Booking with the same Date. Do You want to Continue ?")) {
			bdr.switchTo().alert().accept();
//			Assert.assertEquals(expected_msg1, alert1_msg);
		} else {
			bdr.switchTo().alert().accept();
		}
	}

	public void offAlertBooking() {
		String alert2_msg = bdr.switchTo().alert().getText();
		System.out.println("Alert message is : " + alert2_msg);
		if (alert2_msg.equalsIgnoreCase("Booking saved successfully.")) {
			bdr.switchTo().alert().accept();
		}
	}

	// Methods-Allocation
	public void setChooseAllcationType(String AllocationType) {
		boolean isVendorSelected = chooseradioA_V.isSelected();
		System.out.println(isVendorSelected);
		if (AllocationType == "Self") {
			System.out.println(AllocationType + "= Self ");
		} else {

			chooseradioA_V.click();

		}
	}

	public void setchooseVehicleNu(String VehicleNu) {
		Select Vehicleno = new Select(chooseVehNo);
		Vehicleno.selectByVisibleText(VehicleNu);
	}

	public void setDriverPre(String DriverPrefix) {
		txtDriverPre.sendKeys(DriverPrefix);
	}

	public void setDriverName(String DriverName) throws InterruptedException {
		Thread.sleep(3000);
		for (WebElement listD : listDrivername) {
			if (listD.getText().equalsIgnoreCase(DriverName)) {
				Actions actions1 = new Actions(bdr);
				actions1.moveToElement(listD);
				Thread.sleep(2000);
				listD.click();
				txtDriverPre.sendKeys(Keys.TAB);
			}
		}
	}

	public void ClickSubmitonAllocation() {
		btnsubmitA.click();
	}

	public void offAlertAllocation() {
		String alert3 = bdr.switchTo().alert().getText();
		System.out.println("Alert Message is " + alert3);
		if (alert3.contains("Allocation Done.")) {
			bdr.switchTo().alert().accept();
		}
	}

	public void ClickReturnDashboard() {
		btnRdashB.click();
	}
}
