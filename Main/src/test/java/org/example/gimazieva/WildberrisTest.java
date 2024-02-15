package org.example.gimazieva;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.gimazieva.Constan.Urls.URL_WIDBERRIS;

public class WildberrisTest extends BaseTest {

    @Test
    public void checkWildberris() throws InterruptedException {

        basePage.openPage(URL_WIDBERRIS);

        pageHomeWidberris.getTextPriceAndNameProducts();
        pageHomeWidberris.putInBasket();
        pageHomeWidberris.clickBasket();
        basketPage.getTextPriceBasket();
        basketPage.getTextNameBasket();
        Assertions.assertAll(
                () -> Assertions.assertEquals(pageHomeWidberris.getTotalCountProducts(), basketPage.getTotalCountProductInBasket(), "Количество товаров в корзине не соответствует ожидаемому"),
                () -> Assertions.assertLinesMatch(basketPage.getProductNamesInBasket(), pageHomeWidberris.getProductNames()),//Проверка названий

                () -> Assertions.assertEquals(basketPage.getPricesInBasket(), pageHomeWidberris.getPrices(), "Цены не совпадают"),
                () -> Assertions.assertEquals(basketPage.getTotalSummInBasket(), String.valueOf(pageHomeWidberris.getTotalSumm()), "Сумма товаров до корзины не совпадает с суммой товаров в корзине")
        );
        driver.quit();
    }
}
