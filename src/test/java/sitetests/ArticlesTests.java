package sitetests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class ArticlesTests {
    @Before
    public void setUpClass() throws Exception {

        Core.setup();
    }

    @After
    public void tearDownClass() throws Exception {
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
}