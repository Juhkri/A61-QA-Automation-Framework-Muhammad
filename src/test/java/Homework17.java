import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends LoginTests {
    private String song;

    public void inputSearch() {
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        searchBar.clear();
        searchBar.sendKeys(this.song);
    }

    public void searchSong(String song) {
        this.song = song;
    }

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        //      Initialize window + driver
        loginEmptyEmailPassword();

        //      Searches the song
        searchSong("dark days");
        inputSearch();

        //      Selects view all
        WebElement viewAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAll.click();

        //      Selects first song
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr:nth-child(1)"));
        firstSong.click();

        //      Selects Add to Playlist
        WebElement addTo = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addTo.click();

        //      Playlist to add the song to
        WebElement selectPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li.playlist"));
        selectPlaylist.click();

        //      Prerequisite for verification
        WebElement successMessage = driver.findElement(By.cssSelector("div.success.show"));
        String actualMessage = successMessage.getText();
        String expectedMessage = "Added 1 song into \"Homework17.\"";

        //      Verify the test succeeded
        Assert.assertEquals(actualMessage, expectedMessage, "Song wasn't added to the specified playlist.");
    }
}