package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By products = By.xpath("//a[@href='/products']");
    private By login = By.xpath("//a[@href='/login']");
    private By testCases=By.xpath("//a[@href='/test_cases']");
    private By HomepageImg = By.xpath("//*[@id=\"slider-carousel\"]");
    private By HomepageText =By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h2");
    private By loggedInAs = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
    private By deleteAccount =By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    private By logout =By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private By footer =By.id("footer");
    private By subscriptionText=By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
    private By subscriptionEmail=By.id("susbscribe_email");
    private By subscribeButton=By.id("subscribe");
    private By succesfulSubscription=By.xpath("//*[@id=\"success-subscribe\"]/div");

    private By scrollUpArrow=By.id("scrollUp");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HomePage GoToProducts(){
        click(products);
        return this;
        //return new ProductsPage(driver);
    }
    public LoginSignUpPage GoToLoginSignUp(){
        click(login);
        return new LoginSignUpPage(driver);
    }
    public TestCasePage GoToTestCase(){
        click(testCases);
        return new TestCasePage(driver);
    }
    public boolean HomepageIsVisible(){
        closeAdOverlay();
        return isVisible(HomepageImg);
    }
    public boolean loggedInAsIsVisible(String text){

        return isVisible(loggedInAs) && getText(loggedInAs).equals(text);
    }
    public HomePage deleteAccount(){
        click(deleteAccount);
        return this;
    }
    public HomePage logOut(){
        click(logout);
        return this;
    }
    public HomePage scrollToFooter(){
        scrollTo(footer);
        return this;
    }
    public boolean verifySubscriptionText(String text){
        return isVisible(subscriptionText) && getText(subscriptionText).equals(text);
    }
    public HomePage enterSubscriptionEmail(String email){
        type(subscriptionEmail,email);
        click(subscribeButton);
        return this;
    }
    public boolean verifySubscriptionSuccess(String text){
        return isVisible(succesfulSubscription) && getText(succesfulSubscription).equals(text);
    }
    public HomePage scrollUpByArrow(){
        click(scrollUpArrow);
        return this;
    }
    public boolean homepageTextIsVisible(String text){
        return isVisible(HomepageText) &&  getText(HomepageText).equals(text);
    }

}
