package org.example.gimazieva;

import org.junit.jupiter.api.Test;

import static org.example.gimazieva.Constan.Urls.URL_WIDBERRIS;

public class WildberrisTest extends BaseTest{
   @Test
    public void checkbasket(){ // потом можно отправить в бейс тест или сделать бефорич
        basePage.openPage(URL_WIDBERRIS);
        pageHomeWidberris.putInBasket().clickBasket();
    }
}
