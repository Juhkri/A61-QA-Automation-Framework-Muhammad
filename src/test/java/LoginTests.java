import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPassword() {
    setEmailPassword("", "");
    inputEmail();
    inputPassword();
    loginButton();
    Assert.assertEquals(driver.getCurrentUrl(),"https://qa.koel.app/");
}

    // Login Test using POM

    @Test
    public void positiveLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("kristofer.juhasz@testpro.io");
        loginPage.providePassword("Logintest1!");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

//    @AfterTest
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
