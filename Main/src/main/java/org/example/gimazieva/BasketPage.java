package org.example.gimazieva;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    List<String> pricesBasket = new ArrayList<>();
    List<String> productNamesBasket = new ArrayList<>();
    private final By productInBasket1 = By.xpath("//div[@class='list-item__good']");
    // private final By productInBasket2 = By.xpath("");
    //private final By productInBasket3 = By.xpath("");


    public BasketPage getTextNamePriceBasket() {
        WebElement productElement = driver.findElement(productInBasket1);
        String text = productElement.getAttribute("title");
        System.out.println(text);
//       for (By productPriceAndNameList : productPriceAndNameLists) {
//           WebElement productElement = driver.findElement(productPriceAndNameList);
//           String text = productElement.getAttribute("innerText");
//           textproductPriceAndNameList.add(text);
//       }
//
//       //String regex = "(\\d[\\s\\d]*) ₽[\\s\\S]*?\\n\\n(.*?)\\n\\n"; // Забираем цену и название товара
//       String regex = "(\\d[\\s\\d]*) ₽[\\s\\S]*?\\n\\n(.*) \\/ (.*)\\n\\n\\d(.*)";
//       Pattern pattern = Pattern.compile(regex);
//
//       for (String text : textproductPriceAndNameList) {
//           Matcher matcher = pattern.matcher(text);
//           if (matcher.find()) {
//               String price = matcher.group(1).replaceAll("\\s", ""); // Группа 1 - цена, Группа 3 - название товара
//               String productName = matcher.group(3).trim();
//               prices.add(price);
//               productNames.add(productName);
//           }
//       }
       return this;
//
    }
}

//
//
//
//
//
//
//
//   public BasketPage checkCountProduct(){ //Посчитали количество товаров в корзине
//       int countProduct = driver.findElements(productInBasket).size();
//       return this;

