import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        login();
        createPlaylist();
        deleteFirstPlaylist();
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
