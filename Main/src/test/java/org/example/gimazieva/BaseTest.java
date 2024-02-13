package org.example.gimazieva;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected PageHomeWidberris pageHomeWidberris = new PageHomeWidberris(driver);
    protected BasketPage basketPage = new BasketPage(driver);
    protected CompareValues compareValues =new CompareValues(driver);

//    @AfterAll
//    public void clouse() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
