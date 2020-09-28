package SmarteAssignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonAssignment {

	public static void main(String[] args) throws InterruptedException {
		
// TC1: Amazon website should get launch properly by Selenium Webdriver  :- 
System.out.println(" TC1: Amazon website should get launch properly by Selenium Webdriver  :- ");
		
		// Launch the WebDriver :- 
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		System.out.println(driver.getTitle());
		
		// Searching "Formal" keyword into Search bar and waiting for result.
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Formal");
		driver.findElement(By.xpath("//input[@class=\"nav-input\"and @type=\"submit\"]")).submit();
		Thread.sleep(2000);
		
// TC2: User is able to search by using search bar. Test data : searched keyword "Formal"
System.out.println(" TC2: User is able to search by using search bar. Test data : searched keyword \"Formal\"");
		
		List<WebElement> Productname = driver.findElements(By.xpath("//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));
		System.out.println(Productname.size());
		for (int i=0;i<Productname.size();i++) 
		{
			System.out.println(Productname.get(i).getText());
			if (Productname.get(i).getText().contains("Formal"))
			{
				System.out.println("All product name has formal text hence the test case is Passed");
			}
			else
			{
				System.out.println("The product name is not contain formal text hence the test case is failed");
			}
			
		}	

// TC3: User should able to get appropriate search result based on his/her search keyword :-
System.out.println("TC3: User should able to get appropriate search result based on his/her search keyword :-");
		System.out.println("");	
		WebElement result = driver.findElement(By.xpath("//span[contains(text(),\"results\")]"));
		String[] result_text = result.getText().split(" ");
		System.out.println("Total count for Formal search keyword is " + result_text[3]);
			
// TC4: User is able to apply filers and based on filers search result should be proper
System.out.println("TC4: User is able to apply filers and based on filers search result should be proper");
			
			driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'and text()=\"Men's Formal Shirts\"]")).click();
			Thread.sleep(2000);
			List<WebElement> Productname2 = driver.findElements(By.xpath("//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));
			System.out.println(Productname2.size());
			for (int k=0;k<Productname2.size();k++) 
			{
				System.out.println(Productname2.get(k).getText());
				if (Productname2.get(k).getText().contains("Formal") || Productname2.get(k).getText().contains("Shirt") )
				{
					System.out.println("All product name has formal shirt text hence the test case is Passed");
				}
				else
				{
					System.out.println("The product name is not contain formal shirt text hence the test case is failed");
				}
			}
		
// TC5: The selected size should be bold when its selected in filters. Test data : 38 size
System.out.println("TC5: The selected size should be bold when its selected in filters. Test data : 38 size");	

		driver.findElement(By.xpath("//span[@class=\"a-size-base a-color-base\" and text()='38']")).click();
		Thread.sleep(2000);
		
		WebElement size38 = driver.findElement(By.xpath("//button[@aria-label='38']"));
		
		if (size38.getAttribute("class").contains("a-text-bold")) 
		{
			System.out.println("38 is selected");
		}
		else 
		{
			System.out.println("38 is not selected");
		}
	
	}
}
	



