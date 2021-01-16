package co.qa.testCase;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import co.qa.pageObject.BookingPage;
import co.qa.pageObject.DBFuelPage;
import co.qa.pageObject.LoginPage;
import co.qa.utility.ExcelUtils;

public class GeneralTest extends TestBase {

	@Test(description = "Login to App")
	public void loginTest() throws InterruptedException {

		dr.get(URL);

		System.out.println("------------------Test1-----------------");
		LoginPage lp = new LoginPage(dr);

		// LoginPage
		Thread.sleep(5000);
		lp.removePopu();
		logger.info("Pop Up Removed");

		Thread.sleep(1000);
		lp.setuserName(Username);
		logger.info("Username Fetched");
		Thread.sleep(1000);
		lp.setpasswOrd(Password);
		logger.info("Password Fetched");

		Thread.sleep(5000);
		lp.clicksubmit();
		logger.info("Clicked on Submit");

		Thread.sleep(10000);
		if (dr.getTitle().equals("Dashboard")) {
			Assert.assertTrue(true);
			System.out.println(dr.getTitle());
			logger.info("Title Provided. Correct Page - Dashboard");
		} else {
			Assert.assertTrue(false);
			logger.warn("Login but Title not matched");
		}
		Thread.sleep(3000);
	}

	/*
	 * @DataProvider(name = "LoginData") String[][] getData() throws IOException {
	 * 
	 * String Path = System.getProperty("user.dir") +
	 * "/src/test/java/co/qa/TestData/Data.xlsx";
	 * 
	 * int rownum = ExcelUtils.getRow(Path, "Sheet1"); int colcount =
	 * ExcelUtils.getCol(Path, "Sheet1", 1);
	 * 
	 * String Data[][] = new String[rownum][colcount]; for (int i = 1; i <= rownum;
	 * i++) { for (int j = 0; j < colcount; j++) { Data[i - 1][j] =
	 * ExcelUtils.getCellData(Path, "Sheet1", i, j); } } return Data;
	 * 
	 * }
	 */

	@Test(dataProvider = "BookingMode", description = "Perform Booking")
	public void bookData(String PrefixName, String CompanyName, String ServingCity, String BookingMode,
			String BookingGivenBy, String BookingByContactNo, String BookingByEmailId, String GuestPrefix,
			String GuestName, String GuestMobileNo, String GuestEmailId, String EmployeeiD, String Time,
			String PickupAddress, String PickupLocation, String DropAddress, String DropLocation, String VIP,
			String Lady, String PaymenType, String VehicleType, String PackageFor, String PackageName,
			String AllocationType, String VehicleNu, String DriverPrefix, String DriverName)
			throws InterruptedException {

		System.out.println("------------------Test2-----------------");
		BookingPage bp = new BookingPage(dr);

		Thread.sleep(3000);
		bp.clickBook();

		if (dr.getTitle().equals("Booking")) {
			Assert.assertTrue(true);
			System.out.println(dr.getTitle());
		} else {
			Assert.assertTrue(false);
		}

		Thread.sleep(3000);
		bp.setPrefixName(PrefixName);
		System.out.println("Prefix Name is " + PrefixName);

		Thread.sleep(3000);
		bp.setCompanyName(CompanyName);
		System.out.println("Company Name " + CompanyName);

		Thread.sleep(300);
		bp.setServingCity(ServingCity);
		System.out.println("Serving City is " + ServingCity);

		Thread.sleep(300);
		bp.setBookMode(BookingMode);
		System.out.println("Booking done via " + BookingMode);

		Thread.sleep(10000);
		bp.chosetheDate();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println("Today's Date is " + date1);

		Thread.sleep(3000);
		bp.setBookingGiven(BookingGivenBy);
		System.out.println("Booking done by " + BookingGivenBy);

		Thread.sleep(3000);
		bp.setBookCN(BookingByContactNo);
		System.out.println("Booking By Contact No = " + BookingByContactNo);

		Thread.sleep(3000);
		bp.setBookEmailid(BookingByEmailId);
		System.out.println("Booking EmailID = " + BookingByEmailId);

		Thread.sleep(3000);
		bp.setGuestPrefix(GuestPrefix);
		System.out.println("Guest Prefix = " + GuestPrefix);

		Thread.sleep(3000);
		bp.setGuestName(GuestName);
		System.out.println("Guest Name is " + GuestName);

		Thread.sleep(3000);
		bp.setGuestMobileNo(GuestMobileNo);
		System.out.println("Guest Mobile No " + GuestMobileNo);

		Thread.sleep(3000);
		bp.setGuestEmailId(GuestEmailId);
		System.out.println("Guest Email Id " + GuestEmailId);

		Thread.sleep(3000);
		bp.setEmployeeId(EmployeeiD);
		System.out.println("Employee Id " + EmployeeiD);

		Thread.sleep(3000);
		bp.setGuestBookingtime(Time);
		System.out.println("Guest booking time " + Time);

		Thread.sleep(3000);
		bp.choosePickupAddr(PickupAddress);
		System.out.println("Pickup Address choosen " + Time);

		Thread.sleep(3000);
		bp.setPickupLocation(PickupLocation);
		System.out.println("Pickup Location Guest - " + PickupLocation);

		Thread.sleep(3000);
		bp.chooseDropAddr(DropAddress);
		System.out.println("Drop Address choosen" + DropAddress);

		Thread.sleep(3000);
		bp.setDropLocation(DropLocation);
		System.out.println("Drop Location Guest -" + DropLocation);

		Thread.sleep(3000);
		bp.setCheckVIP(VIP, Lady);
		System.out.println("Check VIP - " + VIP);

		Thread.sleep(3000);
		bp.setCheckLady(Lady, VIP);
		System.out.println("Check Lady - " + Lady);

		Thread.sleep(3000);
		if (PaymenType.equalsIgnoreCase("rdoCash")) {
			bp.setChoosePaymentType(PaymenType);
			System.out.println("Payment Type choosen Cash");
		} else if (PaymenType.equalsIgnoreCase("rdoBTC")) {
			bp.setChoosePaymentType(PaymenType);
			System.out.println("Payment Type choosen BTC");
		}

		Thread.sleep(3000);
		bp.setVehicletype(VehicleType);
		System.out.println("Vehicle Type is " + VehicleType);

		Thread.sleep(3000);
		bp.setPackageFor(PackageFor);
		System.out.println("Package for is " + PackageFor);

		Thread.sleep(3000);
		bp.setPackageName(PackageName);
		System.out.println("Package Name  " + PackageName);

		Thread.sleep(3000);
//		bp.Clicksubmit();
		bp.ClickSubmitnAllocate();

		Thread.sleep(6000);
		bp.OffAlertSameGuestName();

		Thread.sleep(10000);
		String alert2_msg = dr.switchTo().alert().getText();
		System.out.println("Alert message is : " + alert2_msg);
		if (alert2_msg.equalsIgnoreCase("Booking saved successfully.")) {
			dr.switchTo().alert().accept();
		}

		Thread.sleep(3000);
		String Booking = dr.getWindowHandle();
		if (dr.getTitle().equals("Booking")) {
			dr.switchTo().window(Booking);
		}

		// Allocation Tests
		Thread.sleep(3000);
		bp.setChooseAllcationType(AllocationType);
		System.out.println("Allocation Type for " + GuestName + "is " + AllocationType);

		Thread.sleep(3000);
		bp.setchooseVehicleNu(VehicleNu);
		System.out.println("Vehicle No. for " + GuestName + "is " + VehicleNu);

		Thread.sleep(3000);
		bp.setDriverPre(DriverPrefix);

		Thread.sleep(3000);
		bp.setDriverName(DriverName);
		System.out.println("Driver Name for " + VehicleNu + "is " + DriverName);

		Thread.sleep(3000);
		bp.ClickSubmitonAllocation();

		Thread.sleep(3000);
		bp.offAlertAllocation();

		Thread.sleep(10000);
		String Allocation = dr.getWindowHandle();
		dr.switchTo().window(Allocation);

//		Thread.sleep(3000);
//		bp.ClickReturnDashboard();
//		if (dr.getTitle().equals("Dashboard")) {
//			Assert.assertTrue(true);
//			System.out.println(dr.getTitle());
//		} else {
//			Assert.assertTrue(false);
//		}
	}

	@DataProvider(name = "BookingMode")
	String[][] getData1() throws IOException {

		String Path = System.getProperty("user.dir") + "/src/test/java/co/qa/TestData/Data.xlsx";

		int rownum = ExcelUtils.getRow(Path, "Sheet2");
		int colcount = ExcelUtils.getCol(Path, "Sheet2", 1);

		String data[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				data[i - 1][j] = ExcelUtils.getCellData(Path, "Sheet2", i, j);
			}
		}

		return data;

	}

	@Test(description = "add vehicle fuel slip")
	public void addFuelData() throws InterruptedException {
		System.out.println("------------------Test3-----------------");
		DBFuelPage DBFP = new DBFuelPage(dr);

		Thread.sleep(3000);
		DBFP.ClickIconFuel();

		DBFP.setVehicleNo();

	}

}
