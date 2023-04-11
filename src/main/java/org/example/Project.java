package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Project
{
   static Scanner sc = new Scanner(System.in);

   public static void main(String[] args) throws Exception {

      System.out.println("Select the appropriate number based on your choice");
      System.out.println("1. opening the browser");
      System.out.println("2. opening the given url");
      System.out.println("3. open the browser if the credentials are correct");
      System.out.println("4. open the url and give responses of the invalid credentials");
      System.out.println("5. Implement all locators");
      System.out.println("6. Implement CSSSelector");
      System.out.println("7. Implement Xpath");
      System.out.println("8. Develop all Html Controls including checkbox, radio, button,  drop downs(single and multiple) separately");
      System.out.println("9. Implement all Alerts(simple alert,confirm,prompt alert)");
      System.out.println("10. Implement window/screenshot after pushing the code into your github account");
      System.out.println("Choose the option of your choice");

      int option = sc.nextInt();
      switch (option)
      {
         case 1:
            openbrowser();
            break;
         case 2:
            openurl();
            break;
         case 3:
            browsercorrectcred();
            break;
         case 4:
            browserincorrectcred();
            break;
         case 5:
            allLocators();
            break;
         case 6:
            implementCSSSelector();
            break;
         case 7:
            implementXpath();
            break;
         case 8:
            allHtml();
            break;

         case 9:
            allAlerts();
            break;

         case 10:
            screenshot();
            break;

         default:
            System.out.println("You didn't enter a number that is within the limit");
            break;
      }











   }

   public static void openbrowser()
   {
      WebDriver driver;
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();

      driver.get("https://www.facebook.com/");
   }

   public static void openurl()
   {
      WebDriver driver;
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();

      String url = sc.nextLine();
      driver.get(url);
   }

   public static void browsercorrectcred()
   {
      WebDriver driver;
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();

      driver.get("https://github.com/login");

      driver.findElement(By.cssSelector("#password")).sendKeys("vasista45@gmail.com");
      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("20Vasi02@12");
      driver.findElement(By.cssSelector("#login > div.auth-form-body.mt-3 > form > div > input.btn.btn-primary.btn-block.js-sign-in-button")).click();
   }

   public static void browserincorrectcred()
   {
      WebDriver driver;
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();

      driver.get("https://github.com/login");

      driver.findElement(By.cssSelector("#password")).sendKeys("vasista45@gmail.com");
      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("20Vasi2@12");
      driver.findElement(By.cssSelector("#login > div.auth-form-body.mt-3 > form > div > input.btn.btn-primary.btn-block.js-sign-in-button")).click();
   }

   public static void allLocators()
   {
      WebDriver driver;
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();

      driver.get("https://www.github.com/login");
      highlight(driver,driver.findElement(By.id("login_field")));
      highlight(driver,driver.findElement(By.name("password")));
      highlight(driver,driver.findElement(By.className("header-logo")));
      highlight(driver,driver.findElement(By.linkText("Forgot password?")));

      highlight(driver,driver.findElement(By.partialLinkText("Create an account")));


   }

   public static void implementCSSSelector()

   {
      WebDriver driver;
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();

      driver.get("https://www.facebook.com/");
      highlight(driver,driver.findElement(By.cssSelector("#content > div > div > div > div._8esl > div > img")));


   }
   public static void implementXpath()

   {
      WebDriver driver;
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();

      driver.get("https://www.facebook.com/");
      highlight(driver,driver.findElement(By.xpath("//*[@id='reg_pages_msg']/a")));


   }

   public static void allHtml()
   {

      System.out.println("Choose which HTML operation you want to test");
      System.out.println("1. CheckBox");
      System.out.println("2. TextBox");
      System.out.println("3. RadioButton");
      System.out.println("4. Dropdown");


      int choice = sc.nextInt();
      switch (choice)
      {
         case 1:
            checkbox();
            break;
         case 2:
            textbox();
            break;
         case 3:
            radiobutton();
            break;
         case 4:
            dropdown();
            break;
         default:
            System.out.println("This is a wrong option that you have chosen");
            break;
      }

   }

   public static void allAlerts() throws Exception {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Select the appropriate number based on your choice");
      System.out.println("1. Simple Alert");
      System.out.println("2. Confirm Alert");
      System.out.println("3. Prompt Alert");
      System.out.println("Please select one number from the above to view to alert message from the browser");

      int select;
      select = scanner.nextInt();

      switch (select)
      {
         case 1:
            simplealert();
            break;

         case 2:
            confirmalert();
            break;
         case 3:
            promptalert();
            break;
         default:
            System.out.println("This is not a case that you must select");
            break;

      }


   }


   public static void screenshot() throws IOException {
      WebDriver driver;
      WebDriverManager.edgedriver().setup();
      driver= new EdgeDriver();
      driver.manage().window().maximize();
      driver.get("");
      driver.findElement(By.id("signupbtn_topnav")).click();
      TakesScreenshot ts=(TakesScreenshot)driver;
      File file=ts.getScreenshotAs(OutputType.FILE);
      try {
         FileUtils.copyFile(file, new File("./Screenshots/Image1.png"));
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }



   public static void highlight(WebDriver driver, WebElement element)
   {
      JavascriptExecutor executor = (JavascriptExecutor) driver;
      executor.executeScript("arguments[0].setAttribute('style', 'background: orange;')", element);
   }


   public static void checkbox()
   {
       WebDriver driver;
       WebDriverManager.edgedriver().setup();
       driver = new EdgeDriver();

      driver.get("https://demoqa.com/automation-practice-form");
      WebElement isdisplayed = driver.findElement(By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label"));
      if(!isdisplayed.isDisplayed())
      {

         isdisplayed.click();
      }

      WebElement isenabled = driver.findElement(By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label"));
      if(!isenabled.isEnabled())
      {
         isenabled.click();
      }

      WebElement isselected = driver.findElement(By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label"));
      if(!isselected.isSelected())
      {
         isselected.click();
      }

   }

   public static void textbox()
   {
       WebDriver driver;
       WebDriverManager.edgedriver().setup();
       driver = new EdgeDriver();
      driver.get("https://demoqa.com/automation-practice-form");

      WebElement username = driver.findElement(By.cssSelector("#userEmail"));
      if (username.isDisplayed())
      {
         if(username.isEnabled())
         {
            username.click();
            username.sendKeys("abcd@gmail.com");
            System.out.println(username.getAttribute("value"));

         }
         else
            System.out.println("The window is not enabled");
      }
      else
         System.out.println("The window is not displayed");
   }


   public static void radiobutton()
   {
          WebDriver driver;
          WebDriverManager.edgedriver().setup();
          driver = new EdgeDriver();

      driver.get("https://demoqa.com/automation-practice-form");

      WebElement isenabled = driver.findElement(By.cssSelector("#gender-radio-1"));

      if(!isenabled.isEnabled())
      {
         isenabled.click();
      }


   }
   public static void dropdown()
   {
        WebDriver driver;
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

      driver.get("https://demoqa.com/automation-practice-form");
      WebElement dropdown = driver.findElement(By.cssSelector("#continents"));

      if(!dropdown.isDisplayed())
      {
         dropdown.click();
      }

      WebElement dropdownenable = driver.findElement(By.cssSelector("#continents"));

      if(!dropdownenable.isEnabled())
      {
         dropdown.click();
      }
      Select select = new Select(driver.findElement(By.id("continents")));

      List<WebElement> list = select.getOptions();
      WebElement dropdownselect = driver.findElement(By.cssSelector("#continents"));

      if(!dropdownselect.isSelected())
      {
         dropdownselect.click();
         select.selectByIndex(3);

      }
   }

   public static  void simplealert()
   {
      WebDriver driver;
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
      driver.manage().window().maximize();


      driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
      driver.findElement(By.id("alertBox")).click();
      System.out.println(driver.switchTo().alert().getText());
      driver.switchTo().alert().accept();
      System.out.println(driver.findElement(By.id("output")).getText());
   }

   public static  void confirmalert() throws Exception
   {
      WebDriver driver;
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
      driver.manage().window().maximize();

      driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

      System.out.println(driver.findElement(By.id("output")).getText());
      Thread.sleep(2000);
      driver.findElement(By.id("confirmBox")).click();
      Thread.sleep(2000);
      System.out.println(driver.switchTo().alert().getText());
      Thread.sleep(2000);
      driver.switchTo().alert().accept();
      Thread.sleep(2000);
      System.out.println(driver.findElement(By.id("output")).getText());
      System.out.println(driver.findElement(By.id("output")).getText());
      Thread.sleep(2000);
      driver.findElement(By.id("confirmBox")).click();
      Thread.sleep(2000);
      System.out.println(driver.switchTo().alert().getText());
      Thread.sleep(2000);
      driver.switchTo().alert().dismiss();
      Thread.sleep(2000);
      System.out.println(driver.findElement(By.id("output")).getText());

   }


   public static void promptalert() throws Exception
   {
      WebDriver driver;
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

      System.out.println(driver.findElement(By.id("output")).getText());
      Thread.sleep(2000);
      driver.findElement(By.id("promptBox")).click();
      Thread.sleep(2000);
      System.out.println(driver.switchTo().alert().getText());
      Thread.sleep(2000);
      driver.switchTo().alert().sendKeys("Sabitha");
      driver.switchTo().alert().accept();
      Thread.sleep(2000);
      System.out.println(driver.findElement(By.id("output")).getText());
      driver.findElement(By.id("promptBox")).click();
      System.out.println(driver.switchTo().alert().getText());
      Thread.sleep(2000);
      driver.switchTo().alert().dismiss();
      Thread.sleep(2000);
      System.out.println(driver.findElement(By.id("output")).getText());
      Thread.sleep(2000);
   }


}