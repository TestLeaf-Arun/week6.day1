package steps;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionLeaftaps extends BaseClassLeaftaps {
	
//	Create Lead Page
	@Given("Enter the username as {string}")
	public void enterUserName(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@Given("Enter the password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("Click on Login button")
	public void clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("Homepage should be displayed")
	public void verifyHomepage() {
		boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		if (displayed) {
			System.out.println("Homepage is displayed");
		} else {
			System.out.println("not displayed");
		}
	}

	@When("Click on CRMSFA link")
	public void clickCrmsfa() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@When("Click on Leads link")
	public void clickLeadsLink() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@When("Click on Create Lead link")
	public void clickCreateLeadLink() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@Then("Create Lead Page should be displayed")
	public void verifyCreateLeadPage() {
		String createleadpagetitle = driver.getTitle();
		System.out.println("Title of Create Lead page: " + createleadpagetitle);
		if (createleadpagetitle.equalsIgnoreCase("Create Lead | opentaps CRM")) {
			System.out.println("Create Lead page is displayed");
		} else {
			System.out.println("Create Lead page is not displayed");
		}
	}

	@Given("Enter the Company name as {string}")
	public void enterCompanyname(String companyname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
	}

	@Given("Enter the First Name as {string}")
	public void enterFirstname(String firstname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
	}

	@Given("Enter the Last Name as {string}")
	public void enterLastname(String lastname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
	}

	@When("Click on Create Lead button")
	public void clickCreateLeadButton() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("View Lead Page should be displayed")
	public void verifyNewLead() {
		String viewleadpagetitle = driver.getTitle();
		System.out.println("Page title of Create lead page is " + viewleadpagetitle);
		if (viewleadpagetitle.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("View Lead page is displayed");
		} else {
			System.out.println("View Lead page is not displayed");
		}
	}
	
//  Edit Lead Page
	@When("Click on Find Leads link")
	public void clickFindLeadsLink() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@When("Click on Phone tab")
	public void clickPhoneTab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@When("Enter Phone number as {string}")
	public void enterPhoneno(String phoneno) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneno);
	}

	@When("Click on Find Leads button")
	public void clickFindLeadsButton() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}

	@When("Click on first resulting lead")
	public void clickFirstLead() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@When("Click on Edit button")
	public void clickEditButton() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@Given("Edit Company name as {string}")
	public void editCompanyName(String company) {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(company);
	}

	@When("Click on Update button")
	public void clickUpdateButton() {
		driver.findElement(By.name("submitButton")).click();
	}

	@When("Company name of Lead should be updated")
	public void verifyCompanyname() {
		String companytext = driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println("Updated Company Name: " + companytext);
		if (!companytext.equalsIgnoreCase("TestLeaf")) {
			System.out.println("Company Name is updated");
		} else {
			System.out.println("Company Name is not updated");
		}
	}
		
//  Duplicate Lead Page
	@When ("Click on Duplicate Lead button")
	public void clickDuplicateButton() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
		
//  Merge Lead Page
	@When ("Click on Merge Leads link")
	public void clickMergeLeadsLink() {
		driver.findElement(By.linkText("Merge Leads")).click();
	}
	
	@When ("Click on From Lead lookup {string}")
	public void clickFromLeadLookup(String fname) throws InterruptedException, IOException {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		
		Set<String> allWindows1 = driver.getWindowHandles();
		List<String> allhandles1 = new ArrayList<String>(allWindows1);
		driver.switchTo().window(allhandles1.get(1));
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fname);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		
		String MergeleadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/config.properties");		
		Properties prop = new Properties();
		prop.setProperty("MergeLeadID", MergeleadID);
		prop.store(fos, null);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles1.get(0));
	}

	@When ("Click on To Lead lookup {string}")
	public void clickToLeadLookup(String lname) throws InterruptedException {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
		
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lname);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles2.get(0));
	}
		
	@When ("Click on Merge button")
	public void clickMergeButton() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
	}
		
	@When ("Handle the alert")
	public void handleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
		
	@When ("Search by Lead ID")
	public void searchLeadID() throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(prop.getProperty("MergeLeadID"));
	}
		
	@Then ("Verify the Leads are Merged")
	public void verifyLeadsMerged() {
		String text1 = driver.findElement(By.className("x-paging-info")).getText();
		if (text1.equals("No records to display")) {
			System.out.println("Text matched and leads are merged");
		} else {
			System.out.println("Text not matched and leads are not merged");
		}
	}

//  Delete Lead Page
	@When ("Click on first resulting lead to be deleted")
	public void clickFirstResultingLead() throws IOException {
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.setProperty("leadID", leadID);
		prop.store(fos, null);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
		
	@When ("Click on Delete button")
	public void clickDeleteButton() {
		driver.findElement(By.linkText("Delete")).click();
	}
	
	@When ("Enter Lead ID")
	public void enterLeadID() throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(prop.getProperty("leadID"));
	}
	
	@When ("No search results should be displayed")
	public void verifyNoRecords() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
	}
}