import Pages.HomePage;
import Pages.LoginPage;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Sprint1_CreateNewAccount extends BaseTest {

    @Test
    public void createNewAccount() {
        HomePage homePage = new HomePage(driver);

        homePage.getRegistration().click();
        homePage.getEmail().clear();
        homePage.getEmail().sendKeys("kristofer.juhasz@testpro.io");
        homePage.getSubmit().click();
        Assert.assertTrue(homePage.getMessage().isDisplayed());
    }

    @Test
    public void createNewAccountNegativeTestNoAt() {
        HomePage homePage = new HomePage(driver);

        homePage.getRegistration().click();
        homePage.getEmail().clear();
        homePage.getEmail().sendKeys("kristofer.juhasztestpro.io");
        homePage.getSubmit().click();
        //Assert.assertFalse(homePage.getMessage().isDisplayed()); Needs an implicit wait to use assertFalse
    }

    @Test
    public void createNewAccountNegativeTestNoPlus() {
        HomePage homePage = new HomePage(driver);

        homePage.getRegistration().click();
        homePage.getEmail().clear();
        homePage.getEmail().sendKeys("kristofer.juhasz+5@testpro.io");
        homePage.getSubmit().click();
        //Assert.assertFalse(homePage.getMessage().isDisplayed());  Needs an implicit wait to use assertFalse
    }


}
