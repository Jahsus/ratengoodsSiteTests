package sitetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class Core {

    // Объявление переменных ссылок и локаторов элементов
    public static WebDriver driver;

    private static String baseUrl = "http://ratengoods.com/";
    private static String profileUrl ="http://ratengoods.com/user/profile/articles/";

    private static String userButtonCss = ".user";
    private static String groupPolicyCloseButton = "div.popup-policy__close";

    public static String emailInput = ".login-email";
    public static String passwordInput =".login-password";
    public static String loginButton ="#id1";

    private static String vkButtonCss = "a.vk.social-auth-link";
    private static String vkEmailInputCss ="#login_submit > div > div > input:nth-child(7)";
    private static String vkPassInputCss ="#login_submit > div > div > input:nth-child(9)";
    private static String vkLoginButtonCss = "#install_allow";

    private static String fbButtonCss = "a.fb.social-auth-link";
    private static String fbEmailInputCss ="#email";
    private static String fbPassInputCss ="#pass";
    private static String fbLoginButtonCss ="#loginbutton";

    private static String gpButtonCss = "a.gp.social-auth-link";
    private static String gpEmailInputCss ="#identifierId";
    private static String gpEmailAcceptButtonCss = "#identifierNext > content > span";
    private static String gpPassInputCss = "#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input";
    private static String gpPassAcceptButtonCss = "#passwordNext > content > span";

    private static String profileNameCss = "p.user-name";
    private static String profileStatusCss = "p.user-expert";




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

    static void clickLoginButton() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector(userButtonCss));
        element.click();
        Thread.sleep(1000);
    }

    static void clickVkButton() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector(vkButtonCss));
        element.click();
        Thread.sleep(2000);


    }

    static void clickFbButton() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector(fbButtonCss));
        element.click();
        Thread.sleep(2000);
    }

    static void clickGpButton() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector(gpButtonCss));
        element.click();
        Thread.sleep(2000);
    }

    static void authEmail() throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector(emailInput));
        emailField.sendKeys("jah.jaha@gmail.com");
        WebElement passwordField = driver.findElement(By.cssSelector(passwordInput));
        passwordField.sendKeys("VAdb25qwe");
        WebElement elementloginButton = driver.findElement(By.cssSelector(loginButton));
        elementloginButton.click();
        Thread.sleep(3000);
        driver.get(profileUrl);

        String userName = driver.findElement(By.cssSelector(profileNameCss)).getText();
        assertEquals("ValentiN"+"\n"+"KuzmenkoV", userName);

        String userStatus = driver.findElement(By.cssSelector(profileStatusCss)).getText();
        assertEquals("пользователь", userStatus.toLowerCase());
    }

    static void authWithVk() throws InterruptedException{
        WebElement vkEmailField = driver.findElement(By.cssSelector(vkEmailInputCss));
        vkEmailField.sendKeys("t.ratengoods@gmail.com");
        WebElement vkPassField = driver.findElement(By.cssSelector(vkPassInputCss));
        vkPassField.sendKeys("Test1ng");
        WebElement vkLoginButton = driver.findElement(By.cssSelector(vkLoginButtonCss));
        vkLoginButton.click();

        Thread.sleep(3000);
        driver.get(profileUrl);

        String userName = driver.findElement(By.cssSelector(profileNameCss)).getText();
        assertEquals("Valentinnн"+"\n"+"Kuzmenkovvв", userName);

        String userStatus = driver.findElement(By.cssSelector(profileStatusCss)).getText();
        assertEquals("пользователь", userStatus.toLowerCase());
    }

    static void authWithFb() throws InterruptedException{
        WebElement vkEmailField = driver.findElement(By.cssSelector(fbEmailInputCss));
        vkEmailField.sendKeys("t.ratengoods@yandex.ru");
        WebElement vkPassField = driver.findElement(By.cssSelector(fbPassInputCss));
        vkPassField.sendKeys("Test1ng");
        WebElement vkLoginButton = driver.findElement(By.cssSelector(fbLoginButtonCss));
        vkLoginButton.click();

        Thread.sleep(3000);
        driver.get(profileUrl);

        String userName = driver.findElement(By.cssSelector(profileNameCss)).getText();
        assertEquals("Testero"+"\n"+"Testingovich", userName);

        String userStatus = driver.findElement(By.cssSelector(profileStatusCss)).getText();
        assertEquals("пользователь", userStatus.toLowerCase());
    }

    static void authWithGp() throws InterruptedException{
        WebElement gpEmailField = driver.findElement(By.cssSelector(gpEmailInputCss));
        gpEmailField.sendKeys("tt.ratengoods@gmail.com");
        WebElement gpEmailConfirmButton = driver.findElement(By.cssSelector(gpEmailAcceptButtonCss));
        gpEmailConfirmButton.click();
        Thread.sleep(500);
        WebElement gpPassField = driver.findElement(By.cssSelector(gpPassInputCss));
        gpPassField.sendKeys("Test1ng.RG");
        WebElement gpPassConfirmButton = driver.findElement(By.cssSelector(gpPassAcceptButtonCss));
        gpPassConfirmButton.click();

        Thread.sleep(3000);
        driver.get(profileUrl);

        String userName = driver.findElement(By.cssSelector(profileNameCss)).getText();
        assertEquals("Testерой"+"\n"+"Testingovichй", userName);

        String userStatus = driver.findElement(By.cssSelector(profileStatusCss)).getText();
        assertEquals("пользователь", userStatus.toLowerCase());
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