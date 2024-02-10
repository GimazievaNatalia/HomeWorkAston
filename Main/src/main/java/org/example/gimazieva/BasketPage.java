package org.example.gimazieva;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{

    public BasketPage(WebDriver driver) {
        super(driver);
    }
    private final By productInBasket = By.xpath("//div[@class='list-item__wrap']");
   public BasketPage checkCountProduct(){ //Посчитали количество товаров в корзине
       int countProduct = driver.findElements(productInBasket).size();
       return this;
   }
}
