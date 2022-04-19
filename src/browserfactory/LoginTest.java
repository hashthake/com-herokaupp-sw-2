package browserfactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Find Username field and send username as requirement
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        //Find Password field and send password as requirement
        WebElement passowrd = driver.findElement(By.name("password"));
        passowrd.sendKeys("SuperSecretPassword!");
        //Find login link and click on login link
        WebElement loginId = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginId.click();
        //This is from requrement verify text"Secure Area"
        String expectedMessage = "Secure Area";
        //Find webelements for message
        WebElement actualMessageElement = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
        String actualMessage = actualMessageElement.getText();
        //Validate expcted and actual message
        Assert.assertEquals("Secure Area",expectedMessage,actualMessage);
    }


    @Test
    public void verifyTheUsernameErrorMessage(){
        //Find Username field and send username as requirement
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith1");
        //Find Password field and send password as requirement
        WebElement passowrd = driver.findElement(By.name("password"));
        passowrd.sendKeys("SuperSecretPassword!");
        //Find login link and click on login link
        WebElement loginId = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginId.click();
        // This is from requirement
        String expectedMessage = "Your username is invalid!";

        WebElement actualMessageElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualMessageElement.getText();
        //validate expected and actual message
        Assert.assertEquals("Your username is invalid!",expectedMessage,actualMessage);
    }
  @Test
    public void verifyPasswordErrorMessage(){
      //Find Username field and send username as requirement
      WebElement userName = driver.findElement(By.id("username"));
      userName.sendKeys("tomsmith");
      //Find Password field and send password as requirement
      WebElement passowrd = driver.findElement(By.name("password"));
      passowrd.sendKeys("SuperSecretPassword");
      //Find login link and click on login link
      WebElement loginId = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
      loginId.click();
      // This is from requirement
      String expectedMessage = "Your password is invalid!";

      WebElement actualMessageElement = driver.findElement(By.xpath("//div[@id='flash']"));
      String actualMessage = actualMessageElement.getText();
      Assert.assertEquals("Your password is invalid!",expectedMessage,actualMessage);

  }
  @After
    public void tearDown(){
        closeBrowser();
  }

}
