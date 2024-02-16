package org.example.gimazieva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }
    private final By summBasket = By.xpath("//p[contains(@class,'b-top')]//span[@data-link]");
    List<String> pricesInBasket = new ArrayList<>();
    List<String> productNamesInBasket = new ArrayList<>();
    private final By productInBasketForPrice1 = By.xpath("(//div[@class='list-item__price-new'])[1]");
    private final By productInBasketForPrice2 = By.xpath("(//div[@class='list-item__price-new'])[2]");
    private final By productInBasketForPrice3 = By.xpath("(//div[@class='list-item__price-new'])[3]");
    private final By productInBasketForName1 = By.xpath("//span[@class='good-info__good-name'][1]");
    private final By productInBasketForName2 = By.xpath("(//span[@class='good-info__good-name'])[2]");
    private final By productInBasketForName3 = By.xpath("(//span[@class='good-info__good-name'])[3]");
    List<By> productInBasketPrice = Arrays.asList(productInBasketForPrice1, productInBasketForPrice2, productInBasketForPrice3);
    List<By> productInBasketName = Arrays.asList(productInBasketForName1, productInBasketForName2, productInBasketForName3);

    public List<String> getPricesInBasket() {
        return pricesInBasket;
    }

    public List<String> getProductNamesInBasket() {
        return productNamesInBasket;
    }

    public BasketPage getTextPriceBasket() throws InterruptedException { //Забираем  цену товара из корзины
       Thread.sleep(8);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        for (By productInBasket : productInBasketPrice) {
            WebElement productElement = driver.findElement(productInBasket);
            waitElementIsVisible(productElement);
            String textPriceBasket = productElement.getText().replaceAll("₽", "").replaceAll(" ","").trim();
            pricesInBasket.add(textPriceBasket);
            Collections.sort(pricesInBasket);
         }

        return this;
    }
public BasketPage getTextNameBasket(){ //Забираем название товара из корзины
    for (By productInBasket : productInBasketName) {
        WebElement productElement = driver.findElement(productInBasket);
        waitElementIsVisible(productElement);
        String textNameBasket = productElement.getText().trim();
        productNamesInBasket.add(textNameBasket);
        Collections.sort(productNamesInBasket);
    }
        return this;
}
    public String getTotalSummInBasket() { //считаем общую сумму в корзины
        WebElement summ = driver.findElement(summBasket);
        String textSumm = summ.getText().replaceAll("₽", "").replaceAll(" ","").trim();
        return textSumm;
    }


    public int getTotalCountProductInBasket() {  //считаем общее колличество товаров в корзине
        int totalCountProductsInBasket = pricesInBasket.size();
        return totalCountProductsInBasket;
    }
}


