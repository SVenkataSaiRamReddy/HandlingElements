import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumAutomation1 {
	public static void main(String[] args) throws IOException {
		automate();
	}

	public static void automate() throws IOException {
		int count = 1;
		System.setProperty("webdriver.chrome.driver", "A:\\SELENIUM\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

		webDriver.get("https://demoqa.com/automation-practice-form");

		WebElement firstName = webDriver.findElement(By.id("firstName"));
		firstName.sendKeys("Akshay");

		WebElement lastName = webDriver.findElement(By.id("lastName"));
		lastName.sendKeys("TR");
		WebElement email = webDriver.findElement(By.id("userEmail"));
		email.sendKeys("akshay@123.com");

		WebElement gender = webDriver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
		gender.click();
		WebElement mobile = webDriver.findElement(By.id("userNumber"));
		mobile.sendKeys("1234567891");

		WebElement dateInput = webDriver.findElement(By.id("dateOfBirthInput"));
		dateInput.click();
		
		WebElement selectMonthElement = webDriver.findElement(By.className("react-datepicker__month-select"));
		 Select select1 = new Select(selectMonthElement);
		 select1.selectByVisibleText("August");
		 
		 WebElement selectYearElement = webDriver.findElement(By.className("react-datepicker__year-select"));
		 Select select2 = new Select(selectYearElement);
		 select2.selectByVisibleText("2000");

		 WebElement selectDateElement = webDriver.findElement(By.className("react-datepicker__day--019"));
		 selectDateElement.click();
		 
		WebElement sub = webDriver.findElement(By.className("//*[@id=\"subjectsContainer\"]/div/div[1]"));
		sub.sendKeys("Computer Science");

		WebElement hobby1 = webDriver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"));
		hobby1.click();
		
		WebElement hobby2 = webDriver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label"));
		hobby2.click();
WebElement hobby3 = webDriver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label"));
		hobby3.click();

		
		takeScreenshot(webDriver, count++);
		webDriver.close();
	}

	public static void takeScreenshot(WebDriver wd, int number) throws IOException {
		File file = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(
				"C:\\Users\\aksh1\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\SELENIUM-DEMO\\src\\images\\img_"
						+ number + ".png"));
	}
}

