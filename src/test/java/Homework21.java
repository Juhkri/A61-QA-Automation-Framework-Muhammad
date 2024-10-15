import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist() throws InterruptedException {
        login();
        createPlaylist();
        renameFirstPlaylist();
        deleteFirstPlaylist();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
