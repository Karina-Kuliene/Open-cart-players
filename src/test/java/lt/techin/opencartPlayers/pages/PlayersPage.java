package lt.techin.opencartPlayers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlayersPage extends BasePage{

    private static final By MP3PLAYERS_BUTTON = By.linkText("MP3 Players");
    private static final By SEE_ALL_BUTTON = By.xpath("//a[normalize-space()='Show All MP3 Players']");
    private static final By LIST_BUTTON = By.cssSelector("#button-list");
    private static final By LIST_ITEM = By.cssSelector("div.description > h4 > a");
//    private static final By IPOD_CLASSIC = By.xpath("//a[normalize-space()='iPod Classic']");
//    private static final By IPOD_NANO = By.xpath("//a[normalize-space()='iPod Nano']");
//    private static final By IPOD_SHUFFLE = By.xpath("//a[normalize-space()='iPod Shuffle']");
//    private static final By IPOD_TOUCH = By.xpath("//a[normalize-space()='iPod Touch']");

    public PlayersPage(WebDriver driver) {
        super(driver);
    }

    public void clickMP3PlayersButton (){
        driver.findElement(MP3PLAYERS_BUTTON).click();
    }

    public void clickSeeAll(){
        driver.findElement(SEE_ALL_BUTTON).click();
    }

    public void clickList(){
        driver.findElement(LIST_BUTTON).click();
    }

    public List<String> getPlayerName(){
        return driver.findElements(LIST_ITEM)
                .stream()
                .map(WebElement::getText)
                .toList();
    }
}
