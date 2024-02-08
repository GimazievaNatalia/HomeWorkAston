package org.example.gimazieva;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


import static org.example.gimazieva.Config.PLATFORM_BROWSER;
import static org.example.gimazieva.Constan.TimeoutVariable.IMPLISIT_WAIT;

public class CommonAction {
    public static WebDriver createDriver(){
        WebDriver driver = null;

        switch(PLATFORM_BROWSER) {
            case "win_chrome":
                System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                Assertions.fail("Incorrect platform or browser name" + PLATFORM_BROWSER);
        }

        driver.manage().timeouts().implicitlyWait(IMPLISIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}


