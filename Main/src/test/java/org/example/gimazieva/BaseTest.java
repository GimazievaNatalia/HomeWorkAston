package org.example.gimazieva;

import org.openqa.selenium.WebDriver;
public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected PageHomeWidberris pageHomeWidberris = new PageHomeWidberris(driver);
    protected BasketPage basketPage = new BasketPage(driver);
}
