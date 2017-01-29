package com.epam.atm.webDriver.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Ivan_Matsur on 1/29/2017.
 */
public class EmailContentTest extends PreparationTest {

  @Test(description = "check address of the saved draft", groups = "content", dependsOnGroups = "creation")
  public void checkDraftAddress() {
    loginAndOpenDraftFolder();
    WebElement element = webDriver.findElement(
      By.xpath(
        "//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']/div[1]//span[@class='mail-MessageSnippet-FromText']"));
    Assert.assertTrue(element.getText().startsWith(PreparationTest.MAILTO.substring(0, 4)));
    webDriver.quit();
  }

  @Test(description = "check subject of the saved draft", groups = "content", dependsOnGroups = "creation")
  public void checkDraftSubject() {
    loginAndOpenDraftFolder();
    WebElement element = webDriver.findElement(
        By.xpath(
            "//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']/div[1]//span[starts-with(@title, 'Test')]"));
    Assert.assertEquals(element.getText(), PreparationTest.MAILSUBJECT.substring(0, 4));
    webDriver.quit();
  }

  @Test(description = "check body of the saved draft", groups = "content", dependsOnGroups = "creation")
  public void checkDraftBody() {
    loginAndOpenDraftFolder();
    WebElement element = webDriver.findElement(
        By.xpath(
            "//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']/div[1]//span[starts-with(@title, 'Hello')]"));
    Assert.assertTrue(element.getText().startsWith(PreparationTest.MAILBODY.substring(0, 4)));
    webDriver.quit();
  }
}
