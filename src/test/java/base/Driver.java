
package base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
   public static WebDriver     driver;
   private static final String URL = "https://www.gittigidiyor.com/";

   // Disable browser notifications
   public ChromeOptions disableNotifications() {
      Map<String, Object> prefs = new HashMap<String, Object>();
      prefs.put("profile.default_content_setting_values.notifications", 2);
      ChromeOptions options = new ChromeOptions();
      return options.setExperimentalOption("prefs", prefs);
   }

   public void launch() {
      System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
      driver = new ChromeDriver(disableNotifications());
      driver.manage().window().maximize();
      driver.get(URL);
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      Log4j.Log.info(URL + " home page opened.");
   }
}
