package testRunners.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClothingstoreTestSteps {

ChromeDriver driver;
  
  @Given("A user opens magento.softwaretestingboard.com at chrome")
  public void a_user_opens_magento_softwaretestingboard_com_at_chrome() {
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\oshid\\Documents\\RTU\\S2\\Testing and software quality\\Practical task\\1st lab\\chromedriver-win64\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://magento.softwaretestingboard.com/");
      System.out.println(driver.getTitle());
      
  }

  @When("A new customer registers")
  public void a_new_customer_registers() throws InterruptedException {
      WebElement createAcc = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a"));
      createAcc.click();
      Thread.sleep(3000);

      WebElement fName = driver.findElement(By.id("firstname"));
      WebElement lName = driver.findElement(By.id("lastname"));
      WebElement email = driver.findElement(By.id("email_address"));
      WebElement pwd = driver.findElement(By.id("password"));
      WebElement cPwd = driver.findElement(By.id("password-confirmation"));

      fName.sendKeys("udula");
      lName.sendKeys("rathayake");
      email.sendKeys("udularatnayake01@gmail.com");
      pwd.sendKeys("@Qa123tesing");
      cPwd.sendKeys("@Qa123tesing");

      Thread.sleep(3000);
      WebElement subBtn = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
      subBtn.click();
      Thread.sleep(2000);
  }

  @Then("A new customer is registered")
  public void a_new_customer_is_registered() throws InterruptedException {
      WebElement fError = null;
      try {
          fError = driver.findElement(By.id("firstname-error"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (fError != null) {
          System.out.println("Please enter first name!");
      }

      WebElement lError = null;
      try {
          lError = driver.findElement(By.id("lastname-error"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (lError != null) {
          System.out.println("Please enter last name!");
      }

      WebElement eError = null;
      try {
          eError = driver.findElement(By.id("email_address-error"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (eError != null) {
          System.out.println("Please enter email address!");
      }

      WebElement pError = null;
      try {
          pError = driver.findElement(By.id("password-error"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (pError != null) {
          System.out.println("Please enter password!");
      }

      WebElement cpError = null;
      try {
          cpError = driver.findElement(By.id("password-confirmation-error"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (cpError != null) {
          System.out.println("Please enter password confirmation!");
      }

      Thread.sleep(5000);
      WebElement regError = null;
      try {
          regError = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (regError != null) {
          System.out.println("Customer email already exists!");
      }
  }

  @Then("Close Chrome")
  public void close_chrome() {
      driver.quit();
  }

  @When("^A new customer registers with (.*), (.*), (.*), (.*), (.*)$")
  public void a_new_customer_registers_withdata(String firstName, String lastName,String eMail, String password, String rePassword) throws InterruptedException {
      WebElement createAcc = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a"));
      createAcc.click();
      Thread.sleep(3000);

      WebElement fName = driver.findElement(By.id("firstname"));
      WebElement lName = driver.findElement(By.id("lastname"));
      WebElement email = driver.findElement(By.id("email_address"));
      WebElement pwd = driver.findElement(By.id("password"));
      WebElement cPwd = driver.findElement(By.id("password-confirmation"));

      fName.sendKeys(firstName);
      lName.sendKeys(lastName);
      email.sendKeys(eMail);
      pwd.sendKeys(password);
      cPwd.sendKeys(rePassword);

      Thread.sleep(3000);
      WebElement subBtn = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
      subBtn.click();
      Thread.sleep(2000);
  }

  @Then("^A new customer (.*), (.*) is registered$")
  public void a_new_customer_registered(String firstName,String lastName) throws InterruptedException {
      WebElement fError = null;
      try {
          fError = driver.findElement(By.id("firstname-error"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (fError != null) {
          System.out.println("Please enter first name!");
      }

      WebElement lError = null;
      try {
          lError = driver.findElement(By.id("lastname-error"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (lError != null) {
          System.out.println("Please enter last name!");
      }

      WebElement eError = null;
      try {
          eError = driver.findElement(By.id("email_address-error"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (eError != null) {
          System.out.println("Please enter email address!");
      }

      WebElement pError = null;
      try {
          pError = driver.findElement(By.id("password-error"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (pError != null) {
          System.out.println("Please enter password!");
      }

      WebElement cpError = null;
      try {
          cpError = driver.findElement(By.id("password-confirmation-error"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (cpError != null) {
          System.out.println("Please enter password confirmation!");
      }

      Thread.sleep(5000);
      WebElement regError = null;
      try {
          regError = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (regError != null) {
          System.out.println("Customer email already exists!");
      }
  }

  @When("^A registered customer enter (.*), (.*)$")
  public void a_registered_customer_enter_data(String eMail, String password) throws InterruptedException {
      WebElement logAcc = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
      logAcc.click();
      Thread.sleep(3000);
      WebElement loginemail = driver.findElement(By.id("email"));
      WebElement loginpwd = driver.findElement(By.id("pass"));

      loginemail.sendKeys(eMail);
      loginpwd.sendKeys(password);

      WebElement logBtn = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
      logBtn.click();
  }
  @Then("^A registered customer (.*), (.*) is successfully logged$")
  public void a_registered_customer_successfully_logged(String firstName,String lastName) throws InterruptedException {
      

      WebElement eError = null;
      try {
          eError = driver.findElement(By.id("email_address-error"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (eError != null) {
          System.out.println("Please enter email address!");
      }

      WebElement pError = null;
      try {
          pError = driver.findElement(By.id("password-error"));
      } catch (org.openqa.selenium.NoSuchElementException e) {

      }
      if (pError != null) {
          System.out.println("Please enter password!");
      }

      try {
          WebElement loggedNameElem = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[1]/p/text()[1]"));
          String loggedName = String.valueOf(loggedNameElem);
          Assert.assertEquals(firstName+" "+lastName,loggedName);

      }catch (org.openqa.selenium.NoSuchElementException e){

      }
  }

}
