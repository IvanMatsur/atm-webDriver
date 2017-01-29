package com.epam.atm.webDriver.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Ivan_Matsur on 1/29/2017.
 */
public class EmailCreationTest extends PreparationTest {

  @Test(description = "check that new email can be created and saved", groups = "creation", dependsOnGroups = "login")
  public void createNewEmail() {
    PreparationTest.login(webDriver);
    webDriver.findElement(
      By.xpath("//a[contains(@class, 'ns-view-toolbar-button-compose-go') and 1]")).click();
    webDriver.findElement(
      By.xpath(
        "//div[@data-key='view=compose-field-to']//div[@class='mail-Compose-Field-Input']/div")).sendKeys(
          PreparationTest.MAILTO);
    webDriver.findElement(By.xpath("//label[@data-key='view=compose-field-subject']//input")).sendKeys(
      PreparationTest.MAILSUBJECT);
    WebElement textArea = webDriver.findElement(By.xpath("//div[@role='textbox']"));
    textArea.sendKeys(PreparationTest.MAILBODY);
    Assert.assertEquals(textArea.getText(), PreparationTest.MAILBODY);
    webDriver.findElement(By.xpath("//a[@href='#draft']")).click();
    webDriver.findElement(By.xpath("//button[@data-action='save']")).click();
    WebElement draftNumber = webDriver.findElement(
      By.xpath("//div[@data-key='view=folders']/a[5]//span[@class='mail-NestedList-Item-Info-Extras']"));
    Assert.assertEquals(draftNumber.getText(), "1");
    webDriver.quit();
  }
}
