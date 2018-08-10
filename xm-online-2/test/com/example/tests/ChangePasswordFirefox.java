package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import net.sourceforge.htmlunit.corejs.javascript.ast.ThrowStatement;

public class ChangePasswordFirefox {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "resource/geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://compass.test.xm-online.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  
  
  private boolean isLogoutBtnIsPresent() {
	// TODO Auto-generated method stub
	  driver.findElement(By.id("logout")).getText().equals("Sign Out");
	return true;
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
	// basic step to go to login page if u'r not loged
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
