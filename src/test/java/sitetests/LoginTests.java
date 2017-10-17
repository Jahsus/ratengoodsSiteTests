package sitetests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class LoginTests {
    @Before
    public void setUpClass() throws Exception {

        Core.setup();
    }

    @After
    public  void tearDownClass () throws Exception {
        Core.quit();
    }


    @AfterClass
    public static void tearDown() throws Exception {
        System.exit(0);
    }

    @Test
    public void loadMainPageTest() throws Exception {
        Core.loadMainPage();

    }

    @Test
    public void closeLoginWindowTest() throws Exception{
        Core.loadMainPage();
        Core.openLoginWindow();
        Core.closeLoginWindow();
    }

    @Test
    public void loginWithValidEmailTest() throws Exception{
        Core.loadMainPage();
        Core.openLoginWindow();
        Core.authByEmail();
    }

    @Test
    public void loginWithWrongEmailTest() throws Exception{
        Core.loadMainPage();
        Core.openLoginWindow();
        Core.authByWrongEmail();
    }

    @Test
    public void loginSocialVkTest() throws Exception{
        Core.loadMainPage();
        Core.openLoginWindow();
        Core.clickVkButton();
        Core.authWithVk();
    }


    @Test
    public void loginSocialFbTest() throws Exception{
        Core.loadMainPage();
        Core.openLoginWindow();
        Core.clickFbButton();
        Core.authWithFb();
    }


    @Test
    public void loginSocialGplusTest() throws Exception{
        Core.loadMainPage();
        Core.openLoginWindow();
        Core.clickGpButton();
        Core.authWithGp();
    }

    @Test
    public void loginSocialVkAlterTest() throws Exception{
        Core.loadMainPage();
        Core.openLoginWindow();
        Core.clickRegisterButton();
        Core.clickVkRegFormButton();
        Core.authWithVk();
    }

    @Test
    public void loginSocialFbAlterTest() throws Exception{
        Core.loadMainPage();
        Core.openLoginWindow();
        Core.clickRegisterButton();
        Core.clickFbRegFormButton();
        Core.authWithFb();
    }

    @Test
    public void loginSocialGplusAlterTest() throws Exception{
        Core.loadMainPage();
        Core.openLoginWindow();
        Core.clickRegisterButton();
        Core.clickGpRegFormButton();
        Core.authWithGp();
    }


    @Test
    public void registrationTest() throws Exception{
        Core.loadMainPage();
        Core.openLoginWindow();
        Core.clickRegisterButton();
        Core.registrationSuccess();

    }

    @Test
    public void remindPasswordTest() throws Exception{
        Core.loadMainPage();
        Core.openLoginWindow();
        Core.remindPassword();
    }

}

