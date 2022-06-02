
package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager extends Driver {

   public static WebElement waitForElement(By locator, long waitSeconds) {
      try {
         WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
         return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
      }
      catch (RuntimeException ex) {
         throw (ex);
      }
   }

   public static WebElement getElementBySelector(String cssSelector) {
      return waitForElement(By.cssSelector(cssSelector), 25);
   }
   
   public static WebElement getElementByClassName(String className) {
      return waitForElement(By.className(className), 25);
   }

   public static WebElement getElementById(String id) {
      return waitForElement(By.id(id), 25);
   }

   public static WebElement getElementByXpath(String xpath) {
      return waitForElement(By.xpath(xpath), 25);
   }

}
