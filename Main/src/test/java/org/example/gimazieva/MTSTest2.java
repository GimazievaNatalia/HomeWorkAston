package org.example.gimazieva;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MTSTest2 {
    private WebDriver driver;
    private WebElement dropdownPaymentElement;
    private String expectedTextNumberPhoneConnection = "Номер телефона";
    private String expectedTextSumm = "Сумма";
    private String expectedTextMail = "E-mail для отправки чека";
    private String expectedTextNumberphoneInternet = "Номер абонента";
    private String expectedTextNumberAccountInstallment = "Номер счета на 44";
    private String expectedTextNumberAccountArrears = "Номер счета на 2073";
    private String expectedSumm = "150";
    private String expectedNumber = "297777777";
    private String email = "vasya@mail.ru";
    private String numberCard = "2200 7007 1349 0000";
    private String expirationDate = "02/25";
    private String surname = "VASYA PUPKIN";
    private String cvc = "856";
    private String expectedTextNumberCard = "Номер карты";
    private String expectedExpirationDate = "Срок действия";
    private String expectedfieldName = "Имя держателя (как на карте)";

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



   //Заполнить поля Услуги Связи и нажать на кнопку Продолжить
    public void completeButton() {

        WebElement phoneNumberInputField = driver.findElement(By.xpath("//input[@class='phone']"));
        phoneNumberInputField.click();
        phoneNumberInputField.sendKeys(expectedNumber);

        WebElement sumInputField = driver.findElement(By.xpath("//input[@class='total_rub']"));
        sumInputField.click();
        sumInputField.sendKeys(expectedSumm);

        WebElement emailInputField = driver.findElement(By.xpath("//input[@class='email']"));
        emailInputField.click();
        emailInputField.sendKeys(email);

        WebElement comleteButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        comleteButton.click();

    }
    @ParameterizedTest
    @CsvSource({"mastercard", "visa", "belkart", "mir", "maestro"})
    @DisplayName("Проверка наличия логотипов")
    public void testcheckLogo(String paymentSystem) throws InterruptedException {
        completeButton();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(frameElement);
        Thread.sleep(5000);
        By logoLocator = (By.xpath("//div[contains(@class,'cards-brands')]/img"));

        List<WebElement> logos = driver.findElements(logoLocator);
        boolean logoFound = false;
        for (WebElement logo : logos) {
            String srcText = logo.getAttribute("src");
            if (srcText != null && srcText.toLowerCase().contains(paymentSystem.toLowerCase())) {
                logoFound = true;
                break;
            }
        }
        Assertions.assertTrue(logoFound, "Логотип " + paymentSystem + " не найден на странице");
    }


    @Test
    @DisplayName("Проверка  корректности отображения суммы")
    public void testcheckSumm() throws InterruptedException {
        completeButton();

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(frameElement);
        Thread.sleep(8000);

        WebElement fieldSumm = driver.findElement(By.xpath("//p[@class='header__payment-amount']"));
        String textSumm = fieldSumm.getText();
        Pattern pattern = Pattern.compile("\\b(\\d+)\\.\\d+\\b"); //готовим регулярку
        Matcher matcher = pattern.matcher(textSumm);
        if (matcher.find()) {
            String foundSum = matcher.group(1);
            System.out.println("Найденное значение: " + foundSum);
            Assertions.assertEquals(expectedSumm, foundSum);
        }
    }


    @Test
    @DisplayName("Проверка  корректности отображения суммы на кнопке")
    public void testcheckSummButton() {
        completeButton();

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(frameElement);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement numberCardField = driver.findElement(By.xpath("//input[@id='cc-number']"));
        numberCardField.click();
        numberCardField.sendKeys(numberCard);

        WebElement expirationDateField = driver.findElement(By.xpath("//input[@formcontrolname='expirationDate']"));
        expirationDateField.click();
        expirationDateField.sendKeys(expirationDate);

        WebElement surnameField = driver.findElement(By.xpath("//input[@formcontrolname='holder']"));
        surnameField.click();
        surnameField.sendKeys(surname);

        WebElement cvcField = driver.findElement(By.xpath("//input[@formcontrolname='holder']"));
        cvcField.click();
        cvcField.sendKeys(cvc);

        WebElement summButton = driver.findElement(By.xpath("//button[@type='submit' and contains (@class,'colored')]"));
        String amountSumm = summButton.getText();
        Pattern pattern = Pattern.compile("(\\d+)"); //готовим регулярку
        Matcher matcher = pattern.matcher(amountSumm);
        if (matcher.find()) {
            String foundSum = matcher.group(1);
            System.out.println("Найденное значение: " + foundSum);
            Assertions.assertEquals(expectedSumm, foundSum);
        }
    }

    @Test
    @DisplayName("Проверка  корректности отображения номера телефона")
    public void testcheckNumberPhone() throws InterruptedException {
        completeButton();

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(frameElement);
        Thread.sleep(8000);

        WebElement numberPhoneElement = driver.findElement(By.xpath("//p[@class='header__payment-info']"));
        String textNumberPhone = numberPhoneElement.getText();
        Pattern pattern = Pattern.compile("Номер:375(\\d+)"); //готовим регулярку
        Matcher matcher = pattern.matcher(textNumberPhone);
        if (matcher.find()) {
            String foundNumber = matcher.group(1);
            System.out.println("Найденное значение: " + foundNumber);
            Assertions.assertEquals(expectedNumber, foundNumber);
        }
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях карты")
    public void testCardTextField() throws InterruptedException {
        completeButton();

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(frameElement);

        Thread.sleep(8000);
        WebElement numberCardField = driver.findElement(By.xpath("//label[text()='Номер карты']"));
        WebElement fieldExpirationDate = driver.findElement(By.xpath("//label[text()='Срок действия']"));
        WebElement fieldName = driver.findElement(By.xpath("//label[text()='Имя держателя (как на карте)']"));
        String textNumberCardField = numberCardField.getText();
        String textfieldExpirationDate = fieldExpirationDate.getText();
        String textfieldName = fieldName.getText();

        Assertions.assertEquals(expectedTextNumberCard, textNumberCardField);
        Assertions.assertEquals(expectedExpirationDate, textfieldExpirationDate);
        Assertions.assertEquals(expectedfieldName, textfieldName);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

