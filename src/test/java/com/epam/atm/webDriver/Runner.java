package com.epam.atm.webDriver;

import java.util.ArrayList;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

/**
 * Created by Ivan_Matsur on 1/29/2017.
 */
public class Runner {

  public static void main(String[] args) {
    TestNG testNG = new TestNG();

    final XmlSuite xmlSuite = new XmlSuite();
    xmlSuite.setName("TmpSuite");
    xmlSuite.setSuiteFiles(new ArrayList<String>() {
      {
        add("./src/test/java/com/epam/atm/webDriver/suites/suites.xml");
      }
    });

    testNG.setXmlSuites(new ArrayList<XmlSuite>() {
      {
        add(xmlSuite);
      }
    });

    testNG.run();
  }
}
