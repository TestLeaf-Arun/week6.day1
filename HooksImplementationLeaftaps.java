package steps;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksImplementationLeaftaps extends BaseClassLeaftaps {

	@Before
	public void preCondition() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps");
	}
	
	@After
	public void postCondition() {
		driver.close();
	}
}