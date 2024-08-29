import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
  WebElement driver;

    @Test
  public void playSong() throws InterruptedException {
    playNextSong();
    verifyPlay();
  }

  private void verifyPlay() {
    WebElement buttonPlayPause = driver.findElement(By.cssSelector(#mainFooter > div.side.player-controls > span > span.pause));
    String actualMessage = buttonPlayPause.getText();
    Assert.assertTrue(actualMessage.contains("Pause"));
  }

  private void playNextSong() {
    WebElement skip = driver.findElement(By.cssSelector("[title='Play next song']"));
    skip.click();
  }
}
    
    
    
