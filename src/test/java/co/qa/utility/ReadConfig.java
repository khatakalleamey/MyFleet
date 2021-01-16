package co.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties Prop;

	public ReadConfig() {

		File src = new File("./Configuration/config.Properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			Prop = new Properties();
			Prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String URL = Prop.getProperty("URL");
		return URL;
	}

	public String getUsername() {
		String username = Prop.getProperty("Username");
		return username;
	}

	public String getPassword() {
		String password = Prop.getProperty("Password");
		return password;
	}

	public String getChromePath() {
		String chroPath = Prop.getProperty("chromepath");
		return chroPath;
	}

}
