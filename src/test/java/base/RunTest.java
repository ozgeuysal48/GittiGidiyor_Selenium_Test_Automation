
package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RunTest extends DriverManager {

   private String userName  = "seleniumtestdeneme1@gmail.com";
   private String password  = "1234Hello";
   private String searchKey = "bilgisayar";

   @Before
   public void initialize() {
      launch();
   }

   @Test
   public void run() throws InterruptedException, IOException {

      getElementByXpath("//span[text()='Kapat']").click();
      getElementByXpath("//div[contains(text(),'Giriş Yap')]").click();
      getElementByXpath("//*[@data-cy='header-login-button']").click();
      Log4j.Log.info("Advertisement closed and login button clicked.");

      getElementById("L-UserNameField").sendKeys(userName);
      getElementById("L-PasswordField").sendKeys(password);
      getElementById("gg-login-enter").click();
      Log4j.Log.info("Home page opened.");

      String loginVerification = getElementByXpath("//div[@class='gekhq4-4 egoSnI']").getText();
      Assert.assertTrue(loginVerification.contains("Hesabım"));
      Log4j.Log.info("User " + userName + " logged in. Verified that login is successful.");

      getElementBySelector("input[aria-label='Keşfetmeye Bak']").sendKeys(searchKey);
      getElementBySelector("button[type='submit'] span").click();
      getElementByXpath("//span[text()='Sonraki']").click();
      Log4j.Log.info("The product " + searchKey + " searched and moved to next page.");

      Random random = new Random();
      getElementByXpath("//*[@id='2']/li[" + random.nextInt(30) + "]").click();
      Log4j.Log.info("A product clicked randomly.");

      String productName = getElementById("sp-title").getText();
      String productPrice = getElementById("sp-price-highPrice").getText();
      productDetails(productPrice, productName);
      Log4j.Log.info("Product price and name wrote to txt file.");

      getElementById("add-to-basket").click();
      Thread.sleep(2000);
      getElementByXpath("//*[@class='header-cart-hidden-link']").click();
      Log4j.Log.info("Product added to basket.");

      String basketPrice = getElementByClassName("total-price").getText();
      Assert.assertTrue(basketPrice.equals(productPrice));
      Log4j.Log.info("Verified that actual price and expected price is the same.");

      Select dropdown = new Select(getElementByXpath("//*[@class='amount']"));
      dropdown.selectByValue("2");
      Log4j.Log.info("Product count in the basket increased by 1.");

      Thread.sleep(1000);
      String numberOfProduct = getElementByXpath("//div[@class='gg-d-16 gg-m-14 detail-text']").getText();
      Assert.assertTrue(numberOfProduct.equals("Sepet Tutarı (2 Adet)"));
      Log4j.Log.info("Verified that # of product in basket is 2.");

      getElementByXpath("(//a[@title='Sil'])[1]").click();
      Log4j.Log.info("Basket is empty.");

      Thread.sleep(1000);
      String basketMsg = getElementByXpath("//div[@class='gg-w-22 gg-d-22 gg-t-21 gg-m-18']").getText();
      Assert.assertTrue(basketMsg.contains("Sepetinizde ürün bulunmamaktadır."));
      Log4j.Log.info("Verified that basket is empty.");
      Thread.sleep(1000);
   }

   public void productDetails(String price, String name) {
      PrintStream fileStream;
      try {
         fileStream = new PrintStream(new File("product_details.txt"));
         fileStream.println("Product Price: " + price);
         fileStream.println("Product description: " + name);
      }
      catch (FileNotFoundException ex) {
         Log4j.Log.info("An error occured during creating output file." + ex);
      }
   }

   @After
   public void down() {
      Log4j.Log.info("Test completed.");
      driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
      driver.quit();
   }
}
