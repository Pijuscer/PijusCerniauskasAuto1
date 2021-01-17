package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {
    WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    //----------Locators---------------------
    By loginLink = By.xpath("//div[contains(@class, 'loggin-hdr fal fa-user first last')]");
    By messageBlock = By.cssSelector("Norėdami tęsti, privalote sutikti su taisyklėmis ir privatumo politika.");
    By searchTo = By.name("Nereceptiniai vaistai");
    By allDisplayedProduct = By.id("#cart-block");
    By clickTheCart = By.id("#cart-block");
    By productNameInCart = By.cssSelector(".cart-rows .cart-item");


    //----------Methods----------------------
    public void openLoginPage() {
        driver.findElement(loginLink).click();
    }

    public void clickOnTheCart() {
        driver.findElement(clickTheCart).click();
    }

    public void checkThatAllDisplayedProducts() {
        driver.findElement(allDisplayedProduct).click();
    }

    public String getProductNameInCart() {
        return driver.findElement(productNameInCart).getText();
    }

    public String getMessageText() {
        return driver.findElement(messageBlock).getText();
    }

    public void searchToEnter() {
        driver.findElement(searchTo).sendKeys();
    }


}
