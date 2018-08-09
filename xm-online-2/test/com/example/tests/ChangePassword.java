package com.example.tests;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChangePassword {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://compass.test.xm-online.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void forgetYourPass() throws Exception{
	  goToLoginPAge();
	  selectFYP();
	  enterEmail("test@test.com");
	  resetPwd();
  }

  private void resetPwd() {
	// TODO Auto-generated method stub
	driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
}

private void enterEmail(String resetEmail) {
	// TODO Auto-generated method stub
	driver.findElement(By.id("email")).sendKeys(resetEmail);
}

private void selectFYP() {
	// TODO Auto-generated method stub
	driver.findElement(By.className("forgot-link")).click();
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
}
