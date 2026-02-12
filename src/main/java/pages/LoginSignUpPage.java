package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignUpPage extends BasePage{
    private By signUpName = By.name("name");
    private By signUpEmail =By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    private By Submit =By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
    private By signUpText = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");

    private By loginEmail = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    private By loginPass = By.name("password");
    private By loginButton = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    private By loginText = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2");

    private By enterAccText = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2");

    private By TitleMale =By.id("id_gender1");
    private By TitleFemale =By.id("id_gender2");
    private By password = By.id("password");
    private By selectDay = By.id("days");
    private By selectMonth = By.id("months");
    private By selectYear = By.id("years");
    private By newsletter  = By.id("newsletter");
    private By specialOffer = By.id("optin");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By company =  By.id("company");
    private By address =  By.id("address1");
    private By address2 = By.id("address2");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By phone = By.id("mobile_number");
    private By createAccount = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button");
    private By incorrectPass =By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");
    private By emailAlreadyExists = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");

    private By accCreated =By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    private By continueButton =By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    private By accDeleted = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");


    public LoginSignUpPage(WebDriver driver) {
        super(driver);
    }
    public LoginSignUpPage SignUpName(String name){
        type(signUpName, name);
        return this;
    }
    public LoginSignUpPage SignUpEmail(String email){
        type(signUpEmail, email);
        return this;
    }
    public LoginSignUpPage submit(){
        click(Submit);
        return this;
    }
    public boolean isSignUpTextDisplayed(String text){
        waitForUrl("/login");
        return isVisible(signUpText) && getText(signUpText).equals(text);
    }
    public boolean isAccountInfoEnterDisplayed(String text){
        waitForUrl("/signup");
        return isVisible(enterAccText) && getText(enterAccText).equals(text);
    }
    public LoginSignUpPage clickTitleMale(){
        click(TitleMale);
        return this;
    }
    public LoginSignUpPage clickTitleFemale(){
        click(TitleFemale);
        return this;
    }
    public LoginSignUpPage enterPassword(String pass){
        type(password,pass);
        return this;
    }
    public LoginSignUpPage chooseDay(String day){
        scrollTo(selectDay);
        select(selectDay, day);
        return this;
    }
    public LoginSignUpPage chooseMonth(String month){
        scrollTo(selectMonth);
        select(selectMonth, month);
        return this;
    }
    public LoginSignUpPage chooseYear(String year){
        scrollTo(selectYear);
        select(selectYear, year);
        return this;
    }
    public LoginSignUpPage clickNewsletter(){
        scrollTo(newsletter);
        click(newsletter);
        return this;
    }
    public LoginSignUpPage clickSpecialOffer(){
        scrollTo(specialOffer);
        click(specialOffer);
        return this;
    }
    public LoginSignUpPage enterFirstName(String name){
        scrollTo(firstName);
        type(firstName, name);
        return this;
    }
    public LoginSignUpPage enterLastName(String lname){
        scrollTo(lastName);
        type(lastName, lname);
        return this;
    }
    public LoginSignUpPage enterCompany(String comp){
        scrollTo(company);
        type(company, comp);
        return this;
    }
    public LoginSignUpPage enterAddress(String addr){
        scrollTo(address);
        type(address, addr);
        return this;
    }
    public LoginSignUpPage enterAddress2(String addr2){
        scrollTo(address2);
        type(address2, addr2);
        return this;
    }
    public LoginSignUpPage enterCountry(String cntr){
        scrollTo(country);
        select(country, cntr);
        return this;
    }
    public LoginSignUpPage enterState(String st){
        scrollTo(state);
        type(state, st);
        return this;
    }
    public LoginSignUpPage enterCity(String ct){
        scrollTo(city);
        type(city, ct);
        return this;
    }
    public LoginSignUpPage enterZipcode(String zip){
        scrollTo(zipcode);
        type(zipcode, zip);
        return this;
    }
    public LoginSignUpPage enterPhone(String ph){
        scrollTo(phone);
        type(phone, ph);
        return this;
    }
    public LoginSignUpPage createAccount(){
        scrollTo(createAccount);
        click(createAccount);
        return this;
    }
    public boolean isAccountCreatedDisplayed(String text){
        waitForUrl("/account_created");
        return isVisible(accCreated) && getText(accCreated).equals(text);
    }
    public  LoginSignUpPage clickContinue(){
        click(continueButton);
        return this;
    }
    public boolean isAccountDeletedDisplayed(String text){
        waitForUrl("/delete_account");
        return isVisible(accDeleted) && getText(accDeleted).equals(text);
    }
    public LoginSignUpPage closePopUp(){
        clickAt(758,555);
        return this;
    }
    public boolean isLoginToYourAccVisible(String text){
        waitForUrl("/login");
        return isVisible(loginText) && getText(loginText).equals(text);
    }
    public LoginSignUpPage enterLoginEmail(String email){
        type(loginEmail, email);
        return this;
    }
    public LoginSignUpPage enterLoginPassword(String pass){
        type(loginPass, pass);
        return this;
    }
    public LoginSignUpPage clickLoginButton(){
        click(loginButton);
        closeAdOverlay();
        return this;
    }
    public boolean isIncorrectPasswordVisible(String text){
        waitForUrl("/login");
        return isVisible(incorrectPass) && getText(incorrectPass).equals(text);
    }
    public boolean isEmailExistsVisible(String text){
        waitForUrl("/signup");
        return isVisible(emailAlreadyExists) && getText(emailAlreadyExists).equals(text);
    }


}
