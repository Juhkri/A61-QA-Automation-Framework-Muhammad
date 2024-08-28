public class Homework18 extends BaseTest {

  public void playNextSong {
    WebElement skip = driver.findElement(By.cssSelector("[title='Play next song']"));
    skip.click();
  }
    
  public void verifyPlay {
    WebElement buttonPlayPause = driver.findElement(By.xpath([@id="mainFooter"]/div[1]/span/span[2]);
    String actualMessage = buttonPlayPause.getText();
    Assert.assertTrue(actualMessage.contains("Pause"));
  }

    @Test
  public void playSong() throws InterruptedException {
    playNextSong();
    verifyPlay();
  }
}
    
    
    
