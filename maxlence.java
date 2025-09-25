import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class maxlence {
	
	public class ProjectCreationTest {

	    public static void main(String[] args) {
	        
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        WebDriver driver = new ChromeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        try {
	            
	            driver.get("http://your-project-management-tool-url/login");

	            // Login
	            driver.findElement(By.id("username")).sendKeys("validUser");
	            driver.findElement(By.id("password")).sendKeys("validPassword");
	            driver.findElement(By.id("loginButton")).click();

	            // Wait for project module 
	            wait.until(ExpectedConditions.elementToBeClickable(By.id("projectModuleLink"))).click();

	            // wait for create new project
	            wait.until(ExpectedConditions.elementToBeClickable(By.id("createProjectButton"))).click();

	            //project details
	            driver.findElement(By.id("projectName")).sendKeys("Automation Test Project");
	            driver.findElement(By.id("startDate")).sendKeys("2025-10-01");
	            driver.findElement(By.id("endDate")).sendKeys("2025-12-31");
	            driver.findElement(By.id("description")).sendKeys("Project created by automation script");

	            // if many Assign users is there we can use this 
	            driver.findElement(By.xpath("//input[@value='user1']")).click();
	            driver.findElement(By.xpath("//input[@value='user2']")).click();

	            // Saving project
	            driver.findElement(By.id("saveProjectButton")).click();

	            // Verifying success message
	            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));
	            if(successMessage.getText().contains("Project created successfully")) {
	                System.out.println("Test Passed: Project created successfully.");
	            } else {
	                System.out.println("Test Failed: Success message not found.");
	            }

	            //Validation pass/fail
	            driver.findElement(By.id("projectListLink")).click();
	            boolean projectPresent = driver.getPageSource().contains("Automation Test Project");
	            if(projectPresent) {
	                System.out.println("Test Passed: Project is listed.");
	            } else {
	                System.out.println("Test Failed: Project not found in list.");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	    }
	}


}
