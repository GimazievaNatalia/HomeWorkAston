package org.example.gimazieva;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.gimazieva.Constan.Urls.URL_WIDBERRIS;

public class WildberrisTest extends BaseTest{
   @Test
    public void checkbasket(){ // потом можно отправить в бейс тест или сделать бефорич
        basePage.openPage(URL_WIDBERRIS);
        pageHomeWidberris.putInBasket().clickBasket();
    }
    @Test
    public void checkTextNameInBasket() throws InterruptedException {
       basePage.openPage(URL_WIDBERRIS);
      // System.out.println(pageHomeWidberris.getTextNameProduct());
        Thread.sleep(5000);
        WebElement product1 = driver.findElement(By.xpath("//article[@data-card-index='10']//a"));
        String par = product1.getAttribute("ariaLabel");
        System.out.println(par);
    }
}
