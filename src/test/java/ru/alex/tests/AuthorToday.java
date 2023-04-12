package ru.alex.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AuthorToday {
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //получение ссылки на страницу входа из файла настроек
        driver.get("https://author.today/");
    }

    @Test
    public void test() throws InterruptedException {
        WebElement nav = driver.findElement(By.cssSelector("#navbar-right > li:nth-child(2) > a"));
        nav.click();

        WebElement login = driver.findElement(By.id("Login"));
        WebElement password = driver.findElement(By.cssSelector("#authModal > div > div > div.modal-body > div > div > div > form:nth-child(2) > div:nth-child(4) > input"));

        login.sendKeys("zarbogan@mail.ru");
        password.sendKeys("T9dEbgYZ");

        WebElement entrance2 = driver.findElement(By.cssSelector("#authModal .btn.btn-primary.btn-block.mt-lg"));
        entrance2.click();

        Thread.sleep(5000);
        WebElement library = driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(4) > a"));
        library.click();
    }
}
