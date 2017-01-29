package com.epam.atm.webDriver.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Ivan_Matsur on 1/28/2017.
 */
public class PreparationTest {

  protected final static String URL = "https://www.yandex.by/";
  protected final static String USERNAME = "TestJohnSmith";
  protected final static String PASSWORD = "123456Password";
  protected final static String EMAIL = "TestJohnSmith@yandex.ru";
  protected final static String MAILTO = "test@test.by";
  protected final static String MAILSUBJECT = "Test";
  protected final static String MAILBODY = "Hello World!";

  protected WebDriver webDriver;

  @BeforeMethod
  protected void createNewDriverInstance() {
    webDriver = new FirefoxDriver();
  }

  protected static void login(WebDriver webDriver) {
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    webDriver.manage().window().maximize();
    webDriver.get(PreparationTest.URL);
    webDriver.findElement(By.xpath("//input[@name='login']")).sendKeys(PreparationTest.USERNAME);
    webDriver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(PreparationTest.PASSWORD);
    webDriver.findElement(By.xpath("//form[@method='POST']//button[contains(@class, auth__button)]")).click();
  }

  protected void loginAndOpenDraftFolder() {
    PreparationTest.login(this.webDriver);
    webDriver.findElement(By.xpath("//a[@href='#draft']")).click();
  }

  protected void notEmptyFolderIsOpened() {
    webDriver.findElement(
      By.xpath(
        "//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']/div[1]//span[@class='mail-MessageSnippet-FromText']"));
  }
}
