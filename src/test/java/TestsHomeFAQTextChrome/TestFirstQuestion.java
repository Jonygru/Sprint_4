package TestsHomeFAQTextChrome;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.HomePageSamocat;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.core.Is.is;

public class TestFirstQuestion {
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
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        homePageSamocat.scroolForElement1();
        homePageSamocat.clickForElement1();

        String result = homePageSamocat.getTextForElement1();
        MatcherAssert.assertThat(result, is(expected));

    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
