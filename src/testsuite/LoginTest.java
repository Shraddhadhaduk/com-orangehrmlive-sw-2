package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
     String baseUrl = "https://opensource-demo.orangehrmlive.com/";

     @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find the username field and enter valid username
        driver.findElement(By.name("username")).sendKeys("Admin");

        //find the password field and enter password
        driver.findElement(By.name("password")).sendKeys("admin123");

        //find the login button and click on it
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //find out Dashboard and verify text
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();



    }
}
