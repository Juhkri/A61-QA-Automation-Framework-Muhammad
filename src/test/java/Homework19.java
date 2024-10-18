import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        login();
        createPlaylist();
        deleteFirstPlaylist();

    }

}
