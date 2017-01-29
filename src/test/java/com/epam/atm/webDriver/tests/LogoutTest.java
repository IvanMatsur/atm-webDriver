package com.epam.atm.webDriver.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Ivan_Matsur on 1/29/2017.
 */
public class LogoutTest extends PreparationTest {

  @Test(description = "check that draft can be sent", groups = "logout", dependsOnGroups = "login")
  public void logoutTest() {
    login(webDriver);
    webDriver.findElement(By.xpath("//div[@class='mail-User-Name']")).click();
    webDriver.findElement(By.xpath("//div[@class='b-mail-dropdown__item'][last()]/a")).click();
    Assert.assertEquals(webDriver.getCurrentUrl(), PreparationTest.URL);
    webDriver.quit();
  }
}
