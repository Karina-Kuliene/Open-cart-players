package lt.techin.opencartPlayers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PlayersPage extends BasePage {

    private static final By MP3PLAYERS_BUTTON = By.linkText("MP3 Players");
    private static final By SEE_ALL_BUTTON = By.xpath("//a[normalize-space()='Show All MP3 Players']");
    private static final By LIST_BUTTON = By.cssSelector("#button-list");
    private static final By LIST_ITEM = By.cssSelector("div.description > h4 > a");
    private static final By QUANTITY_INPUT = By.cssSelector("#input-quantity");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector("#button-cart");
    private static final By ALERT_MESSAGE = By.cssSelector("#button-cart div");

    public PlayersPage(WebDriver driver) {
        super(driver);
    }

    public void clickMP3PlayersButton() {
        driver.findElement(MP3PLAYERS_BUTTON).click();
    }

    public void clickSeeAll() {
        driver.findElement(SEE_ALL_BUTTON).click();
    }

    public void clickList() {
        driver.findElement(LIST_BUTTON).click();
    }

    public List<String> getPlayerName() {
        return driver.findElements(LIST_ITEM)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public void clickPlayerName(String playerName) {
        Actions actions = new Actions(driver);
        List<WebElement> players = driver.findElements(LIST_ITEM);
        for (WebElement player : players) {
            if (player.getText().equalsIgnoreCase(playerName)) {
                actions.scrollToElement(player).build().perform();
                player.click();
                break;
            }
        }
    }

    public void typeQuantity(String quantity){
        driver.findElement(QUANTITY_INPUT).clear();
        driver.findElement(QUANTITY_INPUT).sendKeys(quantity);
    }

    public void clickAddToCart(){
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public String getAlertMessageText(){

        return driver.findElement(ALERT_MESSAGE).getText();
    }
}
