import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

public class MainPage {
    private WebDriver driver;
    private List<WebElement> elementsAccordion;
    // Локатор  элементов списка
    private By cookieButton = By.id("rcc-confirm-button");
    //Локатор кнопки " принять куки" т.к перекрывает последний элемент по айди
    private By accordionButton = By.className("accordion__button");
    //Локатор по элементу списка - аккордиону.Поиск по классу



    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickToCookiesModal() {
        driver.findElement(cookieButton).click();
    }
    // Метод который соглашается с куками


    public void initElementsAccordion() {
        elementsAccordion = driver.findElements(accordionButton);
    }
    // Метод который ищет элементы выпадающего списка


    public String getTextFromAccordionDesc(int id) {
        elementsAccordion.get(id).click();
        return driver.findElement(By.id("accordion__panel-" + id)).getText();
    }
    // Метод который кликает по элементу выпадющего списка и проверяет текст из его описания


}
