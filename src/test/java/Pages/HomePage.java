package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Elements

    By userAvatarIcon = By.cssSelector("img.avatar");
    By logo = By.cssSelector("[class='logo']");
    By frown = By.cssSelector("[class=\"fa fa-frown-o\"]");

    // Helper Methods

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public WebElement getLogo(){
        return findElement(logo);
    }

    public WebElement getFrown(){
        return findElement(frown);
    }
}
