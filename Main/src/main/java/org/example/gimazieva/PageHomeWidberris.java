package org.example.gimazieva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHomeWidberris extends BasePage{

    public PageHomeWidberris (WebDriver driver) { ////h2[text()='Выберите размер']
        super(driver);
    }
   private final By addToBusketButton = By.xpath("//div[@class='main-page__content-wrapper']//a[contains(@class,'product-card__add-basket')]");
    private final By basketButton = By.xpath("//span[contains(@class,'icon--basket')]");

    public PageHomeWidberris putInBasket (){
        driver.findElement(addToBusketButton).click();
        return this;
    }
    public PageHomeWidberris clickBasket(){
        driver.findElement(basketButton).click();
        return this;

    }
}
