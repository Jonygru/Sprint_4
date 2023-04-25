package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstFormPage {
    private WebDriver driver;

    //Поле имени
    private By nameForm = By.cssSelector("[placeholder='* Имя'][class='Input_Input__1iN_Z Input_Responsible__1jDKN']");

    //Поле фамилии
    private By surnameForm = By.cssSelector("[placeholder='* Фамилия'][class='Input_Input__1iN_Z Input_Responsible__1jDKN']");

    //Поле адреса
    private By adressForm = By.cssSelector("[placeholder='* Адрес: куда привезти заказ'][class='Input_Input__1iN_Z Input_Responsible__1jDKN']");

    //Поле метро
    private By metroForm = By.className("select-search__input");

    //Локатор станции черкизовская
    private By cherkizovskay = By.xpath(".//button[@value='2']");



    //Поле телефона
    private By phoneForm = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка далее
    private By buttonNext = By.xpath(".//button[text()='Далее']");

    //Локатор для получения второй формы заказа
    private By firstFormMakeOrder = By.className("Order_Content__bmtHS");


    public FirstFormPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод ввода имени
    public void addName(String name){
        driver.findElement(nameForm).clear();
        driver.findElement(nameForm).sendKeys(name);

    }

    //Метод ввода фамилии
    public void addSurname(String surname){
        driver.findElement(surnameForm).clear();
        driver.findElement(surnameForm).sendKeys(surname);

    }
    //Метод ввода адреса
    public void addAdress(String adress){
        driver.findElement(adressForm).clear();
        driver.findElement(adressForm).sendKeys(adress);
    }
    //Метод ввода метро
    public void addMetro(String metro, String numberStation){
        driver.findElement(metroForm).clear();
        driver.findElement(metroForm).sendKeys(metro);
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.textToBePresentInElementValue(metroForm, metro));
        driver.findElement(By.xpath(".//button[@value='"+numberStation+"']")).click();
    }


        //Метод ввода адреса
    public void addPhone(String phone){
        driver.findElement(phoneForm).clear();
        driver.findElement(phoneForm).sendKeys(phone);

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonNext));
    }
    public void clickButtonNext(){
        driver.findElement(buttonNext).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(firstFormMakeOrder));
    }
}
