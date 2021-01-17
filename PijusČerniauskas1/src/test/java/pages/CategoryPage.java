package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage {
    WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    //--------------Locators----------------
    By categoryName = By.xpath("//button[@data-filter-value=\"GRIPEX\"]");
    By product = By.cssSelector(".product-thumb");
    By productTitle = By.tagName("h4");
    By addToCart = By.xpath(".//i[contains(@class, 'fa-shopping-cart')]/..");

    //--------------Methods-----------------
    public String getCategoryName() {
        return driver.findElement(categoryName).getText();
    }

    public void addProductToBasket(String productToAdd) {
        for (WebElement product : getAllProducts()) {
            String productName = product.findElement(productTitle).getText();
            if (productName.equals(productToAdd)) {
                product.findElement(addToCart).click();
                break;
            }
        }
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(product);
    }
}