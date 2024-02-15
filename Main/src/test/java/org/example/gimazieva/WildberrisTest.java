package org.example.gimazieva;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import static org.example.gimazieva.Constan.Urls.URL_WIDBERRIS;
public class WildberrisTest extends BaseTest {

    @Test
    public void checkWildberris() throws InterruptedException {
        SoftAssertions softAssert = new SoftAssertions();
        basePage.openPage(URL_WIDBERRIS);

        pageHomeWidberris.getTextPriceAndNameProducts();
        pageHomeWidberris.putInBasket();
        pageHomeWidberris.clickBasket();
       // List<String> firstCollection = ;
        basketPage.getTextPriceBasket();
        basketPage.getTextNameBasket();
        //List<String> secondCollection = basketPage.getProductNamesInBasket();

        Assertions.assertEquals(pageHomeWidberris.getTotalCountProducts(), basketPage.getTotalCountProductInBasket() , "Количество товаров в корзине не соответствует ожидаемому");
        softAssert.assertLinesMatch(basketPage.getProductNamesInBasket(), pageHomeWidberris.getProductNames()); //Проверка названий
       // Assertions.assertTrue(pageHomeWidberris.getProductNames().contains(basketPage.getProductNamesInBasket()));
        Assertions.assertEquals(basketPage.getPricesInBasket(), pageHomeWidberris.getPrices(),"Цены не совпадают");
        Assertions.assertEquals(basketPage.getTotalSummInBasket(),pageHomeWidberris.getTotalSumm(), "Сумма товаров до корзины не совпадает с суммой товаров в корзине" );
        driver.quit();
    }
//    @AfterAll
//    public void clouse() {
//        if (driver != null) {
//
//        }
//    }

}
