package org.example.gimazieva;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.gimazieva.Constan.Urls.URL_WIDBERRIS;
public class WildberrisTest extends BaseTest {

    @Test
    public void checkWildberris() {
        basePage.openPage(URL_WIDBERRIS);
        pageHomeWidberris.getTextPriceAndNameProducts();
        pageHomeWidberris.putInBasket();
        pageHomeWidberris.clickBasket();
        basketPage.getTextNamePriceBasket();

        Assertions.assertEquals(pageHomeWidberris.getTotalCountProducts(), basketPage.getTotalCountProductInBasket() , "Количество товаров в корзине не соответствует ожидаемому"); //Проверка на колличество товаров
        Assertions.assertEquals(pageHomeWidberris.getTotalSumm(),basketPage.getTotalSummInBasket(), "Сумма товаров до корзины не совпадает с суммой товаров в корзине" ); //Проверка суммы до корзины и в корзине
        Assertions.assertEquals(pageHomeWidberris.getPrices(),basketPage.getPricesInBasket(), "Цены не совпадают");
        Assertions.assertEquals(pageHomeWidberris.getProductNames(), basketPage.getProductNamesInBasket(), "Название товаров не совпадают");
    }


}
