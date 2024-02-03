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

import static java.time.Duration.*;

public class MtsTest {
    private WebDriver driver;
    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jacks\\Desktop\\Наташкино\\chromedriver-win64\\chromedriver.exe"); //"src/main/resources/chromedriver.exe"
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://mts.by");
        WebElement cookieAgreeButton = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
        cookieAgreeButton.click();
    }

    @Test
    @DisplayName("Проверка имени блока")
    public void testReplenishmentOnlineText() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        String expectedText = "Онлайн пополнение\n" +
                "без комиссии";
        WebElement replenishmentOnlineText = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        wait1.until(ExpectedConditions.textToBePresentInElement(replenishmentOnlineText, expectedText));
        Assertions.assertEquals(expectedText, replenishmentOnlineText.getText());
    }
    @Test
    @DisplayName("Проверка наличия логотипов")
    public void testcheckLogo() {
        By logoLocator = (By.xpath("//div[@class='pay__partners']/ul/li/img"));
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait2.until(ExpectedConditions.numberOfElementsToBe(logoLocator, 6));
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
    public void testcheckLink(){
        WebElement serviceLink = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));
        serviceLink.click();
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementOnNewPage = wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Номер карты']")));
        Assertions.assertNotNull(elementOnNewPage, "Не удалось найти ожидаемый элемент на новой странице");
    }
    @Test
    @DisplayName("Заполнить поля и нажать на кнопку Продолжить")
    public void testCompleteButton() {
        WebElement phoneNumberInputField = driver.findElement(By.xpath("//input[@class='phone']"));
        phoneNumberInputField.click();
        phoneNumberInputField.sendKeys("297777777");

        WebElement sumInputField = driver.findElement(By.xpath("//input[@class='total_rub']"));
        sumInputField.click();
        sumInputField.sendKeys("150");

        WebElement emailInputField = driver.findElement(By.xpath("//input[@class='email']"));
        emailInputField.click();
        emailInputField.sendKeys("vasya@mail.ru");

        WebElement comleteButton = driver.findElement(By.xpath("//input[@class='email']"));
        comleteButton.click();
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement elementOnNewPage = wait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Порядок оплаты и безопасность интернет платежей']")));
        Assertions.assertNotNull(elementOnNewPage,"Не удалось найти ожидаемый элемент на новой странице");
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}





