package org.example.gimazieva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageHomeWidberris extends BasePage {

    public PageHomeWidberris(WebDriver driver) { ////h2[text()='Выберите размер']
        super(driver);
    }

    private final By addToBusketButton1 = By.xpath("//article[@data-card-index='10']/descendant::a[@href='/lk/basket']");
    private final By addToBusketButton2 = By.xpath("//article[@data-card-index='15']/descendant::a[@href='/lk/basket']");
    private final By addToBusketButton3 = By.xpath("//article[@data-card-index='20']/descendant::a[@href='/lk/basket']");
    private final By tableSizeM = By.xpath("//div[@class='popup__content']//span[text()='M']");
    private final By size = By.xpath("//h2[text()='Выберите размер']");
    private final By product1 = By.xpath("//article[@data-card-index='10']");
    private final By product2 = By.xpath("//article[@data-card-index='15']");
    private final By product3 = By.xpath("//article[@data-card-index='20']");
    private final By basketButton = By.xpath("//span[contains(@class,'icon--basket')]");


    public PageHomeWidberris putInBasket() { //Кладем элемент в корзину
        driver.findElement(addToBusketButton1).click();
        driver.findElement(addToBusketButton2).click();
        driver.findElement(addToBusketButton3).click();
        return this;
    }

    public PageHomeWidberris clickBasket() { //Кликаем по корзине
        driver.findElement(basketButton).click();
        return this;
    }

    public PageHomeWidberris getTextPriceAndNameProducts() { //Забираем названия товаров и цен
        List<By> productPriceAndNameLists = Arrays.asList(product1, product2, product3);
        List<String> textproductPriceAndNameList = new ArrayList<>();
        List<String> prices = new ArrayList<>();
        List<String> productNames = new ArrayList<>();

        for (By productPriceAndNameList : productPriceAndNameLists) {
            WebElement productElement = driver.findElement(productPriceAndNameList);
            String text = productElement.getAttribute("innerText");
            textproductPriceAndNameList.add(text);
        }

        //String regex = "(\\d[\\s\\d]*) ₽[\\s\\S]*?\\n\\n(.*?)\\n\\n"; // Забираем цену и название товара
        String regex = "(\\d[\\s\\d]*) ₽[\\s\\S]*?\\n\\n(.*) \\/ (.*)\\n\\n\\d(.*)";
        Pattern pattern = Pattern.compile(regex);

        for (String text : textproductPriceAndNameList) {
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String price = matcher.group(1).replaceAll("\\s", ""); // Группа 1 - цена, Группа 2 - название товара
                String productName = matcher.group(3).trim();
                prices.add(price);
                productNames.add(productName);
            }
        }
        return this;
    }
}
