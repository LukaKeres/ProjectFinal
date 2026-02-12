package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasePage extends BasePage {
    private By testCaseText =By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b");
    public TestCasePage(WebDriver driver) {
        super(driver);
    }
    public boolean isTestCaseTextVisible(String text){
        waitForUrl("/test_cases");
        return isVisible(testCaseText) && getText(testCaseText).equals(text);
    }
}
