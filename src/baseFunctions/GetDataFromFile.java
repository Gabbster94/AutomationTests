package baseFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromFile {

	public static Properties readfile() throws IOException {
		File file = new File("C:\\_DiskD\\Programare\\Git\\PrivateConfig\\Credentials.properties");

		FileInputStream fileInput = null;
		fileInput = new FileInputStream(file);

		Properties prop = new Properties();

		// load properties file
		prop.load(fileInput);

		return prop;
	}

	public static String getUsernameFromFile(String App) throws IOException {
		Properties prop = readfile();
		if (App.equals("epiesa")) {
			String Username = prop.getProperty("epiesaEmail");
			return Username;
		}
		return null;

	}

	public static String getPasswordFromFile(String App) throws IOException {
		Properties prop = readfile();
		if (App.equals("epiesa")) {
			String Password = prop.getProperty("epiesaPassword");
			return Password;
		}
		return null;
	}
	
	public static String getPhoneNo(String App) throws IOException {
		Properties prop = readfile();
		if(App.equals("epiesa")) {
			String PhoneNo = prop.getProperty("epiesaPhoneNo");
			return PhoneNo;
		}
		return null;
	}
}
