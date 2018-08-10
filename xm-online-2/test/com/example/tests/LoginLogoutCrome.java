package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginLogoutCrome {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://compass.test.xm-online.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void makeLoginLogout() throws Exception {
	  goToLoginPAge();
	  enterUsername("compass");
	  enterPwd("P@ssw0rd");
	  confirmLogin();
	  openUserBar();
	  assertTrue(isLogoutBtnIsPresent());
 	  logout();
	  confirmLogout();
	  }
  
  private boolean isLogoutBtnIsPresent() {
	// TODO Auto-generated method stub
	driver.findElement(By.id("logout")).getText().equals("Sign Out");
	return true;
}

private void confirmLogin() {
	// TODO Auto-generated method stub
	driver.findElement(By.cssSelector(".btn-primary")).click();
}

private void confirmLogout() {
	// TODO Auto-generated method stub
	driver.findElement(By.cssSelector(".swal2-confirm")).click();
}

private void logout() {
	// TODO Auto-generated method stub
	driver.findElement(By.id("logout")).click();
	driver.findElement(By.cssSelector("#logout")).click();
	driver.findElement(By.linkText("Sign out")).click();
}

private void openUserBar() {
	// TODO Auto-generated method stub
	driver.findElement(By.xpath("//div[@class='info']")).click();
	//driver.findElement(By.name("collapse")).click();
	//driver.findElement(By.cssSelector(".collapsed")).click();
}

private void enterPwd(String userNamePwd) {
	// TODO Auto-generated method stub
	  driver.findElement(By.id("password")).sendKeys(userNamePwd);
}

private void enterUsername(String userName) {
	// TODO Auto-generated method stub
	  driver.findElement(By.id("username")).sendKeys(userName);
}

private void goToLoginPAge() {
	// basic step to go to login page if u'r not logged
	  driver.get(baseUrl);
}

@After
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
