package org.example.gimazieva;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.example.gimazieva.Constan.Urls.URL_WIDBERRIS;

public class WildberrisTest extends BaseTest {



    @Test
    public void checkbasket() { // потом можно отправить в бейс тест или сделать бефорич
        basePage.openPage(URL_WIDBERRIS);
        pageHomeWidberris.cvc();

    }

    @Test
    public void checkTextNameInBasket() {
       // basePage.openPage(URL_WIDBERRIS);
       // basePage.waitElementIsVisible(product1);
        pageHomeWidberris.getTextPriceAndNameProducts();
        pageHomeWidberris.getTotalSumm();
        pageHomeWidberris.getTotalCountProducts();
       // basketPage.checkCountProduct();
        basketPage.getTextNamePriceBasket();

    }
}
