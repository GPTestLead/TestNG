package WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DynamicTable {

	
	@Test
	public void table()
	{
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://money.rediff.com/indices");
	
	// click on show more
	driver.findElement(By.id("showMoreLess")).click();
	
	// xpath for table-tbody
	WebElement webTable = driver.findElement(By.xpath("//table[@id='dataTable']//tbody"));
	
	//raws
	List<WebElement> rows=webTable.findElements(By.tagName("tr"));
	 int rowsCount = rows.size();
	 for (int i = 0; i < rowsCount; i++) 
	 {
		//columns
		 List<WebElement> columns= rows.get(i).findElements(By.tagName("td"));
		 int columnscount = columns.size();
		 
		 for (int j = 0; j < columnscount; j++) {
			String cellText = columns.get(j).getText();
			if(cellText.equalsIgnoreCase("S&P BSE 200"))
			{
				System.out.println("Prev close value is : " +columns.get(1).getText());
				System.out.println("Last Traded :"+columns.get(2).getText() );
				System.out.println("Change PTs :"+columns.get(3).getText() );
				System.out.println("% Change :"+columns.get(3).getText() );
			}
		}
	}
	}
	
}

