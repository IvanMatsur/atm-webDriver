package com.epam.atm.webDriver.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Ivan_Matsur on 1/29/2017.
 */
public class SendEmailTest extends PreparationTest {

  @Test(description = "check that draft can be sent", groups = "send", dependsOnGroups = "content")
  public void sendDraft() {
    loginAndOpenDraftFolder();
    webDriver.findElement(
      By.xpath("//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']/div[1]")).click();
    webDriver.findElement(By.xpath("//button[contains(@title, '(Ctrl + Enter')]")).click();
    WebElement element = webDriver.findElement(
      By.xpath("//a[@class='mail-Done-Redirect-Link' and @href='#inbox']"));
    Assert.assertTrue(element.isDisplayed());
    webDriver.quit();
  }

  @Test(description = "check that folder of drafts is empty", groups = "send", dependsOnGroups = "content", dependsOnMethods = "sendDraft")
  public void isNoDraft() {
    loginAndOpenDraftFolder();
    WebElement element = webDriver.findElement(
      By.xpath("//a[@class='b-messages__placeholder-item__link' and @href='#inbox']"));
    Assert.assertTrue(element.isDisplayed());
    webDriver.quit();
  }

  @Test(description = "check that email is in Sent folder", groups = "send", dependsOnGroups = "content", dependsOnMethods = "sendDraft")
  public void isMailSent() throws Exception {
    login(webDriver);
    webDriver.findElement(By.xpath("//div[@data-key='view=folders']/a[2]")).click();
    webDriver.findElement(
      By.xpath(
        "//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']/div[1]//span[@class='mail-MessageSnippet-FromText']"));
    WebElement element = webDriver.findElement(
      By.xpath("//div[@data-key='view=folders']/a[2]//span[@class='mail-NestedList-Item-Info-Extras']"));
    Assert.assertEquals(element.getText(), "1");
    webDriver.quit();
  }
}
