package sitetests;

import org.junit.*;

public class LoginTests {
    @BeforeClass
    public static void setUpClass() throws Exception {

        Core.setup();
    }

    @AfterClass
    public static void tearDownClass () throws Exception {
        Core.quit();
    }

//
//    @After
//    public void tearDown() throws Exception {
//        Core.quit();
//    }

    @Test
    public void loadMainPageTest() throws Exception {
        Core.loadMainPage();

    }

    @Test
    public void loginWithEmailtest() throws Exception{
        Core.loadMainPage();
        Core.clickLoginButton();

    }

}

