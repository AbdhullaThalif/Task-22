package task;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Task_22_1 {
	public static void main(String[] args) throws Exception {
		
		// Launch the ChromeDriver browser
		WebDriver driver = new ChromeDriver();
		// Go to the form page of phptravels.com
		driver.get("https://phptravels.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Input the First Name in the First Name Field
		driver.findElement(By.name("first_name")).sendKeys("Arun");
		// Input the Last Name in the Last Name Field
		driver.findElement(By.name("last_name")).sendKeys("Raj");
		// Input the Business Name in the Business Name Field
		driver.findElement(By.name("business_name")).sendKeys("ArunRaJ");
		// Input the Email ID in the Email Field
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("testemailgv2000@gmail.com");
		// Get the Numbers in the String Value
		String Number1 = driver.findElement(By.xpath("//span[@id='numb1']")).getText();
		System.out.println(Number1);
		String Number2 = driver.findElement(By.xpath("//span[@id='numb2']")).getText();
		System.out.println(Number2);
		// Could not added the values in the string so converted to Integer Value
		int a = Integer.parseInt(Number1);
		int b = Integer.parseInt(Number2);
		// Added the Number1 and Number2 Values
		int Total = a + b;
		// Converted as Integer to String 
		String Sum = Integer.toString(Total);
		System.out.println(Sum);
		// Input the sum to the result field
		driver.findElement(By.xpath("//input[@id='number']")).sendKeys(Sum);
		// Click on the submit button
		driver.findElement(By.xpath("//button[@id='demo']")).click();
		// Confirmed to form has been submitted or not. so get the page title and use If method to verified it
		String Title = driver.getTitle();
		System.out.println(Title);
		if (Title.equalsIgnoreCase("Book Your Free Demo Now - Phptravels")) {
			System.out.println("The form is submitted successfully");
		} else {
			System.out.println("The form is not submitted successfully");
		}
		Thread.sleep(1000);
		// Use TakesScreenshot method to get the screenshot
		TakesScreenshot scr = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File src = scr.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(src, new File("C://Users/ELCOT/eclipse-workspace/GuviTask/ScreenShots/Proof.png"));
	}
}
