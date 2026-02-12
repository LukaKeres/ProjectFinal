package UI;

import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginSignUpPage;
import pages.ProductsPage;
import pages.TestCasePage;
import utils.DriverFactory;

public class UiTests extends TestBase {
    public void registerUser(LoginSignUpPage signUpPage){
        signUpPage.clickTitleMale()
                .enterPassword("luka123")
                .chooseDay("2")
                .chooseMonth("July")
                .chooseYear("2005")
                .clickNewsletter()
                .clickSpecialOffer()
                .enterFirstName("Luka")
                .enterLastName("keres")
                .enterCompany("Google")
                .enterAddress("blabla")
                .enterAddress2("blabla")
                .enterCountry("United States")
                .enterState("California")
                .enterCity("Los Angeles")
                .enterZipcode("0000")
                .enterPhone("557345678")
                .closePopUp()
                .createAccount();
    }
    public void signUp(LoginSignUpPage signUpPage,String name, String email){
        signUpPage.SignUpName(name).SignUpEmail(email).submit();
    }
    @Test(priority = 1)
    @Feature("Register")
    @Story("User Register")
    @Description("Verify That User can register successfully")
    public void RegisterUserTest(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        HomePage home = new HomePage(DriverFactory.getDriver());
        Allure.step("Verify that home page is visible successfully");
        Assert.assertTrue(home.HomepageIsVisible());
        Allure.step(" Click on 'Signup / Login' button");
        home.GoToLoginSignUp();
        LoginSignUpPage signUpPage = new LoginSignUpPage(DriverFactory.getDriver());
        Allure.step("Verify 'New User Signup!' is visible");
        Assert.assertTrue(signUpPage.isSignUpTextDisplayed("New User Signup!"));
        Allure.step(" Enter name and email address");
        signUp(signUpPage,"Luka","lukluk@gmail.com");
        Allure.step(" Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        Assert.assertTrue(signUpPage.isAccountInfoEnterDisplayed("ENTER ACCOUNT INFORMATION"));
        Allure.step(" Fill details: Title, Name, Email, Password, Date of birth , First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
        registerUser(signUpPage);
        Allure.step(" Verify that 'ACCOUNT CREATED!' is visible");
        Assert.assertTrue(signUpPage.isAccountCreatedDisplayed("ACCOUNT CREATED!"));
        signUpPage.clickContinue();
        Allure.step(" Verify that 'Logged in as username' is visible");
        Assert.assertTrue(home.loggedInAsIsVisible("Logged in as Luka"));

        //home.deleteAccount();
        //Assert.assertTrue(signUpPage.isAccountDeletedDisplayed());
    }
    @Test(priority = 2)
    @Feature("Login")
    @Story("User Valid Login")
    @Description("Verify That User can Login with correct Email and Password successfully")
    public void LoginUserWithCorrectEmailAndPassword(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        HomePage home = new HomePage(DriverFactory.getDriver());
        Allure.step("Verify that home page is visible successfully");
        Assert.assertTrue(home.HomepageIsVisible());
        Allure.step(" Click on 'Signup / Login' button");
        home.GoToLoginSignUp();
        LoginSignUpPage signUpPage = new LoginSignUpPage(DriverFactory.getDriver());
        Allure.step(" Verify 'Login to your account' is visible");
        Assert.assertTrue(signUpPage.isLoginToYourAccVisible("Login to your account"));
        Allure.step(" Enter correct email address and password");
        signUpPage.enterLoginEmail("lukluk@gmail.com")
                .enterLoginPassword("luka123")
                .clickLoginButton();
        Allure.step("Verify that 'Logged in as username' is visible");
        Assert.assertTrue(home.loggedInAsIsVisible("Logged in as Luka"));
        Allure.step("Click 'Delete Account' button");
        home.deleteAccount();
        Allure.step(" Verify that 'ACCOUNT DELETED!' is visible");
        Assert.assertTrue(signUpPage.isAccountDeletedDisplayed("ACCOUNT DELETED!"));




    }
    @Test
    @Feature("Login")
    @Story("User Login")
    @Description("Verify That User cannot Login with wrong Email and Password")
    public void LoginUserWithIncorrectEmailAndPassword(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        HomePage home = new HomePage(DriverFactory.getDriver());
        Allure.step("Verify that home page is visible successfully");
        Assert.assertTrue(home.HomepageIsVisible());
        Allure.step(" Click on 'Signup / Login' button");
        home.GoToLoginSignUp();
        LoginSignUpPage signUpPage = new LoginSignUpPage(DriverFactory.getDriver());
        Allure.step(" Verify 'Login to your account' is visible");
        Assert.assertTrue(signUpPage.isLoginToYourAccVisible("Login to your account"));
        Allure.step(" Enter correct email address and password");
        signUpPage.enterLoginEmail("lukluk1@gmail.com")
                .enterLoginPassword("luka1234")
                .clickLoginButton();
        Allure.step("Verify error 'Your email or password is incorrect!' is visible");
        Assert.assertTrue(signUpPage.isIncorrectPasswordVisible("Your email or password is incorrect!"));
    }
    @Test
    @Feature("Login")
    @Story("User Logout")
    @Description("Verify That User can Login and Logout successfully")
    public void LogoutUser(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        HomePage home = new HomePage(DriverFactory.getDriver());
        Allure.step("Verify that home page is visible successfully");
        Assert.assertTrue(home.HomepageIsVisible());
        Allure.step(" Click on 'Signup / Login' button");
        home.GoToLoginSignUp();
        LoginSignUpPage signUpPage = new LoginSignUpPage(DriverFactory.getDriver());
        Allure.step(" Verify 'Login to your account' is visible");
        Assert.assertTrue(signUpPage.isLoginToYourAccVisible("Login to your account"));
        Allure.step(" Enter correct email address and password");
        signUpPage.enterLoginEmail("lukaka@gmail.com")
                .enterLoginPassword("@daburakaraba123")
                .clickLoginButton();
        Allure.step("Verify that 'Logged in as username' is visible");
        Assert.assertTrue(home.loggedInAsIsVisible("Logged in as luka"));
        Allure.step("Click 'Logout' button");
        home.logOut();
        Allure.step("Verify that user is navigated to login page");
        Assert.assertTrue(signUpPage.isLoginToYourAccVisible("Login to your account"));

    }
    @Test
    @Feature("Register")
    @Story("User Register")
    @Description("Verify That User cannot register with existing email")
    public void RegisterUserWithExistingEmail(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        HomePage home = new HomePage(DriverFactory.getDriver());
        Allure.step("Verify that home page is visible successfully");
        Assert.assertTrue(home.HomepageIsVisible());
        Allure.step("Click on 'Signup / Login' button");
        home.GoToLoginSignUp();
        LoginSignUpPage signUpPage = new LoginSignUpPage(DriverFactory.getDriver());
        Allure.step("Verify 'New User Signup!' is visible");
        Assert.assertTrue(signUpPage.isSignUpTextDisplayed("New User Signup!"));
        Allure.step(" Enter name and already registered email address");
        signUp(signUpPage,"Luka","lukaka@gmail.com");
        Allure.step(" Verify error 'Email Address already exist!' is visible");
        Assert.assertTrue(signUpPage.isEmailExistsVisible("Email Address already exist!"));

    }
    @Test
    @Feature("Pages")
    @Story("Page verification")
    @Description("Verify That Test-cases page can be accessed successfully")
    public void VerifyTestPage() {
        DriverFactory.getDriver().get("https://automationexercise.com/");
        HomePage home = new HomePage(DriverFactory.getDriver());
        Allure.step("Verify that home page is visible successfully");
        Assert.assertTrue(home.HomepageIsVisible());
        Allure.step("Click on 'Test Cases' button");
        home.GoToTestCase();
        TestCasePage testCasePage = new TestCasePage(DriverFactory.getDriver());
        Allure.step("Verify user is navigated to test cases page successfully");
        Assert.assertTrue(testCasePage.isTestCaseTextVisible("TEST CASES"));
    }
    @Test
    @Feature("Pagess")
    @Story("Page verification")
    @Description("Verify That User can access products page and view products successfully")
    public void verifyProductsPage(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        HomePage home = new HomePage(DriverFactory.getDriver());
        Allure.step("Verify that home page is visible successfully");
        Assert.assertTrue(home.HomepageIsVisible());
        Allure.step("Click on 'Products' button");
        home.GoToProducts();
        ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());
        Allure.step("Verify user is navigated to ALL PRODUCTS page successfully");
        Assert.assertTrue(productsPage.isAllProductsTextVisible("ALL PRODUCTS"));
        Allure.step("Click on 'View Product' of first product");
        productsPage.viewProduct("1");
        Allure.step("Verify that detail detail is visible: product name, category, price, availability, condition, brand");
        Assert.assertTrue(productsPage.isProductNameTextVisible());
        Assert.assertTrue(productsPage.isProductCategoyTextVisible());
        Assert.assertTrue(productsPage.isProductPriceTextVisible());
        Assert.assertTrue(productsPage.isProductAvailabilityTextVisible());
        Assert.assertTrue(productsPage.isProductConditionTextVisible());
        Assert.assertTrue(productsPage.isProductBrandTextVisible());
    }
    @Test
    @Feature("Pages")
    @Story("Page utility verification")
    @Description("Verify That User can search for product successfully")
    public void searchProduct(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        HomePage home = new HomePage(DriverFactory.getDriver());
        Allure.step("Verify that home page is visible successfully");
        Assert.assertTrue(home.HomepageIsVisible());
        Allure.step("Click on 'Products' button");
        home.GoToProducts();
        ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());
        Allure.step("Verify user is navigated to ALL PRODUCTS page successfully");
        Assert.assertTrue(productsPage.isAllProductsTextVisible("ALL PRODUCTS"));
        Allure.step("Enter product name in search input and click search button");
        productsPage.searchProduct("Tshirt");
        Allure.step(" Verify 'SEARCHED PRODUCTS' is visible");
        Assert.assertTrue(productsPage.isAllProductsTextVisible("SEARCHED PRODUCTS"));
        Allure.step(" Verify all the products related to search are visible");
        Assert.assertTrue(productsPage.allProductsContainSearchTerm("Tshirt"));

    }
    @Test
    @Feature("Pages")
    @Story("Page utility verification")
    @Description("Verify That User can subscribe successfully")
    public void verifySubscription(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        HomePage home = new HomePage(DriverFactory.getDriver());
        Allure.step("Verify that home page is visible successfully");
        Assert.assertTrue(home.HomepageIsVisible());
        Allure.step("Scroll down to footer");
        home.scrollToFooter();
        Allure.step("Verify text 'SUBSCRIPTION'");
        Assert.assertTrue(home.verifySubscriptionText("SUBSCRIPTION"));
        Allure.step("Enter email address in input and click arrow button");
        home.enterSubscriptionEmail("luka@gmail.com");
        Allure.step("Verify success message 'You have been successfully subscribed!' is visible");
        Assert.assertTrue(home.verifySubscriptionSuccess("You have been successfully subscribed!"));
    }

    @Test
    @Feature("Pages")
    @Story("Page utility verification")
    @Description("Verify That Scroll arrow works as intended")
    public void verifyScrollUpArrow(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        HomePage home = new HomePage(DriverFactory.getDriver());
        Allure.step("Verify that home page is visible successfully");
        Assert.assertTrue(home.HomepageIsVisible());
        Allure.step("Scroll down to footer");
        home.scrollToFooter();
        Allure.step("Verify 'SUBSCRIPTION' is visible");
        Assert.assertTrue(home.verifySubscriptionText("SUBSCRIPTION"));
        Allure.step("Click on arrow at bottom right side to move upward");
        home.scrollUpByArrow();
        Allure.step("Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        Assert.assertTrue(home.homepageTextIsVisible("Full-Fledged practice website for Automation Engineers"));
    }



}
