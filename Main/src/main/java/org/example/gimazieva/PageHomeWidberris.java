package org.example.gimazieva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHomeWidberris extends BasePage{

    public PageHomeWidberris (WebDriver driver) { ////h2[text()='Выберите размер']
        super(driver);
    }
   private final By addToBusketButton1 = By.xpath("//article[@data-card-index='10']/descendant::a[@href='/lk/basket']");
    private final By addToBusketButton2 = By.xpath("//article[@data-card-index='15']/descendant::a[@href='/lk/basket']");
    private final By addToBusketButton3 = By.xpath("//article[@data-card-index='20']/descendant::a[@href='/lk/basket']");
    private final By tableSizeM = By.xpath("//div[@class='popup__content']//span[text()='M']");
    private final By size = By.xpath("//h2[text()='Выберите размер']");
    private final By product1 = By.xpath("//article[@data-card-index='10']//a");
    private final By product2 = By.xpath("//article[@data-card-index='15']//a");
    private final By product3 = By.xpath("//article[@data-card-index='20']//a");
    private final By basketButton = By.xpath("//span[contains(@class,'icon--basket')]");


    public PageHomeWidberris putInBasket (){
        driver.findElement(addToBusketButton1).click();
        driver.findElement(addToBusketButton2).click();
        driver.findElement(addToBusketButton3).click();
        return this;
    }
    public PageHomeWidberris clickBasket(){
        driver.findElement(basketButton).click();
        return this;

    }
    public PageHomeWidberris getTextNameProduct(){

        driver.findElement(product1).getAttribute("ariaLabel");
        driver.findElement(product2).getAttribute("ariaLabel");;
        driver.findElement(product3).getAttribute("ariaLabel");;
        return this;
    }
}
