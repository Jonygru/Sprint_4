package TestsHomeFAQTextChrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.HomePageSamocat;

import static org.hamcrest.core.Is.is;

public class TestEightQuestion {
    private WebDriver driver;
    @Test
    public void checkText() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageSamocat homePageSamocat = new HomePageSamocat(driver);
        //Ожидаемый результат
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        homePageSamocat.scroolForElement8();
        homePageSamocat.clickForElement8();
        //Фактический результат
        String result = homePageSamocat.getTextForElement8();
        //Сравнение ОР с ФР
        MatcherAssert.assertThat(result, is(expected));

    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
