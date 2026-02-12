package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(this.driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    protected void type(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
    protected void replaceText(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(Keys.chord(Keys.CONTROL,"a"),text);
    }
    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
    protected void clear(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
    }
    protected void scrollTo(By locator){
        WebElement it = driver.findElement(locator);
        WheelInput.ScrollOrigin scrollorg=WheelInput.ScrollOrigin.fromElement(it);
        action.scrollFromOrigin(scrollorg,0,60).perform();
    }
    protected Alert switchToAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }
    protected void typeInAlert(String text){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
    }
    protected boolean isVisible(By locator){
        if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed()){
            return true;
        }
        else return false;

    }
    protected void select(By locator, String text){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    protected void clickAt(int x, int y){
        action.moveToLocation(x, y).click().perform();
    }
    protected void waitForUrl(String urlPart) {
        wait.until(ExpectedConditions.urlContains(urlPart));
    }
    protected List<WebElement> findElements(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return driver.findElements(locator);
    }
    protected void closeAdOverlay() {
        try {
            Actions actions = new Actions(driver);
            actions.moveByOffset(10, 10).click().perform();
            Thread.sleep(500);
        } catch (Exception e) {
        }
    }
}
