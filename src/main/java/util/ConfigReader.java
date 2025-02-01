package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	public Properties readProperties() {
		properties = new Properties();
		try {
			FileInputStream stream = new FileInputStream("./src/main/resources/config/config.properties");
			properties.load(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
