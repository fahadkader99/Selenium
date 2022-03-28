import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class YouTubeLinks {
	
	@Test
	public void youtubeLinks() throws Exception{
		
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
		
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.179:4444"), caps);
		driver.get("https://www.youtube.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Title of the Page: "+ driver.getTitle());
		
		List<WebElement> linkLists = driver.findElements(By.tagName("a"));
		System.out.println("Total number of Links: "+ linkLists.size());
		
		for(int i = 0; i<linkLists.size();i++) {
			System.out.print("\nLink: "+linkLists.get(i).getAttribute("href"));
			// getAttribut helps to get the links assiociated with href.
		}
		
		driver.close();
		
	}
}
