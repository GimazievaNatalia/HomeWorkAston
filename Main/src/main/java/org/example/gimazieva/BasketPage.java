package org.example.gimazieva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private final By productInBasket1 = By.xpath("(//div[@class='list-item__wrap'])[1]");
     private final By productInBasket2 = By.xpath("(//div[@class='list-item__wrap'])[2]");
    private final By productInBasket3 = By.xpath("(//div[@class='list-item__wrap'])[3]");
    List<By> productInBasketAll = Arrays.asList(productInBasket1, productInBasket2, productInBasket3);
    List<String> textproductInBasket = new ArrayList<>();
    List<String> pricesInBasket = new ArrayList<>();
    List<String> productNamesInBasket = new ArrayList<>();

    public List<String> getPricesInBasket() {
        return pricesInBasket;
    }

    public List<String> getProductNamesInBasket() {
        return productNamesInBasket;
    }

    public BasketPage getTextNamePriceBasket() {

        for (By productInBasket : productInBasketAll) {
            WebElement productElement = driver.findElement(productInBasket);
            waitElementIsVisible(productElement);
            String textBasket = productElement.getAttribute("outerText");
            textproductInBasket.add(textBasket);
        }
        String regex ="(\\d.*) ₽";
        String nameProduct = "\\s(.*)\\n\\n";
        Pattern patternProduct = Pattern.compile(nameProduct);
        Pattern pattern = Pattern.compile(regex);

       for (String text : textproductInBasket) {
           Matcher matcher = pattern.matcher(text);
           Matcher matcherProduct = patternProduct.matcher(text);
           if (matcher.find() && matcherProduct.find()) {
               String price= matcher.group(1).replaceAll("\\s", ""); // Группа 1 - цена, Группа 3 - название товара
               String productName = matcherProduct.group(1).trim();
               pricesInBasket.add(price);
               productNamesInBasket.add(productName);
               Collections.sort(pricesInBasket);
               Collections.sort(productNamesInBasket);
           }
       }
       return this;
    }
    public BasketPage getTotalSummInBasket() { //считаем общую сумму в корзины
        int totalSumInBasket = 0;

        for (String price : pricesInBasket) {
            int numericValue = Integer.parseInt(price);
            totalSumInBasket += numericValue;
        }
        return this;
    }

    public BasketPage getTotalCountProductInBasket() {  //считаем общее колличество товаров в корзине
        int totalCountProductsInBasket = pricesInBasket.size();
        return this;
    }
}


