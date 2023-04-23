package TestsHomeFAQTextChrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.FirstFormPage;
import pageobject.HomePageSamocat;
import pageobject.SecondFormPage;


import static org.hamcrest.core.Is.is;
@RunWith(Parameterized.class)
public class TestPositiveMakeOrderButtonFromAbove {

    private WebDriver driver;
    private final String name;
    private final String surName;

    private final String adress;
    private final String stationMetro;
    private final String namberStation;
    private final String phone;
    private final String date;
    private final String day;

    public TestPositiveMakeOrderButtonFromAbove(String name, String surName, String adress, String stationMetro, String namberStation, String phone, String date, String day) {
        this.name = name;
        this.surName = surName;
        this.adress = adress;
        this.stationMetro = stationMetro;
        this.namberStation = namberStation;
        this.phone = phone;
        this.date = date;
        this.day = day;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {"Женя", "Иванов", "Ушакова 3", "Черкизовская", "2", "89818346565", "21.04.2023", "21"},
                {"Олег", "Булгаков", "Литейный 2", "Сокольники", "4", "898183466667", "23.04.2023", "23"},
        };
    }

    @Test
    public void makeOrderButtonFromAbove() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
            String result = "Заказ оформлен";
          HomePageSamocat homePageSamocat = new HomePageSamocat(driver);
            homePageSamocat.clickToOrderFromAbove();
        FirstFormPage firstFormPage = new FirstFormPage(driver);
            firstFormPage.addName(name);
            firstFormPage.addSurname(surName);
            firstFormPage.addAdress(adress);
            firstFormPage.addMetro(stationMetro, namberStation);
            firstFormPage.addPhone(phone);
            firstFormPage.clickButtonNext();
        SecondFormPage secondFormPage = new SecondFormPage(driver);
            secondFormPage.addDate(date, day);
            secondFormPage.rentalPeriod();
            secondFormPage.clickButtonOrder();
            secondFormPage.clickButtonYes();
            String expected = secondFormPage.checkTextModalWindow();
        MatcherAssert.assertThat(result, is(expected));


    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
