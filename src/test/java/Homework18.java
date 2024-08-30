import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
  public void testSkipSong() {

    login(); // login with valid credentials
    playNextSong(); // won't work unless this is first
    playFirstSong(); // starts the song
    verifyPlay();   //  verify that the song is playing
  }
}
    
    
    
