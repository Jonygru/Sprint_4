package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondFormPage {
    private WebDriver driver;
    //Локатор для поля Даты
    private By dateForm = By.cssSelector("[placeholder='* Когда привезти самокат']");

    //Локатор дропдауна срок аренды
    private By rentalPeriodForm = By.xpath(".//div[text()='* Срок аренды']");
    //Локатор для выбора количества суток
    private By rentalPeriodDropdownForm = By.xpath("//div[text()='двое суток']");

    //Локатор для кнопки заказать
    private By buttonOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //Локатор модального окна подтверждения

    private By modalWindowOrderConfirmation = By.className("Order_Modal__YZ-d3");

    //Локатор кнопки подтверждения заказа

    private By buttonYes = By.xpath(".//button[text()='Да']");

    //Локатор модального окна об успешном заказа

    private By modalWindowOrderTrue = By.xpath(".//div[@class='Order_Modal__YZ-d3']");

    //Локатор текста подтверждения успешного заказа

    private By textModalWindowOrderTrue = By.xpath(".//div[text()='Заказ оформлен']");

    public SecondFormPage(WebDriver driver) {
        this.driver = driver;
    }
    public void addDate(String date, String day){
        driver.findElement(dateForm).clear();
        driver.findElement(dateForm).sendKeys(date);
        driver.findElement(By.xpath(".//div[text()='"+day+"']")).click();
    }
    public void rentalPeriod(){
        driver.findElement(rentalPeriodForm).click();
        driver.findElement(rentalPeriodDropdownForm).click();

    }
    public void clickButtonOrder(){
        driver.findElement(buttonOrder).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(modalWindowOrderConfirmation));
    }
    public void clickButtonYes(){
        driver.findElement(buttonYes).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(modalWindowOrderConfirmation));
    }
    public String checkTextModalWindow(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(modalWindowOrderTrue));
        return driver.findElement(textModalWindowOrderTrue).getText();
    }
}
