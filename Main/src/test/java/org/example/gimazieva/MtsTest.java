package org.example.gimazieva;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;


public class MtsTest {
    private WebDriver driver;
    private String expectedText = "Онлайн пополнение\n" + "без комиссии";
    private String numberPhone = "297777777";
    private String summ = "150";
    private String email = "vasya@mail.ru";

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://mts.by");
        WebElement cookieAgreeButton = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
        cookieAgreeButton.click();
    }

    @Test
    @DisplayName("Проверка имени блока")
    public void testReplenishmentOnlineText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement replenishmentOnlineText = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        wait.until(ExpectedConditions.textToBePresentInElement(replenishmentOnlineText, expectedText));
        Assertions.assertEquals(expectedText, replenishmentOnlineText.getText());
    }

    @Test
    @DisplayName("Проверка наличия логотипов")
    public void testcheckLogo() {
        By logoLocator = (By.xpath("//div[@class='pay__partners']/ul/li/img"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.numberOfElementsToBe(logoLocator, 6));
        List<WebElement> logos = driver.findElements(logoLocator);

        for (WebElement logo : logos) { // проверка атрибута "alt" для каждого логотипа
            String altText = logo.getAttribute("alt");
            Assertions.assertNotNull(altText, "Атрибут 'alt' отсутствует");
            Assertions.assertFalse(altText.isEmpty(), "Атрибут 'alt' не должен быть пустым");
            System.out.println("Логотип: " + altText);
        }
    }

    @Test
    @DisplayName("Проверка ссылки")
    public void testcheckLink() {
        WebElement serviceLink = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));
        serviceLink.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }

        WebElement elementOnNewPage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='container-fluid']/h3")));
        Assertions.assertNotNull(elementOnNewPage, "Не удалось найти ожидаемый элемент на новой странице");
    }

    @Test
    @DisplayName("Заполнить поля и нажать на кнопку Продолжить")
    public void testCompleteButton() {
        WebElement phoneNumberInputField = driver.findElement(By.xpath("//input[@class='phone']"));
        phoneNumberInputField.click();
        phoneNumberInputField.sendKeys(numberPhone);

        WebElement sumInputField = driver.findElement(By.xpath("//input[@class='total_rub']"));
        sumInputField.click();
        sumInputField.sendKeys(summ);

        WebElement emailInputField = driver.findElement(By.xpath("//input[@class='email']"));
        emailInputField.click();
        emailInputField.sendKeys(email);

        WebElement comleteButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        comleteButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(frameElement);
        WebElement elementOnNewPage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Оплатить')]")));
        Assertions.assertNotNull(elementOnNewPage, "Не удалось найти ожидаемый элемент на новой странице");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}





