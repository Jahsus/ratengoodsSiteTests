package sitetests;

import org.junit.*;

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
    public void loginWithEmailTest() throws Exception{
        Core.loadMainPage();
        Core.clickLoginButton();
        Core.authEmail();



    }

    @Test
    public void loginSocialVkTest() throws Exception{
        Core.loadMainPage();
        Core.clickLoginButton();
        Core.clickVkButton();
        Core.authWithVk();

    }

    @Test
    public void loginSocialFbTest() throws Exception{
        Core.loadMainPage();
        Core.clickLoginButton();
        Core.clickFbButton();
        Core.authWithFb();

    }


}

