package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSamocat {
    private WebDriver driver;


    //Кнопка заказать вверху
    private By toOrderFromAbove = By.className("Button_Button__ra12g");

    //Кнопка заказать снизу

    private By toOrderBelow = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Первая форма оформления заказа самоката
    private By firstFormMakeOrder = By.className("App_App__15LM-");


    public HomePageSamocat(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по вопросу
    public void clickForElement(String numberQuestion) {
        WebElement element = driver.findElement(By.id("accordion__heading-"+numberQuestion));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id("accordion__heading-"+numberQuestion)).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-"+numberQuestion+"']/p")));
    }
    //Метод проверяет соответсвие текста под вопросом
    public String getTextForElement(String text) {
        return driver.findElement(By.xpath(".//p[text()='"+text+"']")).getText();


    }



    //Метод клика по верхней кнопке заказать и ожидание формы
    public void clickToOrderFromAbove() {
        driver.findElement(toOrderFromAbove).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(firstFormMakeOrder));
    }


    //Метод клика по нижней кнопке заказать и ожидание формы
    public void clickToOrderBelow() {
        WebElement element = driver.findElement(toOrderBelow);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(toOrderBelow).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(firstFormMakeOrder));
    }




}
