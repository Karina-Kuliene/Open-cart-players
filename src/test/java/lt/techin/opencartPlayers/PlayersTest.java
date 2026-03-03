package lt.techin.opencartPlayers;

import lt.techin.opencartPlayers.pages.PlayersPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayersTest extends BaseTest{

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/players.csv")
    void testMP3PlayersList(String playerName){
        PlayersPage playersPage = new PlayersPage(driver);
        playersPage.clickMP3PlayersButton();
        playersPage.clickSeeAll();
        playersPage.clickList();
        List<String> playersList = playersPage.getPlayerName();
        assertTrue(playersList.contains(playerName));
        playersPage.clickPlayerName(playerName);



    }

}
