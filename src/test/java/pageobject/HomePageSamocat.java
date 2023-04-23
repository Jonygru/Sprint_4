package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSamocat {
    private WebDriver driver;


    //Первый вопрос в FAQ
    private By firstQestion = By.id("accordion__heading-0");

    //Текст под первым вопросом в FAQ
    private By textFirstQestion = By.cssSelector("[class='accordion__item'] > div[id='accordion__panel-0'] > p");

    //Второй вопрос в FAQ
    private By secondQestion = By.id("accordion__heading-1");

    //Текст под вторым вопросом в FAQ
    private By textSecondQestion = By.cssSelector("[class='accordion__item'] > div[id='accordion__panel-1'] > p");
    //третий вопрос в FAQ
    private By thirdQestion = By.id("accordion__heading-2");

    //Текст под третьим вопросом в FAQ
    private By textThirdQestion = By.cssSelector("[class='accordion__item'] > div[id='accordion__panel-2'] > p");
    //Четвертый вопрос в FAQ
    private By fourthQestion = By.id("accordion__heading-3");

    //Текст под четвертым вопросом в FAQ
    private By textFourthQestion = By.cssSelector("[class='accordion__item'] > div[id='accordion__panel-3'] > p");
    //Пятый вопрос в FAQ
    private By fifthQestion = By.id("accordion__heading-4");

    //Текст под пятым вопросом в FAQ
    private By textFifthQestion = By.cssSelector("[class='accordion__item'] > div[id='accordion__panel-4'] > p");
    //Шестой вопрос в FAQ
    private By sixthQestion = By.id("accordion__heading-5");

    //Текст под шестым вопросом в FAQ
    private By textSixthQestion = By.cssSelector("[class='accordion__item'] > div[id='accordion__panel-5'] > p");
    //Седьмой вопрос в FAQ
    private By seventhQestion = By.id("accordion__heading-6");

    //Текст под седьмым вопросом в FAQ
    private By textSeventhQestion = By.cssSelector("[class='accordion__item'] > div[id='accordion__panel-6'] > p");
    //Восьмой вопрос в FAQ
    private By eightQestion = By.id("accordion__heading-7");

    //Текст под восьмым вопросом в FAQ
    private By textEightQestion = By.cssSelector("[class='accordion__item'] > div[id='accordion__panel-7'] > p");

    //Кнопка заказать вверху
    private By toOrderFromAbove = By.className("Button_Button__ra12g");

    //Кнопка заказать снизу

    private By toOrderBelow = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Первая форма оформления заказа самоката
    private By firstFormMakeOrder = By.className("App_App__15LM-");


    public HomePageSamocat(WebDriver driver) {
        this.driver = driver;
    }

    //метод прокрутки страницы до первого вопроса
    public void scroolForElement1() {
        WebElement element = driver.findElement(firstQestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Клик по первому вопросу
    public void clickForElement1() {
        driver.findElement(firstQestion).click();
    }
    //Метод проверяет соответсвие текста под первым вопросом
    public String getTextForElement1() {
        return driver.findElement(textFirstQestion).getText();


    }
    //метод прокрутки страницы до второго вопроса
    public void scroolForElement2() {
        WebElement element = driver.findElement(secondQestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Клик по второму вопросу
    public void clickForElement2() {
        driver.findElement(secondQestion).click();
    }

    //Метод проверяет соответсвие текста под вторым вопросом
    public String getTextForElement2() {
        return driver.findElement(textSecondQestion).getText();
    }
    //метод прокрутки страницы до третьего вопроса
    public void scroolForElement3() {
        WebElement element = driver.findElement(thirdQestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Клик по третьему вопросу
    public void clickForElement3() {
        driver.findElement(thirdQestion).click();
    }

    //Метод проверяет соответсвие текста под третьим вопросом
    public String getTextForElement3() {
        return driver.findElement(textThirdQestion).getText();
    }

    //метод прокрутки страницы до четвертого вопроса
    public void scroolForElement4() {
        WebElement element = driver.findElement(fourthQestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Клик по четвертому вопросу
    public void clickForElement4() {
        driver.findElement(fourthQestion).click();
    }

    //Метод проверяет соответсвие текста под четвертым вопросом
    public String getTextForElement4() {
        return driver.findElement(textFourthQestion).getText();
    }

    //метод прокрутки страницы до пятого вопроса
    public void scroolForElement5() {
        WebElement element = driver.findElement(fifthQestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Клик по пятому вопросу
    public void clickForElement5() {
        driver.findElement(fifthQestion).click();
    }

    //Метод проверяет соответсвие текста под пятым вопросом
    public String getTextForElement5() {
        return driver.findElement(textFifthQestion).getText();
    }


    //метод прокрутки страницы до шестого вопроса
    public void scroolForElement6() {
        WebElement element = driver.findElement(sixthQestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Клик по шесстому вопросу
    public void clickForElement6() {
        driver.findElement(sixthQestion).click();
    }

    //Метод проверяет соответсвие текста под шестым вопросом
    public String getTextForElement6() {
        return driver.findElement(textSixthQestion).getText();
    }

    //метод прокрутки страницы до седьмго вопроса
    public void scroolForElement7() {
        WebElement element = driver.findElement(seventhQestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Клик по седьмому вопросу
    public void clickForElement7() {
        driver.findElement(seventhQestion).click();
    }

    //Метод проверяет соответсвие текста под седьмым вопросом
    public String getTextForElement7() {
        return driver.findElement(textSeventhQestion).getText();
    }

    //метод прокрутки страницы до восьмого вопроса
    public void scroolForElement8() {
        WebElement element = driver.findElement(eightQestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Клик по восьмому вопросу
    public void clickForElement8() {
        driver.findElement(eightQestion).click();
    }

    //Метод проверяет соответсвие текста под восьмым вопросом
    public String getTextForElement8() {
        return driver.findElement(textEightQestion).getText();
    }

    //Метод клика по верхней кнопке заказать и ожидание формы
    public void clickToOrderFromAbove() {
        driver.findElement(toOrderFromAbove).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(firstFormMakeOrder));
    }

    //метод прокрутки страницы нижней кнопки заказать
    public void scroolForToOrderBelow() {
        WebElement element = driver.findElement(toOrderBelow);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Метод клика по верхней кнопке заказать и ожидание формы
    public void clickToOrderBelow() {
        driver.findElement(toOrderBelow).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(firstFormMakeOrder));
    }
}
