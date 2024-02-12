package org.example.gimazieva;

import org.junit.jupiter.api.Test;

import static org.example.gimazieva.Constan.Urls.URL_WIDBERRIS;
public class WildberrisTest extends BaseTest {

    @Test
    public void checkWildberris() {
        basePage.openPage(URL_WIDBERRIS);
        pageHomeWidberris.getTextPriceAndNameProducts();
        pageHomeWidberris.getTotalSumm();
        pageHomeWidberris.getTotalCountProducts();
        pageHomeWidberris.putInBasket();
        pageHomeWidberris.clickBasket();
        basketPage.getTextNamePriceBasket();
        basketPage.getTotalSummInBasket();
        basketPage.getTotalCountProductInBasket();

    }


}
