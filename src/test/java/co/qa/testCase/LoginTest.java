package co.qa.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import co.qa.pageObject.LoginPage;
import co.qa.utility.ExcelUtils;

public class LoginTest extends TestBase {

	@Test(dataProvider = "LoginData", description = "Login to App")
	public void loginTest(String Username, String Password) throws InterruptedException {

		dr.get(URL);
		System.out.println("------------------Test1-----------------");
		LoginPage lp = new LoginPage(dr);

		// LoginPage
		Thread.sleep(5000);
		lp.removePopu();
		Thread.sleep(5000);
		lp.setuserName(Username);
		Thread.sleep(5000);
		lp.setpasswOrd(Password);
		Thread.sleep(5000);
		lp.clicksubmit();
		Thread.sleep(10000);
		if (dr.getTitle().equals("Dashboard")) {
			Assert.assertTrue(true);
			System.out.println(dr.getTitle());
		} else {
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {

		String Path = System.getProperty("user.dir") + "/src/test/java/co/qa/TestData/Data.xlsx";

		int rownum = ExcelUtils.getRow(Path, "Sheet1");
		int colcount = ExcelUtils.getCol(Path, "Sheet1", 1);

		String Data[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				Data[i - 1][j] = ExcelUtils.getCellData(Path, "Sheet1", i, j);
			}
		}
		return Data;

	}
}
