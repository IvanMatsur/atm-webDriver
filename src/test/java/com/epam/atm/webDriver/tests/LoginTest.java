package com.epam.atm.webDriver.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Ivan_Matsur on 1/26/2017.
 */
public class LoginTest extends PreparationTest {

  @Test(description = "check that login is successful", groups = "login")
  public void loginToMailBox() {
    PreparationTest.login(webDriver);
    Assert.assertEquals(
      webDriver.findElement(By.xpath("//div[@class='mail-User-Name']")).getText(),
      PreparationTest.EMAIL);
    webDriver.quit();
  }
}
