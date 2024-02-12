package org.example.gimazieva;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.gimazieva.Constan.TimeoutVariable.EXPLISIT_WAIT;

public class PageHomeWidberris extends BasePage {

    public PageHomeWidberris(WebDriver driver) {
        super(driver);
    }
    private final By addToBusketButton1 = By.xpath("//article[@data-card-index='10']/descendant::a[@href='/lk/basket']");
    private final By addToBusketButton2 = By.xpath("//article[@data-card-index='15']/descendant::a[@href='/lk/basket']");
    private final By addToBusketButton3 = By.xpath("//article[@data-card-index='20']/descendant::a[@href='/lk/basket']");
    private final By size = By.xpath("//h2[text()='Выберите размер']");
    public final By product1 = By.xpath("//article[@data-card-index='10']");
    private final By product2 = By.xpath("//article[@data-card-index='15']");
    private final By product3 = By.xpath("//article[@data-card-index='20']");
    private final By basketButton = By.xpath("//span[contains(@class,'icon--basket')]");
    private final By sizeClothing = By.xpath("//span[@class='sizes-list__size']");
    private final List<By> productPriceAndNameLists = Arrays.asList(product1, product2, product3);
    private final List<String> textproductPriceAndNameList = new ArrayList<>();
    private final List<String> prices = new ArrayList<>();
    private final List<String> productNames = new ArrayList<>();
    private final By[] addToBasketButtons = {addToBusketButton1, addToBusketButton2, addToBusketButton3};

    public PageHomeWidberris getTextPriceAndNameProducts() { //Забираем названия товаров и цен

        for (By productPriceAndNameList : productPriceAndNameLists) {
            WebElement productElement = driver.findElement(productPriceAndNameList);
            String text = productElement.getAttribute("innerText");
            textproductPriceAndNameList.add(text);
        }

        String regex = "(\\d[\\s\\d]*) ₽[\\s\\S]*?\\n\\n(.*) \\/ (.*)\\n\\n\\d(.*)";
        Pattern pattern = Pattern.compile(regex);

        for (String text1 : textproductPriceAndNameList) {
            Matcher matcher = pattern.matcher(text1);
            if (matcher.find()) {
                String price = matcher.group(1).replaceAll("\\s", ""); // Группа 1 - цена, Группа 3 - название товара
                String productName = matcher.group(3).trim();
                prices.add(price);
                productNames.add(productName);
            }
        }
        return this;
    }
    public PageHomeWidberris getTotalSumm() { //считаем общую сумму до корзины
        double totalSum = 0.0;

        for (String price : prices) {
            double numericValue = Double.parseDouble(price);
            totalSum += numericValue;
        }
        return this;
    }
    public PageHomeWidberris getTotalCountProducts() {  //считаем общее колличество товаров которые положили в корзину
        int totalCountProducts = prices.size();
        return this;
    }
    private PageHomeWidberris checkOnClothing(By addToBasketButton) {  //Проверка товара одежда или нет
        WebElement addToBasketElement = (new WebDriverWait(driver, Duration.ofSeconds(EXPLISIT_WAIT)))
                .until(ExpectedConditions.elementToBeClickable(addToBasketButton));
        addToBasketElement.click();

        boolean isClothing = false;
        try {
            WebElement sizeElement = driver.findElement(size);
            isClothing = true;

            WebElement sizeSmall = sizeElement.findElement(sizeClothing);
            sizeSmall.click();
        } catch (Exception ignored) {

        }
        return this;
    }
    public PageHomeWidberris putInBasket() { //Кладем товар в корзину
        for (By addToBasketButton : addToBasketButtons) {
            checkOnClothing(addToBasketButton);
        }
        return this;
    }
    public PageHomeWidberris clickBasket() { //Кликаем по корзине
        driver.findElement(basketButton).click();
        return this;
    }
}
