package data.Assignement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class AppTest 

{
	        public static void main(String[] args) throws InterruptedException {
	        	  try {
	                  // Set up ChromeDriver using WebDriverManage
	                  WebDriver driver = new ChromeDriver();

	                  // Navigate to the FitPeo home page
	                  driver.get("https://www.fitpeo.com/home");

	                  // Open the drawer menu
	                  driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();

	                  // Select the "Revenue Calculator" option from the menu
	                  driver.findElement(By.xpath("//span[text()='Revenue Calculator']")).click();

	                  // Maximize the browser window
	                  driver.manage().window().maximize();

	                  // Scroll to the specific section of the page using JavaScript
	                  JavascriptExecutor js = (JavascriptExecutor) driver;
	                  js.executeScript("document.getElementsByClassName('MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6 css-iol86l')[0].scrollIntoView(true);"
	                  );

	                  // Locate the slider element on the page
	                  WebElement slider = driver.findElement(By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh']"));

	                  // Use Actions class to drag and move the slider by 94 units horizontally
	                  Actions action = new Actions(driver);
	                  action.dragAndDropBy(slider, 94, 0).perform();

	                  // Set the value of a specific input field using JavaScript
	                  js.executeScript("document.getElementById(':R57alklff9da:').value='560'");

	                  // Scroll down the page to ensure visibility of other elements
	                  js.executeScript("window.scrollTo(0,850);");

	                  // Select checkboxes for CPT codes
	                  driver.findElement(By.xpath("//p[text()='CPT-99091']/following-sibling::label")).click();
	                  driver.findElement(By.xpath("//p[text()='CPT-99453']/following-sibling::label")).click();
	                  driver.findElement(By.xpath("//p[text()='CPT-99454']/following-sibling::label")).click();

	                  // Interact with an input field inside a specific div element
	                  driver.findElement(By.xpath("//div[@class='MuiBox-root css-1eynrej'][8]//input")).click();

	                  // Wait for some time to allow the calculation to complete (not recommended for production use)
	                  Thread.sleep(3000);

	                  // Retrieve the total reimbursement value from the page
	                  String total = driver.findElement(By.xpath("//div[@class='MuiBox-root css-m1khva']/p[@class='MuiTypography-root MuiTypography-body1 inter css-12bch19']")).getText();

	                  // Validate the total reimbursement value and print the result
	                  if (total.contains("110700")) {
	                      System.out.println("Test passed: Total Recurring Reimbursement for all Patients Per Month: " + total);
	                  } else {
	                      System.out.println("Test failed: Total Recurring Reimbursement for all Patients Per Month: " + total);
	                  }

	                  // Close the browser
	                  driver.close();
	                  System.out.println("Testing Execution Completed");
	              } catch (InterruptedException e) {
	                  // Handle any InterruptedException that occurs during Thread.sleep
	                  e.printStackTrace();
	              }
	          }

}

