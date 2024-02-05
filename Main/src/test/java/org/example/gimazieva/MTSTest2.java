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
    private WebElement dropdownPaymentElement;
   private String expectedTextNumberPhoneConnection = "Номер телефона";
    private String expectedTextSumm = "Сумма";
    private String expectedTextMail = "E-mail для отправки чека";
    private String expectedTextNumberphoneInternet = "Номер абонента";
    private String expectedTextNumberAccountInstallment = "Номер счета на 44";
    private String expectedTextNumberAccountArrears="Номер счета на 2073";



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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement fieldNumberphone = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        WebElement fieldSumm = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        WebElement fieldMail = driver.findElement(By.xpath("//input[@id='connection-email']"));

        wait.until(ExpectedConditions.attributeToBe(fieldNumberphone, "placeholder", "Номер телефона"));
        wait.until(ExpectedConditions.attributeToBe(fieldSumm, "placeholder", "Сумма"));
        wait.until(ExpectedConditions.attributeToBe(fieldMail, "placeholder", "E-mail для отправки чека"));

        Assertions.assertEquals(expectedTextNumberPhoneConnection, fieldNumberphone.getAttribute("placeholder"));
        Assertions.assertEquals(expectedTextSumm, fieldSumm.getAttribute("placeholder"));
        Assertions.assertEquals(expectedTextMail, fieldMail.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях Домашний интернет")
    public void testPaymentHomeInternetText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        dropdownPaymentElement = driver.findElement(By.xpath("//select[@id='pay']"));
        Select dropdown = new Select(dropdownPaymentElement);
        dropdown.selectByValue("Домашний интернет");

        WebElement fieldNumberPhone = driver.findElement(By.xpath("//input[@id='internet-phone']"));
        WebElement fieldSumm = driver.findElement(By.xpath("//input[@id='internet-sum']"));
        WebElement fieldMail = driver.findElement(By.xpath("//input[@id='internet-email']"));

        wait.until(ExpectedConditions.attributeToBe(fieldNumberPhone, "placeholder", "Номер абонента"));
        wait.until(ExpectedConditions.attributeToBe(fieldSumm, "placeholder", "Сумма"));
        wait.until(ExpectedConditions.attributeToBe(fieldMail, "placeholder", "E-mail для отправки чека"));

        Assertions.assertEquals(expectedTextNumberphoneInternet, fieldNumberPhone.getAttribute("placeholder"));
        Assertions.assertEquals(expectedTextSumm, fieldSumm.getAttribute("placeholder"));
        Assertions.assertEquals(expectedTextMail, fieldMail.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях Рассрочка")
    public void testPaymentInstallmentText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        dropdownPaymentElement = driver.findElement(By.xpath("//select[@id='pay']"));
        Select dropdown = new Select(dropdownPaymentElement);
        dropdown.selectByValue("Рассрочка");

        WebElement fieldNumberAccount = driver.findElement(By.xpath("//input[@id='score-instalment']"));
        WebElement fieldSumm = driver.findElement(By.xpath("//input[@id='instalment-sum']"));
        WebElement fieldmail = driver.findElement(By.xpath("//input[@id='instalment-email']"));

        wait.until(ExpectedConditions.attributeToBe(fieldNumberAccount, "placeholder", "Номер счета на 44"));
        wait.until(ExpectedConditions.attributeToBe(fieldSumm, "placeholder", "Сумма"));
        wait.until(ExpectedConditions.attributeToBe(fieldmail, "placeholder", "E-mail для отправки чека"));

        Assertions.assertEquals(expectedTextNumberAccountInstallment, fieldNumberAccount.getAttribute("placeholder"));
        Assertions.assertEquals(expectedTextSumm, fieldSumm.getAttribute("placeholder"));
        Assertions.assertEquals(expectedTextMail, fieldmail.getAttribute("placeholder"));
    }
    @Test
    @DisplayName("Проверка надписи в незаполненных полях Задолженность")
    public void testPaymentArrearsText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        dropdownPaymentElement = driver.findElement(By.xpath("//select[@id='pay']"));
        Select dropdown = new Select(dropdownPaymentElement);
        dropdown.selectByValue("Задолженность");

        WebElement fieldNumberAccount = driver.findElement(By.xpath("//input[@id='score-arrears']"));
        WebElement fieldSumm = driver.findElement(By.xpath("//input[@id='arrears-sum']"));
        WebElement fieldmail = driver.findElement(By.xpath("//input[@id='arrears-email']"));

        wait.until(ExpectedConditions.attributeToBe(fieldNumberAccount, "placeholder", "Номер счета на 2073"));
        wait.until(ExpectedConditions.attributeToBe(fieldSumm, "placeholder", "Сумма"));
        wait.until(ExpectedConditions.attributeToBe(fieldmail, "placeholder", "E-mail для отправки чека"));

        Assertions.assertEquals(expectedTextNumberAccountArrears, fieldNumberAccount.getAttribute("placeholder"));
        Assertions.assertEquals(expectedTextSumm, fieldSumm.getAttribute("placeholder"));
        Assertions.assertEquals(expectedTextMail, fieldmail.getAttribute("placeholder"));
    }


        @Test
    @DisplayName("Заполнить поля Услуги Связи и нажать на кнопку Продолжить")
    public void testCompleteButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        dropdownPaymentElement = driver.findElement(By.xpath("//select[@id='pay']"));
        Select dropdown = new Select(dropdownPaymentElement);
        dropdown.selectByValue("Услуги cвязи");

        WebElement phoneNumberInputField = driver.findElement(By.xpath("//input[@class='phone']"));
        phoneNumberInputField.click();
        phoneNumberInputField.sendKeys("297777777");

        WebElement sumInputField = driver.findElement(By.xpath("//input[@class='total_rub']"));
        sumInputField.click();
        sumInputField.sendKeys("150");

        WebElement emailInputField = driver.findElement(By.xpath("//input[@class='email']"));
        emailInputField.click();
        emailInputField.sendKeys("vasya@mail.ru");

        WebElement comleteButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        comleteButton.click();


    }
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

