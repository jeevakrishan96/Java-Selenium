package Utils;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    static Properties props;

    public PropertiesReader() {
        try {
            FileReader reader = new FileReader("config.properties");
            props = new Properties();
            props.load(reader);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            // Handle the exception as needed, for example, log it or throw a custom exception.
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            // Handle the exception as needed, for example, log it or throw a custom exception.
        }
    }

    public PropertiesReader(String propertyFile) {
        try {
            FileReader reader = new FileReader(propertyFile);
            props = new Properties();
            props.load(reader);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            // Handle the exception as needed, for example, log it or throw a custom exception.
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            // Handle the exception as needed, for example, log it or throw a custom exception.
        }
    }
    public  String getProperty(String key) {
		return props.getProperty(key);
		
	}

    public  void setProperty(String key, String value) {
		 props.setProperty(key, value);
		
	}

  
}