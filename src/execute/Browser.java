package execute;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Browser {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://app.gopazo.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMahesh() throws Exception {
    driver.get(baseUrl + "/login");
   /* String str2=driver.getTitle();
    System.out.println(str2);*/
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("phase3test");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("phase3test");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
   /*String str=driver.getTitle();
   System.out.println(str);
   driver.findElement(By.xpath("//td[13]/a/span")).click();
   String str1=driver.getTitle();
   System.out.println(str1);*/
   /*if (str=app.gopazo.com//super_client)
   {
	   System.out.println("test case pass");
   }*/
    
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}