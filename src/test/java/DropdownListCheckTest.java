import constants.Url;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import static org.junit.Assert.assertEquals;
//import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class DropdownListCheckTest {
    private int elementID;
    // Ключ выпадающего списка (по порядку: 1, 2, 3...)
    private String checkedText;
    // Ожидаемый текст в описании элемента

    private WebDriver driverChrome;
    //private WebDriver driverFirefox;


    public DropdownListCheckTest(int elementID, String checkedText) {
        this.elementID = elementID;
        this.checkedText = checkedText;
    }
    // Конструктор который описывает ожидаемые параметры

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    } // Параметризация теста ,для перебора (проверки данных по порядку),сокращения кода.

    @Test
    public void checkTextInAccordionItem() {
         driverChrome = new ChromeDriver();
         //driverFirefox = new FirefoxDriver();

        this.initTest(driverChrome);
       // this.initTest(driverFirefox);
    }
    //Метод запуска теста

    public void initTest(WebDriver driver) {
        driver.get(Url.SCOOTER_URL);
        // Открываю сайт

        MainPage mainPage = new MainPage(driver);
        // Создаю экземпляр класса главной страницы

        mainPage.clickToCookiesModal();
        // Кликаю по кнопке в модальку cookies, она мешает кликать по последнему пункту списка


        mainPage.initElementsAccordion();
        // Запрашиваю все элементы  списка


        String text = mainPage.getTextFromAccordionDesc(elementID);
        // Получаю текст описания по ключу  списка (аккордеона)

        assertEquals(checkedText,text);
        // Сравниваю полученный текст с тем текстом что мы ожидаем
    }

    @After
    public void teardown() {
        driverChrome.quit();
        //driverFirefox.quit();
        // Закрываю браузеры   по очереди
    }
}
