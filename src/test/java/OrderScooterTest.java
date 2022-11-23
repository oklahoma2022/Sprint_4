import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver; //По заданию только гугл хром нужен на ревью. удалять не стала для возможности дебага
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    private String firstName; // имя
    private String lastName; //фамилия
    private String address; //адрес
    private String metro; //метро
    private String phone; // телефон
    private String date; //дата
    private String comments; //коментарий для курьера
    private WebDriver driverChrome;
   // private WebDriver driverFirefox;//По заданию только гугл хром нужен на ревью. удалять не стала для возможности дебага

   public OrderScooterTest(String firstName, String lastName, String address, String metro, String phone, String date, String comments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.comments = comments;
    }

    @Parameterized.Parameters
    public static Object[][] getInput() {
        return new Object[][]{
                {"Иван","Иванов","Ул. Амурская д.7 кв. 3", "Черкизовская","79001230000","12.11.2022", "Спасибо"},
                {"Петр","Петров", "Ул. Новорязанская д.16 кв. 7","Комсомольская","79004320001","12.12.2022", "Спасибо,жду вас"},
                {"Раиса","Иванова","Ул. Захарова д.2 кв. 14","Орехово", "79007650002","25.11.2022", ""},
                {"Галина","Петрова", "Ул. Брянская д.8 кв. 89","Киевская","79003450003","31.12.2022", "Позвоните перед  приездом!"},
        };
    }

    @Test
    public void checkOrderScooterHeader() {
       driverChrome = new ChromeDriver();
      // driverFirefox = new FirefoxDriver();//По заданию только гугл хром нужен на ревью. удалять не стала для возможности дебага

        this.initTestButtomHeader(driverChrome);
      //  this.initTestButtomHeader(driverFirefox);//По заданию только гугл хром нужен на ревью. удалять не стала для возможности дебага
    }

    public void initTestButtomHeader(WebDriver driver) {
        OrderPage orderPage = new OrderPage(driver);
        //Создаю экземпляр класса
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Открываю сайт
        orderPage.clickToOrderButtonHeader();
        //Кликаю на кнопку заказа
        orderPage.completionInputs(firstName, lastName, address, metro, phone);
        //Заполняем форму
        orderPage.clickButtonFurther();
        //Кликаю далее
        orderPage.completionInputsPageTwo(date,comments);
        orderPage.successModalText();
    }


    @Test
    public void checkOrderScooterCenter() {
       driverChrome = new ChromeDriver();
       //driverFirefox = new FirefoxDriver(); //По заданию только гугл хром нужен на ревью. удалять не стала для возможности дебага

        this.initTestButterCenter(driverChrome);
       // this.initTestButterCenter(driverFirefox); //По заданию только гугл хром нужен на ревью. удалять не стала для возможности дебага
    }

    public void initTestButterCenter(WebDriver driver) {
        OrderPage orderPageTwo = new OrderPage(driver);
        //Создаю экземпляр класса
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Открываю сайт
        orderPageTwo.clickToCookiesModal();
        // Соглашаюсь с куками
        orderPageTwo.FiendClickToOrderButtonCenter();
        //Кликаю на кнопку заказа
        orderPageTwo.completionInputs(firstName, lastName, address, metro, phone);
        //Заполняю форму
        orderPageTwo.clickButtonFurther();
        //Кликаю далее
        orderPageTwo.completionInputsPageTwo(date,comments);
        orderPageTwo.successModalText();
    }

    @After
    public void teardownCenter() {
        driverChrome.quit();
       // driverFirefox.quit();//По заданию только гугл хром нужен на ревью. удалять не стала для возможности дебага
        // Закрываю браузеры   по очереди  После Окончания всех тестов
    }
}