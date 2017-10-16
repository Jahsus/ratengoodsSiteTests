package sitetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Core {

    // Объявление переменных ссылок и локаторов элементов
    public static WebDriver driver;

    private static String baseUrl = "http://stage.ratengoods.com/";
    private static String userButtonCss = ".user";
    private static String groupPolicyCloseButton = "div.popup-policy__close";
    private static String vkButton = "#sign-in > div.social-auth > ul > li:nth-child(1) > a";

    static void setup() {
        // Иногда кнопки не нажимаются, поэтому сделал запуск браузера в полном экране.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





    }

    static void loadMainPage() {
        driver.get(baseUrl); // запуск браузера.
        WebElement element = driver.findElement(By.cssSelector(groupPolicyCloseButton)); // найти кнопку и "закрыть" групповую политику
        element.click();



    }

    static void clickLoginButton(){
        WebElement element = driver.findElement(By.cssSelector(userButtonCss));
        element.click();
    }

    static void clickVkButton(){
        WebElement element = driver.findElement(By.cssSelector(vkButton));
        element.click();
    }

    static void quit() {
        driver.close();

    }

  /*  static void slidePromo(int count) throws InterruptedException {
        WebElement arrowNext = driver.findElement(By.cssSelector());
        System.out.println(arrowNext.getText());

        // Цикл для реализации пяти нажатий кнопки промо-слайдера
        for (int i = 0; i < count; i++) {
            arrowNext.click();
            Thread.sleep(500);
        }
    }

    public static void clickWatchLatter() throws InterruptedException {
        // Нажать кнопку "Смотреть позже"
        WebElement watchLatter = driver.findElement(By.xpath());
        watchLatter.click();
        String clickedMovieID = watchLatter.getAttribute("data-object-id");
        Thread.sleep(2000);
        System.out.println(clickedMovieID);

    }

    static void checkWatchLatterButton() throws InterruptedException {
        // Не нашёл как проверить что звезда стала "красной", поэтому проверяю, что класс кнопки изменился на *active
        WebElement watchLatter = driver.findElement(By.xpath());
        assertThat(watchLatter.getAttribute("class"), is());


    }

    static void checkWatchLatterBlock() throws InterruptedException {

        // Почему-то в "чистом" браузере кнопка "Смотреть позже" динамически не меняется
        // и не появляется блок с фильмом добавленным в "Смотерть позже" поэтому пришлось обновлять страницу
        driver.navigate().refresh();
        Thread.sleep(3000);

        //Сравнить ссылки на фильм из блока промо и блока См. позже
        String watchLatterLink = driver.findElement(By.cssSelector()).getAttribute("href");
        String clickedMovieID = driver.findElement(By.xpath()).getAttribute("data-object-id");
        assertThat(watchLatterLink, is());

        // Получение текста  и проверка заголовка появившегося блока "Смотреть позже"
        String watchLatterButtonText = driver.findElement(By.cssSelector()).getText();
        System.out.println(watchLatterButtonText);

        String selectedMovieID = driver.findElement(By.cssSelector()).getAttribute("data-id");
        System.out.println(clickedMovieID);
        assertThat(watchLatterButtonText, is("См. позже"));

        // Проверка того, что совпадают ID фильмов нажатой кнопки "Смотреть позже" и добавленного в блок под слайдером
        assertThat(selectedMovieID,is(clickedMovieID));
        System.out.println("Всё верно, в раздел \"Смотреть позже\" добавлен правильный фильм.");

    }


*/




}