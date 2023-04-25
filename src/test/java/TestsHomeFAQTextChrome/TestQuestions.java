package TestsHomeFAQTextChrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.HomePageSamocat;

import static org.hamcrest.core.Is.is;
@RunWith(Parameterized.class)
public class TestQuestions {
    private WebDriver driver;
    private final String questionText;
    private final String numberQuestion;


    public TestQuestions(String questionText, String numberQuestion) {
        this.questionText = questionText;
        this.numberQuestion = numberQuestion;
    }

    @Before
    public void updown(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "0"},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "1"},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "2"},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "3"},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "4"},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "5"},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "6"},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", "7"},
        };
    }
    @Test
    public void checkText1() {


        HomePageSamocat homePageSamocat = new HomePageSamocat(driver);
        String expected = questionText;
        homePageSamocat.clickForElement(numberQuestion);

        String result = homePageSamocat.getTextForElement(questionText);
        MatcherAssert.assertThat(result, is(expected));

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
