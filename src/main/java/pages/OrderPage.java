package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private static WebDriver driver;
    private  By orderButton = By.xpath(".//button[1][text()='Заказать']");;
    //Локатор поиска кнопки заказа вверху страницы
    private By cookieButton = By.id("rcc-confirm-button");
    //Локатор на  кнопку согласия с куками
    private  By orderButtonCenter =  By.xpath(".//button[1][text()='Заказать']");
    //Локатор поиска кнопки заказа в центре  страницы

    private  By completionFirstName = By.xpath(".//input[@placeholder='* Имя']");
    //Локатор импута ввода имени
    private  By completionLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор импута ввода фамилии
    private  By completionAdres = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор импута ввода адреса
    private  By completionMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    //Локатор импута ввода метро
    private  By completionFirstOptionMetroSelect = By.className("select-search__option");
    //Первый подходящий вариант метро
    private  By completionPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор  импута телефон
    private  By buttonFurther =  (By.xpath(".//button[text()='Далее']"));
    //локатор кнопки далее
    private  By completionData = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Локатор импута ввода даты
    private  By completionComments = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Локатор импута комментарий для курьера
    private  By completionRentalPeriod = By.className("Dropdown-arrow");
    //Локатор селекта срок аренды для клика
    private  By choiceTerm= By.xpath(".//div[text()='пятеро суток']");
    private  By choiceColor = By.id("black");
    //Локатор цвета самоката
    private  By сonfirmationOrderButton = By.xpath(".//button[2][text()='Заказать']");
    //Локатор подверждения заказа
    private  By сonfirmationYesOrderButton = By.xpath(".//button[text()='Да']");
    //Локатор "да" в модальке заказа
    private  By orderSuccess = By.className("Order_ModalHeader__3FDaJ");
    //Локатор класса  "заказ оформлен" модального окна

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickToOrderButtonHeader() {
        driver.findElement(orderButton).click();
    }

    public void FiendClickToOrderButtonCenter() {
//        WebElement element = driver.findElement(orderButtonCenter);
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", orderButtonCenter);
        driver.findElement(orderButtonCenter).click();
    }
    public  void completionInputs(String firstName, String lastName, String address, String metro, String phone) {
        driver.findElement(completionFirstName).sendKeys(firstName);
        driver.findElement(completionLastName).sendKeys(lastName);
        driver.findElement(completionAdres).sendKeys(address);
        driver.findElement(completionPhone).sendKeys(phone);
        driver.findElement(completionMetro).sendKeys(metro);
        driver.findElement(completionFirstOptionMetroSelect).click();
    }
    public  void clickButtonFurther(){
        driver.findElement(buttonFurther).click();
    }

    public  void completionInputsPageTwo(String date, String comments) {
        driver.findElement(completionData).sendKeys(date);
        driver.findElement(completionComments).sendKeys(comments);
        driver.findElement(completionRentalPeriod).click();
        driver.findElement(choiceTerm).click();
        driver.findElement(choiceColor).click();
        driver.findElement(сonfirmationOrderButton).click();
        driver.findElement(сonfirmationYesOrderButton).click();

    }
    public String modalText() {
        return driver.findElement(orderSuccess).getText();
    }
    public void clickToCookiesModal() {
        driver.findElement(cookieButton).click();
    }
}
