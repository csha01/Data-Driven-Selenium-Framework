package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
		
	public static FileReader fr;
	public static FileReader fr1;
	
	static Properties p = new Properties();
	
	protected static Properties loc = new Properties();
	
	@BeforeMethod
	public static void setUp() throws IOException {
		
		if(driver==null) {
			 fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties");
			 fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\locator.properties");
			loc.load(fr1);
			p.load(fr);
		}
		
		if(p.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(p.getProperty("testurl"));
		}
		else if(p.getProperty("browser").equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(p.getProperty("testurl"));
			
		}
		
	}

	@AfterMethod
	public static void tearDown() {
		driver.close();
		System.out.println("Teardown successful");
	}

}
