import Pages.HomePage;
import Pages.LoginPage;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class Sprint2_Favorites extends BaseTest {

    @Test
    public void favoritesNoSongsTest() {
        HomePage homePage = new HomePage(driver);

        login();
        homePage.getFavorites().click();
        Assert.assertTrue(homePage.getFrown().isDisplayed()); // image only appears if there are no songs in the playlist
    }

    @Test
    public void favoritesAddRemoveFavoriteTest() {
        HomePage homePage = new HomePage(driver);

        login();
        homePage.gotoHomePage(); // exits playlist screen (this is necessary because of a website bug)
        homePage.inputSearch("dark days"); // searches a song
        homePage.viewAllButton(); // enters list view
        WebElement exampleSongFavorite = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[6]/button/i"));
        exampleSongFavorite.click(); // favorites a song
        homePage.getFavorites().click(); // navigates to favorites
        Assert.assertTrue(homePage.getDownloadAll().isDisplayed()); // this only appears if a song is in favorites
        WebElement exampleSongUnFavorite = driver.findElement(By.xpath("/html/body/div/div/div[1]/section[1]/section[7]/div/div/div[1]/table/tr/td[6]/button/i"));
        exampleSongUnFavorite.click(); // reset test conditions and tests un-favorite function
        Assert.assertTrue(homePage.getFrown().isDisplayed()); // this only appears if there are no songs in the playlist


    }

}