package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{
    private By allProducts = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    private By searchedProducts = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");

    private By viewProductLink;
    private By productName = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");
    private By productCategoy =By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]");
    private By productPrice =By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span");
    private By productAvailability=By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b");
    private By productCondition=By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b");
    private By productBrand=By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b");

    private By searchProduct=By.id("search_product");
    private By submitSearchProduct=By.id("submit_search");

    private By productNames = By.xpath("//div[@class='productinfo text-center']/p");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public boolean isAllProductsTextVisible(String text){
        closeAdOverlay();
        waitForUrl("/products");
        return isVisible(allProducts) && getText(allProducts).equals(text);
    }
    public ProductsPage viewProduct(String productNum) {
        closeAdOverlay();
        viewProductLink = By.xpath("//a[@href='/product_details/" + productNum + "']");
        scrollTo(viewProductLink);
        click(viewProductLink);
        return this;
    }
    public boolean isProductNameTextVisible() {
        return isVisible(productName);
    }
    public boolean isProductCategoyTextVisible() {
        return isVisible(productCategoy);
    }
    public boolean isProductPriceTextVisible() {
        return isVisible(productPrice);
    }
    public boolean isProductAvailabilityTextVisible() {
        return isVisible(productAvailability);
    }
    public boolean isProductConditionTextVisible() {
        return isVisible(productCondition);
    }
    public boolean isProductBrandTextVisible() {
        return isVisible(productBrand);
    }

    public ProductsPage searchProduct(String productName) {
        type(searchProduct, productName);
        click(submitSearchProduct);
        return this;
    }
    public boolean allProductsContainSearchTerm(String searchTerm) {
        List<WebElement> products = findElements(productNames);
        if(products.isEmpty()) {
            return false;
        }
        for(WebElement product : products) {
            String productName = product.getText().toLowerCase().replaceAll("[^a-z]","");
            if(!productName.contains(searchTerm.toLowerCase().replaceAll("[^a-z]",""))) {
                return false;
            }
        }
        return true;
    }


}
