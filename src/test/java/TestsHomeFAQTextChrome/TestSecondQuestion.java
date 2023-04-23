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

public class TestSecondQuestion {
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
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        homePageSamocat.scroolForElement2();
        homePageSamocat.clickForElement2();
        //Фактический результат
        String result = homePageSamocat.getTextForElement2();
        //Сравнение ОР с ФР
        MatcherAssert.assertThat(result, is(expected));

    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
