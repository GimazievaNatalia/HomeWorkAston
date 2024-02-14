package org.example.gimazieva;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.example.gimazieva.Constan.Urls.URL_WIDBERRIS;
public class WildberrisTest extends BaseTest {

    @Test
    public void checkWildberris() {
        basePage.openPage(URL_WIDBERRIS);

        pageHomeWidberris.getTextPriceAndNameProducts();
        pageHomeWidberris.putInBasket();
        pageHomeWidberris.clickBasket();
        List<String> firstCollection = pageHomeWidberris.getProductNames();
        List<String> secondCollection = basketPage.getProductNamesInBasket();
       basketPage.getTextNamePriceBasket();

        Assertions.assertEquals(pageHomeWidberris.getTotalCountProducts(), basketPage.getTotalCountProductInBasket() , "Количество товаров в корзине не соответствует ожидаемому");
        Assertions.assertEquals(pageHomeWidberris.getTotalSumm(),basketPage.getTotalSummInBasket(), "Сумма товаров до корзины не совпадает с суммой товаров в корзине" );
        Assertions.assertEquals(pageHomeWidberris.getPrices(),basketPage.getPricesInBasket(), "Цены не совпадают");
        Assertions.assertTrue(secondCollection.containsAll(firstCollection)); //Проверка названий
    }
    @AfterAll
    public void clouse() {
        if (driver != null) {
            driver.quit();
        }
    }

}
