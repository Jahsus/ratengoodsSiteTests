package sitetests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class Core {

    // Объявление переменных ссылок и локаторов элементов
    public static WebDriver driver;
    private static WebDriverWait sWebDriverWait;

    private static String baseUrl = "http://ratengoods.com/";
    private static String profileUrl ="http://ratengoods.com/user/profile/articles/";

    private static String userButtonCss = ".user";
    private static String groupPolicyCloseButton = "div.popup-policy__close";
    private static String logoCss = "body > header > div > a";

    public static String emailInput = ".login-email";
    public static String passwordInput = ".login-password";
    public static String loginButton = "#id1";
    public static String remindPassButtonCss = "[href=\"#forgot-pwd\"]";
    public static String remindPassEmailFieldCss = ".email";
    public static String remindEmailConfirmButtonCss = "button.btn:nth-child(3)";
    public static String errorMessageCss ="div.help-block";
    public static String loginWindowCss ="#signup > div:nth-child(1) > div:nth-child(1)";

    public static String regButtonCss = "#signup > div > div > div.modal-header > ul > li:nth-child(2) > a";
    public static String regFirstNameInputCss = "#sign-up > div.modal-form > div:nth-child(1) > input";
    public static String regLastNameInputCss = "#sign-up > div.modal-form > div:nth-child(2) > input";
    public static String regEmailInputCss = "#sign-up > div.modal-form > div:nth-child(3) > input";
    public static String regPassInputCss = "#sign-up > div.modal-form > div:nth-child(4) > input";
    public static String regConfirmButton = "#id2";

    private static String vkButtonCss = "a.vk.social-auth-link";
    private static String vkButtonRegFormCss = "#sign-up > div.social-auth > ul > li:nth-child(1) > a";
    private static String vkEmailInputCss ="#login_submit > div > div > input:nth-child(7)";
    private static String vkPassInputCss ="#login_submit > div > div > input:nth-child(9)";
    private static String vkLoginButtonCss = "#install_allow";

    private static String fbButtonCss = "a.fb.social-auth-link";
    private static String fbButtonRegFormCss = "#sign-up > div.social-auth > ul > li:nth-child(2) > a";
    private static String fbEmailInputCss ="#email";
    private static String fbPassInputCss ="#pass";
    private static String fbLoginButtonCss ="#loginbutton";

    private static String gpButtonCss = "a.gp.social-auth-link";
    private static String gpButtonRegFormCss = "#sign-up > div.social-auth > ul > li:nth-child(3) > a";
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

    static WebElement isElementVisible(By by){
        try {
            return sWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            System.out.println("Элемент " + by.toString() + " не является видимым на странице. \n");
            e.printStackTrace();
            System.out.println();
            return null;
        }
    }

    static void loadMainPage() {
        driver.get(baseUrl); // запуск браузера.
        WebElement element = driver.findElement(By.cssSelector(groupPolicyCloseButton)); // найти кнопку и "закрыть" групповую политику
        element.click();
        assertEquals("Rate&Goods - огромный каталог товаров с фотографиями, ценами, мнениями экспертов и отзывами потребителей.",driver.getTitle().toString());

    }

    static void openLoginWindow() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.cssSelector(userButtonCss));
        loginButton.click();
        Thread.sleep(1000);

        WebElement loginWindow = (new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(loginWindowCss))));
        Assert.assertTrue(loginWindow.isDisplayed());
    }

    static void closeLoginWindow() {
        WebElement element = driver.findElement(By.cssSelector("#signup > div > div > div.modal-header > button > span"));
        element.click();

        WebElement loginWindow = (new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(loginWindowCss))));
        Assert.assertTrue(!loginWindow.isDisplayed());

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

    static void clickVkRegFormButton() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector(vkButtonRegFormCss));
        element.click();
        Thread.sleep(2000);
    }

    static void clickFbRegFormButton() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector(fbButtonRegFormCss));
        element.click();
        Thread.sleep(2000);
    }

    static void clickGpRegFormButton() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector(gpButtonRegFormCss));
        element.click();
        Thread.sleep(2000);
    }

    static void clickRegisterButton() throws InterruptedException{
        WebElement registerButton = driver.findElement(By.cssSelector(regButtonCss));
        registerButton.click();
        Thread.sleep(500);
    }

    static void remindPassword() {
        WebElement remindPassButton = driver.findElement(By.cssSelector(remindPassButtonCss));
        remindPassButton.click();
        WebElement emailInputField = driver.findElement(By.cssSelector(remindPassEmailFieldCss));
        emailInputField.sendKeys("jah.jaha@gmail.com");
        WebElement remindEmailConfirmButton = driver.findElement(By.cssSelector(remindEmailConfirmButtonCss));
        remindEmailConfirmButton.click();

    }

    static void registrationSuccess() throws InterruptedException{

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); // Генерим строку с текущим временем и датой

        WebElement regFirstNameField = driver.findElement(By.cssSelector(regFirstNameInputCss));
        regFirstNameField.sendKeys("Mister");
        WebElement regLastNameField = driver.findElement(By.cssSelector(regLastNameInputCss));
        regLastNameField.sendKeys("Bixter");
        WebElement regEmailField = driver.findElement(By.cssSelector(regEmailInputCss));
        regEmailField.sendKeys(timeStamp+"@mail.com"); // встарвляем строку таймстем чтоб получить уникальный емейл
        WebElement regPassField = driver.findElement(By.cssSelector(regPassInputCss));
        regPassField.sendKeys("Test1ng");
        WebElement regConfirm = driver.findElement(By.cssSelector(regConfirmButton));
        regConfirm.click();

        Thread.sleep(3000);
        driver.get(profileUrl);

        String userName = driver.findElement(By.cssSelector(profileNameCss)).getText();
        assertEquals("Mister"+"\n"+"Bixter", userName);

        String userStatus = driver.findElement(By.cssSelector(profileStatusCss)).getText();
        assertEquals("пользователь", userStatus.toLowerCase());
    }




    static void authByEmail() throws InterruptedException {
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

    static void authByWrongEmail() throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector(emailInput));
        emailField.sendKeys("hah.haha@gmail.com");
        WebElement passwordField = driver.findElement(By.cssSelector(passwordInput));
        passwordField.sendKeys("VAdb25qwe");
        WebElement elementloginButton = driver.findElement(By.cssSelector(loginButton));
        elementloginButton.click();


        String errorMessage = driver.findElement(By.cssSelector(errorMessageCss)).getText();
        assertEquals("неверный логин или пароль.", errorMessage.toLowerCase());

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

}