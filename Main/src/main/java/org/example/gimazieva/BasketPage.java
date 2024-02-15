package org.example.gimazieva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    private final By productInBasketForPrice1 = By.xpath("(//div[@class='list-item__price-new'])[1]");
    private final By productInBasketForPrice2 = By.xpath("(//div[@class='list-item__price-new'])[2]");
    private final By productInBasketForPrice3 = By.xpath("(//div[@class='list-item__price-new'])[3]");
    private final By productInBasketForName1 = By.xpath("//span[@class='good-info__good-name'][1]");
    private final By productInBasketForName2 = By.xpath("(//span[@class='good-info__good-name'])[2]");
    private final By productInBasketForName3 = By.xpath("(//span[@class='good-info__good-name'])[3]");
    List<By> productInBasketPrice = Arrays.asList(productInBasketForPrice1, productInBasketForPrice2, productInBasketForPrice3);
    List<By> productInBasketName = Arrays.asList(productInBasketForName1, productInBasketForName2, productInBasketForName3);
    List<String> textPriceProductInBasket = new ArrayList<>();
    List<String> pricesInBasket = new ArrayList<>();
    List<String> productNamesInBasket = new ArrayList<>();

    public List<String> getPricesInBasket() {
        return pricesInBasket;
    }

    public List<String> getProductNamesInBasket() {
        return productNamesInBasket;
    }

    public BasketPage getTextPriceBasket() throws InterruptedException { //Забираем  цену товара из корзины
        Thread.sleep(7);
        for (By productInBasket : productInBasketPrice) {
            WebElement productElement = driver.findElement(productInBasket);
            waitElementIsVisible(productElement);
            String textPriceBasket = productElement.getAttribute("innerText").replaceAll("₽", "").replaceAll(" ","").trim();
            pricesInBasket.add(textPriceBasket);
            Collections.sort(pricesInBasket);
        }
//        String regex = "(\\d.*) ₽";
//
//        String nameProduct = "^(.*?),";
//        Pattern patternProduct = Pattern.compile(nameProduct);
//        Pattern pattern = Pattern.compile(regex);
//
//        for (String text : textPriceProductInBasket) {
//            Matcher matcher = pattern.matcher(text);
//            Matcher matcherProduct = patternProduct.matcher(text);
//            if (matcher.find()) {
//                String price = matcher.group(1).replaceAll(" ", ""); // Группа 1 - цена, Группа 3 - название товара
//                String productName = matcherProduct.group(1).trim();
//                pricesInBasket.add(price);
//                productNamesInBasket.add(productName);
//                Collections.sort(pricesInBasket);
//                Collections.sort(productNamesInBasket);
//            }
//        }


        return this;
    }
public BasketPage getTextNameBasket(){ //Забираем название товара из корзины
    for (By productInBasket : productInBasketName) {
        WebElement productElement = driver.findElement(productInBasket);
        waitElementIsVisible(productElement);
        String textNameBasket = productElement.getAttribute("outerText").replaceAll("\\.", "").trim();
        productNamesInBasket.add(textNameBasket);
        Collections.sort(productNamesInBasket);
    }
        return this;
}
    public int getTotalSummInBasket() { //считаем общую сумму в корзины
        int totalSumInBasket = 0;

        for (String price : pricesInBasket) {
            int numericValue = Integer.parseInt(price);
            totalSumInBasket += numericValue;
        }
        return totalSumInBasket;
    }

    public int getTotalCountProductInBasket() {  //считаем общее колличество товаров в корзине
        int totalCountProductsInBasket = pricesInBasket.size();
        return totalCountProductsInBasket;
    }
}


