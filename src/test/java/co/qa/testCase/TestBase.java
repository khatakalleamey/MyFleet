package co.qa.testCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import co.qa.utility.ReadConfig;

public class TestBase {
	ReadConfig readconfig = new ReadConfig();
	public String URL = readconfig.getApplicationURL();
	public String Username = readconfig.getUsername();
	public String Password = readconfig.getPassword();
//	public  String path = readconfig.getPath();
//	public String companyName = "ABC INDIA PVT. LTD.(AIPL)";
//	public String ServingCity = "PUNE";
//	public String BookingMode = "Online";
	public static Logger logger;

	public static WebDriver dr;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		logger = Logger.getLogger("MyFleetMan");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			{
				System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
				dr = new ChromeDriver();
			}
		} else {
			System.out.println("No Browser Found");
		}
		dr.manage().window().maximize();

	}

	/*
	 * @AfterClass public void closeDown() { dr.quit(); }
	 */

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
