package org.example.gimazieva;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class MTSTest2 {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://mts.by");
        WebElement cookieAgreeButton = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
        cookieAgreeButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях Услуги Связи")
    public void testPaymentСommunicationServicesText() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        String expectedTextNumberphone = "Номер телефона";
        String expectedTextSumm = "Сумма";
        String expectedTextmail = "E-mail для отправки чека";



        WebElement fieldNumberphone = driver.findElement(By.xpath("//input[@class='phone']"));
        WebElement fieldSumm = driver.findElement(By.xpath("//input[@class='total_rub']"));
        WebElement fieldmail = driver.findElement(By.xpath("//input[@class='email']"));

        wait1.until(ExpectedConditions.attributeToBe(fieldNumberphone, "placeholder", "Номер телефона"));
        wait1.until(ExpectedConditions.attributeToBe(fieldSumm, "placeholder", "Сумма"));
        wait1.until(ExpectedConditions.attributeToBe(fieldmail, "placeholder", "E-mail для отправки чека"));

        Assertions.assertEquals(expectedTextNumberphone, fieldNumberphone.getAttribute("placeholder"));
        Assertions.assertEquals(expectedTextSumm, fieldSumm.getAttribute("placeholder"));
        Assertions.assertEquals(expectedTextmail, fieldmail.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях Домашний интернет")
    public void testPaymentHomeInternetText() {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        String expectedTextNumberphone = "Номер телефона";
        String expectedTextSumm = "Сумма";
        String expectedTextmail = "E-mail для отправки чека";

        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='идентификатор_вашего_выпадающего_списка']")); ДОПИСАТЬ ХПАС

        // Создать объект класса Select
        Select dropdown = new Select(dropdownElement);
    }






//    @Test
//    @DisplayName("Заполнить поля и нажать на кнопку Продолжить")
//    public void testCompleteButton() {
//        WebElement phoneNumberInputField = driver.findElement(By.xpath("//input[@class='phone']"));
//        phoneNumberInputField.click();
//        phoneNumberInputField.sendKeys("297777777");
//
//        WebElement sumInputField = driver.findElement(By.xpath("//input[@class='total_rub']"));
//        sumInputField.click();
//        sumInputField.sendKeys("150");
//
//        WebElement emailInputField = driver.findElement(By.xpath("//input[@class='email']"));
//        emailInputField.click();
//        emailInputField.sendKeys("vasya@mail.ru");
//
//        WebElement comleteButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
//        comleteButton.click();
//        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
//        driver.switchTo().frame(frameElement);
//        WebElement elementOnNewPage = wait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Оплатить')]")));
//        Assertions.assertNotNull(elementOnNewPage, "Не удалось найти ожидаемый элемент на новой странице");
//    }
//    @Test
//    @DisplayName("Проверка наличия логотипов")
//    public void testcheckLogo() {
//        By logoLocator = (By.xpath("//div[@class='pay__partners']/ul/li/img"));
//        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait2.until(ExpectedConditions.numberOfElementsToBe(logoLocator, 6));
//        List<WebElement> logos = driver.findElements(logoLocator);
//
//        for (WebElement logo : logos) { // проверка атрибута "alt" для каждого логотипа
//            String altText = logo.getAttribute("alt");
//            Assertions.assertNotNull(altText, "Атрибут 'alt' отсутствует");
//            Assertions.assertFalse(altText.isEmpty(), "Атрибут 'alt' не должен быть пустым");
//            System.out.println("Логотип: " + altText);
//        }
//    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

