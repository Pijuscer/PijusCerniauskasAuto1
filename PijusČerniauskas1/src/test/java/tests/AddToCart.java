package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.CommonPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AddToCart extends BaseTest {
    WebDriverWait wait;

    @Test(dataProvider = "products")
    public void addToCart(String productToAdd) {
        String categoryToOpen = "GRIPEX";
        CommonPage commonPage = new CommonPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        //Į paiešką įvesti „Nereceptiniai vaistai“
        commonPage.searchToEnter();

        //Patikrinti ar gera kategorija atidaryta
        assertEquals(categoryPage.getCategoryName(), categoryToOpen, "Wrong category opened");

        //Patikrinti, jog visi atvaizduojami produktai turi „GRIPEX“ žodį pavadinime (assert)
        commonPage.checkThatAllDisplayedProducts();
        assertEquals(commonPage.getProductNameInCart(), productToAdd, "Wrong product has been added to cart");

        //Įdėti gerą produktą į krepšelį
        categoryPage.addProductToBasket(productToAdd);

        //Paspausti ant krepšelio
        commonPage.clickOnTheCart();

    }

    @DataProvider(name = "products")
    public Object[][] products() {
        return new Object[][]{
                {"Gripex, plėvele dengtos tabletės, N12"},
                {"Gripex, plėvele dengtos tabletės, N24"}
        };
    }
}
